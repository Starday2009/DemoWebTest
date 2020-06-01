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

  String firstFilterName;
  String secondFilterName;

  private By hashTagList =
          By.xpath("//a[contains(@class, 'tag-default tag-pill ng-binding ng-scope') and child::text()]");
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
    firstFilterName = commonActions.find(hashTagList).findElements(hashTagList).get(0).getText();
    commonActions.find(hashTagList).findElements(hashTagList).get(0).click();
  }

  @Step("Assert test tag is displayed")
  public void assertTestTag() {
    commonActions.loggerPrint("Assert that #test tag is displayed");
    String filterName = commonActions.find(currentHashTag).getText();
    Assert.assertEquals(filterName, firstFilterName);
  }

  @Step("Select filter #dragons")
  public void selectSecondFilter() {
    secondFilterName = commonActions.find(hashTagList).findElements(hashTagList).get(2).getText();
    commonActions.find(hashTagList).findElements(hashTagList).get(2).click();
  }

  @Step("Assert #dragons tag is displayed")
  public void assertDragonsTag() {
    commonActions.loggerPrint("Assert that #dragons tag is displayed");
    String filterName = commonActions.find(currentHashTag).getText();
    Assert.assertEquals(filterName, secondFilterName);
  }
}
