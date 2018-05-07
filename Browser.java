package com.anz.selenium.comcards.PageObjects;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.os.WindowsUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Browser {

	private static WebDriver driver;

	public static void setup(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("window-size=800,600");
			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			driver = new ChromeDriver(capabilities);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		} else if (browserName.equalsIgnoreCase("FF")) {
			File pathToBinary = new File(
					"C:\\Documents and Settings\\mn1\\Desktop\\FireFox\\firefox.exe");
			FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
			FirefoxProfile firefoxProfile = new FirefoxProfile();

			// /download folder path code**********
			firefoxProfile.setPreference("browser.download.folderList", 2);
			firefoxProfile.setPreference(
					"browser.download.manager.showWhenStarting", false);
			firefoxProfile.setPreference("browser.download.dir",
					"C:\\NotBackedUp\\EclipseWorkspace\\DownloadReports");
			firefoxProfile.setPreference("browser.helperApps.alwaysAsk.force",
					false);
			firefoxProfile
					.setPreference(
							"browser.helperApps.neverAsk.saveToDisk",
							"application/msword,application/csv,text/csv,application/vnd.ms-excel,application/pdf");
			firefoxProfile.setPreference("pdfjs.disabled", true);
			firefoxProfile.setPreference("xlsjs.disabled", true);
			firefoxProfile.setPreference("csvjs.disabled", true);

		

			driver = new FirefoxDriver(ffBinary, firefoxProfile);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} else if (browserName.equalsIgnoreCase("IE")) {
			DesiredCapabilities capabilities = DesiredCapabilities
					.internetExplorer();
			capabilities
					.setCapability(
							InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
							true);
			File file = new File(
					"C:\\NotBackedUp\\IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			driver = new InternetExplorerDriver(capabilities);
			driver.manage().window().maximize();
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	}

	public static WebDriver driver() {
		return driver;
	}

	public static void open(String url) throws Exception {
		driver.get(url);
		Thread.sleep(3000);

	}

	public static void close() {
		driver.quit();
	}

	public static void closeAll() {

		String[] browserEXE = { "chromedriver.exe", "firefox.exe",
				"iexplore.exe" };

		for (String s : browserEXE) {

			WindowsUtils.tryToKillByName(s);

		}

	}

}
