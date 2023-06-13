import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBrowserNavigation {
    public static void main(String[] args) throws InterruptedException {
        String name = "rahul";

//        System.setProperty("webdriver.chrome.driver", "C:/Chrome Driver/chromedriver_win32/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com");
        driver.get("https://rahulshettyacademy.com/AutomationPractice");
        System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
        System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());
        driver.navigate().back();
        driver.navigate().forward();

    }
}
