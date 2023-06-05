package techproed.day07_Maven_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_MavenClassWork {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver =new ChromeDriver();
        driver.manage().window().maximize();//sayfayi maximize yapıyoruz
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//15 saniye bekliyoruz
        //  1.http://zero.webappsecurity.com sayfasina gidin

        driver.get("http://zero.webappsecurity.com");
        //  2.Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//*[@class='icon-signin']")).click();

       //3.Login alanine “username” yazdirin
         WebElement loginUserName =driver.findElement(By.xpath("//*[@id='user_login']"));
         loginUserName.sendKeys("username");

       //4.Password alanine “password” yazdirin
        WebElement password =driver.findElement(By.xpath("//*[@id='user_password']"));
        password.sendKeys("password");

       //5.Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //guveblik problemini gecmek icin sayfada bir geri gelim.
        driver.navigate().back();

        // 6.Online bank alrinda Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
       driver.findElement(By.xpath("//span[text()='Pay Bills']")).click();

      //7.amount kismina yatirmak istediginiz herhangi bir miktari yazin
WebElement amount =driver.findElement(By.xpath("//input[@id='sp_amount']"));
amount.sendKeys("100");

     //8.tarih kismina “2020-09-10” yazdirin
        WebElement date =driver.findElement(By.xpath("//input[@name='date']"));
        date.sendKeys("2020-09-10");

      //9.Pay buttonuna tiklayin
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // "The payment was successfully submitted." mesajinin ciktigini test edin
        WebElement mesaj = driver.findElement(By.xpath("//span[text()='The payment was successfully submitted.']"));

        if(mesaj.isDisplayed()){
            System.out.println("TEST PASSED");
        }else{
            System.out.println("TEST FAILED");
        }

        Thread.sleep(2000);


        // Sayfayi kapatın
        driver.close();


    }
}