import org.openqa.selenium.Proxy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class SeleniumOtherConfiguration {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://expired.badssl.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //Proceed invalid certificate
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);

        //Set proxy
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("ipaddress:4444"); //define the proxy in a variable
        options.setCapability("proxy",proxy); //if ip address is directly inputted here, java will read them as STRING

        //Delete cookies
        driver.manage().deleteAllCookies();

        //Close
        driver.close();
    }
    }
