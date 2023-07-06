package techproed.day21_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C01_ExcelRead {

    //web Sayfasında kullanılacak olan bilgileri depolamak icin excel kullanırız
//excelde index sıfırdan baslar

    @Test
    public void readExcelTest01() throws IOException {


       //3.satır birinci sutun degerini yazdırın ve France oldugunu test ediniz.
          //---Note: dosya yolunu alalım
        String dosyaYolu = "src/test/java/techproed/resources/Capitals.xlsx";

        //---Note Capitals excel dosyasını java ya uyarlama yapılır.dosyayı okuyabilmek icin akısa almalıyız
        FileInputStream fis =new FileInputStream(dosyaYolu);

        //----Note : dosyayı workbook a atamalıyız java ortamında excel dosyası olusturmalıyız.
        Workbook workbook = WorkbookFactory.create(fis);// dosyayı enson fis e assign etmistik

       String Satır3Sutun1= workbook.getSheet("Sheet1").getRow(2).getCell(0).toString();
                                     //sayfa                satır        sutun         string e assign ettik
        System.out.println("Satır3Sutun1 = " + Satır3Sutun1);


        Assert.assertEquals("France",Satır3Sutun1);

      //son satır sayısını bulunuz

        System.out.println("sonSatir Sayisi = "+workbook.getSheet("Sheet1").getLastRowNum());
        //NOT:getLastRowNum() methodu sayfadaki son satır sayısını verir ve index 0(sıfır) dan başlar


        // Kullanılan satır sayısın bulun
        System.out.println("Kullanılan satır sayısı : "+workbook.getSheet("Sheet1").getPhysicalNumberOfRows());
        //NOTE___getPhysicalNumberOfRows() methodu kullanılan yani içi dolu olan satırların sayısını verir.Index 1 den başlar

    }

    @Test
    public void test02() throws IOException {
        //capital dosyasındaki tum verilri yazdırın
        Map<String,String> capitalsMap=new HashMap<>();
        //capital dosyasındaki tum verileri koyabilecegimiz en uygun java objesi map tir. --key ----value

        String dosyaYolu = "src/test/java/techproed/resources/Capitals.xlsx";

        //---Note Capitals excel dosyasını java ya uyarlama yapılır.dosyayı okuyabilmek icin akısa almalıyız
        FileInputStream fis =new FileInputStream(dosyaYolu);

        //----Note : dosyayı workbook a atamalıyız java ortamında excel dosyası olusturmalıyız.
        Workbook workbook = WorkbookFactory.create(fis);// dosyayı enson fis e assign etmistik

        int sonSatirSayisi = workbook.getSheet("Sheet1").getLastRowNum();
        for (int i = 0; i <sonSatirSayisi ; i++) {
          String key =workbook.getSheet("Sheet1").getRow(i).getCell(0).toString();
         String value= workbook.getSheet("Sheet1").getRow(i).getCell(1).toString();

         capitalsMap.put(key,value);
        }

        System.out.println("CapitalsTumVeriler = " + capitalsMap);











    }
}
