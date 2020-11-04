package pages;

import core.Log;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasicWebPage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public final static int WAIT_TIMEOUT_IN_SECONDS = 5;

    public BasicWebPage(final WebDriver driver) {
        wait = new WebDriverWait(driver, WAIT_TIMEOUT_IN_SECONDS);
        PageFactory.initElements(driver, this);
    }

    protected WebElement waitForWebElement(WebElement webElementElement) {
        wait.ignoring(NoSuchElementException.class, StaleElementReferenceException.class).
                withTimeout(Duration.ofSeconds(WAIT_TIMEOUT_IN_SECONDS)).until(w -> webElementElement.isDisplayed());
        return webElementElement;
    }

    protected WebElement waitForWebElementWithTimeSet(WebElement webElement, int waitDurationInSeconds) {
        wait.ignoring(NoSuchElementException.class, StaleElementReferenceException.class).
                withTimeout(Duration.ofSeconds(waitDurationInSeconds)).until(w -> webElement.isDisplayed());
        return webElement;
    }

    public void enterText(WebElement element, String text, Boolean clearField ) {
         element.click();
        if (clearField) {
            element.clear();
        }
        element.sendKeys(text);
        Log.info("The " + text + " is entered to " + element.getTagName());
    }

    public void isUrlChanged(String urlString) {
        wait.until(ExpectedConditions.urlContains(urlString));
    }

    public void waitByThreadSleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Log.info("The thread sleep method is finished with exception");
            e.printStackTrace();
        }
    }
    public boolean isElementDisplayed(WebElement element){
        try{
            return element.isDisplayed();
        } catch (NotFoundException e){
            Log.info("The web element isn't found.This is valid logic for some test. Element name is " + element);
            return false;
        }
    }
    public boolean isElementDisplayedWithWait(WebElement element){
        try{
            return waitForWebElement(element).isDisplayed();
        } catch (NotFoundException e){
            Log.info("The web element isn't found.This is valid logic for some test. Element name is " + element);
            return false;
        }
    }
}
