package techproed.day16_SeleniumWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_ExpilicitWait extends TestBase {


    @Test
    public void test01() {

            //https://the-internet.herokuapp.com/dynamic_loading/1
            driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

            //Start buttonuna tıkla
            driver.findElement(By.xpath("//button")).click();

            //Hello World! Yazının sitede oldugunu test et
            visibleWait(By.xpath("(//h4)[2]"),20);
            Assert.assertEquals("Hello World!",driver.findElement(By.xpath("(//h4)[2]")).getText());
        }



    }

