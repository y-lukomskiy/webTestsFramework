package tests;

import core.BasicTestParameters;
import driver.setup.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.AuthenticationPage;
import pages.BasicWebPage;
import pages.HomePage;
import pages.MyAccountPage;

public class BasicActions {
    public static WebDriver driver;

    HomePage homePage;
    AuthenticationPage authenticationPage;
    MyAccountPage myAccountPage;
    BasicWebPage basicWebPage;

    @BeforeMethod
    public void setupTestRun() {
        String browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browserName");
        String platform = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("platform");

        driver = DriverFactory.createInstance(browser,platform);
        initializePages();

        driver.get(BasicTestParameters.getSiteUrl());
    }

    protected void initializePages(){
       authenticationPage = new AuthenticationPage(driver);
       basicWebPage = new BasicWebPage(driver);
       homePage = new HomePage(driver);
       myAccountPage = new MyAccountPage(driver);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
