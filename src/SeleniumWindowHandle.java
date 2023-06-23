import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class SeleniumWindowHandle {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //Click the link at top right
        driver.findElement(By.className("blinkingText")).click();

        //Switch to second window
        Set<String> windows = driver.getWindowHandles(); //get the windows id in an array
        Iterator<String> it = windows.iterator();
        String tab1 = it.next(); //define the first window id as "tab1"
        String tab2 = it.next(); //define the second window id as "tab2"
        driver.switchTo().window(tab2);

        //Get the email
        String email = driver.findElement(By.xpath("//p[@class='im-para red']/strong/a")).getText();
        System.out.println(email);

        //Use the email to input the username in the first tab
        driver.switchTo().window(tab1);
        driver.findElement(By.id("username")).sendKeys(email);

        //Close
        driver.quit();
    }
}
