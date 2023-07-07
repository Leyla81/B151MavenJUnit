package techproed.day23_log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C02_Log4j extends TestBase {
    @Test
    public void test01() {
        Logger logger = LogManager.getLogger(C02_Log4j.class);
        //Techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");
        logger.info("techpro sayfasına gidildi");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//reklamı kapat
        logger.info("Reklam kapatildi");

//Basligin Egitim icerdigini dogrulayalim

        Assert.assertFalse(driver.getTitle().contains("Egitim"));
        logger.error("Sayfa baslıgı Egitim yazisi icermiyor");








    }
}
