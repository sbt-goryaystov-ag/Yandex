package yandex.auto.steps;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import yandex.auto.util.Init;
import yandex.auto.util.TestProperties;

import java.util.concurrent.TimeUnit;


public class BaseSteps {

    private static WebDriver driver;

    @BeforeClass
    public static void setUp() throws Exception {

        String browser = TestProperties.getInstance().getProperties("browser");

        switch (browser){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", TestProperties.getInstance().getProperties("webdriver.chrome.driver"));
                driver = new ChromeDriver();
                Init.setDriver(driver);
                break;
            default:
                throw new AssertionError();
        }

        String baseUrl = TestProperties.getInstance().getProperties("appUrl");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }
}