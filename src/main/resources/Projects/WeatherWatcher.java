package main.resources.Projects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.ArrayList;
import java.util.List;

public class WeatherWatcher {
    static class WeatherData {
        private final String currentTemperature;
        private final String weatherAlert;
        private final String visibility;
        private final String windSpeed;
        private final String humidity;

        // Constructor
        public WeatherData(String currentTemperature, String weatherAlert, String visibility, String windSpeed, String humidity) {
            this.currentTemperature = currentTemperature;
            this.weatherAlert = weatherAlert;
            this.visibility = visibility;
            this.windSpeed = windSpeed;
            this.humidity = humidity;
        }

        // Getter methods
        public String getCurrentTemperature() { return currentTemperature; }
        public String getWeatherAlert() { return weatherAlert; }
        public String getVisibility() { return visibility; }
        public String getWindSpeed() { return windSpeed; }
        public String getHumidity() { return humidity; }
    }

    public static void main(String[] args) {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\carlo\\OneDrive\\Documents\\EDGE_WEBDRIVERS\\msedgedriver_126.0.2592.68.exe");
        WebDriver driver = new EdgeDriver();

        try {
            // find website
            driver.get("https://weather.com/weather/today");

            List<WeatherData> weatherList = new ArrayList<>();

            // locate by needed attributes
            WebElement currentTempElement = driver.findElement(By.className("CurrentConditions--tempValue--MHmYY"));
            WebElement weatherAlertElement = driver.findElement(By.className("AlertHeadline--alertText--38xov"));
            WebElement windSpeedElement = driver.findElement(By.cssSelector("span[class='Wind--windWrapper--3Ly7c undefined'] span:nth-child(2)"));
            WebElement visibilityElement = driver.findElement(By.xpath("//span[@data-testid='VisibilityValue']"));
            WebElement humidityElement = driver.findElement(By.cssSelector("span[data-testid='PercentageValue']"));

            // extract text from elements
            String currentTemp = currentTempElement != null ? currentTempElement.getText() : "N/A";
            String weatherAlert = weatherAlertElement != null ? weatherAlertElement.getText() : "N/A";
            String windSpeed = windSpeedElement != null ? windSpeedElement.getText() : "N/A";
            String visibility = visibilityElement != null ? visibilityElement.getText() : "N/A";
            String humidity = humidityElement != null ? humidityElement.getText() : "N/A";

            // create a search result object
            WeatherData todaysWeatherData = new WeatherData(currentTemp, weatherAlert, visibility, windSpeed, humidity);

            weatherList.add(todaysWeatherData);

            for (WeatherData weatherData : weatherList) {
                System.out.println("-----------------------------");
                System.out.println("Current Temp. : " + weatherData.getCurrentTemperature());
                System.out.println("Weather Alert : " + weatherData.getWeatherAlert());
                System.out.println("Wind Speed : " + weatherData.getWindSpeed() + " mph");
                System.out.println("Humidity : " + weatherData.getHumidity());
                System.out.println("Visibility : " + weatherData.getVisibility());
                System.out.println("-----------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
