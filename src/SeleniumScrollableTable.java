import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class SeleniumScrollableTable {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //Import Javascript
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Scroll webpage to the bottom of the webpage
        js.executeScript("window.scrollBy(0,500)");

        //Define sum variable
        int sum=0;

        //Define rows in the table
        List<WebElement> row = driver.findElements(By.cssSelector("div[class='tableFixHead'] tbody tr"));

        //Loop the rows in the table to get the value
        for(WebElement i:row){
//            System.out.println(i.findElements(By.cssSelector("td")).get(3).getText());
            //Add the value to the sum variable
            sum += Integer.parseInt(i.findElements(By.cssSelector("td")).get(3).getText());
        }
        int sumWritten = Integer.parseInt(driver.findElement(By.className("totalAmount")).getText().split(": ")[1]);

        Assert.assertEquals(sum,sumWritten);
        //Scroll the table
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

        driver.close();

    }
}
