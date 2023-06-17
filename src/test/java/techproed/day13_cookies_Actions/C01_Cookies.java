package techproed.day13_cookies_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Arrays;
import java.util.Set;

public class C01_Cookies extends TestBase {
    @Test
    public void test01() {
        //1-Amazon anasayfaya gidin
        driver.get("https://amazon.com");

        //2-tum cookie’leri listeleyin
        /*
    Cookie'leri listelemek istersek 
            driver.manage().getCookies() methodu ile bir Set ya da ArraList'e atarak listeyebiliriz
 */

       // 1.yol Array ve lambda  ile
       // Arrays.stream(driver.manage().getCookies().toArray()).forEach(System.out::println);//---->lambda ile yazdırdık

      Set<Cookie>cookieSet = driver.manage().getCookies();//collectionlarda yazdırmak icin foreach kullanılır
      int counter =1;
        for (Cookie w:cookieSet) {
            System.out.println(counter +" .cookie :"+w);
            System.out.println(counter +" .cookieName :"+w.getName());//w.getName()cookilerin isimlerini alabiliriz
            System.out.println(counter +" .cookieValue :"+w.getValue());//w.getValue()cookilerin valuelarını alırız alabiliriz

            counter++;

        }

        
        //3-Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin

        Assert.assertTrue(cookieSet.size()>5);

        //4-ismi  olan cookie degerinin USD oldugunu test edin
        String actualCookieValue= driver.manage().getCookieNamed("i18n-prefs").getValue();
        //getCookieNamed() methodu ile bize verilen cookie isminin getValue() methoduyla gercek degerini actualCookieValue degiskenine assign ettik
        String expectedCookieValue ="USD";
        Assert.assertEquals(expectedCookieValue,actualCookieValue);

        // 5-ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie  olusturun ve sayfaya ekleyin
        Cookie cookie=new Cookie("En Sevdigim Cookie","Cikolatali");

        driver.manage().addCookie(cookie);

        //6-eklediginiz cookie’nin sayfaya eklendigini test edin
        cookieSet=driver.manage().getCookies();
        for (Cookie each:cookieSet) {
            System.out.println(each);

        }
        //Assert.assertEquals("cikolatali", driver.manage().getCookieNamed("en sevdigim cookie").getValue());
        System.out.println(" cookieSayisi" +cookieSet.size());
        //sayısınılambd ile yaztırma
        System.out.println("cookie Sayisi Lambda" +Arrays.stream(driver.manage().getCookies().toArray()).count());

        //7-ismi skin olan cookie’yi silin ve silindigini test edin


        int silinmedenOnce = cookieSet.size();
        System.out.println("silinmedenOnce = " + silinmedenOnce);

       driver.manage().deleteCookieNamed("skin");//burda ismi"skin" olanı sildi

        cookieSet=driver.manage().getCookies();//silindikten sonra atamayı yapıp size ı yeniledik


       int silindiktenSonra =cookieSet.size();
        System.out.println("silindiktenSonra = " + silindiktenSonra);

        Assert.assertEquals(1,(silinmedenOnce-silindiktenSonra));



        System.out.println(" cookieSayisi = " +cookieSet.size());
        //sayısınılambd ile yaztırma
        System.out.println("cookie Sayisi Lambda = " +Arrays.stream(driver.manage().getCookies().toArray()).count());


        //8-tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();//tum cookıe ler slindi
        cookieSet=driver.manage().getCookies(); //cookie set guncellendi
        Assert.assertTrue(cookieSet.isEmpty());//cookie set in icini bos oldugunu isEmpty methodu ile test ettik

















    }
}
