package techproed.AutomationExcercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class TestCase04 extends TestBase {
    @Test
    public void test01() {
       //1. Launch browser
       //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

       //3. Verify that home page is visible successfully
        WebElement homePage =driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(homePage.isDisplayed());

       //4. Click on 'Products' button
        driver.findElement(By.xpath("(//li)[2]")).click();

       //5. Verify user is navigated to ALL PRODUCTS page successfully
        String productTitle =driver.getTitle();
        Assert.assertTrue(productTitle.contains("All Products"));
       //6. The products list is visible

       List<WebElement> allProducts= driver.findElements(By.xpath("//div[@class='choose']"));
        for (int i = 0; i <allProducts.size(); i++) {
            allProducts= driver.findElements(By.xpath("//div[@class='choose']"));
          assert allProducts.get(i).isDisplayed();
        }
       //7. Click on 'View Product' of first product
        Actions actions=new Actions(driver);
        actions.moveToElement(allProducts.get(0)).build();
         allProducts.get(0).click();

       //8. User is landed to product detail page
        String expecteUrl="https://https://automationexercise.com/product_details/1";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expecteUrl,actualUrl);

       //9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
        WebElement category=driver.findElement(By.xpath("//p[normalize-space()='Category: Women > Tops']"));
        System.out.println("category = " + category.getText());
        assert category.isDisplayed();
        WebElement price=driver.findElement(By.xpath("//span[normalize-space()='Rs. 500']"));
        System.out.println("price = " + price.getText());
        assert price.isDisplayed();
        WebElement productName = driver.findElement(By.xpath("(//h2)[3]"));
        System.out.println("productName = " + productName);
         assert productName.isDisplayed();
       WebElement availability =driver.findElement(By.xpath("(//p)[4]"));
        System.out.println("availability = " + availability);
       assert  availability.isDisplayed();
        WebElement condition =driver.findElement(By.xpath("(//p)[5]"));
        System.out.println("condition = " + condition);
       assert  condition.isDisplayed();
        WebElement  brand= driver.findElement(By.xpath("(//p)[6]"));
        System.out.println("brand = " + brand);
       assert  brand.isDisplayed();





    }
}
