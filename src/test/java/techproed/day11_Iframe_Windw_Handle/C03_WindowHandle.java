package techproed.day11_Iframe_Windw_Handle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03_WindowHandle extends TestBase {

    @Test
    public void windowHandle() {
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techproedWindowHandle=driver.getWindowHandle();

//Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        String actualTitle= driver.getTitle();
        String expectedTitle="Techpro Education | Online It Courses & Bootcamps";
        Assert.assertEquals(expectedTitle,actualTitle);
//Window 2'de (yeni bir pencere) https://www.youtube.com sayfasını açınız:
       driver.switchTo().newWindow(WindowType.WINDOW);//---->yeni pecere acar
       //WindowType.TAB yeni sekme acar

       driver.get("https://www.youtube.com");
       String youTubeWindowHandle= driver.getWindowHandle();


//Window 3'te (yeni bir pencere) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        String linkedinWindowHandle=driver.getWindowHandle();

//techproeducation sayfasına geçiniz:
        driver.switchTo().window(techproedWindowHandle);
        bekle(3);
//youtube sayfasına geçiniz:
        driver.switchTo().window(youTubeWindowHandle);
        bekle(3);
//linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedinWindowHandle);
        bekle(3);




    }
}
