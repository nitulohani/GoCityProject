package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.DriverClass;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BasePage {
    WebDriverWait wait;
    WebDriver driver;

    BasePage() {
        driver = DriverClass.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void waitForPageToLoad(WebElement element) {

        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForPageToLoad(By identifier) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(identifier)));
    }

    public void waitForPageToload(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void click(WebElement element) {

        element.click();
    }

    public void setValueToElement(WebElement element, String message) {

        element.sendKeys(message);
    }

}
