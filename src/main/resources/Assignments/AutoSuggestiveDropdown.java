package main.resources.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.stream.IntStream;

public class AutoSuggestiveDropdown {
    public static void main(String[] args) {
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--remote-allow-origins=*");

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\carlo\\OneDrive\\Documents\\DownloadedChromedrivers\\chromedriver_v123.0.6312.122.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        String expectedCountryName = "United States (USA)";
        String starterText = "uni";
        int numOfTimesToMoveArrowDown = 7;

        WebElement dropdown = driver.findElement(By.xpath("//input[@id='autocomplete']"));
        dropdown.click();

        dropdown.sendKeys(starterText);

        // Re-click the dropdown after sending the starter text
        dropdown.click();

        Actions actions = new Actions(driver);

        IntStream.rangeClosed(1, numOfTimesToMoveArrowDown)
                .forEach(i -> actions.sendKeys(Keys.ARROW_DOWN).perform());

        String selectedCountryName = driver.findElement(By.id("autocomplete")).getAttribute("value");

        System.out.println("Selected country text: " + selectedCountryName);

        Assert.assertEquals(expectedCountryName, selectedCountryName);

    }
}
