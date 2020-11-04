package tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogOutTest extends BasicActions {
    @BeforeMethod
    public void loginToSite() {
        homePage.waitForPageLoad();
        homePage.clickSignInButton();
        authenticationPage.waitToLoadAuthenticationPage();
        authenticationPage.enterEmail();
        authenticationPage.enterPassword();
        authenticationPage.clickSignInButton();
        myAccountPage.checkLoggedUserName();
    }

    @Test(description = "Log from account with 'Sign Out' button")
    public void signOutWithButton(){
        myAccountPage.clickSignOutButton();
        myAccountPage.isUserSignedIn(false);
    }

    @Test(description = "Log from account with logout link")
    public void signOutWithLink(){
        driver.get(myAccountPage.getLogoutString());
        myAccountPage.isUserSignedIn(false);

    }
}
