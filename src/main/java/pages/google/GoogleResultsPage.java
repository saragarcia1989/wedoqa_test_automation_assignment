package pages.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.demoqa.DemoqaPage;

import java.util.List;

public class GoogleResultsPage {

    private WebDriver driver;

    public GoogleResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    //    WebElement locators
    private By links = By.tagName("h3");
    private By googleResults = By.xpath("//div[contains(@id, 'result-stats')]");

    /**
     * Clicking the first result in order to go to Demoqa.com
     *
     * @return Demoqa website
     */
    public DemoqaPage goToDemoqa() {
        List<WebElement> allLinks = driver.findElements(links);
        allLinks.get(0).click();
        return new DemoqaPage(driver);
    }

    /**
     * Get number of results found by Google
     *
     * @return an integer with the number of results
     */
    public long getNumberOfResults() {

        String results = driver.findElement(this.googleResults).getText();
//        Get only the numeric characters
        String numbers = results.replaceAll("[^0-9]", "");
//        Remove the last three numeric characters which correspond to the time to find the results
        String newResults = numbers.substring(0, numbers.length() - 3);
//        Convert the String into integer
        long longResults = Long.parseLong(newResults);

        return longResults;
    }
}
