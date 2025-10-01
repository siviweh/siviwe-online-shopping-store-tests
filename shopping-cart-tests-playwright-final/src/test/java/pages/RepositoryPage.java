package pages;

import com.microsoft.playwright.Page;

import static org.junit.Assert.assertTrue;

public class RepositoryPage {
    private Page page;
    private String repoLinkSelector = "a[href*='github.com']";

    public RepositoryPage(Page page) {
        this.page = page;
    }

    public void openApp(String url) {
        page.navigate(url);
    }

    public void assertRepoLinkAccessible() {
        String href = page.getAttribute(repoLinkSelector, "href");
        assertTrue("GitHub repo link not found", href != null && href.contains("github.com"));

        page.navigate(href);
        String title = page.title();
        assertTrue("GitHub repo did not load", title.contains("GitHub"));
    }

    public void assertReadmePresent() {
        assertTrue("README.md is missing", page.locator("text=README.md").isVisible());
    }
}