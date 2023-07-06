package techproed.day21_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_ExcelWrite {
    @Test
    public void test01() throws IOException {

    //Bir nufus sutunu olusturun


        String dosyaYolu = "src/test/java/techproed/resources/Capitals.xlsx";

        FileInputStream fis =new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);

        workbook.getSheet("Sheet1").getRow(0).createCell(2).setCellValue("NUFUS");
        // ---note: excel de bir hucre olusturmak icin createCell() methodu kullanılır
        //----hucre icine yazdirilacak deger icin setCellValue() methodu olusturulur.

// baskent nufuslarını excel dosyasına yazınız.
// (D.C: 1000, Paris:1100, London:1200, Ankara:1300)
        workbook.getSheet("Sheet1").getRow(1).createCell(2).setCellValue("1100");
        workbook.getSheet("Sheet1").getRow(2).createCell(2).setCellValue("1500");
        workbook.getSheet("Sheet1").getRow(3).createCell(2).setCellValue("1600");
        workbook.getSheet("Sheet1").getRow(4).createCell(2).setCellValue("1800");
        workbook.getSheet("Sheet1").getRow(5).createCell(2).setCellValue("1900");
        workbook.getSheet("Sheet1").getRow(6).createCell(2).setCellValue("1200");
        workbook.getSheet("Sheet1").getRow(7).createCell(2).setCellValue("1300");
        workbook.getSheet("Sheet1").getRow(8).createCell(2).setCellValue("1400");
        workbook.getSheet("Sheet1").getRow(9).createCell(2).setCellValue("1000");
        workbook.getSheet("Sheet1").getRow(10).createCell(2).setCellValue("1700");

        FileOutputStream fos = new FileOutputStream(dosyaYolu);
        //--Notw :dataları bizim classimizdan Capitals dosyasına gondermek icin FileOutputStream objesi ile yaparız
        workbook.write(fos);



}







}
