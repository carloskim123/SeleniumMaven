package main.resources.Projects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;


public class BusTicketBookingService {

    public static void main(String[] args) {
        // Globals
        String ticketServiceUrl = "https://www.wanderu.com/";
        String departureLocation = "Germany Beck, York";
        String arrivalLocation = "Daytona Beach, FL";

        // Get current date
        LocalDate currentDate = LocalDate.now();

        // Add a week to the current date
        LocalDate departureDate = currentDate.plusDays(7);

        // Format the departure date to the supported format: E, MMM,d / Fri, Apr 5
        String formattedDepartureDate = departureDate.format(DateTimeFormatter.ofPattern("E, MMM d"));

        // Initialize WebDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\carlo\\OneDrive\\Documents\\DownloadedChromedrivers\\chromedriver_v123.063.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // window handles
        Set<String> windowHandles = driver.getWindowHandles();

        // access website
        driver.get(ticketServiceUrl);

        // find and input departure location
        WebElement departureElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='departure']")));
        departureElement.sendKeys(departureLocation);
        departureElement.sendKeys(Keys.ESCAPE);

        // find and input arrival location
        WebElement arrivalElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@aria-label='arrival']")));
        arrivalElement.sendKeys(arrivalLocation);
        departureElement.sendKeys(Keys.ESCAPE);


        // find and click on the departure date input to open the calendar
        WebElement departureDateInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@aria-label='Departure']")));
        departureDateInput.click();
        departureDateInput.click();

        // hit search
        WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@label='Search']")));
        searchBtn.click();


        // begin window switch - switch to the next window

        // Get all window handles after the new window is opened
        Set<String> newWindowHandles = driver.getWindowHandles();
        String mainWindowHandle = driver.getWindowHandle();

        // Find the new window handle by comparing with the main window handle
        String newWindowHandle = "";
        for (String handle : newWindowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                newWindowHandle = handle;
                break;
            }
        }

        // Switch to the new window
        driver.switchTo().window(newWindowHandle);


        // now we're in the new window

        WebElement resultsFound = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='coGzNlgINE46']")));
        System.out.println( ticketServiceUrl + " " + "responded with: " +resultsFound.getText());



    }
}
