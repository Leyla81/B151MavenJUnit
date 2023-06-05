package techproed.day07_Maven_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class odev1 {
    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//https://www.google.com/  adresine gidin
        driver.get("https://www.google.com");
//cookies uyarisini  kabul ederek kapatin
//Sayfa	basliginin	"Google"	ifadesi	icerdigini	test  edin
        String actualtitle=driver.getTitle();
        if (actualtitle.contains("Google")){
            System.out.println("Test passed");
        }else System.out.println(actualtitle);
//Arama cubuguna "Nutella" yazip aratin
driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("nutella"+ Keys.ENTER);
//Bulunan sonuc sayisini yazdirin
        WebElement sonuYazisi =driver.findElement(By.xpath("//div[@id='result-stats']"));
        System.out.println( sonuYazisi.getText());
//sonuc sayisinin 10 milyon'dan fazla oldugunu test  edin
String[] sonucSayisi =sonuYazisi.getText().split(" ");
        System.out.println("sonucSayisi = " + sonucSayisi[1]);



driver.close();
//Sayfayi kapatin








    }

}
