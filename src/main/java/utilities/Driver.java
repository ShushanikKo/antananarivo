package utilities;

import enums.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.*;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;

/**
 * @author shushKostumian
 */
public class Driver {

	public WebDriver driver = null;
	public static ThreadLocal<WebDriver> driverThread;

	@BeforeClass(alwaysRun = true)
	public void initDriver() throws MalformedURLException {

		setDriver(Browser.CHROME);
		// TODO
		this.driver.manage().window().maximize();
		driverThread = new ThreadLocal<WebDriver>();
		driverThread.set(driver);
	}

	public void setDriver(Browser browserType) throws MalformedURLException {
		switch (browserType) {
		case CHROME:
			driver = new ChromeDriver(initChromeOptions());
			break;
		case FIREFOX:
			// TODO
			break;
		case SAFARI:
			// TODO
			break;
		default:
			driver = new ChromeDriver(initChromeOptions());
		}
	}

	public static ChromeOptions initChromeOptions() {
		WebDriverManager.chromedriver().browserVersion("77.0.3865.40").setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.addArguments("enable-automation");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-infobars");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-browser-side-navigation");
		options.addArguments("--disable-gpu");
		return options;
	}

	@AfterClass(alwaysRun = true)
	public void quiteDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
			driverThread.remove();
		}
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void clearCaches() {
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}

}
