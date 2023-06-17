package techproed.day13_cookies_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions extends TestBase {
    @Test
    public void test01() {

        //https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

//Kutuya sag tıklayın
        WebElement kutu = driver.findElement(By.id("hot-spot"));
        //sag klik yapabilmek icin action classından bir obje olusturduk
        Actions actions =new Actions(driver);
        actions.contextClick(kutu).//sag kilik yapma methodu
        perform();//ile uygulanmasını sagladık


//Alert'te cikan yazinin"You selected a context menu"oldugunu test edin


        Assert.assertEquals("You selected a context menu",alertGetText());//testBase deki methodu kullandık

//alertGetText()____>driver.switchTo().alert().getText();


//Tamam diyerek alert'i kapatın
        alertAccept();//TestBase deki methodu kullandık____>driver.switchTo().alert().accept()

    }
























}
