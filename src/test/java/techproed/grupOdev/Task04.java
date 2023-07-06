package techproed.grupOdev;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Task04 extends TestBase {






   //
  //-Çıkan mesajı konsola yazdırınız
  //-Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız

    @Test
    public void test01() throws InterruptedException {
        //-http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
        driver.get("http://demo.automationtesting.in/Alerts.html");

        // -Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız
        WebElement alert = driver.findElement(By.xpath("//*[@onclick='alertbox()']"));
        alert.click();

        //-Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        //-Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız
        driver.findElement(By.xpath("(//*[@class='analystic'])[2]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@onclick='confirmbox()']")).click();
        Thread.sleep(2000);

        //-Çıkan alert'te iptal butonuna basınız
        driver.switchTo().alert().dismiss();
        //-Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız
        driver.findElement(By.xpath("//*[text()='Alert with Textbox ']")).click();
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("button[onclick='promptbox()']")).click();
        Thread.sleep(2000);

       // -Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız
        driver.switchTo().alert().sendKeys("Leyla");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        //-Çıkan mesajı konsola yazdırınız

        System.out.println(driver.findElement(By.xpath("//*[@id='demo1']")).getText());

        //-Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız
        Assert.assertEquals("Hello Leyla How are you today",driver.findElement(By.xpath("//*[@id='demo1']")).getText());



}
}
