package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GeneralPage extends BasePage {

//  Basic Elements
	private final By ADD_NODE_BTN = By.xpath("//*[text()='Add Node']");
	private final By MAIN_CANVAS = By.id("KeyLines-chart-1");

	public GeneralPage(WebDriver driver) {
		super(driver);
	}

	public void clickOnAddNodeButton() {
		clickOnElement(ADD_NODE_BTN);
	}
	
	public WebElement returnCanvas() {
		return getElement(MAIN_CANVAS);
	}
}
