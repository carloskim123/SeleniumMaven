package main.resources;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class Miscelleanous {
    public static void main(String[] args) throws IOException {
        // Todo: Lesson 107 : Maximizing window and deleting cookies

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\carlo\\OneDrive\\Documents\\DownloadedChromedrivers\\chromedriver_v123.0.6312.122.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().deleteCookieNamed("sessionKey");

        // session



        driver.get("http://google.com");

        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
       FileUtils.copyFile(src,new File("D://screenshot.png"));
    }
}
