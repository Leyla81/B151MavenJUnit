package techproed.day14_Action_Fakers;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions_dragAndDrop extends TestBase {

    @Test
    public void test01() { //dragAndDrop() methodu ile tutup bırakma

//Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable");

//And user moves the target element(Drag me to my target) in to  destination(Drop here
//Drag me to my target webelementini Drop here webelementi üzerine bıkalım

       /*
        drag ve drop webelementleri iframe icinde oldugu icin iframe'e gecis yapmaliyiz
         */
        driver.switchTo().frame(0);

        WebElement drag=driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));

        Actions actions=new Actions(driver);
        actions.dragAndDrop(drag,drop).perform();

   /*
            Eğer bir hareketli webelementi tutup başka bir webelementin üzerene bırakmak istersek
         sürüklemek istediğimiz we'tin locatini alıp üzerine bırakacağımız we'tin locate'ini de alarak
         dragAndDrop(kaynak,hedef) methodu ile işlemi gerçekleştirebiliriz
         */

//dragAndDrop() iki webelement ister, drag webelemntini alir, drop webelementin üstüne koyar.
//action objemizle yapacagimiz islemi uygulamasi icin veya sonlandirmasi icin perform() kullaniriz

    }

    @Test
    public void test02() { //clickAndHold() methodu ile tutup bırakma

        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable");
          /*
        drag ve drop webelementleri iframe icinde oldugu icin iframe'e gecis yapmaliyiz
         */
        driver.switchTo().frame(0);

        WebElement drag=driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));

        Actions actions=new Actions(driver);
        actions.clickAndHold(drag). //--> Bu method ile webelemente mouse ile basili tuttuk
                moveToElement(drop).//--> Bu method ile basili tuttugumuz webelementi diger webelementin uzerine goturduk
                release().//--> Bu method ile basili tuttugumuz webelementi serbest biraktik.
                perform();//--> Islemi sonlandirdik


    }

    @Test
    public void test03() {//  moveByOffset(84,28) --->koordinatlarla tutup bırakma

        //Given user is on https://jqueryui.com/droppable/
        driver.get("https://jqueryui.com/droppable");
          /*
        drag ve drop webelementleri iframe icinde oldugu icin iframe'e gecis yapmaliyiz
         */
        driver.switchTo().frame(0);

        WebElement drag=driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("//*[@id='droppable']"));

        Actions actions=new Actions(driver);
        actions.clickAndHold(drag).
                moveByOffset(84,28).//belirtmis oldugumuz koordinatlara web elementi tasır
                                        release().perform();
    }
}
