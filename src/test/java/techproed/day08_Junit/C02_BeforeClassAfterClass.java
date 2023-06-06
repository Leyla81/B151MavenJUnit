package techproed.day08_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;

public class C02_BeforeClassAfterClass {


    //@beforeClass ve @AterClass methodları static methodlarla calisir
    //@BeforeClass class'da oncesi calısır
    //@AfterClass methodu her class sonunda calisir


    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Class'daki en once calisan methotdur bir kez calisir");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Class'daki en son calisan methotdur bir kez calisir");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Class'da her test methodundan ONCE calisan methoddur");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Class'da her test methodundan SONRA calisan methoddur");
    }

    @Test
    public void TEST01() {
        System.out.println("ilk test");
    }

    @Test
    public void TEST02() {
        System.out.println("ikinci test");
    }
}
