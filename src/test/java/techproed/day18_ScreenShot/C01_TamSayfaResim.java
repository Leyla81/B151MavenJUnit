package techproed.day18_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_TamSayfaResim extends TestBase {


    @Test
    public void test01() throws IOException {
        //tecproeducation .com a gidelim

        driver.get("https://techproeducation.com");

        //Cıkan Reklamı kapatalım

        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //ve ekran goruntusunu alalalım

        /*
        ilk olarak ScreenShot aldıgımız da nereye kaydetmek istiyorsak oranın yolunu belirtelim
         */
        String dosyaYolu ="src/test/java/techproed/ScreenShot/screenShot.png";//screenshot package in yolu

        //2. olarak screenShot arayuzunden obje olustururuz

        TakesScreenshot ts = (TakesScreenshot) driver;

        //3. olarak FileUtil class'ından copyFile() methodu ile ts objemizi kullanarak
        // getScreenshotAs() methodu ile dosya yolunu belirtecegiz
        FileUtils.copyFile(  ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));


        /*
SCREENSHOT
       Selenium'da tüm ekran görüntüsünü alabilmek için TakesScreenShot arayünden bir obje oluşturup
   driver'a eşitleriz. Arayüzler farklı olduğu için casting yaparız. Ve bu oluşturduğumuz obje ile
   getScreenshotAs methodu ile sayfanın resmini alırız. Almış olduğumuz resmi projemizde nereye kaydedeceksek
   oranın yolunu belirtiriz.
 */

    }

    @Test
    public void test02() throws IOException {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        bekle(2);
        //Çıkan reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //Ve ekran görüntüsünü alalım
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("ScreenShot/screenShot.png"));
    }

    @Test
    public void test03() throws IOException {


    /*
    Kaydettiğimiz ekran resmini her seferinde aynı dosya üzerine yazmaması için dosya isminden sonra
    String bir değişkene tarih formatı atayabiliriz.
     */
            //Techproeducation sayfasına gidelim
            driver.get("https://techproeducation.com");

            bekle(2);
            //Çıkan reklamı kapatalım
            driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

            //Ve ekran görüntüsünü alalım
    /*
    SimpleDateFormat'ı kullanarak yeni bir tarih formatı oluşturup bir String'e assing ederiz.
    Ve bunu dosya isminden önce belirtiriz.
     */
            String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
            String dosyaYolu =" src/test/java/techproed/ScreenShot//screenShot" + tarih + ".jpeg";
            TakesScreenshot ts = (TakesScreenshot) driver;
            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));

        }









    }

