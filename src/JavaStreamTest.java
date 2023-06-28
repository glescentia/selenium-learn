import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStreamTest {
    @Test
    public void countNameInitial(){
        ArrayList<String> names = new ArrayList<String>();

        names.add("Abhijeet");
        names.add("Don");
        names.add("Amaya");
        names.add("Adam");
        names.add("Ram");

        int count = 0 ;

        //Traditional Method
        for(int i=0;i<names.size();i++){
                if(names.get(i).startsWith("A")){count++;}
            }
        System.out.println(count);

        //Javastream Method
        long count2 = names.stream().filter(s->s.startsWith("A")).count();
        System.out.println(count2);
    }

    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://qaclickacademy.com/greenkart/#/offers");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //#1 Check if the table is sorted
        //Click on column
        driver.findElement(By.xpath("//tr/th[1]")).click();
        //Get the webelement of the first column of the table in a list
        List<WebElement> elementList = driver.findElements(By.xpath("//tr/td[1]"));
        //Capture the text using stream in a list
        List<String> originalList = elementList.stream().map(s->s.getText()).collect(Collectors.toList());
        //Capture the sorted list
        List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
        //Compare the original and sorted list
        Assert.assertEquals(originalList,sortedList);

//        //#2 Get the price of an item
//        //Langsung print
//        System.out.println(elementList.stream().filter(s->s.getText().contains("Beans")).map(s->getPrice(s)).collect(Collectors.toList()));
//        //Cara course
//        List<String> price;
//        do {
//            List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
//            price = rows.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPrice(s)).collect(Collectors.toList());
//            price.forEach(a -> System.out.println(a));
//            if(price.size()<1){
//                driver.findElement(By.cssSelector("[aria-label='Next']"));
//            }
//        }
//        while(price.size()<1);

        //#3 How many row is the search result and validate the result
        String keyword = "Rice";
        driver.findElement(By.id("search-field")).sendKeys(keyword);
        List<WebElement> searchList = driver.findElements(By.xpath("//tr/td[1]"));
        //Create list with rows containing keyword
        List<WebElement> filteredList = searchList.stream().filter(s->s.getText().contains(keyword)).collect(Collectors.toList());
        //Check if the number of search result is correct
        Assert.assertEquals(searchList.size(),filteredList.size());
        
    }

    private static Object getPrice(WebElement s) {
        return s.findElement(By.xpath("following-sibling::td[1]")).getText();
    }
}
