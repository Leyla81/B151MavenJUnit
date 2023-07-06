package techproed.day20_WebTable;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ExcelClassWork {
    @Test
    public void test01() throws IOException {

        //Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
        FileInputStream fis = new FileInputStream("src/test/java/techproed/resources/Capitals.xlsx");

        Workbook workbook = WorkbookFactory.create(fis);
        String Satir1Sutun2 =workbook.getSheet("Sheet1").getRow(0).getCell(1).toString();
        System.out.println("Satir1Sutun2 = " + Satir1Sutun2);

        //3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
        
        
        String Satir3Sutun1 = workbook.getSheet("Sheet1").getRow(2).getCell(0).toString();
        System.out.println("Satir3Sutun1 = " + Satir3Sutun1);
        Assert.assertEquals("France",Satir3Sutun1);

        // Kullanılan satır sayısın bulun
        System.out.println("Kullanılan satır sayısı : "+workbook.getSheet("Sheet1").getPhysicalNumberOfRows());
        //NOTE___getPhysicalNumberOfRows() methodu kullanılan yani içi dolu olan satırların sayısını verir.Index 1 den başlar

        //Sayfadaki satir sayisini buluun
        System.out.println(workbook.getSheet("Sheet1").getLastRowNum());
       //NOT:getLastRowNum() methodu sayfadaki satır sayısını verir ve index 0(sıfır) dan başlar

        //Ülke-Başkent şeklinde verileri yazdırın
        for (int i = 0; i < workbook.getSheet("Sheet1").getPhysicalNumberOfRows(); i++) {
            for (int j = 0; j < workbook.getSheet("Sheet1").getRow(0).getPhysicalNumberOfCells(); j++) {
                System.out.print(workbook.getSheet("Sheet1").getRow(i).getCell(j)+"\t");

            }
            System.out.println();
        }



    }
}
