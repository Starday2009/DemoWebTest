import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import pages.HomePage;

public class FilterTest extends BaseTest {
  @Description("Test filters with hashtag #test and #dreagons")
  @Test()
  public void filtersTest() {
    HomePage homePage = new HomePage();
    homePage.navigate();
    homePage.selectFirstFilter();
    homePage.assertTestTag();
    homePage.selectSecondFilter();
    homePage.assertDragonsTag();
  }
}
