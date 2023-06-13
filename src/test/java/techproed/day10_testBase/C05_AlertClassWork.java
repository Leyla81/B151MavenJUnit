package techproed.day10_testBase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C05_AlertClassWork extends TestBase {


    @Test
    public void test01() {
        //https://demoqa.com/alerts adresine gidelim
        driver.get("https://demoqa.com/alerts");


//Click Button to see alert karşısındaki butona tıklayalım
        driver.findElement(By.xpath("(//button)[2]")).click();
//Çıkan Alert'te You clicked a button yazısının çıktığını doğrulayalım
        System.out.println(alertGetText());
        Assert.assertEquals("You clicked a button",alertGetText());

//Ve alert'ü kapatalım
        alertAccept();


    }

    @Test
    public void test02() {

        driver.get("https://demoqa.com/alerts");

        //On button click, confirm box will appear karşısındaki butona tıklayalım.
        driver.findElement(By.xpath("(//button)[4]")).click();

        //Çıkan alertte iptale basalım.
        alertDismiss();

        //sonuc yazısında You selected Cancel yazdığını doğrulayalım
        String sonucYazisi = driver.findElement(By.id("confirmResult")).getText();
        Assert.assertEquals("You selected Cancel",sonucYazisi);
    }
    @Test
    public void test03() {
        driver.get("https://demoqa.com/alerts");

        //On button click, prompt box will appear karşısındaki butona tıklayalım
        driver.findElement(By.xpath("(//button)[5]")).click();

       //çıkan alerte ismimizi girelim
        alertSendKeys("Leyla");
        bekle(2);
        alertAccept();
         //ismi girdiğimizi doğrulayalım

     String sonucYazisi =driver.findElement(By.id("promptResult")).getText();
     Assert.assertTrue(sonucYazisi.contains("Leyla"));

    }
}
