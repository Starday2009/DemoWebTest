package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.WebDriverFactory;

import static pages.PagesURLs.base;

public class HomePage {
  WebDriver driver;
  CommonActions commonActions;

  String filterName;
  private By testTagName =
      By.xpath("//a[contains(@class, 'tag-default tag-pill ng-binding ng-scope')]");
  private By dragonsTagName =
      By.xpath("//a[contains(@class, 'tag-default tag-pill ng-binding ng-scope')][3]");
  private By currentHashTag =
      By.xpath("//a[contains(@class, 'nav-link active ng-binding') and child::text()]");

  public HomePage() {
    this.driver = WebDriverFactory.getDriver();
    commonActions = new CommonActions(driver);
  }

  @Step("Open page: " + base)
  public void navigate() {
    commonActions.loggerPrint("Open page: " + base);
    driver.get(base);
  }

  @Step("Select filter #test")
  public void selectFirstFilter() {
    commonActions.find(testTagName).click();
  }

  @Step("Assert test tag is displayed")
  public void assertTestTag() {
    commonActions.loggerPrint("Assert that #test tag is displayed");
    commonActions.find(currentHashTag).isDisplayed();
    filterName = driver.findElement(currentHashTag).getText();
    Assert.assertEquals(filterName, "test");
  }

  @Step("Select filter #dragons")
  public void selectSecondFilter() {
    commonActions.find(dragonsTagName).click();
  }

  @Step("Assert #dragons tag is displayed")
  public void assertDragonsTag() {
    commonActions.loggerPrint("Assert that #dragons tag is displayed");
    commonActions.find(currentHashTag).isDisplayed();
    filterName = driver.findElement(currentHashTag).getText();
    Assert.assertEquals(filterName, "dragons");
  }
}
