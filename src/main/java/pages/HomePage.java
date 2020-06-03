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

  String selectedFilterName;

  private By hashTagList =
      By.xpath(
          "//a[contains(@class, 'tag-default tag-pill ng-binding ng-scope') and child::text()]");
  private By currentHashTag =
      By.xpath("//a[contains(@class, 'nav-link active ng-binding') and child::text()]");
  private By tagInArticleList = By.xpath("//ul[contains(@class,  'tag-list') and child::text()]");

  public HomePage() {
    this.driver = WebDriverFactory.getDriver();
    commonActions = new CommonActions(driver);
  }

  @Step("Open page: " + base)
  public void navigate() {
    commonActions.loggerPrint("Open page: " + base);
    driver.get(base);
  }

  @Step("Assert test tag is displayed")
  public void assertTagInHeader() {
    commonActions.loggerPrint("Assert that #test tag is displayed");
    String filterNameInHeader = commonActions.find(currentHashTag).getText();
    Assert.assertEquals(filterNameInHeader, selectedFilterName);
  }

  @Step("Select filter by index")
  public void selectFilterByIndex(Integer index) {
    selectedFilterName =
        commonActions.find(hashTagList).findElements(hashTagList).get(index).getText();
    commonActions.find(hashTagList).findElements(hashTagList).get(index).click();
  }

  @Step
  public void assertTagInArticle() {
    Object[] tagInArticleListArray = commonActions.find(tagInArticleList).findElements(tagInArticleList).toArray();
    for (int i = 0; i < tagInArticleListArray.length; i++) {
      String tag = commonActions.find(tagInArticleList).findElements(tagInArticleList).get(i).getText();
      Assert.assertTrue(tag.contains(selectedFilterName));
    }
  }
}
