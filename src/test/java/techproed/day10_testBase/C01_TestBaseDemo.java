package techproed.day10_testBase;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C01_TestBaseDemo extends TestBase {
    //techpro education sayfasına gidiniz baslıgın
    // bootcamp icerdigini test ediniz


    @Test
    public void test01() {
    driver.get("https://techproeducation.com");
    String actualTitle=driver.getTitle();
    String expectedTitle = "Bootcamp";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }
}
