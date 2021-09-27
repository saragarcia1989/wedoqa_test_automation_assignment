package pages.orangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeHRMLogInPage {

    private WebDriver driver;

    public OrangeHRMLogInPage(WebDriver driver) {
        this.driver = driver;
    }

    //WebElement locators
    private By logInButton = By.cssSelector("input[class='btn btn-success']");

    /**
     * Click on login OrangeHRM
     *
     * @return It returns OrangeHRM homepage
     */
    public OrangeHRMHomePage logIn() {
        driver.findElement(logInButton).click();

        // Wait for OrangeHRM page to load
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new OrangeHRMHomePage(driver);
    }
}
