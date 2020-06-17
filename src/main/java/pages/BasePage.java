package pages;

import exceptions.ElementNotFoundException;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author shushKostumian
 */
public class BasePage {

	private final Logger LOGGER = Logger.getLogger(BasePage.class);
	protected WebDriver driver;
	private WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
//		DesiredCapabilities caps = DesiredCapabilities.chrome();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	/**
	 * click on element
	 *
	 * @param by
	 */
	protected void clickOnElement(By by) {
		try {
			driver.findElement(by).click();
			LOGGER.info("The element: " + by.toString() + " is clicked");

		} catch (Exception e) {
			throw new ElementNotFoundException(by.toString());
		}

	}

	protected void changeElementDisplayNone(By by) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(by);
		js.executeScript("arguments[0].setAttribute('style', 'display:none')", element);
	}

	protected void changeElementDisplayBlock(By by) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(by);
		js.executeScript("arguments[0].setAttribute('style', 'display:block')", element);
	}

	protected void clickTest(WebElement el) {
		el.click();
	}

	/**
	 * clear text element
	 *
	 * @param by
	 */
	protected void clearElementText(By by) {
		try {
			driver.findElement(by).clear();
		} catch (Exception e) {
			throw new ElementNotFoundException(by.toString());
		}
	}

//    protected boolean elementIsVisible(By by) {
//    	return driver.findElement(by).isDisplayed();
//    }

	/**
	 * click on element by index
	 *
	 * @param by
	 * @param index
	 */
	protected void clickOnElement(By by, int index) {
		try {
			driver.findElements(by).get(index).click();
			LOGGER.info("The element: " + by.toString() + " at given index " + index + " is clicked");

		} catch (Exception e) {
			throw new ElementNotFoundException(by.toString());

		}
	}

	/**
	 * get text from element
	 *
	 * @param by
	 * @return
	 */
	protected String getText(By by) {
		String text;
		try {
			text = driver.findElement(by).getText();
			LOGGER.info("The text of element " + by.toString() + " is " + text);
			return text;

		} catch (Exception e) {
			throw new ElementNotFoundException(by.toString());

		}
	}

	/**
	 * get text from element by index
	 *
	 * @param by
	 * @param index
	 * @return
	 */
	protected String getText(By by, int index) {
		String text;
		try {
			text = driver.findElements(by).get(index).getText();
			LOGGER.info("The text of element " + by.toString() + " at given " + index + " is " + text);
			return text;

		} catch (Exception e) {
			throw new ElementNotFoundException(by.toString());

		}

	}

	/**
	 * type text
	 *
	 * @param by
	 * @param text
	 */
	protected void typeText(By by, String text) {

		try {
			clearElementText(by);
			driver.findElement(by).sendKeys(text);
			LOGGER.info("The text " + text + " is send to " + by.toString());

		} catch (Exception e) {
			throw new ElementNotFoundException(by.toString());

		}

	}

	protected void typeTextWithoutClear(By by, String text) {

		driver.findElement(by).sendKeys(text);
		LOGGER.info("The text " + text + " is send to " + by.toString());

	}

	/**
	 * type text at index
	 *
	 * @param by
	 * @param index
	 * @param text
	 */
	protected void typeText(By by, int index, String text) {
		try {
			driver.findElements(by).get(index).sendKeys(text);
			LOGGER.info("The text " + text + " is send to " + by.toString());

		} catch (Exception e) {
			throw new ElementNotFoundException(by.toString());

		}

	}

	/**
	 * type number
	 *
	 * @param by
	 * @param index
	 * @param text
	 */
	protected void typeText(By by, int number) {
		try {
			driver.findElement(by).sendKeys(String.valueOf(number));
			LOGGER.info("The text " + number + " is send to " + by.toString());

		} catch (Exception e) {
			throw new ElementNotFoundException(by.toString());

		}

	}

	/**
	 * Get page title
	 *
	 * @return
	 */
	protected String getPageTitle() {
		String title = driver.getTitle();
		LOGGER.info("The Page title is " + title);
		return title;
	}

	/**
	 * Navigate to given url page
	 *
	 * @param url
	 */
	protected void navigateToUrl(String url) {
		driver.navigate().to(url);
		LOGGER.info("Navige to url: " + url);
	}

	/**
	 * Refresh/update page
	 */
	public void refreshPage() {
		driver.navigate().refresh();
		LOGGER.info("The page is refreshed");
	}

	/**
	 * Navigate back from the page
	 */
	protected void navigateBackFromThePage() {
		driver.navigate().back();
		LOGGER.info("navigateBackFromThePage() method is executed");

	}

	/**
	 * Navigate forward from the page
	 */
	protected void navigateForwardFromThePage() {
		driver.navigate().forward();
		LOGGER.info("navigateForwardFromThePage() method is executed");

	}

	/**
	 * Sets the amount of time to wait for a page load to complete before throwing
	 * an error. If the timeout is negative, page loads can be indefinite.
	 *
	 * @param timeOut
	 */
	protected void pageLoad(long timeOut) {
		driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
		LOGGER.info("pageLoad() method is executed");
	}

	/**
	 * The command retrieve the URL of the webPage the user is currently accessing
	 */
	protected String getCurrentUrl() {
		String url = driver.getCurrentUrl();
		LOGGER.info("The page url is: " + url);
		return url;
	}

	/**
	 * Switch to frame
	 *
	 * @param by
	 */
	protected void switchFrames(By by) {
		WebElement element = driver.findElement(by);
		driver.switchTo().frame(element);

	}

	/**
	 * Switch to frame
	 *
	 * @param by
	 */
	protected void switchDefault() {
		driver.switchTo().defaultContent();
	}

	/**
	 * Open ur
	 *
	 * @param url
	 */
	public void openUrl(String url) {
		driver.get(url);
	}

	/**
	 * Check if element enabled
	 *
	 * @param by
	 */
	protected boolean isElementEnabled(By by) {
		return driver.findElement(by).isEnabled();
	}

	/**
	 * Checks if element is displayed
	 *
	 * @param by
	 * @return
	 */
	protected boolean isElementDisplayed(By by) {
		try {
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			return driver.findElement(by).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * Checks if element exists
	 *
	 * @param by
	 * @return
	 */
	protected boolean elementExists(By by) {
		return driver.findElements(by).size() != 0;
	}

	/**
	 * Checks if element with given inner text exists
	 *
	 * @param by
	 * @return
	 */
	protected boolean elementExistsWithInnerText(String text) {
		return driver.findElements(By.xpath("//*[contains(text(), text)]")).size() != 0;
	}

	/**
	 * Check if with the same path elements are displayed
	 *
	 * @param by
	 * @param index
	 * @return
	 */
	protected boolean isElementsDisplayed(By by, int index) {
		return driver.findElements(by).get(index).isDisplayed();
	}

	protected String returnElementInnerText(By by) {
		WebElement element = driver.findElement(by);
//		return element.getAttribute("innerText");
		return element.getText();
	}

	/**
	 * Getting elements from page
	 *
	 * @param by
	 * @return
	 */

	protected List<WebElement> getElements(By by) {
		List<WebElement> elements = driver.findElements(by);

		return elements;
	}
	
	protected WebElement getElement(By by) {
		WebElement element = driver.findElement(by);

		return element;
	}

	/**
	 * Check elements count on page
	 *
	 * @param by
	 * @return
	 */
	protected int getElementsCount(By by) {
		return driver.findElements(by).size();

	}

	/**
	 * Drag the sourceElement and drop to targetElement
	 *
	 * @param sourceElement
	 * @param targetElement
	 */
	protected void dragAndDropElement(By sourceElement, By targetElement) {
		WebElement sourceLocator = driver.findElement(sourceElement);
		WebElement destinationLocator = driver.findElement(targetElement);
		Actions actions = new Actions(driver);
		actions.dragAndDrop(sourceLocator, destinationLocator).build().perform();

	}

	/**
	 * Hove/move over web elements like over menu to see submenu etc.
	 *
	 * @param by
	 */
	protected void moveToElement(By by) {
		WebElement element = driver.findElement(by);
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();

	}

	/**
	 * Get element Atribute
	 *
	 * @param by
	 * @param attribute
	 * @return
	 */
	protected String getAttribute(By by, String attribute) {
		return driver.findElement(by).getAttribute(attribute);
	}

	/**
	 * The command is used to retrieve the page source of the webpage the user is
	 * currently accessing.
	 *
	 * @return
	 */
	protected String getPageSource() {
		return driver.getPageSource();
	}

	/**
	 * Closes the web browser window that the user is currently working on or we can
	 * also say the window that is being currently accessed by the WebDriver
	 */
	protected void closeWindow() {
		driver.close();
	}

	/**
	 * Closes down all the windows that the program has opened. Do not confuse with
	 * closeWindow() method
	 */
	protected void quiteWindow() {
		driver.quit();
	}

	/**
	 * Mouse hover to element of given index.
	 *
	 * @param by
	 * @param index
	 */
	protected void mouseHover(By by, int index) {
		WebElement element = driver.findElements(by).get(index);
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();

	}

	/**
	 * Mouse hover to element
	 *
	 * @param by
	 */
	protected void mouseHover(By by) {
		WebElement element = driver.findElement(by);
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();

	}

	/**
	 * Selecting multiple items by value in a drop drop down list.
	 *
	 * @param by
	 * @param value
	 */
	protected void selectByValue(By by, String value) {
		Select selectByValue = new Select(driver.findElement(by));
		selectByValue.selectByValue(value);
	}

	/**
	 * Selecting multiple items by visibility of text in a drop drop down list.
	 *
	 * @param by
	 * @param text
	 */
	protected void selectByVisibleText(By by, String text) {
		Select selectByValue = new Select(driver.findElement(by));
		selectByValue.selectByVisibleText(text);

	}

	/**
	 * Check if radio button is selected
	 *
	 * @param by
	 */
	protected boolean isRadioButtonChecked(By by) {
		return driver.findElement(by).isSelected();
	}

	/**
	 * Check if radio buttons are selected
	 *
	 * @param by
	 * @param index
	 */
	protected boolean isRadioButtonsChecked(By by, int index) {
		return driver.findElements(by).get(index).isSelected();
	}

	/**
	 * Selecting multiple items by index of text in a drop drop down list.
	 *
	 * @param by
	 * @param index
	 */
	protected void selectByIndex(By by, int index) {
		Select selectByValue = new Select(driver.findElement(by));
		selectByValue.selectByIndex(index);

	}

	/**
	 * Scrolling to element.
	 *
	 * @param by
	 */
	protected void scrollToElement(By by) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver.findElement(by));

	}

	/**
	 * Scrolling to element.
	 *
	 * @param by
	 */
	protected void scrollToWebElement(WebElement elem) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elem);

	}

	/**
	 * CLear fields.
	 *
	 * @param by
	 */
	protected void clearFields(By by) {
		List<WebElement> elements = driver.findElements(by);
		for (int i = 0; i < elements.size(); i++) {
			elements.get(i).clear();
		}
	}

	/**
	 * Switch driver to another tab.
	 *
	 * @param index
	 */
	protected void switchDriverToNewTab(int index) {
		ArrayList<String> availableWindows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(availableWindows.get(index));
	}

	/**
	 * Change element's visibility to true
	 *
	 * @param by
	 */
	protected void changeVisibilitytoVisible(By by) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('display', 'block')", driver.findElement(by));
	}

	/**
	 * Clicks on key Enter
	 *
	 * @param by
	 */
	protected void clickOnEnter(By by) {
		driver.findElement(by).sendKeys(Keys.ENTER);
	}

	/**
	 * Finds the elements with the same attributes
	 *
	 * @param by
	 */
	protected List<WebElement> returnListOfElementsBy(By by) {
		return driver.findElements(by);
	}

	/**
	 * Gets the checked attribute value of the element (for custom radio buttons)
	 *
	 * @param by
	 */
	protected String getAttributeValueOf(By by, String attr) {
//		return driver.findElement(by).getAttribute("aria-checked");
		return driver.findElement(by).getAttribute(attr);
	}

	protected String getAttributeValueOf(WebElement by, String attr) {
//		return driver.findElement(by).getAttribute("aria-checked");
		return by.getAttribute(attr);
	}

	/**
	 * Switch test window to an IFrame
	 *
	 * @param by
	 */
	protected void switchToIFrame(By by) {
		driver.switchTo().frame(0);
	}

	/**
	 * Finds element via inner text
	 *
	 * @param by
	 */
	protected WebElement returnElementByInnerText(String text) {
		return driver.findElement(By.xpath("//*[contains(text()," + text + ")]"));
	}

	/**
	 * Return WebElement of given By object
	 *
	 * @param by
	 */
	protected WebElement returnWebElementObjectOf(By by) {
		return driver.findElement(by);
	}

}
