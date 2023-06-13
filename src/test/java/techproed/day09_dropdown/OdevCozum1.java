package techproed.day09_dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class OdevCozum1 {
//    ●https://the-internet.herokuapp.com/dropdown adresine gidin.
//  1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
//2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
//  3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
//4.Tüm dropdown değerleri(value) yazdırın
//5.Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/dropdown");
    }
}
