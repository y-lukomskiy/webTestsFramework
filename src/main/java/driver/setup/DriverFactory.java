package driver.setup;

import core.Log;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

import java.util.concurrent.TimeUnit;

public class DriverFactory {
	private static ThreadLocal<WebDriver> DRIVER = new ThreadLocal<WebDriver>();
	private static ThreadLocal<String> BROWSER_INFO = new ThreadLocal<String>();

	public static WebDriver createInstance(String browserName, String platform) {
		// defaults to chrome on local machine
		browserName = browserName == null ? "chrome" : browserName;
		return DriverFactory.getDriver(browserName, platform);
	}

	public static WebDriver getDriver(String browserName, String platform) {
		Log.info("Local Driver Creation");
		WebDriver driver = null;
		BrowserType browserType = BrowserType.init(browserName);
		String exePath = "";

		switch (browserType) {
		case FIREFOX:
			// Process for Firefox
			if (platform.contains("Windows")) {
				exePath = String.format("%s/src/main/resources/webdrivers/windows/geckodriver.exe", System.getProperty("user.dir"));
			} else {
				exePath = String.format("%s/src/main/resources/webdrivers/mac/geckodriver", System.getProperty("user.dir"));
			}
			System.setProperty("webdriver.gecko.driver", exePath);
			Log.info(" exePath set for firefox is " + exePath);
			DriverCapabilities.setBrowserCapabilities(browserType);
			driver = new FirefoxDriver();
			break;
		case IE:
			// Process for Internet Explorer
			if (System.getProperty("os.name").contains("Win")) {
				exePath = String.format("%s/src/main/resources/webdrivers/windows/IEDriverServer.exe", System.getProperty("user.dir"));
			} else {
				throw new UnreachableBrowserException("The IE browser is supported only in Windows");
			}
			System.setProperty("webdriver.ie.driver", exePath);
			Log.info(" exePath set for Internet Explorer is " + exePath);
			DriverCapabilities.setBrowserCapabilities(browserType);
			driver = new InternetExplorerDriver();
			break;
		case CHROME:
			// Process for Google Chrome
			if (System.getProperty("os.name").contains("Win")) {
				exePath = String.format("%s/src/main/resources/webdrivers/windows/chromedriver.exe", System.getProperty("user.dir"));
			} else {
				exePath = String.format("%s/src/main/resources/webdrivers/mac/chromedriver.exe", System.getProperty("user.dir"));
			}
			System.setProperty("webdriver.chrome.driver", exePath);
			Log.info(" exePath set for Chrome is " + exePath);
			DriverCapabilities.setBrowserCapabilities(browserType);
			driver = new ChromeDriver();
			break;
		}
		Log.info("DriverFactory created an instance of WebDriver on local machine for: " + browserName);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}
}
