package techproed.day15_fileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_FileUploadTest extends TestBase {
    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        /*
    Eger dosyaSec butonuna basmamiz istenirse ve otomasyon ile bu butona click yapmak istedigimizde exception aliyorsak
    direk upload istedigimiz dosya yolunu alip sendKeys() methodu ile dosyayi sayfaya upload yapabiliriz
 */

        String dosyaYolu ="C:\\Users\\yusuf\\OneDrive\\Masaüstü\\leyla.txt";

//chooseFile butonuna basalim

WebElement dosyaSec=driver.findElement(By.id("file-upload"));
   //dosyaSec.click();//---->click yapmadı exception aldi

        //Yuklemek istediginiz dosyayi secelim.
        dosyaSec.sendKeys(dosyaYolu);

//Upload butonuna basalim.
WebElement upload = driver.findElement(By.id("file-submit"));
upload.click();
//"File Uploaded!" textinin goruntulendigini test edelim.
       WebElement yazi= driver.findElement(By.xpath("//h3[text()='File Uploaded!']"));
        Assert.assertTrue(yazi.isDisplayed());
//2.yol
        Assert.assertTrue(driver.findElement(By.xpath("//h3[text()='File Uploaded!']")).isDisplayed());

    }
}
