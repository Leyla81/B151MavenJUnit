package techproed.day07_Maven_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeAfter {
    WebDriver driver;
    @Before
    public void setUp()  {
        WebDriverManager.chromedriver().setup();
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void tecproedTest() {
        driver.get("https://techproeducation.com");
    }

    @Test
    public void amazonTest() {
        driver.get("https://amazon.com");
    }

    @After
    public void tearDown()  {
        driver.close();

    }

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("her classdan once bir kez calisir");

    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("her classdan sonra bir kez calisir");

    }
}
