package techproed.grupOdev;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Task05 extends TestBase {
    // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
    @Test
    public void test02() throws InterruptedException {
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
// ikinci emojiye tıklayın
        WebElement iframe = driver.findElement(By.xpath("//*[@id='emoojis']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("(//*[@data-upgraded=',MaterialRipple'])[2]")).click();

// İkinci emoji öğelerini yazdırınız
// Parent iframe e geri donun
// Formu doldurun,(Formu istediğiniz metinlerle doldurun)
// Apply button a basiniz
}


}
