package techproed.AutomationExcercises;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase01 extends TestBase {
    @Test
    public void test01() {


        // 1. Launch browser
        extentReport("Chrome","TestCase04");
        extentTest=extentReports.createTest("AutoExercisesReport","Test Raporu");

        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
extentTest.info("sayfaya gidildi");

        // 3. Verify that home page is visible successfully
        WebElement home = driver.findElement(By.xpath("(//a[@href='/'])[2]"));
        assert home.isDisplayed();
        webElementResmi(home);
      extentTest.info("ana sayfanın gorunur lupoolmadgı dogrylandı");

        // 4. Click on 'Signup / Login' button
        WebElement login = driver.findElement(By.xpath("//a[@href='/login']"));
        login.click();
        extentTest.info("signup butonuna basın");

        // 5. Verify 'Login to your account' is visible
        WebElement loginToYourAccountVisible = driver.findElement(By.xpath("//h2[text()='Login to your account']"));
        loginToYourAccountVisible.isDisplayed();

        extentTest.info("Login to your account gorunurlugu dogrulandı");

        // 6. Enter correct email address and password
        // 7. Click 'login' button
WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
email.sendKeys("mustafasagiroglu06452@gmail.com", Keys.TAB,"Password",Keys.TAB,Keys.ENTER);

//123@gmail.com
//12345 mustafasagiroglu06452@gmail.com
//Password

        // 8. Verify that 'Logged in as username' is visible
WebElement userName = driver.findElement(By.xpath("//li[10]//a[1]"));
 assert userName.isDisplayed();
 webElementResmi(userName);


        // 9. Click 'Logout' button
driver.findElement(By.xpath("(//a[@style='color:brown;'])[1]")).click();

        // 10. Verify that user is navigated to login page
       String actualTitle= driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Signup"));

       tumSayfaResmi();
       extentTest.info("sayfanın yenilendigi ");
        extentReports.flush();
    }
}