package pages;

import core.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage extends BasicWebPage {

    @FindBy(css = ".logo")
    private WebElement homePageElement;
    @FindBy(css = ".login")
    private WebElement signInButton;


    public HomePage(final WebDriver driver) { super(driver);}

    public void waitForPageLoad(){
        Assert.assertTrue(isElementDisplayedWithWait(homePageElement),
                "The Home page logo isn't loaded");
        Log.info("The 'Home' page is opened");
    }

    public void clickSignInButton(){
        try {
            waitForWebElement(signInButton).click();
            Log.info("The 'Sign In' button is clicked");
        } catch (Exception e){
           e.printStackTrace();
         Log.info("The web element wasn't found");
        }
    }
}
