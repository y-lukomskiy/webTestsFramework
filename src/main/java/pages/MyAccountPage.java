package pages;

import core.BasicTestParameters;
import core.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MyAccountPage extends BasicWebPage {

    @FindBy(xpath = "//span[contains(.,'My account')]")
    private WebElement pageSelector;

    @FindBy(css = ".account > span")
    private WebElement loggedUserName;

    @FindBy(css = ".logout")
    private WebElement signOutButton;

    public MyAccountPage(final WebDriver driver) { super(driver); }

    public void checkMyAccountPageShown() {
        Assert.assertTrue(isElementDisplayedWithWait(pageSelector));
        Log.info("The 'My account' screen is opened");
    }

    public void checkLoggedUserName(){
        Assert.assertEquals(loggedUserName.getText(), BasicTestParameters.getUserName(),
                "The logged user name isn't same to expected");
        Log.info("The '" + loggedUserName.getText() + "' text is displayed as account name after login");
    }

    public void isUserSignedIn(boolean expectedState){
        Assert.assertEquals(isElementDisplayed(loggedUserName), expectedState,
                "User authorization status isn't the same to expected");
    }

    public void clickSignOutButton(){
        waitForWebElement(signOutButton).click();
        if(isElementDisplayed(signOutButton)){
            waitByThreadSleep(2000);
        }
    }

    public String getLogoutString() {
        return BasicTestParameters.getSiteUrl() + "?mylogout=";
    }
}
