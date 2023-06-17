package techproed.day12_WindowHandle;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_BasicAutentication extends TestBase {


    @Test
    public void test01() {


   /*
    Aşağıdaki bilgileri kullanarak authentication yapınız:
    Url: https://the-internet.herokuapp.com/basic_auth
    Username: admin
    Password: admin
    Başarılı girişi doğrulayın.
     */
     driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
     bekle(3);

     //congratulations yazisinin cıktıgını dogrulayın
        WebElement text =driver.findElement(By.xpath("//p"));
        Assert.assertTrue(text.getText().contains("Congratulations"));


        //Elemenal Selenium yazısına tıklayalım
        driver.findElement(By.xpath("(//a)[2]")).click();//yeni pencere acıldı
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());//--> Açılan yeni pencereye geçtik

        //Başlığın Elemental Selenium olmadığını doğrulayın
        System.out.println("Sayfa Başlığı : "+driver.getTitle());
        Assert.assertNotEquals("Elemental Selenium",driver.getTitle());
        //DDM'den java seçelim
        WebElement ddm = driver.findElement(By.xpath("//select"));
        /*
        Select select = new Select(ddm);
        select.selectByVisibleText("Java");
         */
        ddmVisibleText(ddm,"Java"); //--> Method ile





    }
}
