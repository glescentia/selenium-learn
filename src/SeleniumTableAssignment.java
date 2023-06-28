import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;

public class SeleniumTableAssignment {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://qaclickacademy.com/practice.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //print number of row and column
        WebElement table = driver.findElement(By.id("product"));
        int col = table.findElements(By.cssSelector("tr")).size();
        int row = table.findElements(By.cssSelector("th")).size();
        System.out.println("Number of column: "+col);
        System.out.println("Number of row: "+row);
        //print second row of data
        System.out.println(table.findElements(By.cssSelector("tr")).get(2).getText());

        //Select country by inputting keyword and use arrow key
        driver.findElement(By.id("autocomplete")).sendKeys("Ind");
        Thread.sleep(2000);

        while (!driver.findElement(By.id("autocomplete")).getAttribute("value").equalsIgnoreCase("Indonesia")){
            driver.findElement(By.id("autocomplete")).sendKeys(Keys.ARROW_DOWN);
        }

        System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
        //Close
        driver.close();
    }
}
