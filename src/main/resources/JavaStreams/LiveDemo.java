package main.resources.JavaStreams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

public class LiveDemo {
    public static void main(String[] args) {

        WebDriver driver;

        WebDriverManager.edgedriver().setup();

        driver = new EdgeDriver();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        // Click on Column
        driver.findElement(By.xpath("//tr//th[1]")).click();
        // capture all elements into list
        List<WebElement> elementsList = driver.findElements(By.xpath("//tr//td[1]"));

        // Next Button
//        WebElement nextButton = driver.findElement(By.xpath("(//a[@aria-label='Next'])[1]"));

        // capture text of all web elements into (original) list
        List<String> originalList = elementsList.stream().map(WebElement::getText).toList();

        //sort on the original list of step 3
        List<String> sortedList = originalList.stream().sorted().toList();

        // compare originalList vs sortedList

        Assert.assertTrue(originalList.equals(sortedList), "Original and sorted lists are not equal");

        List<String> price;
        do {
            List<WebElement> row = driver.findElements(By.xpath("//tr//td[1]"));

//        // scan the name column with getText -> Beans -> print its price
            price = row.stream()
                    .filter(e -> e.getText().contains("Rice"))
                    .map(LiveDemo::getPriceVeggie).toList();

            price.forEach(System.out::println);

            if (price.size() < 1) {
                driver.findElement(By.cssSelector("[aria-label='Next']")).click();
            }
        } while( price.size() < 1);
    }



    private static String getPriceVeggie(WebElement s) {

        return s.findElement(By.xpath("following-sibling::td[1]")).getText();
    }
}
