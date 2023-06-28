import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class SeleniumRelativeLocators {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://qaclickacademy.com/angularpractice");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //Print the label 'Name' above name input box
        WebElement nameBox = driver.findElement(By.cssSelector("[name='name']"));
        System.out.println(driver.findElement(with(By.tagName("label")).above(nameBox)));

        //Click submit button below date of birth
        WebElement dateOfBirth = driver.findElement(By.cssSelector("[for='dateOfBirth']"));
        driver.findElement(with(By.tagName("input")).below(dateOfBirth)).click(); //input box below date of birth is not identified because it is a flex element

        //Check 'Love ice cream' checkbbox
        WebElement iceCreamLabel = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
        driver.findElement(with(By.tagName("input")).toLeftOf(iceCreamLabel)).click();
    }
}
