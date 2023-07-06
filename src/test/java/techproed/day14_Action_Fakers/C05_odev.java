package techproed.day14_Action_Fakers;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_odev extends TestBase {



    @Test
    public void name() {
        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //2- Hover over  Me First" kutusunun ustune gelin
        WebElement myfirst=driver.findElement(By.xpath("(//button[@class=\"dropbtn\"])[1]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(myfirst).perform();

        //3- Link 1" e tiklayin
        driver.findElement(By.xpath("(//*[@class='list-alert'])[1]")).click();

       //4- Popup mesajini yazdirin
        System.out.println("Well done you clicked on the link!");

        //5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();

        //6- “Click and hold" kutusuna basili tutun
        WebElement clickAndHold = driver.findElement(By.xpath("//div[@id='click-box']"));
        actions.clickAndHold(clickAndHold).perform();

        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println("Well done! keep holding that click now.....");

        // 8- “Double click me" butonunu cift tiklayin. Tıklandığını test edin
        WebElement doubleClick1 =driver.findElement(By.xpath("//h2[text()='Double Click Me!']"));
        actions.doubleClick(doubleClick1);
    }
}
