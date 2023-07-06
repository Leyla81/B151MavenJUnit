package techproed.day15_fileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDowload extends TestBase {



    @Test
    public void name() {

        String filePath ="C:\\Users\\yusuf\\Downloads\\b10 all test cases, code.docx";
        try {
            Files.delete(Paths.get(filePath));
        } catch (IOException e) {
            System.out.println("dosya bulunamadı");
        }
    /*
    Dosyayı daha önce indirdiğimiz için ve tekrar testi çalıştırdığımızda yine aynı dosyayı indireceği için
    burda dosyayı sildik
     */




        //"https://testcenter.techproeducation.com/index.php?page=file-download"   adresine gidin
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");
        bekle(2);

/*


Eğer  localinizden otomasyon ile dosya silmek için File class ından obje oluşturup dosya yolunu içine yerleştiririz.
 Ve oluşturduğumuz obje ile delete() methodunu kullanarak silebiliriz.
 Bunu yapma sebebimiz test classımızı çalıştırmada yeni bir dosya indireceği için oradaki dosya kalabalığını önlemiş oluruz
 Aynı zamananda doğrulama yaparken işimizi garantiye almış oluyoruz
 Aynı isimde birden fazla dosya indirmiş olsakta her indirilenin yanına index vereceği için ve bizim ilk indirdiğimiz
 o klasörün içinde bulamayacağı için her zaman ilk dosyanın varlığını böylelikle test etmiş oluruz

 */
      //"b10 all test cases" dosyasını indirin

       WebElement indirilecekDosya= driver.findElement(By.xpath("//a[text()='b10 all test cases, code.docx']"));
       indirilecekDosya.click();
       bekle(5);

      // Dosyanın başarıyla indirilip indirilmediğini test edin.


        String dosyayolu ="C:\\Users\\yusuf\\Downloads\b10 all test cases, code.docx";
        Assert.assertTrue(Files.exists(Paths.get(dosyayolu)));









    }
}
