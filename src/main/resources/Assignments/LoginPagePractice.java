package main.resources.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginPagePractice {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\carlo\\OneDrive\\Documents\\chromedriver_v119.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");

        // Fill in user details
        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.name("password")).sendKeys("learning");
        driver.findElement(By.cssSelector("input[value='user']")).click();

        // Handle popup
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
        driver.findElement(By.id("okayBtn")).click();

        // Handle select dropdown
        WebElement dropdownElement = driver.findElement(By.tagName("select"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText("Consultant");

        // Check terms and conditions radio -> Optional
        driver.findElement(By.name("terms")).click();

        // Handle submit
        driver.findElement(By.id("signInBtn")).click();

        // Wait for a specific element to be present
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".card-footer button")));

        // Call the addItems function
        addItems(driver);

        // navigate to checkout
        driver.findElement(By.cssSelector(".nav-link.btn.btn-primary")).click();

    }

    public static void addItems(WebDriver driver) {
        List<WebElement> buttonsInCardFooter = driver.findElements(By.cssSelector(".card-footer button"));
        for (WebElement button : buttonsInCardFooter) {
            button.click();
        }
    }
}

