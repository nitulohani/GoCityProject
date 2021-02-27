package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.fail;


public class DriverClass {

    private static WebDriver driver;


    public static WebDriver getDriver() {
        driver.get(ConfigReader.getProperty("URL"));
        driver.manage().window().maximize();
        return driver;
    }

    public void setup() {

        initiateDriver();
    }

    public void closeDriver() {

        driver.quit();
    }

    private WebDriver initiateDriver() {
        String browser = ConfigReader.getProperty("browser").toLowerCase();

        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", ConfigReader.getProperty("ChromePath"));
                driver = new ChromeDriver();
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;

            default:
                fail("Browser not supported");
        }

        return driver;

    }


}
