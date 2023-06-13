package techproed.day10_testBase;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_AlertClassWork extends TestBase {
      /*
            Eğer bir sayfadaki bir buttona tıkladığımızda bir uyarı penceresi çıkıyorsa ve bu çıkan pencereye sağ klik
         yapıp locate alamıyorsak, bu bir js Alert'tür.
            js Alert'ü handle edebilmek için driver'ımızı o pencere geçirmemiz gerekir. Bunun için;
         driver objemizi kullanarak switchTo() methoduyla alert() methodunu kullanarak js alert'e geçiş yapmış oluruz
         accept() yada dismiss() methodlarıyla js Alert'ü onaylar yada iptal ederek kapatırız.
         */

    @Test
    public void test01() {
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //Bir metod olusturun: acceptAlert
        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının “You successfully clicked an alert” oldugunu test edin.
driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
driver.switchTo().alert().accept();
bekle(1);
        WebElement resultMsj=driver.findElement(By.xpath("//p[@id='result']"));
        String expectedMsj="You successfully clicked an alert";
        Assert.assertEquals(expectedMsj,resultMsj.getText());

    }
    @Test
    public void test2() {

            //Bir metod olusturun: dismissAlert
            //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
            driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
            //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının

            //“successfuly” icermedigini test edin.
        WebElement resultMsj = driver.findElement(By.xpath("(//p)[2]"));
        String expectedMsj="successfuly";
        Assert.assertFalse(resultMsj.getText().contains(expectedMsj));
        bekle(2);

    }
    @Test
    public void test3() {
        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        //Bir metod olusturun: sendKeysAlert
        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna

        driver.findElement(By.xpath("(//button)[3]")).click();
        bekle(3);
        driver.switchTo().alert().sendKeys("leyla");
        bekle(3);
        driver.switchTo().alert().accept();
        bekle(3);
        WebElement resultMsj = driver.findElement(By.xpath("(//p)[2]"));
        String girilenMetin="Leyla";
        Assert.assertTrue(resultMsj.getText().contains(girilenMetin));

    }
}

