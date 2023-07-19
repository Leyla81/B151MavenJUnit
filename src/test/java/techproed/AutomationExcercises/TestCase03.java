package techproed.AutomationExcercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class TestCase03 extends TestBase {

        @Test
        public void test01() {
            //1. Launch browser
            //2. Navigate to url 'http://automationexercise.com'
            driver.get("https://automationexercise.com");
            driver.navigate().refresh();
            if (!driver.findElement(By.xpath("//*[@href=\"/test_cases\"]")).isDisplayed()) {// TEST CASES butonuna ulaşılamoyorsa
                driver.switchTo().frame("aswift_5");// parent frame geç

                if (driver.findElement(By.xpath("//*[@id='dismiss-button']")).isDisplayed()) {// Kapatma simgesi gözüküyorsa
                    driver.findElement(By.xpath("//*[@id='dismiss-button']")).click();

                } else {//// Kapatma simgesi gözükmüyorsa child frame geç
                    driver.switchTo().frame(0);
                    bekle(3);
                    driver.findElement(By.xpath("//*[@id='dismiss-button']")).click();

                }
            }

            //3. Verify that home page is visible successfully

            WebElement homePage = driver.findElement(By.xpath("//a[normalize-space()='Home']"));
            Assert.assertTrue(homePage.isDisplayed());
            //4. Click on 'Test Cases' button
            bekle(2);
            WebElement testCases1 = driver.findElement(By.xpath("//*[@href=\"/test_cases\"]"));
            testCases1.click();
            //5. Verify user is navigated to test cases page successfully
            bekle(3);

            if (!driver.findElement(By.xpath("(//h2)[1]")).isDisplayed()) {// TEST CASES yazısı gözükmüyorsa
                driver.switchTo().frame("aswift_5");// parent frame geç

                if (driver.findElement(By.xpath("//*[@id='dismiss-button']")).isDisplayed()) {// Kapatma simgesi gözüküyorsa
                    driver.findElement(By.xpath("//*[@id='dismiss-button']")).click();

                } else {//// Kapatma simgesi gözükmüyorsa child frame geç
                    driver.switchTo().frame(0);
                    bekle(3);
                    driver.findElement(By.xpath("//*[@id='dismiss-button']")).click();

                }
            }
            bekle(3);
            String actualTitle = driver.getTitle();
            String expectedTitle = "Automation Practice Website for UI Testing - Test Cases";
            Assert.assertEquals(expectedTitle, actualTitle);
            WebElement testCases = driver.findElement(By.xpath("(//h2)[1]"));
            Assert.assertTrue(testCases.isDisplayed());
        }
    }





















