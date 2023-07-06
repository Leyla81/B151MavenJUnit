package techproed.day21_Excel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_jsExecutor_Click extends TestBase {
    @Test
    public void jsExecutor() {
        /*
    Eger bir web sayfasinin HTML kodlari tamamen ya da kismen JavaScript kullanilarak olusturulduysa
    o sayfayla etkilesimde bulunmak icin standart WebDriver komutlari yetersiz kalabilir

    Bu durumda sayfayla etkilesime gecmek icin JavaScriptExecuter arayüzünü kullanmak gerekir
    JavaScriptExecuter arayüzü sayfaya dogrudan erisebilir.

    JavaScriptExecuter her durumda kullanabiliriz.
    Her kapiyi ancan anahtar gibidir. Ancak WebDriver'in sundugu standart yöntemleri kullanmak daha iyidir.
    JS kullanımı sayfanin gec yüklenmesine sebep olabilir.

     */

            //https://www.amazon.com/ sayfasina gidin
            driver.get("https://www.amazon.com/");

        // returns kısmına tıklayın
        WebElement returns = driver.findElement(By.xpath("//a[@id='nav-orders']"));
        //returns.click();


        /*
        ilgili webElementin HTML kodu, JavaScript kullanılarak olusturulduysa,
        standart WebDriver komutu olan click() yetersiz kalabilir.
        Böyle durumlarda JavaScriptExecuter kullanılarak sayfayla etkilesime gecilebilir.
         */


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",returns);
    }
}
