package selenium;


import org.openqa.selenium.WebDriver;

import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import selenium.configurations.TestConfig;
import selenium.driver.WebDriverConfig;
import selenium.utils.WebDriverProvider;
import selenium.utils.annotations.DisableCookies;
import selenium.utils.annotations.UserAgent;
import selenium.utils.annotations.browser.Browser;
import selenium.utils.annotations.browser.BrowserDimension;
import selenium.utils.annotations.browser.Browsers;


public abstract class SeleniumTestWrapper {

	// Config
	protected final TestConfig testConfig = new TestConfig();
	private final WebDriverConfig webDriverConfig = new WebDriverConfig();
	protected final WebDriverProvider webDriverProvider = new WebDriverProvider(this.webDriverConfig);

	protected WebDriver getDriver() {
		return this.webDriverProvider.getDriver();
	}

	/**
	 * test class annotations
	 */
	@BeforeClass
	public void setUserAgent(){
		UserAgent userAgent = this.getClass().getAnnotation(UserAgent.class);
		if (userAgent != null) {
			webDriverProvider.useUserAgent(userAgent.value());
		}
	}

	@BeforeClass
	public void disableCookies(){
		DisableCookies cookies = this.getClass().getAnnotation(DisableCookies.class);
		if (cookies != null) {
			webDriverProvider.disableCookies(true);
		}
	}

	@BeforeClass
	public void browser() throws Exception {
		Browser browser = this.getClass().getAnnotation(Browser.class);
		if (browser != null){
			if (browser.require().length > 0 && browser.skip().length == 0){
				String browsers = concatinateBrowsers(browser.require());
				if (browsers.contains(testConfig.getBrowser())) {
					throw new SkipException("only execute test against " + browsers);
				}
			}

			if (browser.skip().length > 0 && browser.require().length == 0){
				String browsers = concatinateBrowsers(browser.skip());
				if (browsers.contains(testConfig.getBrowser())) {
					throw new SkipException("skip test against " + browsers);
				}
			}
		}
	}

	private String concatinateBrowsers(Browsers[] browsers){
		String concatinatedBrowsers = "";
		for(Browsers browser : browsers) concatinatedBrowsers += browser.getValue() + " & ";
		return concatinatedBrowsers.substring(0,concatinatedBrowsers.lastIndexOf("&"));
	}

	@BeforeClass
	public void browserDimension(){
		BrowserDimension browserDimension = this.getClass().getAnnotation(BrowserDimension.class);
		if (browserDimension != null) {
			getDriver().manage().window().setSize(browserDimension.value().dimension);
		}
	}

	@AfterClass
	public void closeBrowser(){
		getDriver().quit();
	}


}
