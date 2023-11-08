package main.resources.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowHandlesPractice {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\carlo\\OneDrive\\Documents\\chromedriver_v119.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/");

        driver.findElement(By.linkText("Multiple Windows")).click();

        driver.findElement(By.linkText("Click Here")).click();

        Set<String> windows = driver.getWindowHandles();

        Iterator<String> iterator = windows.iterator();

        String parent= iterator.next();

        String child = iterator.next();

        driver.switchTo().window(child);

        System.out.println(driver.findElement(By.tagName("h3")).getText());

        driver.switchTo().window(parent);

        System.out.println(driver.findElement(By.tagName("h3")).getText());




    }
}
