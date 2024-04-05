package main.resources.Review;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Review {

    static String inputText = "Kenya";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\carlo\\OneDrive\\Documents\\chromedriver_v121.067.exe");
        WebDriver driver = new ChromeDriver();


        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Locate Input Field
        driver.findElement(By.id("autocomplete")).click();
        System.out.println("Input Location done");

        // Enter text into input field
        driver.findElement(By.id("autocomplete")).sendKeys(inputText);
        System.out.println("Text entering done");

        // Check dropdown field for text and log to console
       // System.out.println(driver.findElement(By.className(".ui-menu-item-wrapper")).getText());






    }
}
