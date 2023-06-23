import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SeleniumFrameHandleAssignment {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.findElement(By.xpath("//a[text()='Nested Frames']")).click();

        //Go to first frame in web page
        driver.switchTo().frame(0);
        //Go to second frame (middle frame) in web page
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-middle']")));
        //Print the text in the middle frame
        System.out.println(driver.findElement(By.id("content")).getText());

        //Close driver
        driver.close();
    }
    }
