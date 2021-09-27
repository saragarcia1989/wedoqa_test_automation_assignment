package pages.demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToolTipsPage {

    private WebDriver driver;

    public ToolTipsPage(WebDriver driver) {
        this.driver = driver;
    }

    //    WebElement locators
    private By hoverMeToSeeButton = By.id("toolTipButton");
    private By toolTip = By.cssSelector("div[class = 'tooltip-inner']");

    /**
     * Move cursor to "Hover me to see" button
     */
    public void moveToHoverMeToSeeButton() {

        WebElement hoverButton = driver.findElement(hoverMeToSeeButton);
        Actions actions = new Actions(driver);
        actions.moveToElement(hoverButton).perform();
    }

    /**
     * Get tooltip text
     *
     * @return Tooltip text
     */
    public String getToolTipText() {

        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOfElementLocated(toolTip));

        String toolTipText = driver.findElement(toolTip).getText();

        return toolTipText;
    }
}
