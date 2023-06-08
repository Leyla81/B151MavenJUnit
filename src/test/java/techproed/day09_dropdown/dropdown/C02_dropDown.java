package techproed.day09_dropdown.dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_dropDown {
    /*
    -getFrstOption()------>dropdown daki enson sectigimiz optionı dondurur
    -getOptions----------->dropdowndaki tum optionları bize dondurur
     */
WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void dropDown() {
        // https://testcenter.techproeducation.com/index.php?page=dropdown sayfasına gidiniz
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

        // Select a State Dropdown'undan "Arizona" seciniz

WebElement state =driver.findElement(By.xpath("//select[@id='state']"));
        Select select =new Select(state);
        select.selectByVisibleText("Arizona");
        //select.selectByValue("AZ");

        // Select a State Dropdown'undan son secilen option'un "Arizona" oldugunu test ediniz
       WebElement sonOption= select.getFirstSelectedOption();
      String sonOptionStr= sonOption.getText() ;      //---->sonOption WebElement oldugundan getText() ile String e cevirdik
        Assert.assertEquals("Arizona",sonOptionStr);

        // Select a State Dropdown'undaki tum optionları konsolda yazdırınız
      //  System.out.println(select.getOptions());

        List <WebElement>allOption=select.getOptions();
     /*   for (WebElement each:allOption) {
            System.out.println(each.getText());
        }
        */
      //lambda ile yapımı
        allOption.stream().forEach(t-> System.out.println(t.getText()));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
