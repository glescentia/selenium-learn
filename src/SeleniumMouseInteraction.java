import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class SeleniumMouseInteraction {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://id.hm.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        Actions mouse = new Actions(driver);
        mouse.moveToElement(driver.findElement(By.id("ui-id-5"))).build().perform();
        System.out.println(driver.findElement(By.id("ui-id-19")).getText());
        mouse.moveToElement(driver.findElement(By.id("search"))).click().keyDown(Keys.SHIFT).sendKeys("Blouse").build().perform();
        mouse.moveToElement(driver.findElement(By.id("search"))).doubleClick().sendKeys(Keys.BACK_SPACE).build().perform();
        driver.close();
    }
}
