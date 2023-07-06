package techproed.day14_Action_Fakers;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C04_Fakers {

    @Test
    public void faker() {


 /*
        Faker class'indan sahte verileri kullanabilmek icin obje olusturmamiz gerekir
         */
        Faker faker=new Faker();

        //faker objesini kullanarak bir ism yazdıralın
        System.out.println(faker.name().firstName());

        //faker objesini kullanarak bir soyisim yazdıralın

        System.out.println(faker.name().lastName());

        //faker objesini kullanarak bir full name yazdıralın
        System.out.println(faker.name().fullName());

        //faker objesini kullanarak bir adres yazdıralın
        System.out.println(faker.address().fullAddress());

        //faker objesini kullanarak bir tel-no yazdıralın
        System.out.println(faker.phoneNumber().cellPhone());
        //Rastgele 15 haneli bir numara yazdiralim
        System.out.println("Rastgele 15 haneli bir numara : "+faker.number().digits(15));

        //Meslek pozisyonu
        System.out.println(faker.job().position());


    }
}
