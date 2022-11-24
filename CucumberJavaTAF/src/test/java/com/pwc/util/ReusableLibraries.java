package com.pwc.util;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ReusableLibraries {

	private static WebDriver driver;

	public static WebDriver launchBrowser(String URL) throws InterruptedException {

		//System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setBinary("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe");
		options.addArguments("--user-data-dir=D:/Default");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(URL);
		Thread.sleep(3000);
		driver.navigate().refresh();
		return driver;
	}

	public static String getChildWindow(String parentWindow, Set<String> windowHandles) {

		String childWindow = null;
		Iterator<String> itr = windowHandles.iterator();
		while (itr.hasNext()) {
			childWindow = itr.next();
			if (!parentWindow.equals(childWindow)) {
				System.out.println("Parent: " + parentWindow);
				System.out.println("Child: " + childWindow);
			}
		}
		return childWindow;
	}

	public static String getReportConfigPath() {

		String reportConfigPath = "D:/Workspace/com.pwc/extent-config.xml";
		return reportConfigPath;
	}

	public static byte[] takeScreenshot(WebDriver driver) {

		final byte[] screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		return screenShot;
	}
}
