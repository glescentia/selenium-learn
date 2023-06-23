import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.time.Duration;

public class SeleniumFrameHandle {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //Go to frame in web page
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
        driver.findElement(By.id("draggable")).click();

        //Define actions for mouse interaction
        Actions mouse = new Actions(driver);
        //Define source and target element to drag and drop
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        mouse.dragAndDrop(source,target).build().perform();

        //Check if the element is dropped
        Assert.assertEquals(driver.findElement(By.xpath("//div[@id='droppable']/p")).getText(),"Dropped!");

        //Back to default web page
        driver.switchTo().defaultContent();
        driver.findElement(By.className("entry-title")).isDisplayed();
    }
}
