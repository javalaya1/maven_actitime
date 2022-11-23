package com.atlas.maven_actitime.utility;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserFactory {

	public static RemoteWebDriver driver;

	private static void openChromeBrowser() {
		System.setProperty("webdriver.chrome.driver", "actitime_browserexes/chromedriver.exe");
		driver = new ChromeDriver();
	}

	private static void openEdgeBrowser() {
		System.setProperty("webdriver.edge.driver", "actitime_browserexes/msedgedriver.exe");
		driver = new EdgeDriver();
	}

	private static void openFirefoxBrowser() {
		System.setProperty("webdriver.gecko.driver", "actitime_browserexes/geckodriver.exe");
		driver = new FirefoxDriver();
	}

	public static RemoteWebDriver openRequiredBorwser(String browserName) {
		// if (driver == null) {
		switch (browserName.toLowerCase()) {
		case "chrome":
		case "gc":
			openChromeBrowser();
			break;
		case "firefox":
		case "ff":
			openFirefoxBrowser();
			break;
		case "edge":
		case "me":
			openEdgeBrowser();
		}
		// }
		return driver;
	}

	public static void launchApplication(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
	}

	public static void closeCurrentBrowser() {
		driver.close();
	}

	public static void closeAllBrowsers() {
		driver.quit();
		driver=null;
	}

}
