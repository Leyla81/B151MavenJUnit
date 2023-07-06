package techproed.day17_Exceptions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_TimeOutException extends TestBase {
    /*
    TIME_OUT_EXCEPTION
         Expilict wait kullanırken yanlış method yada yanlış max. bekleme süresi gibi durumlarda
     org.openqa.selenium.TimeoutException hatası alırız.
     */
    @Test
    public void test01() {

        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

//Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        WebElement helloWorldText = driver.findElement(By.xpath("(//h4)[2]"));
        //Locate'ini aldığımız helloWorldText webelementini görünür olana kadar explicit wait ile bekleyeceğim
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));//-->max.20 saniye belirttik
        wait.until(ExpectedConditions.visibilityOf(helloWorldText));
//visibilityOf() methoduyla görünür olana kadar bekler



          /*
        org.openqa.selenium.TimeoutException: normalde helloWorldText webelementi 5-6 saniye civarında
        etkileşime gireken biz max. bekleme süresini 2 saniye verdiğimiz için bu hatayı aldık.Dolayısıyla
        bu exception'ı handle edebilmek için doğru süreyi ve doğru methodu kullanmamız gerekir.
         */
        Assert.assertEquals("Hello World!",helloWorldText.getText());

    }

    @Test
    public void test02() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //Start buttonuna tıkla
        driver.findElement(By.xpath("//button")).click();

        //Hello World! Yazının sitede oldugunu test et
        //WebElement helloWorldText = driver.findElement(By.xpath("yanlis locate"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("yanlisLocate")));
        /*
        Yukardaki örnekte max. süreyi doğru vermemize rağmen yanlis locate aldığımız için yine
        org.openqa.selenium.TimeoutException hatası alırız
         */

    }

    @Test
    public void test03() {
        //https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver adresine gidelim
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

        //CheckBox yazan buttona tıklayalım
        driver.findElement(By.xpath("//*[@id='checkbox']")).click();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id='ch']")));
        /*
        org.openqa.selenium.TimeoutException:
         */

        //checkBox'ın seçili olduğunu doğrulayalım(CheckBox'ı locate etmeliyiz)
        WebElement checkBox = driver.findElement(By.xpath("//*[@id='ch']"));
        Assert.assertTrue(checkBox.isSelected());
          /*
        org.openqa.selenium.TimeoutException: Gorunur olan bir webelementi gorunur olmayana kadar bekleme methodunu kullandigimiz
        icin TimeoutException hatasi aldik.
         */

    }










}
