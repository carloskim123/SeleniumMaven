package main.resources;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class javascriptExecutor {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\carlo\\OneDrive\\Documents\\DownloadedChromedrivers\\chromedriver_v123.0.6312.122.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");


        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("window.scrollBy(0,500)");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

        List<WebElement> values = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
        int sum = 0;

        for (WebElement value : values) {

            sum = sum + Integer.parseInt(value.getText());

        }

        System.out.println("Calculated Count" + sum);

        // compare (sum) against the actual count

        WebElement actualCountElement = driver.findElement(By.xpath("//div[@class='totalAmount']"));
        int actualCountValue = Integer.parseInt(actualCountElement.getText().split(":")[1].trim());
        System.out.println("Actual Count: " + actualCountValue);


        Assert.assertEquals(sum, actualCountValue);







    }
}
