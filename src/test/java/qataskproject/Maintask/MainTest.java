package qataskproject.Maintask;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import helpers.ConfigFileReader;
import pages.GeneralPage;
import utilities.Driver;

public class MainTest extends Driver {

	static ConfigFileReader configFileReader = new ConfigFileReader();
	private Actions actions;
	private GeneralPage generalPage;
	private WebElement canvas;

	private String mainUrl = configFileReader.getTestingPageURL();

	@BeforeClass
	public void setup() {
		actions = new Actions(driver);
		generalPage = new GeneralPage(driver);
		driver.get(mainUrl);
	}

	@Test(description = "Case: Clicking not on nodes but the random coordinates on canvas. Expected: nodes are not added. Actual result: nodes are added(without links.)")
	public void randomlyClickingOnCanvasAreaCase() throws InterruptedException {

		canvas = generalPage.returnCanvas();
		generalPage.clickOnAddNodeButton();

		for (int i = 0; i < 10; i++) {
			actions.moveToElement(canvas, 0, 0).moveByOffset(60, 150).doubleClick().build().perform();
		}
		Thread.sleep(3000);

	}
}
