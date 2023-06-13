package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public abstract class TestBase {
    //abstract yaptık obje olusturulmaması icin
    //bu class a extend ettigimiz test classlardan ulasabiliriz

   //depo olarak kullanılır

 protected WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }



    public void bekle(int  saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

//alertAccept methodu olusturma
    public void alertAccept(){

        driver.switchTo().alert().accept();
    }
    //alertDismiss
    public void alertDismiss(){

        driver.switchTo().alert().dismiss();
    }
    //alertPrompt
    public void alertPrompt(String text){

        driver.switchTo().alert().sendKeys(text);
    }
public String alertGetText(){

      return  driver.switchTo().alert().getText();
}
public void alertSendKeys(String text){
        driver.switchTo().alert().sendKeys(text);
}
//DropDown visibleText
public void ddmVisibleText(WebElement ddm,String secenek){
    Select select=new Select(ddm);
    select.selectByVisibleText(secenek);


}

//DropDown index

    public void ddmindex(WebElement ddm,int secenek) {
        Select select = new Select(ddm);
        select.selectByIndex(secenek);


    }
    //DropDown value
    public void ddmvalue(WebElement ddm,String secenek) {
        Select select = new Select(ddm);
        select.selectByValue(secenek);


    }


}
