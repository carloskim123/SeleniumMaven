package main.resources.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TablesPractice {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\carlo\\OneDrive\\Documents\\DownloadedChromedrivers\\chromedriver_v123.0.6312.122.exe");
        WebDriver driver = new ChromeDriver();

        // TODO: Get the number of table rows and columns
        // TODO: Get the value of the 2nd row in the table count from the first row not including the header

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // find table
        WebElement table = driver.findElement(By.xpath("//div[@class='left-align']//table[@id='product']"));

        // find tr - table rows
        int tableRows = table.findElements(By.tagName("tr")).size();
        System.out.println(tableRows);

        // find td - table downs or columns using th
        int colCount = table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size();
        System.out.println("Number of columns: " + colCount);

        // locate the 2nd row
        List<WebElement> secondRow = table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));

        System.out.println(secondRow.get(0).getText());
        System.out.println(secondRow.get(1).getText());
        System.out.println(secondRow.get(2).getText());

    }
}
