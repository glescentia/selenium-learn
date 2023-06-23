import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SeleniumWaitUsageAssignment {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //Log In
        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("password")).sendKeys("learning");
        driver.findElement(By.xpath("//input[@value='user']/following-sibling::span")).click();
        w.until(ExpectedConditions.elementToBeClickable(By.id("okayBtn")));
        driver.findElement(By.id("okayBtn")).click();
        driver.findElement(By.xpath("//select[@class='form-control']")).click();
        driver.findElement(By.xpath("//option[@value='consult']")).click();
        driver.findElement(By.id("terms")).click();
        driver.findElement(By.id("signInBtn")).click();

        //Add All Items To Cart
        w.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-info']")));
        int numOfItem = driver.findElements(By.xpath("//button[@class='btn btn-info']")).size();
        for(int i=0;i<numOfItem;i++){
            driver.findElements(By.xpath("//button[@class='btn btn-info']")).get(i).click();
        }

        //Check Number Of Item In Cart
        Assert.assertEquals(driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).getText().split(" ")[2],Integer.toString(numOfItem));

        //Checkout The Cart
        driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();

        //Close
        driver.close();
    }
}
