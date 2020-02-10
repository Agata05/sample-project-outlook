package selenium.pageobjects;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.Pages;

@Slf4j
public class DetailsPage extends Pages {

    public DetailsPage(WebDriver driver){
        super(driver);
    }

    private final static String ACTION_TXT = "No account? Create one!";

    @FindBy(id = "i0116")
    private
    WebElement loginInput;

    @FindBy(css = ".text-13.action-links")
    private
    WebElement loginLink;

    @FindBy(id = "idSIButton9")
    private
    WebElement nextButton;

    public boolean isDetailsPageDisplayed(){
        String actionLinks = loginLink.getAttribute("innerText");
        return actionLinks.contains(ACTION_TXT);
    }

    public boolean isLoginInputEnabled(){
        return loginInput.isEnabled();
    }

    public boolean isNextButtonEnabled(){
        return nextButton.isEnabled();
    }

    public void enterLoginEmail(String login){
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginInput);
        loginInput.sendKeys(login);
        log.info("Log in with email: " + login);
    }

    public EntryPage navigateToEntryPage(){
        log.info("Navigate to Entry Page");
        nextButton.click();
        return new EntryPage(driver);
    }
}
