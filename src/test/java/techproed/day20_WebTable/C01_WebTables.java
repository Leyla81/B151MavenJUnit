package techproed.day20_WebTable;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C01_WebTables extends TestBase {

    /*
    WEBTABLE;
        <table> tagı ile başlar
            <thead> başlıklar için bu tag ile devam eder
            <tr> baslıkların satıri
                <th> table head
                    <td> başlıktaki veriler
                <tbody> başlıklar altındaki verileri temsil eder
                        <tr> table row(satır)
                            <td> table data (tablodaki veri)

     */
    @Test
    public void test01() {
        extentReport("Chrome","WebTable");
        //    https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");
        extentTest.info("sayfaya gidildi");

//    Task 1 : Table1’i yazdırın

        WebElement table1 =driver.findElement(By.id("table1"));
        System.out.println("tablo1");
        System.out.println(table1.getText());
        extentTest.info("");

//    Task 2 : 3. Satır verilerini yazdırın
        WebElement ucuncuSatir = driver.findElement(By.xpath("(//table)[1]//tr[3]"));
        System.out.println("************************************");
        System.out.println(ucuncuSatir.getText());


//    Task 3 : Son satırın verilerini yazdırın

WebElement sonSatır = driver.findElement(By.xpath("(//tbody)[1]//tr[last()]"));
        System.out.println(" ************************************");



//    Task 4 : 5. Sütun verilerini yazdırın
        WebElement BesBaslık = driver.findElement(By.xpath("(//thead)[1]//th[5]"));
        System.out.println(BesBaslık.getText());//5. sutun baslık

        List<WebElement>besinciSutun =driver.findElements(By.xpath("(//tbody)[1]//td[5]"));
        besinciSutun.forEach(t-> System.out.println(t.getText()));

//  Task 5: 3.Satir
        System.out.println("***********************************************");
        List<WebElement> ucuncuSatirr = driver.findElements(By.xpath("(//tbody)[1]//tr[3]//td[position()>=1 and position()<=2]"));
      ucuncuSatirr.forEach(t-> System.out.println(t.getText()));

//    Task 6 : Iki parametreli bir Java metodu oluşturalım: printData
        //    Parameter 1 = satır numarası
        //    Parameter 2 = sütun numarası
        //    printData(2,3);  => 2. satır, 3. sütundaki veriyi yazdırsın.

        printData(2,3);

    }

    private String printData(int satir, int sutun) {
        WebElement satirSutun = driver.findElement(By.xpath("(//tbody)[1]//tr["+satir+"]//td["+sutun+"]"));
        System.out.println("2.Satir 3.sutun= "+satirSutun.getText());

        //3.satır 2.sutun bilgisini Jack olup olmadıgını dogrulayın
        String actualData = printData(3,2);
        String expectedData ="jack";
        Assert.assertNotEquals(expectedData,actualData);
        extentTest.fail("3.satir 2.sutun bilgisinin jason oldugu goruldu");
        extentTest.pass("sayfa Kapatıldı");
        extentReports.flush();



return satirSutun.getText();
    }
}
