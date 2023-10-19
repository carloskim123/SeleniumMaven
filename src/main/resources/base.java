package main.resources;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\carlo\\Documents\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        // expected
        String[] itemsNeeded = {"Cucumber", "Broccoli","Beetroot"};

        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        for (int i = 0; i <products.size();i++){
            String name = products.get(i).getText();
            // check if extracted item present in array
            // convert from array to ArrayList for easier search

            List<String> itemsNeededList = Arrays.asList(itemsNeeded);

            if(itemsNeededList.contains(name)) {
                // Add to Cart logic
                driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
                break;

            }
        }
    }

}
