package base;

import com.google.common.io.Files;
import org.junit.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.google.GooglePage;

import java.io.File;
import java.io.IOException;

public class SetGoogleWebSite {

    private WebDriver driver;
    protected GooglePage googlePage;


    /**
     * Set up Google website
     */
    public void setUpGoogle() {
//        The default browser is chrome
        String browser = System.getProperty("browser", "chrome");

//        Set it up with chromedriver
        if (browser.equalsIgnoreCase("chrome")) {

            System.out.println("chrome");
            System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.google.com/");
            googlePage = new GooglePage(driver);

//        Set it up with firefox
        } else if (browser.equalsIgnoreCase("firefox")) {

            System.out.println("firefox");

            System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
            driver = new FirefoxDriver();
            driver.get("https://www.google.com/");
            driver.manage().window().maximize();
            googlePage = new GooglePage(driver);

        }
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    /**
     * Take screenshot
     */
    public void takeScreenshot() {
        TakesScreenshot camera = (TakesScreenshot) driver;
//      This will save this screenshot as a file in resources directory
        File screenshot = camera.getScreenshotAs(OutputType.FILE);
        try {
            Files.move(screenshot, new File("resources/screenshots/test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
