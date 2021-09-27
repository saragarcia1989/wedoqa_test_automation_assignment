package pages.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DemoqaPage {

    private WebDriver driver;

    public DemoqaPage(WebDriver driver) {
        this.driver = driver;
    }

    //    WebElement locators
    private By mainPageInteractions = By.cssSelector("div[class*='card mt-4 top-card']");

    /**
     * This method is used to check if we are in the right website
     *
     * @return URL from the page
     */
    public String getUrl() {

        String url = driver.getCurrentUrl();

        return url;
    }

    /**
     * Go to Interactions section
     */
    public void clickInteractions() {
        driver.findElements(mainPageInteractions).get(4).click();
    }

    /**
     * Click Droppable section
     *
     * @return Droppable page
     */
    public DroppablePage clickDroppable() {
        WebElement droppable = driver.findElement(By.xpath("//li/span[text()='Droppable']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", droppable);
        droppable.click();
        return new DroppablePage(driver);
    }
}



