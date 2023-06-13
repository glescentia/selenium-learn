import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumAssignmentUI {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        driver.findElement(By.name("name")).sendKeys("Livia");
        driver.findElement(By.name("email")).sendKeys("Livia@gmail.com");
        driver.findElement(By.id("exampleInputPassword1")).sendKeys("Livia");
        driver.findElement(By.id("exampleCheck1")).click();
        driver.findElement(By.id("exampleFormControlSelect1")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//select[@id='exampleFormControlSelect1'] //option[text()='Female']")).click();
        driver.findElement(By.id("inlineRadio1")).click();
        driver.findElement(By.name("bday")).sendKeys("03Aug");
        driver.findElement(By.name("bday")).sendKeys(Keys.TAB);
        driver.findElement(By.name("bday")).sendKeys("2000");
        driver.findElement(By.className("btn-success")).click();
        System.out.println(driver.findElement(By.className("alert-success")).getText());
        driver.close();
    }
    }
