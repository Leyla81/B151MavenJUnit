package techproed.day12_WindowHandle;

import org.bouncycastle.math.ec.custom.sec.SecT113Field;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C01_windowHandle extends TestBase {
    @Test
    public void test01() {
        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.getWindowHandle();


//  ilk sayfasının Handle degerini alın yazdırın
        String ilkSayfaHandle = driver.getWindowHandle();
        System.out.println("ilkSayfaHandle = " + ilkSayfaHandle);

//  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String actualText=driver.findElement(By.xpath("//h3")).getText();
        String expectedText ="Opening a new window";
        Assert.assertEquals(expectedText,actualText);

//  ilk sayfa Title'ının "The Internet" olduğunu test edin.

        String actualTitle = driver.getTitle();
        String expectedTitle ="The Internet";
        Assert.assertEquals(expectedTitle,actualTitle);

//  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();
        /*
    Bir button'a click yaptigimizda kontrolumuz disinda yeni bir sekme ya da pencere acilirsa , yeni acilan pencerenin
    handle degerini bilmedigim icin normal getWindowHandle ile driver'imi yeni pencereye geciremem. Bunu getWindowHandles()
    methoduyla acilan tum pencereleri bir Set'e assign edip , ilk actigimiz pencere degilse ikinci acilan yeni penceredir
    mantigiyla bir loop icinde cozebiliriz
 */
        Set<String> pencereler =driver.getWindowHandles();
        for (String w:pencereler) {
            System.out.println(w);
            if (!w.equals(ilkSayfaHandle)){//eger birici sayfaya esit degise
                driver.switchTo().window(w);//yeni pencereye gecis yap
            }
            
        }
        

//  ikinci sayfa Title'ının "New Window" olduğunu test edin.

String actualtitle= driver.findElement(By.xpath("//h3")).getText();
        System.out.println("actualtitle = " + actualtitle);
String expectedtitle = "New Window";
Assert.assertEquals(expectedtitle,actualtitle);
String ikinciSayfaHandle = driver.getWindowHandle();
        System.out.println("ikinciSayfaHandle = " + ikinciSayfaHandle);

//  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(ilkSayfaHandle);
        String ilkSayfaactualTitle = driver.getTitle();
        String ilkSayfaexpectedTitle ="The Internet";
        Assert.assertEquals(ilkSayfaexpectedTitle,ilkSayfaactualTitle);

//  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(ikinciSayfaHandle);
//  ilk sayfaya tekrar dönün.
        driver.switchTo().window(ilkSayfaHandle);
    }



    @Test
    public void test02() { //ArrayList ile cozumu

        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.getWindowHandle();


//  ilk sayfasının Handle degerini alın yazdırın
        String ilkSayfaHandle = driver.getWindowHandle();
        System.out.println("ilkSayfaHandle = " + ilkSayfaHandle);

//  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String actualText=driver.findElement(By.xpath("//h3")).getText();
        String expectedText ="Opening a new window";
        Assert.assertEquals(expectedText,actualText);

//  ilk sayfa Title'ının "The Internet" olduğunu test edin.

        String actualTitle = driver.getTitle();
        String expectedTitle ="The Internet";
        Assert.assertEquals(expectedTitle,actualTitle);

//  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();//kontrolumuz dısında yeni bir sekme acıldı

//  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        List<String>pencereler =new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pencereler.get(1));
        String actualtitle1= driver.findElement(By.xpath("//h3")).getText();
        System.out.println("actualtitle1 = " + actualtitle1);
        String expectedtitle = "New Window";
        Assert.assertEquals(expectedtitle,actualtitle1);

/*
            getWindowHandles() methodunu kullanarak acilan tum pencerelerin handle degerlerini bir arraylist' e atadik.
        Index 0(sifir)'dan basladigi icin kontrolum disinda acilan pencere 1. index de oldugundan
         driver.switchTo().window(pencereler.get(1)); ile yeni acilan pencereye gecis yaptik
         */

//  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(pencereler.get(0));
        String ilkSayfaactualTitle = driver.getTitle();
        String ilkSayfaexpectedTitle ="The Internet";
        Assert.assertEquals(ilkSayfaexpectedTitle,ilkSayfaactualTitle);

//  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(pencereler.get(1));
//  ilk sayfaya tekrar dönün.
        driver.switchTo().window(pencereler.get(0));


    }
    @Test
    public void test3() {

        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.getWindowHandle();


//  ilk sayfasının Handle degerini alın yazdırın
        String ilkSayfaHandle = driver.getWindowHandle();
        System.out.println("ilkSayfaHandle = " + ilkSayfaHandle);

//  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String actualText=driver.findElement(By.xpath("//h3")).getText();
        String expectedText ="Opening a new window";
        Assert.assertEquals(expectedText,actualText);

//  ilk sayfa Title'ının "The Internet" olduğunu test edin.

        String actualTitle = driver.getTitle();
        String expectedTitle ="The Internet";
        Assert.assertEquals(expectedTitle,actualTitle);

//  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();//kontrolumuz dısında yeni bir sekme acıldı

//  ikinci sayfa Title'ının "New Window" olduğunu test edin.
      driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        String actualtitle1= driver.getTitle();
        System.out.println("actualtitle1 = " + actualtitle1);
        String expectedtitle = "New Window";
        Assert.assertEquals(expectedtitle,actualtitle1);
/*
    Set ve ArrayList kullanmadan switchTo() methodu icine arguman olarak driver.getWindowHandles() methodu ile butun acilan
    pencereli bir array olarak alip index belirterek istedigim pencereye gecis yapabilirim
 */


//  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
        String ilkSayfaactualTitle = driver.getTitle();
        String ilkSayfaexpectedTitle ="The Internet";
        Assert.assertEquals(ilkSayfaexpectedTitle,ilkSayfaactualTitle);

//  ikinci sayfaya tekrar geçin.
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
//  ilk sayfaya tekrar dönün.
        driver.switchTo().window(driver.getWindowHandles().toArray()[0].toString());
    }


    @Test
    public void test04() {

        //  https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.getWindowHandle();


//  ilk sayfasının Handle degerini alın yazdırın
        String ilkSayfaHandle = driver.getWindowHandle();
        System.out.println("ilkSayfaHandle = " + ilkSayfaHandle);

//  ilk sayfadaki textin "Opening a new window" olduğunu test edin.
        String actualText=driver.findElement(By.xpath("//h3")).getText();
        String expectedText ="Opening a new window";
        Assert.assertEquals(expectedText,actualText);

//  ilk sayfa Title'ının "The Internet" olduğunu test edin.

        String actualTitle = driver.getTitle();
        String expectedTitle ="The Internet";
        Assert.assertEquals(expectedTitle,actualTitle);

//  "Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("(//a)[2]")).click();//kontrolumuz dısında yeni bir sekme acıldı

//  ikinci sayfa Title'ının "New Window" olduğunu test edin.
        switchWindow(1);
        String actualtitle1= driver.getTitle();
        System.out.println("actualtitle1 = " + actualtitle1);
        String expectedtitle = "New Window";
        Assert.assertEquals(expectedtitle,actualtitle1);



//  ilk sayfaya dönün ve Title'ının "The Internet" olduğunu test edin.
      switchWindow(0);
        String ilkSayfaactualTitle = driver.getTitle();
        String ilkSayfaexpectedTitle ="The Internet";
        Assert.assertEquals(ilkSayfaexpectedTitle,ilkSayfaactualTitle);

//  ikinci sayfaya tekrar geçin.
      switchWindow(1);
//  ilk sayfaya tekrar dönün.
        switchWindow(0);

    }
}
