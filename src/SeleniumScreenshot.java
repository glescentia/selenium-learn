import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;


public class SeleniumScreenshot {
    public static void main(String[] args) throws InterruptedException, IOException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://youtube.com/");

        File src = ((TakesScreenshot)driver).getScreenshotAs((OutputType.FILE));
        FileHandler.copy(src,new File("C:\\Users\\livia\\Workspace\\screenshot.png"));

        driver.close();
    }
}
