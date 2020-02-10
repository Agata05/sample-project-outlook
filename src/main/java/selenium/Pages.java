package selenium;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;
import selenium.configurations.TypedProperties;

public abstract class Pages extends SeleniumFunctions {

	private final static TypedProperties testConfig =  new TypedProperties("/test_config.properties");

	public Pages(final WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	private String baseUrl = testConfig.getValue("base_url");


	protected void open(String path){
		driver.get(baseUrl + path);
	}

	protected void open(){
		driver.get(baseUrl);
	}

}
