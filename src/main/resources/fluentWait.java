package main.resources;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class fluentWait {


    public static void main(String[] args) {
        // https://the-internet.herokuapp.com/dynamic_loading/1
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\carlo\\OneDrive\\Documents\\chromedriver_v119.exe");
        WebDriver driver = new ChromeDriver();

        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        driver.findElement(By.cssSelector("[id='start'] button")).click();

        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3))
                .ignoring(NoSuchElementException.class);


        WebElement foo = wait.until(driver1 -> {
            WebElement element = driver1.findElement(By.cssSelector("[id='finish'] h4"));

            if(element.isDisplayed()) {
                return element;
            } else return null;


        });


        System.out.println(driver.findElement(By.cssSelector("[id='finish'] h4")).getText());

    }
}




















