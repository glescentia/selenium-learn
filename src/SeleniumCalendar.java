import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SeleniumCalendar {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise");

        //Select From and To City
        driver.manage().window().maximize();
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//a[@value='MAA']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//a[@value='BHO'])[2]")).click();

        //Select Date
        driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//td //a[text()='29']")).click();

        //Select Round Trip and Checking if the return date is able to edit
        System.out.println(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());
        if(driver.findElement(By.className("picker-second")).getAttribute("style").contains("1")){
            Assert.assertTrue(true);
        }
        else{
            Assert.assertTrue(false);
        }

        driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
        if(driver.findElement(By.className("picker-second")).getAttribute("style").contains("1")){
            Assert.assertTrue(true);
        }
        else{
            Assert.assertTrue(false);
        }

    }
    }
