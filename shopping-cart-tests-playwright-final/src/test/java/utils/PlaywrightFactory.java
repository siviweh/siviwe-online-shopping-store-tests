package utils;

import com.microsoft.playwright.*;

public class PlaywrightFactory {
    private static Playwright playwright;
    private static Browser browser;
    private static Page page;

    public static Page getPage() {
        if (playwright == null) {
            playwright = Playwright.create();
            BrowserType.LaunchOptions options = new BrowserType.LaunchOptions()
                    .setHeadless(false)
                    .setExecutablePath("/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");
            browser = playwright.chromium().launch(options);
            page = browser.newPage();
        }
        return page;
    }

    public static void close() {
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
        browser = null;
        playwright = null;
        page = null;
    }
}