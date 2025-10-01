package pages;

import com.microsoft.playwright.Page;

public class HomePage {
    private Page page;
    private String BASE_URL = "https://automated-test-evaluation.web.app/";
    private String productAddBtn = ".product button";

    public HomePage(Page page) {
        this.page = page;
    }

    public void open() {
        page.navigate(BASE_URL);
    }

    public void addFirstProductToCart() {
        page.click(productAddBtn);
    }
}