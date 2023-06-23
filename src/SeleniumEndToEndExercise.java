import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SeleniumEndToEndExercise {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://qaclickacademy.com/practice.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //Count number of link in the webpage
        System.out.println(driver.findElements(By.cssSelector("a")).size());

        //Count number of link in the foot webpage
        System.out.println(driver.findElements(By.cssSelector("div#gf-BIG a")).size());
        //Another way
        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
        System.out.println(footerDriver.findElements(By.cssSelector("a")).size());

        //Count number of link in the foot webpage, first column
        WebElement firstCol = footerDriver.findElement(By.xpath("//ul[1]"));
        List<WebElement> firstColLink = firstCol.findElements(By.cssSelector("a"));
        int numFirstCol = firstColLink.size();
        System.out.println(numFirstCol);

        //Click every link in the first column and check if the pages are opening
        for(int i=0;i<numFirstCol;i++){
            //Click while holding ctrl to open it in new tab
            String clickOnLinkTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
            firstColLink.get(i).sendKeys(clickOnLinkTab);
        }
        //Count the tabs
        Set<String> windows = driver.getWindowHandles();
        Assert.assertEquals(windows.size(),numFirstCol+1);
        System.out.println(windows.size());

        //Get the titles of all tabs
        Iterator<String> it = windows.iterator();

        while(it.hasNext()){
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }
    }
}
