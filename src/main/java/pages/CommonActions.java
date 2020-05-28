package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Element;

import java.util.concurrent.TimeUnit;

public class CommonActions {
  private static final int PAGE_LOAD_MAXIMUM_SECONDS = 50;
  public WebDriver driver;

  public CommonActions(WebDriver driver) {
    this.driver = driver;
  }

  public CommonActions() {}

  protected Element find(By by) {
    String elementStr = String.valueOf(by);
    Element element = new Element(null);
    WebDriverWait wait = new WebDriverWait(driver, PAGE_LOAD_MAXIMUM_SECONDS);
    try {
      loggerPrint("Try to find element- \"" + elementStr + "\" ");
      wait.until(ExpectedConditions.presenceOfElementLocated(by));
      element = new Element(driver.findElement(by));
      driver.findElement(by);
    } catch (WebDriverException | NullPointerException e) {
      loggerPrint("Element did not appear");
      failTest("Element \"" + elementStr + "\" did not appear, see screen");
    }
    return element;
  }

  public boolean isElementDisplayed(By by) {
    boolean isDisplayed = true;
    try {
      driver.findElement(by).isDisplayed();
      WebDriverWait wait = new WebDriverWait(driver, 3);
      WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
      loggerPrint("isDisplayed is true for element");
    } catch (NoSuchElementException | TimeoutException e) {
      isDisplayed = false;
    }
    return isDisplayed;
  }

  public void failTest(String message) {
    loggerPrintError(message);
    Assert.fail(message);
  }

  public void loggerPrint(String message) {
    DemoLogger.getInstance().loggerPrint(message);
  }

  protected void loggerPrintError(String message) {
    DemoLogger.getInstance().loggerPrintError(message);
  }
}
