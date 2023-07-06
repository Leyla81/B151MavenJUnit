package techproed.day22_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_GetAttribute extends TestBase {

    @Test
    public void test01() {

//  https://www.carettahotel.com/ a gidiniz
        driver.get("https://www.carettahotel.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@id='details-button']")).click();
        bekle(2);
        driver.findElement(By.xpath("//*[@id='proceed-link']")).click();
//  Tarih kısmını JS ile locate ediniz.
        JavascriptExecutor js= (JavascriptExecutor) driver;

WebElement date = (WebElement) js.executeScript("return document.getElementById('checkin_date')");
/*
    Java Script kodlarıyla yazılmış webelementleri bizim bildiğimiz findElement() methoduyla locate edemeyebiliriz.
    js executor kullanarak ister html ister java script ile yazılmış olsun bir webelementin locatini js executor
    ile alabiliriz. Yukarıdaki örnekte sayfadaki tarih webelementini js executor ile locate ettik.
     */
        date.clear();
        date.sendKeys("05/25/2023");

 // Date webelemetinin Attribute degerlerini yazdiralim

      String idAttributeDegeri=  js.executeScript("return document.getElementById('checkin_date').id").toString();
        String typeAttributeDegeri= js.executeScript("return document.getElementById('checkin_date').type").toString();
        String nameAttributeDegeri= js.executeScript("return document.getElementById('checkin_date').name").toString();
        String valueAttributeDegeri= js.executeScript("return document.getElementById('checkin_date').value").toString();

        System.out.println("idAttributeDegeri= "+idAttributeDegeri);
        System.out.println("typeAttributeDegeri= "+typeAttributeDegeri);
        System.out.println("nameAttributeDegeri= "+nameAttributeDegeri);
        System.out.println("valueAttributeDegeri= "+valueAttributeDegeri);
/*
Js executor ile attribute değerlerini yazdırabilmek için js ile locate ettiğimiz webelementin sonuna
yukarıdaki örnekteki gibi hangi attributun değeri yazdırmak istersek sonuna attribute adını yazarız.
 */

    }

    @Test
    public void test02() {
        //https://www.priceline.com/ adresine gidiniz
        driver.get("https://www.priceline.com");

//Submit butonunun rengini Kirmizi yazınız

   WebElement kirmizi= driver.findElement(By.xpath("//*[text()='Find Your Hotel']"));
   JavascriptExecutor js= (JavascriptExecutor) driver;
   js.executeScript("arguments[0].style.color ='red';",kirmizi);


    }
}
