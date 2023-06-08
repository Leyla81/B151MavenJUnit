package techproed.day09_dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_nigtTimeTekra {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }


    @Test
    public void Test01() {
        //programming languages ddm den istediğiniz 4 seçeneği seçiniz
        WebElement diller = driver.findElement(By.xpath("(//select)[6]"));
        Select select = new Select(diller);
        select.selectByIndex(0);
        select.selectByIndex(2);
        select.selectByIndex(3);
        select.selectByIndex(4);
        //lambda ile
        select.getAllSelectedOptions().forEach(w-> System.out.println(w.getText()));

        System.out.println("******************************************");
        //for ile
        for (WebElement each:select.getAllSelectedOptions()) {
            System.out.println(each.getText());

        }
        //seceneklerden 4 tane sectigimizi dogrulayalim
        Assert.assertEquals(4,select.getAllSelectedOptions().size());

        //sectigimiz seceneklerden ilkini yazdiralim ,ilk secenegin java oldugunu dogrulayalim
        System.out.println("***************************************");

        System.out.println("secilen seceneklerden ilki : "+select.getFirstSelectedOption().getText());
        Assert.assertEquals("Java",select.getFirstSelectedOption().getText());

        //sectigimiz seceneklerin hepsini kaldırmak icin
        select.deselectAll();

        //sendKeys() methodu ile istediğimiz bir seçeneği gönderelim
        diller.sendKeys("C#");

        //visibleText olarak secim yapacagımız bir method olusturup programming language dropdown den bir secenek secelim
        selectVisibleTest(diller,"Java");

        //İNDEX olarak secim yapacagımız bir method olusturup programming language dropdown den bir secenek secelim
        selectIndex(diller,2);

        //Value olarak secim yapacagımız bir method olusturup programming language dropdown den bir secenek secelim
selectValue(diller,"js");
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }

    //METHODLAR
    public void selectVisibleTest(WebElement ddm,String secenek){
        Select select =new Select(ddm);
        select.selectByVisibleText(secenek);
    }
       public  void  selectIndex(WebElement ddm,int index){
        Select select=new Select(ddm);
        select.selectByIndex(index);
}
      public void selectValue(WebElement ddm,String value){
    Select select=new Select(ddm);
    select.selectByValue(value);
}
    public void  bekle (int saniye)  {
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }













}