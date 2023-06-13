package techproed.grupOdev;

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

public class AssertionsOdev {


//   1)Bir class oluşturun: YoutubeAssertions
// https://www.youtube.com adresine gidin
//3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
// Sayfa başlığının “YouTube” oldugunu test edin
// YouTube resminin görüntülendiğini (isDisplayed()) test edin
// Search Box 'in erisilebilir oldugunu test edin (isEnabled())
// ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.youtube.com");
    }

    @Test
    public void test01() {
       String actualtitle= driver.getTitle();
       String expectedTitle="YouTube";
        Assert.assertEquals(expectedTitle,actualtitle);

    }

    @Test
    public void test02() {
      WebElement logo= driver.findElement(By.xpath("(//yt-icon)[6]"));
      Assert.assertTrue(logo.isDisplayed());

    }

    @Test
    public void test03() {
      WebElement searchBox=  driver.findElement(By.xpath("//input[@id='search']"));
      Assert.assertTrue(searchBox.isEnabled());
    }

    @Test
    public void test04() {
        String actualtitle= driver.getTitle();
        String expectedTitle="youtube";
       // Assert.assertNotEquals(expectedTitle,actualtitle);
        Assert.assertFalse(expectedTitle.equals(actualtitle));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
