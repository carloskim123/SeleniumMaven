package main.resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class BrokenLink {
    public static void main(String[] args) throws IOException {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\carlo\\OneDrive\\Documents\\EDGE_WEBDRIVERS\\msedgedriver_126.0.2592.68.exe");
        WebDriver driver = new EdgeDriver();

        // Broken Url
        // Step 1 is to get all urls tied up to links using selenium
        // Java methods will call the URL's and gets you the status code
        // if status codes are greater than 400 then the link isn't working and is broken

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        SoftAssert $softAssert = new SoftAssert();


        for(WebElement link : links) {
            String url = link.getAttribute("href");

            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("HEAD");

            conn.connect();

            int responseCode = conn.getResponseCode();
            System.out.println(responseCode);
            $softAssert.assertTrue(responseCode < 400, "The link with Text " + link.getText() + " is broken with code " + responseCode);

        }


        $softAssert.assertAll();





    }
}
