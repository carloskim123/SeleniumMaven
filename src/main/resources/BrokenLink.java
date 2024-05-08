package main.resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class BrokenLink {
    public static void main(String[] args) throws MalformedURLException, IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\carlo\\OneDrive\\Documents\\DownloadedChromedrivers\\chromedriver_v123.0.6312.122.exe");
        WebDriver driver = new ChromeDriver();

        // Broken Url
        // Step 1 is to get all urls tied up to links using selenium
        // Java methods will call the URL's and gets you the status code
        // if status codes are greater than 400 then the link isn't working and is broken

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        String url = driver.findElement(By.cssSelector("a[href*='soapui']")).getAttribute("href");

        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        conn.setRequestMethod("HEAD");

        conn.connect();

        int responseCode = conn.getResponseCode();

        System.out.println(responseCode);





    }
}
