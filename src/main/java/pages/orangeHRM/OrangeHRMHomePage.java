package pages.orangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeHRMHomePage {

    private WebDriver driver;

    public OrangeHRMHomePage(WebDriver driver) {
        this.driver = driver;
    }

    //WebElement locators
    private By recruitment = By.xpath("//li[contains(@id, 'left_menu_item_15')]");
    private By candidates = By.id("menu_recruitment_viewCandidates");

    /**
     * Go and open recruitment section in side left panel
     */
    public CandidatesPage clickOnRecruitment() {
        driver.findElement(recruitment).click();
        // Wait for the page to load
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new CandidatesPage(driver);
    }

    public void clickRecruitmentButton() {
    }

    /**
     * Click on Candidates section
     *
     * @return Candidates page
     */
    public CandidatesPage clickCandidates() {
        driver.findElement(candidates).click();
        // Wait for candidates page to load
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new CandidatesPage(driver);
    }

}
