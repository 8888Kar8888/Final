import org.example.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    protected WebDriver driver;
    protected HomePage homePage;
    private ScreenshotListener screenshotListener; // Declare the ScreenshotListener instance

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://marush.am/");
        homePage = new HomePage(driver);
        ScreenshotListener.setDriver(driver);
    }

//    @BeforeClass
//    public void SetUp() {
//        // Initialize the WebDriver
//        System.setProperty("webdriver.chrome.driver", ".idea/drivers/chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get("https://marush.am/");
//        homePage = new HomePage(driver);
//
//        // Initialize the ScreenshotListener and set the driver
//        screenshotListener = new ScreenshotListener();
//        ScreenshotListener.setDriver(driver);
//    }


    protected WebDriver getDriver() {
        return this.driver;
    }

    // Uncomment and use the tearDown method to properly close the WebDriver after tests
//    @AfterClass
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
