import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class SeleniumBrokenLinks {
    public static void main(String[] args) throws InterruptedException, IOException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //Use soft assertions
        SoftAssert a = new SoftAssert();

        //Define footer driver
        WebElement footerDriver = driver.findElement(By.id("gf-BIG"));

        //Get the links in the footer driver
        List<WebElement> links = footerDriver.findElements(By.cssSelector("a"));
        //Check every link
        for(WebElement link:links){
            //Check broken links using XHR Status in network in Dev Tools
            //To get the status, use open connection
            HttpURLConnection connection = (HttpURLConnection) new URL(link.getAttribute("href")).openConnection();
            connection.setRequestMethod("HEAD");
            connection.connect();
            int respCode = connection.getResponseCode();
            a.assertTrue(respCode<400,"The link "+link.getAttribute("href")+" is broken.");
        }

//        HttpURLConnection connection = (HttpURLConnection) new URL("https://rahulshettyacademy.com/brokenlink").openConnection();
//        connection.setRequestMethod("HEAD");
//        connection.connect();
//        int respCode = connection.getResponseCode();
//        System.out.println(respCode);
//        a.assertTrue(respCode<400,"The link is broken");
        a.assertAll();
        //close
        driver.close();
    }
}
