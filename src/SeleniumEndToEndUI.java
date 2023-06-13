import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SeleniumEndToEndUI {
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

        //Check Return Date is Disabled
        if(driver.findElement(By.className("picker-second")).getAttribute("style").contains("1")){
            Assert.assertTrue(false);
        }
        else{
            Assert.assertTrue(true);
        }

        //Select Currency Dropdown
        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByVisibleText("AED");

        //Click Search
        driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();

        //Close
        driver.close();
    }
    }
