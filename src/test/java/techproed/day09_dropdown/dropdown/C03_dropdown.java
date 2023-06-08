package techproed.day09_dropdown.dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
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

public class C03_dropdown {
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test01() {
        // https://testcenter.techproeducation.com/index.php?page=dropdown sayfasına gidiniz
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

        // Programlama Dili Dropdown'undan "Java" seciniz
        WebElement dil=driver.findElement(By.xpath("//select[@name='Languages']"));
        Select select =new Select(dil);
        select.selectByVisibleText("Java");


        // Programlama Dili Dropdown'undan son secilen option'un "Java" oldugunu test ediniz
        WebElement sonSecimJava=select.getFirstSelectedOption();
       String sonSecimJavaStr=  sonSecimJava.getText();//Assertion yapmak icin String e donusturur
        Assert.assertEquals("Java",sonSecimJavaStr);

        // Programlama Dili Dropdown'undaki tum optionları konsolda yazdırınız
       List<WebElement>allOptions= select.getOptions();
       //1. yol lambda ile
    allOptions.stream().forEach(t-> System.out.println(t.getText()));
       //2. yol forEach
       /* for (WebElement each:allOptions) {
            System.out.println(each);
        }*/


    }
}
