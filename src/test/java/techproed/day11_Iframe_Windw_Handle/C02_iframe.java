package techproed.day11_Iframe_Windw_Handle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_iframe extends TestBase {

    @Test
    public void iframe() {





        //https://the-internet.herokuapp.com/iframe sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

        //Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız
        String editorYazisi =driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(editorYazisi.contains("Editor"));

        //Textbox içindeki yazıyı siliniz.
         driver.switchTo().frame("mce_0_ifr");
       WebElement textBox= driver.findElement(By.xpath("//p"));
       textBox.clear();
      // textBox.sendKeys("leyla");

//Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
        textBox.sendKeys("Bu textbox iFrame içinde yer almaktadır");

        //Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.
        driver.switchTo().defaultContent();
       WebElement elemantalSelenium= driver.findElement(By.xpath("(//a)[3]"));

        System.out.println("elemantalSelenium = " + elemantalSelenium);
       Assert.assertTrue(elemantalSelenium.isDisplayed());







    }
}
