package selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.Pages;

public class LoggedInPage extends Pages {

    public LoggedInPage(WebDriver driver){
        super(driver);
    }

    @FindBy(css = ".nvtp")
    private
    WebElement navigationPanel;

    public boolean isNavigationPanelDisplayed(){
        return navigationPanel.isDisplayed();
    }
}
