package steps;

import io.cucumber.java.en.*;
import com.microsoft.playwright.Page;
import pages.HomePage;
import pages.CartPage;
import pages.RepositoryPage;
import utils.PlaywrightFactory;

public class ShoppingCartSteps {
    private Page page = PlaywrightFactory.getPage();
    private HomePage homePage = new HomePage(page);
    private CartPage cartPage = new CartPage(page);
    private RepositoryPage repoPage = new RepositoryPage(page);

    @Given("I open the shopping cart application")
    public void openApplication() {
        homePage.open();
    }

    @When("I add the first product to the cart")
    public void addFirstProduct() {
        homePage.addFirstProductToCart();
    }

    @Then("the cart should contain {int} item")
    public void verifyCartItemCount(int expectedCount) {
        cartPage.assertCartHasItems(expectedCount);
    }

    @When("I remove the product from the cart")
    public void removeProduct() {
        cartPage.removeFirstItem();
    }

    @Then("the cart should be empty")
    public void verifyCartEmpty() {
        cartPage.assertCartEmpty();
    }

    @When("I increase the quantity of the product")
    public void increaseQuantity() {
        cartPage.increaseQuantity();
    }

    @Then("the cart should reflect the updated quantity {string}")
    public void verifyQuantityUpdated(String expectedQty) {
        cartPage.assertQuantity(expectedQty);
    }

    @Given("I open the evaluation app")
    public void openEvaluationApp() {
        repoPage.openApp("https://automated-test-evaluation.web.app/");
    }

    @When("I check the GitHub repository link")
    public void checkRepoLink() {
        repoPage.assertRepoLinkAccessible();
    }

    @Then("the repository should be accessible and contain a README.md")
    public void verifyRepo() {
        repoPage.assertReadmePresent();
    }
}