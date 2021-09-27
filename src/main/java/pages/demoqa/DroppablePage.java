package pages.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DroppablePage {

    private WebDriver driver;

    public DroppablePage(WebDriver driver) {
        this.driver = driver;
    }

    //    WebElement locators
    private By dragMeBox = By.id("draggable");
    private By dropHereBox = By.id("droppable");
    private By leftSideLinks = By.className("element-group");

    /**
     * Pick and drop "Drag me" box into the "Drop here" box
     */
    public void pickAndDropDragMeBox() {

        WebElement dragMe = driver.findElement(dragMeBox);
        WebElement dropMe = driver.findElements(dropHereBox).get(0);

        Actions actions = new Actions(driver);
        actions.moveToElement(dragMe).dragAndDrop(dragMe, dropMe).perform();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get text from "Drop here" box
     *
     * @return Text from "Drop here" box
     */
    public String getTexFromDropHereBox() {

        String text = driver.findElements(dropHereBox).get(0).getText();
        return text;
    }

    /**
     * Click Widgets section in left side menu
     */
    public void clickWidgets() {
        driver.findElements(leftSideLinks).get(3).click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Click ToolTips link in left side menu
     *
     * @return Tooltips page
     */
    public ToolTipsPage clickToolTips() {

        WebElement toolTips = driver.findElement(By.xpath("//li/span[text()='Tool Tips']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", toolTips);
        toolTips.click();

        return new ToolTipsPage(driver);
    }

}