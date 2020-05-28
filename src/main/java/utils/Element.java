package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CommonActions;

import java.util.List;

import static java.lang.Thread.sleep;

public class Element extends CommonActions implements WebElement {
  private WebElement element;

  public Element(WebElement element) {
    this.element = element;
  }

  @Override
  public void click() {
    try {
      element.click();
    } catch (StaleElementReferenceException e) {
      try {
        sleep(3000);
      } catch (InterruptedException ex) {
        ex.printStackTrace();
      }
      element.click();
    }
  }

  @Override
  public void submit() {
    element.submit();
  }

  @Override
  public void sendKeys(CharSequence... keysToSend) {
    loggerPrint(String.format("Enter value: %s", keysToSend));
    element.sendKeys(keysToSend);
  }

  @Override
  public void clear() {
    try {
      element.clear();
    } catch (ElementNotInteractableException e) {
      element.clear();
    }
  }

  @Override
  public String getTagName() {
    return element.getTagName();
  }

  @Override
  public String getAttribute(String name) {
    return element.getAttribute(name);
  }

  @Override
  public boolean isSelected() {
    return element.isSelected();
  }

  @Override
  public boolean isEnabled() {
    return element.isEnabled();
  }

  @Override
  public String getText() {
    return element.getText();
  }

  @Override
  public List<WebElement> findElements(By by) {
    return element.findElements(by);
  }

  @Override
  public Element findElement(By by) {
    return new Element(element.findElement(by));
  }

  @Override
  public boolean isDisplayed() {
    try {
      return element.isDisplayed();
    } catch (TimeoutException e) {
      return false;
    }
  }

  public boolean isVisible() {
    try {
      return element.isDisplayed();
    } catch (NullPointerException e) {
      return false;
    } catch (StaleElementReferenceException i) {
      return true;
    }
  }

  @Override
  public Point getLocation() {
    return element.getLocation();
  }

  @Override
  public Dimension getSize() {
    return element.getSize();
  }

  @Override
  public Rectangle getRect() {
    return element.getRect();
  }

  @Override
  public String getCssValue(String propertyName) {
    return element.getCssValue(propertyName);
  }

  @Override
  public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
    return element.getScreenshotAs(target);
  }

  public void selectByVisibleText(String value) {
    new Select(element).selectByVisibleText(value);
  }

}
