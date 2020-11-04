package driver.setup;

public enum BrowserType {
	CHROME("chrome"),
	FIREFOX("firefox"),
	IE("internet explorer");

	private final String browserValue;

	BrowserType(String browserName) {
		this.browserValue = browserName;
	}

	public String getBrowserString() {
		return this.browserValue;
	}

	public static BrowserType init(String browserValue) {
		for (BrowserType browsers : BrowserType.values()) {
			if (browsers.getBrowserString().equalsIgnoreCase(browserValue))
				return browsers;
		}
		// Chrome will be returned in case the setup is incorrect
		return CHROME;
	}
}
