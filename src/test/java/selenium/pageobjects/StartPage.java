package selenium.pageobjects;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.Pages;

@Slf4j
public class StartPage extends Pages {


	public StartPage(final WebDriver driver) {
		super(driver);
	}

	@Override
	public void open(){
		super.open();
	}

	@FindBy(css = ".auxiliary-actions .internal.sign-in-link")
	private
	WebElement loginLink;

	@FindBy(xpath = "//h1[@class = 'product-name']/span")
	private
	WebElement outlookSign;



	public String getTitle(){
		return driver.getTitle();
	}

	public boolean isSignInButtonDisplayed(){
		return loginLink.isDisplayed();
	}

	public boolean isOutlookSignDisplayed(){
		return outlookSign.isDisplayed();
	}

	public DetailsPage navigateToDetailsPage(){
		log.info("Navigate to Details Page");
		loginLink.click();
		return new DetailsPage(driver);
	}










}
