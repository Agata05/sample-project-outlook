package selenium.pageobjects;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.Pages;

@Slf4j
public class EntryPage extends Pages {

    public EntryPage(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "i0118")
    private
    WebElement passwordInput;

    @FindBy(id = "idSIButton9")
    private
    WebElement signInButton;

    @FindBy(id = "idA_PWD_ForgotPassword")
    private
    WebElement passwordLink;

    @FindBy(id = "iShowSkip")
    private
    WebElement skipLink;

    public boolean isEntryPageDisplayed(){
        return passwordLink.isDisplayed();
    }

    public void enterPassword(String password){
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", passwordInput);
        passwordInput.sendKeys(password);
        log.info("Entered password: " + password);
    }

    public boolean isSignInButtonEnabled(){
        return signInButton.isEnabled();
    }

    public LoggedInPage navigateToLoggedInPage(){
        log.info("Navigate to LoggedIn Page");
        signInButton.click();
        if (isElementPresent(skipLink)){
            log.info("Skip");
            skipLink.click();
        }
        return new LoggedInPage(driver);
    }
}
