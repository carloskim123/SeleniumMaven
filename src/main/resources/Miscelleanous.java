package main.resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Miscelleanous {
    public static void main(String[] args) {
        // Todo: Lesson 107 : Maximizing window and deleting cookies

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\carlo\\OneDrive\\Documents\\DownloadedChromedrivers\\chromedriver_v123.0.6312.122.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().deleteCookieNamed("sessionKey");

        // session



        driver.get("http://google.com");



    }
}
