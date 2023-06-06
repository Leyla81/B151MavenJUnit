package techproed.grupOdev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Odev {

    //baglantiniz gizli degil cikiyor
    //b. Sign in butonuna basin
    //sign in den sonra logine basiyorum
    //c. email textbox,password textbox, and signin button elementlerini locate ediniz..

    //d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:

    //i. Username : testtechproed@gmail.com
    //ii. Password : Test1234!
    //e. Expected user id nin "ei@fruveg.de" oldugunu dogrulayin(verify).
    //f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed)
    //doğrulayin(verify).
    //3. Sayfada kac tane link oldugunu bulun. //sayfadaki linklerin sayisini ve linkleri yazdir
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //a. https://a.testaddressbook.com adresine gidiniz.
        driver.get("https://a.testaddressbook.com");
        //baglantiniz gizli degil cikiyor
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='details-button']")).click();
        driver.findElement(By.xpath("//a[@id='proceed-link']")).click();
        // driver.findElement(By.xpath("//a[@href='https://www.heroku.com/home']")).click();
        //b. Log in butonuna basin
        driver.findElement(By.cssSelector("a[href='https://id.heroku.com']")).click();

        //c. email textbox,password textbox, and signin button elementlerini locate ediniz..
        WebElement element=driver.findElement(By.id("email"));




        //d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
        element.sendKeys("ei@fruveg.de", Keys.TAB,"Erol1234!",Keys.TAB,Keys.ENTER);

        //i. Username : testtechproed@gmail.com
        //ii. Password : Test1234!
        //e. Expected user id nin "ei@fruveg.de" oldugunu dogrulayin(verify).
        driver.findElement(By.xpath("//img[@class='glostick_user_avatar']")).click();
        String actualEmail=driver.findElement(By.xpath("//div[@class='glostick_account-details_email']")).getText();
        String expectedEmail="ei@fruveg.de";
        if (actualEmail.equals(expectedEmail)){
            System.out.println("TEST PASSED");
        }else {
            System.out.println("TEST FAILED");
        }

        //f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed)
        //doğrulayin(verify).

        //3. Sayfada kac tane link oldugunu bulun. //sayfadaki linklerin sayisini ve linkleri yazdir
    }
}

























