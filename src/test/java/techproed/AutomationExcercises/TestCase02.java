package techproed.AutomationExcercises;

import org.junit.Test;
import utilities.TestBase;

import java.util.Random;

public class TestCase02 extends TestBase {


    @Test
    public void test01() {
        //https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html adresine gidelim
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html");

//Hesap makinasından 2 basamaklı random iki tane sayı seçelim ve random 4 işlemden birini yaptıralım
        Random random =new Random();
        int randomNum1 =random.nextInt(10)+1;
        int randomNum2 = random.nextInt(10)+1;
//Sonucu konsola yazdırıp  esittir tikla
//sonucu yazdir
//Sonucun doğrulamasını yapalım











    }
}
