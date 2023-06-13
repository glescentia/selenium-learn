import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumWindowAlert {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        String nameOnAlert = "Livia";

        //Enter name and click alert button
        driver.findElement(By.id("name")).sendKeys(nameOnAlert);
        driver.findElement(By.id("alertbtn")).click();

        //Click OK at alert
        Thread.sleep(500);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().getText().contains(nameOnAlert);
        driver.switchTo().alert().accept();

        //Click confirm button then cancel
        driver.findElement(By.id("confirmbtn")).click();
        Thread.sleep(500);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();

        //Close
        driver.close();
    }
}
