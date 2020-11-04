package pages;

import core.BasicTestParameters;
import core.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AuthenticationPage extends BasicWebPage{

    @FindBy(id = "email")
    private WebElement emailField;
    @FindBy(id = "passwd")
    private WebElement passwordField;
    @FindBy(id = "SubmitLogin")
    private WebElement submitLoginButton;

    public AuthenticationPage(final WebDriver driver) { super(driver); }

    public void waitToLoadAuthenticationPage(){
        Assert.assertTrue(isElementDisplayedWithWait(submitLoginButton),
                "The Authentication Page isn't loaded");
        Log.info("The 'Authentication' page is opened");
    }

    public void enterEmail() {
        enterText(emailField,BasicTestParameters.getUserLogin(),true);
    }

    public void enterPassword() {
        enterText(passwordField,BasicTestParameters.getUserPassword(),true);
    }

    public void clickSignInButton(){
        waitForWebElement(submitLoginButton).click();
        Log.info("The 'Sign In' button is clicked");
    }
}
