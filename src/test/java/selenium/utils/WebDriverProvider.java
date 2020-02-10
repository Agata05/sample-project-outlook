package selenium.utils;

import org.openqa.selenium.WebDriver;

import selenium.driver.UserAgents;
import selenium.driver.WebDriverBuilder;
import selenium.driver.WebDriverConfig;

public class WebDriverProvider {
    private final WebDriverBuilder webDriverBuilder;
    private WebDriver driver;

    public WebDriverProvider(final WebDriverConfig webDriverConfig) {
        this.webDriverBuilder = new WebDriverBuilder(webDriverConfig);
    }

    public WebDriver getDriver() {
        if (driver == null) {
            driver = webDriverBuilder.toWebDriver();
        }
        return driver;
    }

    public void useUserAgent(UserAgents userAgent) {
        webDriverBuilder.userAgent(userAgent);
    }

    public void disableCookies(boolean cookies) {
        webDriverBuilder.disableCookies(cookies);
    }

    public boolean existsDriver() {
        return driver != null;
    }

}
