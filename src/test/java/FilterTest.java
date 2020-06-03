import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.WebDriverFactory;

public class FilterTest extends BaseTest {
  @Description("Test filters with hashTag")
  @Test()
  public void filtersTest() {
    HomePage.using(WebDriverFactory.getDriver())
    .navigate()
    .selectFilterByIndex(0)
    .assertTagInHeader()
    .assertTagInArticle();
  }
}
