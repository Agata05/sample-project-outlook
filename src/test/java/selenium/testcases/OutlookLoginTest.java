package selenium.testcases;

import lombok.val;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import selenium.SeleniumTestWrapper;
import selenium.pageobjects.EntryPage;
import selenium.pageobjects.LoggedInPage;
import selenium.pageobjects.StartPage;
import selenium.pageobjects.DetailsPage;

import static org.assertj.core.api.Assertions.assertThat;

public class OutlookLoginTest extends SeleniumTestWrapper {

    private StartPage startPage;
    private DetailsPage detailsPage;
    private EntryPage entryPage;
    private LoggedInPage loggedInPage;

    private static final String START_PAGE_PART_TITLE = "Outlook";

    @BeforeClass
    public void setup() {
        startPage = new StartPage(getDriver());
        startPage.open();
    }

    @Test(priority = 1)
    public void checkIfCorrectTitleIsDisplayed() {
        String startPageTitle = startPage.getTitle();
        assertThat(startPageTitle).as("Page title").contains(START_PAGE_PART_TITLE);
    }

    @Test(priority = 2)
    public void checkIfSignInBtnIsDisplayed() {
        val isSignInButtonDisplayed = startPage.isSignInButtonDisplayed();
        val isOutlookSignDisplayed = startPage.isOutlookSignDisplayed();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(isSignInButtonDisplayed, "Is SignIb Button displayed?");
        softAssert.assertTrue(isOutlookSignDisplayed, "Is Outlook sign displayed?");
        softAssert.assertAll();

    }

    @Test(priority = 3)
    public void checkIfDetailsPageIsDisplayed() {
        detailsPage = startPage.navigateToDetailsPage();
        val isDetailsPageDisplayed = detailsPage.isDetailsPageDisplayed();
        Assert.assertTrue(isDetailsPageDisplayed, "Is Details Page displayed?");
    }

    @Test(priority = 4)
    public void checkIfLoginInputIsEnabled() {
        val isLoginInputEnabled = detailsPage.isLoginInputEnabled();
        Assert.assertTrue(isLoginInputEnabled, "Is Login input enabled?");
    }

    @Test(priority = 5)
    public void checkIfNextBtnIsEnabled() {
        val isNextButtonEnabled = detailsPage.isNextButtonEnabled();
        Assert.assertTrue(isNextButtonEnabled, "Is Next Button enabled?");
    }

    @Test(priority = 6)
    public void checkIfEntryPageIsLoaded() {
        detailsPage.enterLoginEmail(testConfig.getLogin());
        entryPage = detailsPage.navigateToEntryPage();
        val isEntryPageDisplayed = entryPage.isEntryPageDisplayed();
        Assert.assertTrue(isEntryPageDisplayed, "Is Entry Page displayed?");
    }

    @Test(priority = 7)
    public void checkIfSignInBtnIsEnabled() {
        val isSignInButtonEnabled = entryPage.isSignInButtonEnabled();
        Assert.assertTrue(isSignInButtonEnabled, "Is SignIn button enabled?");
    }

    @Test(priority = 8)
    public void checkIfLoggedInPageIsDisplayed() {
        entryPage.enterPassword(testConfig.getPassword());
        loggedInPage = entryPage.navigateToLoggedInPage();
        val isNavigationPanelDisplayed = loggedInPage.isNavigationPanelDisplayed();
        Assert.assertTrue(isNavigationPanelDisplayed, "Is navigation panel displayed?");
    }
}
