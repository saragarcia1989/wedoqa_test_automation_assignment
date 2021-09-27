package base;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.orangeHRM.OrangeHRMLogInPage;

public class SetOrangeHRM {

    private WebDriver driver;
    protected OrangeHRMLogInPage OrangeHRMLogInPage;

    /**
     * Set up OrangeHRM demo website
     */
    public void setUpOrangeHRM() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://orangehrm-demo-7x.orangehrmlive.com/");
        OrangeHRMLogInPage = new OrangeHRMLogInPage(driver);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
