package driver.setup;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

public class DriverCapabilities {

    public static DesiredCapabilities setBrowserCapabilities(BrowserType browserType){
        switch (browserType) {
            case FIREFOX:
                return getFirefoxCapabilities();
            case IE:
                return getIECapabilities();
            case CHROME:
            default:
                return getChromeCapabilities();
        }
    }

    public static DesiredCapabilities getFirefoxCapabilities(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        FirefoxOptions options = new FirefoxOptions();
        options.addPreference("pdfjs.disabled", true);
        options.addPreference("security.insecure_password.ui.enabled", false);
        options.addPreference("security.insecure_field_warning.contextual.enabled", false);

        return desiredCapabilities;
    }

    public static DesiredCapabilities getIECapabilities(){
        return new DesiredCapabilities();
    }

    public static DesiredCapabilities getChromeCapabilities(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.default_content_settings.popups", 0);
        options.setExperimentalOption("prefs", prefs);
        options.setExperimentalOption("w3c", true);

        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);

        return desiredCapabilities;
    }
}
