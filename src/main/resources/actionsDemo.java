package main.resources;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Interaction;

import java.security.Key;

public class actionsDemo {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\carlo\\OneDrive\\Documents\\chromedriver_v119.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");

        driver.manage().window().maximize();
        Actions a = new Actions(driver);

        WebElement move = driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));

        a.moveToElement(driver.findElement(By.id("twotabsearchtextbox")))
                .click()
                .keyDown(Keys.SHIFT)
                .sendKeys("hello world")
                .doubleClick()
                .build()
                .perform();


        a.moveToElement(move).contextClick().build().perform();
    }
}
