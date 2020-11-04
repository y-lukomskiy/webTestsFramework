package tests;

import org.testng.annotations.Test;

public class LoginTest extends BasicActions {

    @Test(description = "Login to site and check user name")
    public void loginToSite() {
        homePage.waitForPageLoad();
        homePage.clickSignInButton();

        authenticationPage.waitToLoadAuthenticationPage();
        authenticationPage.enterEmail();
        authenticationPage.enterPassword();
        authenticationPage.clickSignInButton();

        myAccountPage.checkMyAccountPageShown();
        myAccountPage.checkLoggedUserName();
    }
}
