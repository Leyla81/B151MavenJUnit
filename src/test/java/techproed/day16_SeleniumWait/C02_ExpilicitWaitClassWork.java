package techproed.day16_SeleniumWait;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_ExpilicitWaitClassWork extends TestBase {
    @Test
    public void test01() {

        //https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver adresine gidelim
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");

       //Click me to open an Alert buttonuna basalım
        driver.findElement(By.xpath("//button[@id='alert']")).click();

        //Cıkan Alert i kapatalım
        driver.switchTo().alert().accept();//methot ile de yapılabilir --->alertaccept()











    }
}
