import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class SeleniumWindowHandleAssignment {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();

        //Switch to second window
        Set<String> windows = driver.getWindowHandles(); //get the windows id in an array
        Iterator<String> it = windows.iterator();
        String tab1 = it.next(); //define the first window id as "tab1"
        String tab2 = it.next(); //define the second window id as "tab2"
        driver.switchTo().window(tab2);

        //Print heading in the new tab
        System.out.println(driver.findElement(By.cssSelector("h3")).getText());

        //Back to the previous window
        driver.switchTo().window(tab1);
        System.out.println(driver.findElement(By.cssSelector("h3")).getText());

        //Close driver
        driver.quit();
    }
}
