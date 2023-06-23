import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class SeleniumEndToEndAssignment {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://qaclickacademy.com/practice.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //Click a checkbox
        driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[3]/input")).click();
        //Grab the label of the selected checkbox
        String label = driver.findElement(By.xpath("//div[@id='checkbox-example']/fieldset/label[3]")).getText();
        System.out.println(label);
        //Select the dropdown which is the selected checkbox
        WebElement staticDropdown = driver.findElement(By.id("dropdown-class-example"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByVisibleText(label);
        //Enter the label to the text box
        driver.findElement(By.id("name")).sendKeys(label);
        driver.findElement(By.id("confirmbtn")).click();
        //Click and verify if the label is present in the pop up window
        if (driver.switchTo().alert().getText().contains(label)){
            driver.switchTo().alert().accept();
            System.out.println("accepted");
        }
    }
    }
