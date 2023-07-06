package techproed.day14_Action_Fakers;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.security.KeyFactorySpi;

public class C03_KeyDownKeyUp extends TestBase {


    @Test
    public void test01() {


            //Google anasayfasına gidelim
            driver.get("https://google.com");

            //arama kutusunda shift tusuna basılı olarak selenim yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
            WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
            Actions actions = new Actions(driver);
            actions.keyDown(aramaKutusu, Keys.SHIFT).//--> Arama Kutusunda shift tuşuna bastık
                    sendKeys("selenium").//-->selenium metnini shift tuşuna basılı kaldığı için büyük yazdı
                    keyUp(Keys.SHIFT).//--> shift tusunu serbest bıraktık
                    sendKeys("-java",Keys.ENTER).//--> bu kismi shift'i serbest bıraktığımız için küçük yazdı
                    perform();

        }

    @Test
    public void test02() {

        //Google anasayfasına gidelim
        driver.get("https://google.com");

        //arama kutusunda shift tusuna basılı olarak selenim yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        Actions actions = new Actions(driver);
        aramaKutusu.sendKeys(Keys.SHIFT,"selenium",Keys.SHIFT,"-java",Keys.ENTER);


    }
    @Test
    public void test03() {
        //google sayfasına gidelim
        driver.get("https://google.com");
        //Arama kutusuna "Selenium" yazın ve Enter tuşuna basın
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys("Selenium",Keys.ENTER);
        //Sayfayı bekleyin
        bekle(4);
        //Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim
        driver.findElement(By.xpath("//*[@class='gLFyf']")).//-->sayfa yenilendiği için tekrar locate aldık
                sendKeys(Keys.CONTROL,"a");//-->Metni kesebilmemiz için önce ctrl+a ile seçmemiz gerekir
        bekle(2);
        driver.findElement(By.xpath("//*[@class='gLFyf']")).
                sendKeys(Keys.CONTROL,"x");//-->Seçilen metni ctrl+x ile kestik
        bekle(2);
        //Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım
        driver.navigate().to("https://google.com");
        driver.findElement(By.xpath("//*[@class='gLFyf']")).
                sendKeys(Keys.CONTROL,"v",Keys.ENTER);//-->Kestiğimiz metni ctrl+v tusu ile tekrar arama kutusuna yapıştırdık ve arattık
    }
}



