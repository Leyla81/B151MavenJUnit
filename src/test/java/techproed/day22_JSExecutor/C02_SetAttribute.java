package techproed.day22_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_SetAttribute extends TestBase {
    @Test
    public void test01() {
        //Techpro education ana sayfasina git reklamı kapat

        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

//Arama kutusuna QA yaz

       /*
    <input> tag'ina sahip webelementlere deger gonderirken sendKeys() methodu kullaniriz
    sendKeys() methodu ile deger gonderemedigimiz durumlarda js executor ile rahatlikla deger gonderebiliriz
 */
        WebElement aramakutusu = driver.findElement(By.xpath("//*[@type='search']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='QA'",aramakutusu);//value attribute u aramakutusu icine girilen degeri temsil eder
                                                                        //arama kutusunaQA yazdirir.



    }

    @Test
    public void test02() { //---------testBase class ındaki method ile
        //Techpro education ana sayfasina git reklamı kapat

        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

//Arama kutusuna QA yaz
        WebElement aramakutusu = driver.findElement(By.xpath("//*[@type='search']"));
      jsSendKeys("java",aramakutusu);
    }

    @Test
    public void test03() {//---------------setAttribute('value','QA')methodu ile
        //Techpro education ana sayfasina git reklamı kapat

        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();


//Arama kutusuna QA yaz
        WebElement aramakutusu = driver.findElement(By.xpath("//*[@type='search']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].setAttribute('value','QA')",aramakutusu);

    }

    @Test
    public void test04() {//-----arama kutusu locate nde id attribute degistirme
        //Techpro education ana sayfasina git reklamı kapat

        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();


//Arama kutusuna QA yaz
        WebElement aramakutusu = driver.findElement(By.xpath("//*[@type='search']"));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].setAttribute('id','leyla')",aramakutusu);
        driver.findElement(By.id("leyla")).sendKeys("java", Keys.ENTER);

    }


    @Test
    public void test05() {//-------------TestBase Method ile
        //Techpro education ana sayfasina git reklamı kapat

        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();


//Arama kutusuna QA yaz
        WebElement aramakutusu = driver.findElement(By.xpath("//*[@type='search']"));
        jsSetAttribute("value","QA",aramakutusu);//testBase method
    }
}
