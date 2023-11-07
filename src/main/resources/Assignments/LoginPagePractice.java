package main.resources.Assignments;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPagePractice {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");

        WebDriver driver=new ChromeDriver();
        WebDriverWait w =new WebDriverWait(driver, Duration.ofSeconds(5));

        // Fill in user details
        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.name("password")).sendKeys("learning");

        driver.findElement(By.tagName("input[value='user']")).click();


        // Handle popup
        w.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
        driver.findElement(By.id("okayBtn")).click();


        WebElement dropdownElement = driver.findElement(By.className("form-control"));

        Select dropdown = new Select(dropdownElement);

        dropdown.selectByVisibleText("Student");

        driver.findElement(By.name("terms")).click();




    }
}
