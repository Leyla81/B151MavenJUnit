package techproed.day08_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_Assertions {
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    @Test
    public void test01() {

// https://amazon.com sayfasına gidin
// sayfa baslıgının "Amazon" kelimesini icerdigini test edin
        driver.get("https://amazon.com");
        String sayfaBasligi =driver.getTitle();
        Assert.assertTrue(sayfaBasligi.contains("Amazon"));
    }

    @Test
    public void test02() {
// https://amazon.com sayfasına gidin
// Amazon resminin görüntülendiğini (isDisplayed()) test edin
        driver.get("https://amzon.com");
      WebElement logo= driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));
      Assert.assertTrue(logo.isDisplayed());

    }

    @Test
    public void test03() {
// https://amazon.com sayfasına gidin
// arama kutusunun erisilebilir oldugunu test edin
        driver.get("https://amazon.com");
       WebElement aramaKutusu= driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
       Assert.assertTrue(aramaKutusu.isEnabled());
    }

    @Test
    public void test04() {
        // https://amazon.com sayfasına gidin
// sayfa baslıgının "kitap" icermedigini test edin
        driver.get("https://amazon.com");
        String title = driver.getTitle();
        Assert.assertFalse(title.contains("kitap"));
    }













}
