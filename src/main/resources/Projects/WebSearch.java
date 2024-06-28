package main.resources.Projects;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class WebSearch {

    static class SearchResult {
        private final String title;
        private final String source;
        private final String rating;
        private final String ingredients;

        // constructor
        public SearchResult(String title, String source, String rating, String ingredients) {
            this.title = title;
            this.source = source;
            this.rating = rating;
            this.ingredients = ingredients;
        }

        // getter for the fields
        public String getTitle() { return title; }
        public String getSource() { return source; }
        public String getRating() { return rating; }
        public String getIngredients() { return ingredients; }
    }

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\carlo\\OneDrive\\Documents\\DownloadedChromedrivers\\chromedriver_v123.0.6312.122.exe");
        WebDriver driver = new ChromeDriver();

        // data object for the search result
        List<SearchResult> searchResults = new ArrayList<>();

        // globals
        String searchKeyword = "best pizza recipes";
        String pageUrl = "https://www.google.com/search?q=best+pizza+recipes&rlz=1C1JSBI_enUS1109US1109&oq=best+pi" +
                "&gs_lcrp=EgZjaHJvbWUqBggAEEUYOzIGCAAQRRg7MgYIARBFGDkyBwgCEAAYjwIyBwgDEAAYjwIyBwgEEAAYjwLSAQgxODIzajBqMagCALACAA&sourceid=chrome&ie=UTF-8";

        driver.get(pageUrl);

        // find the first search result title to check if any elements are found
        WebElement firstSearchResultTitle = findElement(driver, By.cssSelector(".hfac6d.LviCwe.tNxQIb.ynAwRc"));

        // if the first search result title is not found, scroll down and try again
        if (firstSearchResultTitle == null) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0, 250)");
            // Wait for some time for the page to scroll and load new content
            Thread.sleep(2000);

            // Try to find elements again after scrolling
            firstSearchResultTitle = findElement(driver, By.cssSelector(".hfac6d.LviCwe.tNxQIb.ynAwRc"));

            // If still not found, handle the situation accordingly
            if (firstSearchResultTitle == null) {
                System.out.println("No search results found even after scrolling.");
                driver.quit();
                return;
            }
        }

        // If the first search result title is found, proceed to find other elements
        WebElement firstSearchResultSource = driver.findElement(By.className("KuNgxf"));
        WebElement firstSearchResultRating = driver.findElement(By.cssSelector(".yi40Hd.YrbPuc"));
        WebElement firstSearchResultIngredients = driver.findElement(By.cssSelector(".LDr9cf.L5KuY.tbeioe.CqqFGf"));

        // create a search result object
        SearchResult firstResult = new SearchResult(
                firstSearchResultTitle.getText(),
                firstSearchResultSource.getText(),
                firstSearchResultRating.getText(),
                firstSearchResultIngredients.getText());

        searchResults.add(firstResult);

        for (SearchResult result : searchResults) {
            System.out.println("Title: " + result.getTitle());
            System.out.println("Source: " + result.getSource());
            System.out.println("Rating: " + result.getRating());
            System.out.println("Ingredients: " + result.getIngredients());
            System.out.println("-----------------------------");
        }

        // close driver and browsers
        driver.quit();

    }

    // Method to find element with retry
    private static WebElement findElement(@NotNull WebDriver driver, By by) {
        try {
            return driver.findElement(by);
        } catch (NoSuchElementException e) {
            return null;
        }
    }




}
