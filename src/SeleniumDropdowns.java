import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumDropdowns {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/dropdownsPractise");
        //Select Currency Dropdown
        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByIndex(3);
        dropdown.selectByVisibleText("AED");

        //Select Passengers Dropdown
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(500);
        int numPassengers = 5;
        //Increase num of passengers using for loop
        for(int i=0;i<numPassengers-1;i++) {
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        //Reset num of passengers
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(500);
        for(int i=0;i<numPassengers-1;i++) {
            driver.findElement(By.id("hrefDecAdt")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        //Increase num of passengers using while loop
        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(500);
        int i = 1;
        while (i<numPassengers){
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }
        driver.findElement(By.id("btnclosepaxoption")).click();

        //Dynamic Dropdown From and To City
        driver.manage().window().maximize();
        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//a[@value='MAA']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//a[@value='BHO'])[2]")).click();

        //Address element that is hidden when user click somewhere else (including inspect window)
        driver.findElement(By.id("autosuggest")).sendKeys("Ind");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[contains(@id,'ui-id')][text()='India']")).click();
        driver.close();
    }
}
