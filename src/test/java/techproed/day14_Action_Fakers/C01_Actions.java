package techproed.day14_Action_Fakers;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;
public class C01_Actions extends TestBase {
    @Test
    public void test01() {
        //tecpro sayfasına gidelim
        driver.get("https://techproeducation.com");

        //reklamı kapat
        WebElement reklam=driver.findElement(By.xpath("//i[@class='eicon-close']"));
        reklam.click();

        //sayfanın altına dogru gidelim
        Actions action =new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN,Keys.PAGE_DOWN).perform();

        //sayfanın ustune dogru gidelim

action.sendKeys(Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP,Keys.PAGE_UP).perform();

    }


    @Test
    public void test2() {
        //tecpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        //reklamı kapat
        WebElement reklam=driver.findElement(By.xpath("//i[@class='eicon-close']"));
        reklam.click();

        //sayfanın altına dogru gidelim
        Actions action =new Actions(driver);
        action.sendKeys(Keys.END);
        bekle(3);

        //sayfanın en üstüne scroll yapalım
        action.sendKeys(Keys.HOME).build().perform();
        //build() --> methodu action'ları birleştirmek için kullanılan methoddur.Birden fazla oluşturduğumuz action
        //objesini birbirine bağlar

       // release()---->methodu mouse serbest bırakır


    }
    @Test
    public void test03() {
        //tecpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        //reklamı kapat
        WebElement reklam=driver.findElement(By.xpath("//i[@class='eicon-close']"));
        reklam.click();

        //sayfanın altına dogru gidelim
        Actions action =new Actions(driver);
  action.scrollByAmount(0,1500).perform();//+ deger asagı indirir  - Deger yukarı cıkarır
        bekle(3);

        //sayfanın en üstüne dogru yapalım
    action.scrollByAmount(0,-1500);

    }


/*
her actions dan sonra perform kullanmazsak olay cok seri gerceklesir.
build kullandigimizda olay milisaniye icinde gerceklesir.
araya bekle methodu koysak bile java build methodunun oldugu kisimda sayfayi asagi yaparak hizli sekilde gerceklestirir

release() methodu kutuyu bir yerrden sürükleme veya eslestirme gibi konulari yaparken
mouseyi cekip birakmali sorularda release() methodu kullanilir
actionsta mouseta sürükleme islemi yapiyorsak serbest birakma islemi icin release() methodu kullanilir.
 *///build = kur , inşa et, oluştur.
    //build() -->methodu action'lari birlestirmek icin kullanilan methoddur.Birden fazla olusturdugumuz action
    //objesini birbirine baglar
    //release() methodu mouse'u birakir







}
