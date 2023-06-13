package techproed.day10_testBase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Alert extends TestBase {





    @Test
    public void acceptAlert1() { //Bir metod olusturun: acceptAlert
       //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("   https://testcenter.techproeducation.com/index.php?page=javascript-alerts ");


        //1. butona tıklayın,
    driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();

        //uyarıdaki OK butonuna tıklayın
    driver.switchTo().alert().accept();//switchTo() allert e cevirir inceleme yapılamayan butonu kapatır


        //ve result mesajının "You successfully clicked an alert" oldugunu test edin.
String actualResult=driver.findElement(By.xpath("//*[@id='result']")).getText();
        System.out.println("actualResult : "+actualResult);
String expectedResult="You successfully clicked an alert";
        Assert.assertEquals(expectedResult,actualResult);


    }

    @Test
    public void dismissAlert() {// Bir metod olusturun: dismissAlert
        driver.get("   https://testcenter.techproeducation.com/index.php?page=javascript-alerts ");

       // 2. butona tıklayın,
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();


       // uyarıdaki Cancel butonuna tıklayın
        driver.switchTo().alert().dismiss();




       // ve result mesajının "successfuly" icermedigini test edin.
 String resulrMsj= driver.findElement(By.xpath("//p[@id='result']")).getText();
 String expectedMsj ="succesfully";
 Assert.assertFalse(expectedMsj.contains(resulrMsj));

    }


    @Test
    public void sendKeysAlert() {


        // Bir metod olusturun: sendKeysAlert
        // https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        // 3. butona tıklayın,
        driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[3]")).click();

        // uyarıdaki mesajı konsolda yazdırın,
        System.out.println(("I am a JS prompt"));
        // uyarıdaki metin kutusuna isminizi yazin,
        driver.switchTo().alert().sendKeys("Leyla Simitci");
        //         OK butonuna tıklayın
        driver.switchTo().alert().accept();
        // ve result mesajında isminizin görüntülendiğini doğrulayın.
        String actualResult = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedResult = "Leyla Simitci";
        Assert.assertTrue(actualResult.contains(expectedResult));

    }
}
