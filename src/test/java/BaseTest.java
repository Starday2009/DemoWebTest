import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import utils.TestListener;
import utils.WebDriverFactory;

@Listeners({TestListener.class})
public class BaseTest {

  @BeforeTest()
  public void setUp() {
    WebDriverFactory.createInstance("Chrome");
  }

  @AfterTest()
  public void tearDown() {
    WebDriverFactory.getDriver().quit();
  }
}
