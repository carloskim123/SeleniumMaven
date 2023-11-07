package main.resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class base {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\carlo\\Documents\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        // expected
        String[] itemsNeeded = {"Cucumber","Brocolli", "Beetroot", "Carrot"};

        driver.get("https://rahulshettyacademy.com/seleniumPractise/");

        addItems(driver, itemsNeeded);
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();
        driver.findElement(By.xpath("//button[contains(text(), 'PROCEED TO CHECKOUT')]")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promobtn")).click();

        w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));

        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
    }


    public static void addItems(WebDriver driver, String[] itemsNeeded) {
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
        int j = 0;

        for (int i = 0; i < products.size(); i++) {

            String[] name = products.get(i).getText().split("-");
            String formattedName = name[0].trim();
            // check if extracted item present in array
            // convert from array to ArrayList for easier search

            List<String> itemsNeededList = Arrays.asList(itemsNeeded);

            if (itemsNeededList.contains(formattedName)) {
                // Add to Cart logic
                j++;
                System.out.println(j);
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

                if(j == itemsNeededList.size()){
                    System.out.println("Iterated over " + itemsNeededList.size());
                    break;
                }
            }
        }
    }


}
