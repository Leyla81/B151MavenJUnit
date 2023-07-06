package techproed.day21_NightTime_Excel;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JsExecutor extends TestBase {

 /*
        Bir web sayfasinda bazi webelementler olusturulurken JAVASCRIPT kodlariyla olusturulmus olabilir.
    Bu webelementleri handle edebilmek icin JavaScriptExecutor arayuzunu kullanmamiz gerekir.
    Bir webelement JavaScript kodlari ile yazilmamis olsa da javaScriptExecutor ile o webelementi handle edebiliriz
    Normal bildigimiz methodlardan daha yavas calisacagi icin bildigimiz methodlar isimizi goruyorsa onlari kullaniriz
     */


    @Test
    public void test01() {
        //amazon sayfasına gidiniz
        driver.get("https://amazon.com");

        //Sell Linkinin resmini alalım alalım
        WebElement sell = driver.findElement(By.xpath("//*[text()='Sell']"));
        webElementResmi(sell);//testBase method ile

        //sell linkine jsExecutor kullanarak tıklayınız

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", sell);


        //Başlığın sell içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("Sell"));


        //Sayfanın resmini alalim
        tumSayfaResmi();//testBase method ile


    }

    @Test
    public void test02() {
        //Amazon sayfasına gidiniz
        driver.get("https://amazon.com");

        bekle(2);
        //sell linkinin resmini alalım
        WebElement sellLinki = driver.findElement(By.xpath("//*[.='Sell']"));
        webElementResmi(sellLinki);

        //Sell linkine tıklayınız
        sellLinki.click();
            /*
        JS executor ile Webelementin önünde uyarı çıkmasına rağmen webelemente click yaptı çünkü kodlara direk ulaşıyor
        Normal kullandığımız click methodu burda önünde farklı bir element olduğu için ElementClickInterceptedException:
        hatası verdi.Dolayısıyla bu exception ile karşılaştığımızda da js executor ile bunu çözebiliriz
         */



    }

    @Test
    public void test03() {
        //Amazon sayfasına gidiniz
        driver.get("https://amazon.com");

        bekle(2);
        //sell linkinin resmini alalım
        driver.findElement(By.className("a-button-inner")).click();//uyari kapatmak icin

        WebElement sell = driver.findElement(By.xpath("//*[.='Sell']"));
        webElementResmi(sell);

        //Sell linkine js executor kullanarak tıklayınız
        click(sell);
        //Başlığın Sell içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("Sell"));

        //Sayfanın resmini alalım
        tumSayfaResmi();
    }


}