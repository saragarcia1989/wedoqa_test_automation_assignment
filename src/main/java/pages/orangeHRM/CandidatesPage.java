package pages.orangeHRM;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CandidatesPage {

    private WebDriver driver;

    public CandidatesPage(WebDriver driver) {
        this.driver = driver;
    }

    //    WebElement locators
    private String candidatesIframeId = "noncoreIframe";
    private By candidatesNumber = By.cssSelector("div[class='count-container active'] > div > span");
    private By addButton = By.cssSelector("button[tooltip='Add Candidate']");
    private By candidateCheckBox = By.cssSelector("div[class='oxd-checkbox-wrapper']");
    private By logOutButton = By.id("navbar-logout");

    /**
     * @return Total number of candidates
     */
    public int getNumberOfCandidates() {
        String candidates = driver.findElement(candidatesNumber).getText();
        return Integer.parseInt(candidates);
    }

    /**
     * Click add button
     */
    public void clickAddButton() {
        driver.findElement(addButton).click();
//        Wait for Add Candidate modal to show up
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param firstName        Introduce String with first name
     * @param lastName         Introduce String with second name
     * @param email            Introduce String with email
     * @param pathOfResumeFile Introduce String with the absolute path of the file
     */

    public void addCandidate(String firstName, String lastName, String email, String pathOfResumeFile) {

//        Add candidate first name
        driver.findElement(By.id("addCandidateForm_firstName")).sendKeys(firstName);
//        Add candidate last name
        driver.findElement(By.id("addCandidateForm_lastName")).sendKeys(lastName);
//        Add candidate email
        driver.findElement(By.id("addCandidateForm_email")).sendKeys(email);
//        Upload file with resume
        driver.findElement(By.id("addCandidateForm_file")).sendKeys(pathOfResumeFile);
//        Click save button
        driver.findElement(By.cssSelector("button[class='oxd-button oxd-button--medium oxd-button--secondary'")).click();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param candidatePosition Takes the position of the candidate in the list being 0 the first element
     */
    public void selectCandidate(int candidatePosition) {

//        List with all checkboxes
        List<WebElement> boxes = driver.findElements(candidateCheckBox);
        boxes.get(candidatePosition).click();
    }

    /**
     * Click on delete button
     */
    public void deleteCandidate() {

        driver.findElement(By.cssSelector("button[class='oxd-button oxd-button--medium oxd-button--label-danger with-icon'")).click();
        new WebDriverWait(driver, 2).until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector("button[class='oxd-button oxd-button--medium oxd-button--label-feedback-danger with-icon orangehrm-button-margin'"))).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Click on logout button
     */
    public void logOut() {
        driver.findElement(logOutButton).click();
    }
}

