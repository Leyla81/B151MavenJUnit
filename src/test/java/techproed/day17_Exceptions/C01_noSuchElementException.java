package techproed.day17_Exceptions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C01_noSuchElementException extends TestBase {
    @Test
    public void test01() {

      /*
      No Such Element Exception = bir elementim locate ini yanlıs aldıgımız da element bulamaz
      ve "no such element" exception fırlatır
       */

        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //reklamı kapat
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //arama kutusunda qa aratalım

driver.findElement(By.xpath("//input[@id='elementor-searchs-form-9f26725']")).sendKeys("qa", Keys.ENTER);

//"//input[@id='elementor-search-form-9f26725']"))---->burdaki locate i bozduk no suc elemen versin diye

        //sayfa başlığının qa içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("qa"));

    }

    @Test
    public void test02() {
        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        //reklamı kapat
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //arama kutusunda qa aratalım

        driver.findElement(By.cssSelector("//input[@id='elementor-search-form-9f26725']")).sendKeys("qa", Keys.ENTER);
         /*
    org.openqa.selenium.InvalidSelectorException: xpath ile aldığımız bir webelementin locate'ini
    cssSelector locator ile kullanırsak bu exception'ı alırız. Dolayısıyla bunu handle etmek için
    doğru locator'ı kullanmamız gerekir.
     */

//"//input[@id='elementor-search-form-9f26725']"))---->burdaki locate i bozduk no suc elemen versin diye

        //sayfa başlığının qa içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("qa"));

    }

    }

