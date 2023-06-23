import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class SeleniumCalendarMonth {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.makemytrip.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String month = "August";
        int date = 28;
        //Click departure calendar
        driver.findElement(By.xpath("//label[@for='departure']")).click();
        List<WebElement> calCaptions = driver.findElements(By.xpath("//div[@class='DayPicker-Caption']"));
        //Define index i to identify the location of the element. 0 means the first (left), 1 means the second (right).
        int i;
        //Check if the left calendar's month is the month
        if(calCaptions.get(0).findElement(By.cssSelector("div")).getText().contains(month)){
            i=0;
        }
        else{
            i=1;
            //Click next until the month on the right match
            while(!calCaptions.get(1).findElement(By.cssSelector("div")).getText().contains(month)){
                driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
            }
        }
        //Define the xpath based on date parameter
        String calXpath = "//div[@class='DayPicker-Day']/div/p[text()='"+date+"']";
        //Click the element based on the index defined by i
        driver.findElements(By.xpath(calXpath)).get(i).click();
        //Close
        driver.close();
    }
}
