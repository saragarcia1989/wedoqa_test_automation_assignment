package pages.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//This class represents the main page of google

public class GooglePage {

    private WebDriver driver;

    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }

    //    WebElement locators
    private By searchBar = By.name("q");

    /**
     * This method is to search in google and wait 2 seconds for the site to show the results
     *
     * @param wordToSearch Introduce the string you want to search
     * @return Page with the results
     */

    public GoogleResultsPage searchInGoogle(String wordToSearch) {
        acceptCookies();
        driver.findElement(searchBar).click();
        driver.findElement(searchBar).sendKeys(wordToSearch);
        driver.findElement(searchBar).submit();
        // Wait for google page to load the results
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new GoogleResultsPage(driver);
    }

    /**
     * Accept cookies if the acceptance window for cookies shows up
     */
    private void acceptCookies() {
        boolean acceptCookiesButton = driver.findElement(By.cssSelector(("button[id = 'L2AGLb']"))).isDisplayed();
        if (acceptCookiesButton == true) {
            driver.findElement(By.cssSelector(("button[id = 'L2AGLb']"))).click();
        }
    }
}
