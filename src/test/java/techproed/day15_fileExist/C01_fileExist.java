package techproed.day15_fileExist;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_fileExist {




    @Test
    public void fileExist() {

        System.out.println(System.getProperty("user.dir"));//C:\Users\yusuf\IdeaProjects\B151MavenJUnit
        System.out.println(System.getProperty("user.home"));//C:\Users\yusuf

//SORU
        // Desktop(masaustu)'da bir text dosyası olusturun
        //"C:\Users\yusuf\OneDrive\Masaüstü
        String dosyaYolu="C:\\Users\\yusuf\\OneDrive\\Masaüstü\\leyla.txt";
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
      Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));



/*2 . yol
        String farklikisim=System.getProperty("user.home");
        String ortakKisim="\\OneDrive\\Masaüstü";
        String dosyaYolu=farklikisim+ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


// Desktop(masaustu)'da text dosyasının olup olmadıgını test edin*/

}
@Test
    public void test03() throws InterruptedException {
        /*
   Bir server'da farkli isletim sistemleri ile ayni anda dosya varligini test etmek istedigimiz zaman, daha dinamik
   olmasi acisindan System.getProoerty("os.name") bu sekilde isletim sistemini alir
   her isletim sisteminin kullanici yolu farkli olacagindan System.getProoerty("user.home") bilgisayarimizdaki
   kullanici yolunu bu sekilde alip String bir degiskene farkliYol ismi ile System.getProoerty("user.home") atayarak
   her seferinde farkli yollari almayla ugrasmamiz oluruz. Dosya diyelim ki masa ustunde ve her isletim sisteminde
   bize ayni yolu verecegi icin bunu da ortak yol olarak bir String'e assing ederiz


 */
        String isletimSistemiadi=System.getProperty("os.name");//windws 11
    System.out.println(isletimSistemiadi);


    String farkliYol = "";
    String isletimSistemiAdi = System.getProperty("os.name");//-->İşletim sistemimizin adını verir
    System.out.println(isletimSistemiAdi);

    System.out.println(System.getProperty("user.home"));//-->Bilgisayarımızdaki kullanıcı yolunu verir

    if (isletimSistemiAdi.contains("Win")){
        farkliYol = System.getProperty("user.home");//-->Windows 10/-->C:\Users\yusuf
    }else if (isletimSistemiAdi.contains("mac")){
        farkliYol = "/Users/aycapolatkamali";//-->Mac işletim sistemi yolu
    }

    String ortakYol = "\\OneDrive\\Masaüstü\\leyla.txt";
    String dosyaYolu = farkliYol+ortakYol;
    System.out.println(Files.exists(Paths.get(dosyaYolu)));
    Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    try {
        Files.delete(Paths.get(dosyaYolu));//-->Bu şekilde belirtmiş olduğumuz dosyayı sileriz
    } catch (IOException e) {
        System.out.println("Dosya bulunamadı");
    }
    Assert.assertFalse(Files.exists(Paths.get(dosyaYolu)));//-->Sildiğimiz için assertFalse kullandık

    Thread.sleep(3000);
    //Sildiğimiz dosya isminde yeni bir dosya oluşturalım
    try {
        Files.createFile(Paths.get(dosyaYolu));//-->Belirtmiş olduğumuz dosyayı oluşturduk
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
    Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    /*
        Her seferinde test ettiğimiz sayfada download işlemi yapılıyorsa gereksiz dosya kalabalığını önlemek için
    yukardaki delete işlemini kullanabiliriz
     */

}
    @Test
    public void test3() {
        /*
            Yukarıdaki methodlarda bilgisayarımızdaki dosya yolunun varlığını Files.exists()methoduyla test etmiştik
        Aynı işlemi aşağıdaki örnekteki gibi File class'ından obje oluşturarak da yapabiliriz.
         */
        String dosyaYolu = "C:\\Users\\yusuf\\OneDrive\\Masaüstü\\leyla.txt";
        File file = new File(dosyaYolu);
        System.out.println(file.exists());
        Assert.assertTrue(file.exists());
        file.delete();
    }



    }

