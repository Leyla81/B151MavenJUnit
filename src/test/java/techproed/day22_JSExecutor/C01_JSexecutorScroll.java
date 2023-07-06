package techproed.day22_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_JSexecutorScroll extends TestBase {

    /*
    Actions class'ındaki gibi java script ile de sayfada scroll islemi yapabiliriz.
     bir webelementi locate edip o webelement gorunur olana kadar scroll yapabiliriz
     "arguments[0].scrollIntoView(true);,WebElement --->bu script kodu ile belirtmis oldugumuz webelemente scroll yapabiliriz
     */
    @Test
    public void test01() {
        //Techpro education ana sayfasına git
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//reklamı kapattık

//"We Offer" elementi görünür olacak şekilde üzerine scroll et ve ekran görüntüsünü al
        WebElement weOffer = driver.findElement(By.xpath("//span[text()='we offer']"));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true)",weOffer);
         bekle(2);
        tumSayfaResmi();//testBase deki screenShot methodu

//Aynı sayfada "Enroll Free "elementi görünür olacak sekilde scroll et ve ekran görüntüsünü al
      WebElement EnrollFree = driver.findElement(By.xpath("//*[.='Enroll Free Course']"));
        jse.executeScript("arguments[0].scrollIntoView(true)",EnrollFree);
        bekle(2);
        tumSayfaResmi();

//Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
WebElement whyUs = driver.findElement(By.xpath("//h3[text()='WHY US?']"));
        jse.executeScript("arguments[0].scrollIntoView(true)",whyUs);
        bekle(2);
        tumSayfaResmi();

//Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        jse.executeScript("arguments[0].scrollIntoView(true)",EnrollFree);
        bekle(2);
        tumSayfaResmi();

//Sayfayı en alta scroll yapalım ----window.scrollTo(0,document.body.scrollHeight --- sayfayı asagı tasımak icin
        jse.executeScript("window.scrollTo(0,document.body.scrollHeight");

//Sayfayi en üste scroll yapalım ----window.scrollTo(0,-document.body.scrollHeight---sayfayi yukarı tasımak icin method
        jse.executeScript("window.scrollTo(0,-document.body.scrollHeight");


    }

    @Test
    public void test02() {
        //Techpro education ana sayfasına git
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//reklamı kapattık
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollTo(0,2000)");//bu sekilde de kullanılabilir
    }

    @Test
    public void test03() {//-------------TestBase classındaki method ile
        //Techpro education ana sayfasına git
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //"We Offer" elementi görünür olacak şekilde üzerine scroll et ve ekran görüntüsünü al
        WebElement weofferWE = driver.findElement(By.xpath("//*[.='we offer']"));
        jsScrollWE(weofferWE);
        bekle(2);
        tumSayfaResmi();//-->TestBase deki ScreenShot methodu

        //Aynı sayfada "Enroll Free "elementi görünür olacak sekilde scroll et ve ekran görüntüsünü al
        WebElement enrollFreeWE = driver.findElement(By.xpath("//*[.='Enroll Free Course']"));
        jsScrollWE(enrollFreeWE);
        bekle(2);
        tumSayfaResmi();

        //Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        WebElement whyUsWE = driver.findElement(By.xpath("//*[text()='WHY US?']"));
        jsScrollWE(whyUsWE);
        bekle(2);
        tumSayfaResmi();

        //Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        jsScrollWE(enrollFreeWE);
        bekle(2);
        tumSayfaResmi();

        //Sayfayı en alta scroll yapalım
        scrollEnd();
        bekle(2);
        //Sayfayi en üste scroll yapalım
        scrollHome();
    }
}
