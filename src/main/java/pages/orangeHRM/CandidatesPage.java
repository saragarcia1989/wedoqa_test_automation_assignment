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
    private By candidatesNumber = By.cssSelector("div#fromToOf > div");
    private By addButton = By.id("addItemBtn");
    private By candidateCheckBox = By.cssSelector("td.material-checkbox > label");
    private By threeDotsButton = By.id("ohrmList_Menu");
    private By sideMenu = By.id("user-dropdown");
    private By logOutButton = By.cssSelector("a[id = 'logoutLink']");

    /**
     * Need to change the frame in order to interact with the elements on the page
     */
    public void switchToCandidatesFrame() {
        driver.switchTo().frame(candidatesIframeId);
    }

    /**
     * @return Integer with total number of candidates
     */
    public int getNumberOfCandidates() {

        WebElement candidatesElement = driver.findElement(candidatesNumber);
//        Scroll to find the number of candidates
        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor) driver).executeScript(script, candidatesElement);
//        Get the last characters from the String corresponding to the number of candidates
        String candidates = driver.findElement(candidatesNumber).getText().substring(10);
//        Turn the String with the number of candidate into an integer
        int numberOfCandidates = Integer.valueOf(candidates);

        return numberOfCandidates;
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
     * @param vacancy          Introduce integer with the position of the desired vacancy in the list, being 1 the first element
     */

    public void addCandidate(String firstName, String lastName, String email, String pathOfResumeFile, int vacancy) {

//        Add candidate first name
        driver.findElement(By.cssSelector("input[id = 'addCandidate_firstName']")).sendKeys(firstName);
//        Add candidate last name
        driver.findElement(By.cssSelector("input[id = 'addCandidate_lastName']")).sendKeys(lastName);
//        Add candidate email
        driver.findElement(By.cssSelector("input[id = 'addCandidate_email']")).sendKeys(email);
//        Upload file with resume
        driver.findElement(By.id("addCandidate_resume")).sendKeys(pathOfResumeFile);
//        Click on vacancy section
        driver.findElement(By.id("textarea_addCandidate_vacancy")).click();
//        Scroll down to find the dropdown with the vacancies
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                driver.findElement(By.cssSelector("ul[class = 'dropdown-content dropdownObjectSearch active']")));
//        Scroll down until find the desired vacancy and select it
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                driver.findElement(By.cssSelector("li[class = 'searchSingleObjectLi not-selected']:nth-child(" + vacancy + ")")));
//        Click save button
        driver.findElement(By.id("saveCandidateButton")).click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    /**
     * @param candidatePosition Takes the position of the candidate in the list being 0 the first element
     */
    public void selectCandidate(int candidatePosition) {

//        List with all checkboxes
        List<WebElement> boxes = driver.findElements(candidateCheckBox);

//        Scroll to the top of the page
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        Click in the checkbox chosen
        boxes.get(candidatePosition).click();
    }

    /**
     * Click on the three dots button in the left upper side
     */
    public void openCandidateOptions() {
        driver.findElement(threeDotsButton).click();
    }

    /**
     * Click on delete button
     */
    public void deleteCandidate() {

        driver.findElement(By.id("deleteItemBtn")).click();
        new WebDriverWait(driver, 2).until(ExpectedConditions
                .visibilityOfElementLocated(By.id("candidate-delete-button"))).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Open the side menu
     */
    public void displaySideMenu() {

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
        driver.findElement(sideMenu).click();

    }

    /**
     * Click on logout button
     */
    public void logOut() {
        driver.findElement(logOutButton).click();
    }
}

