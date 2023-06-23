import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class SeleniumFunctionalTesting {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/");
        WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(5));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();

        //Define products that is wanted to be added
        String[] productNeeded = {"Cucumber","Brocolli","Carrot"};

        //Define number of products added
        int productAdded=0;

        //Add 'Cucumber' to cart
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        for(int i=0;i<products.size();i++){
            //Convert array of product needed into array list
            List<String> productNeededList = Arrays.asList(productNeeded);
                //Check if the product is listed in the product needed list
                if (productNeededList.contains(products.get(i).getText().split(" - ")[0])){
                    driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                    productAdded++;
                    //If all of the products are added, stop the execution
                    if(productAdded==productNeeded.length){
                        break;
                    }
                }

        }

        //Checkout Cart
        driver.findElement(By.xpath("//a[@class='cart-icon']")).click();
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
        driver.findElement(By.className("promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.className("promoBtn")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='promoInfo']")));
        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='promoInfo']")).getText(),"Code applied ..!");

        //Close
        driver.close();
    }
}
