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

  public HomePage(WebDriver driver) {
    this.driver = WebDriverFactory.getDriver();
    commonActions = new CommonActions(driver);
  }

  public static HomePage using(WebDriver driver) {
    return new HomePage(driver);
  }

  @Step("Open page: " + base)
  public HomePage navigate() {
    commonActions.loggerPrint("Open page: " + base);
    driver.get(base);
    return this;
  }

  @Step("Assert test tag is displayed")
  public HomePage assertTagInHeader() {
    commonActions.loggerPrint("Assert that #test tag is displayed");
    String filterNameInHeader = commonActions.find(currentHashTag).getText();
    Assert.assertEquals(filterNameInHeader, selectedFilterName);
    return this;
  }

  @Step("Select filter by index")
  public HomePage selectFilterByIndex(Integer index) {
    selectedFilterName =
        commonActions.find(hashTagList).findElements(hashTagList).get(index).getText();
    commonActions.find(hashTagList).findElements(hashTagList).get(index).click();
    return this;
  }

  @Step
  public HomePage assertTagInArticle() {
    Object[] tagInArticleListArray =
        commonActions.find(tagInArticleList).findElements(tagInArticleList).toArray();
    for (int i = 0; i < tagInArticleListArray.length; i++) {
      String tag =
          commonActions.find(tagInArticleList).findElements(tagInArticleList).get(i).getText();
      Assert.assertTrue(tag.contains(selectedFilterName));
      System.out.println(tag);
    }
    return this;
  }
}
