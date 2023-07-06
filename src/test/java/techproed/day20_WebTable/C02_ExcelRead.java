package techproed.day20_WebTable;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ExcelRead {
/*
    EXCEL dosyasından veri okuyabilmemiz için öncelikle pom.xml dosyamıza poi ve poi.ooxml dependency'lerini
yüklememiz gerekir.
    Sonra üzerinde çalışacağımız excel dosyasını projemizde src>test>java>techpoed>resources package'i içine
kayarız.
 */

    @Test
    public void test01() throws IOException {
        //1- dosya yolunu alınız
        String dosyayolu ="src/test/java/techproed/resources/Capitals.xlsx";

        //2- dosyayi okuyabilmemiz icin akısa almamız gerekir
        FileInputStream fis = new FileInputStream(dosyayolu);

        //3- Java ortamında bir excel dosyası olusturabilmek icin
        Workbook workbook = WorkbookFactory.create(fis);//--> Akisa aldigimiz dosyayi okuyoruz

        //4-olusturdugumuz  excelden sayfa(sheet) secmemiz gerekir
        Sheet sheet = workbook.getSheet("Sheet1");

        //5. - Belirttiğimiz sayfaki satır(row) bilgisini seçmemiz gerekir
        Row row = sheet.getRow(0);//-->Satır da index 0(sıfır)'dan başladığı için 1. satırı getirir

        //6. - Belirttiğimiz satırdaki hücre(Cell) bilgisini seçmemiz gerekir
        Cell cell = row.getCell(0);

        //Son olarak cell bilgisini sout ile yazdırıp excel'deki 1.satır 1.hücredeki veriyi görebiliriz
        System.out.println(cell);

    }

    @Test
    public void test02() throws IOException {
        
        //Pratik cozum
        FileInputStream fis = new FileInputStream("src/test/java/techproed/resources/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        String Satir1Sutun1 =workbook.getSheet("Sheet1").getRow(0).getCell(0).toString();


        System.out.println("Satir1Sutun1 = " + Satir1Sutun1);
        
        
        
        
        
        
        
        
        
        
        
    }
}

