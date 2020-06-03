import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pages.HomePage;

public class FilterTest extends BaseTest {
  @Description("Test filters with hashTag")
  @Test()
  public void filtersTest() {
    HomePage homePage = new HomePage();
    homePage.navigate();
    homePage.selectFilterByIndex(0);
    homePage.assertTagInHeader();
    homePage.assertTagInArticle();
  }
}
