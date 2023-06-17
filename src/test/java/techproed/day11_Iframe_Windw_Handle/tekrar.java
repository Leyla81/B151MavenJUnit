package techproed.day11_Iframe_Windw_Handle;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class tekrar extends TestBase {
    @Test
    public void name() {

        //➢ https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        //   Ana sayfadaki 'An iframe with a thin black border:' metninde 'black border' yazisinin   oldugunu test edelim
        String metin=driver.findElement(By.xpath("(//p)[1]")).getText();
        System.out.println("metin = " + metin);
        Assert.assertTrue(metin.contains(" black border"));

        //➢    Ayrica 'Applications lists' yazisinin sayfada oldugunu test edelim
       driver.switchTo().frame(0); //frame gecis yaparak exceptiondan kurtulduk
        String ApplicationslistYazisi=driver.findElement(By.xpath("//h1")).getText();
        System.out.println("Applicationslists = " + ApplicationslistYazisi);
        Assert.assertEquals("Applications lists",ApplicationslistYazisi); //noSuchElemenException aldık bu yuzden yukarida iframe e cevirdik
//Son olarak sayfa başınlığında iframe yazısının görünür olduğunu test ediniz
        driver.switchTo().defaultContent();
        //driver.get(driver.getCurrentUrl()); --> Sayfayı yeniledik
        //driver.navigate().refresh();
        WebElement iframeYazisi = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(iframeYazisi.isDisplayed());









    }



}
