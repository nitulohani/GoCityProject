package frontendTest.pages;

import frontendTest.util.DriverClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BasePage {
    WebDriverWait wait;
    WebDriver driver;

    BasePage() {
        driver = DriverClass.getDriver();
        wait = new WebDriverWait(driver,30);
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

    public void assertElement(WebElement element){
        Boolean booleanCondition=element.isDisplayed();
        Assert.assertTrue(booleanCondition);

    }
    //select the dropdown using "select by visible text"
    public static void dropDownSelectByText(WebElement webElement, String VisibleText){
        Select selObj=new Select(webElement);
        selObj.selectByVisibleText(VisibleText);
    }

    //select the dropdown using "select by index"
    public static void dropDownSelectByIndex(WebElement webElement, int IndexValue){
        Select selObj=new Select(webElement);
        selObj.selectByIndex(IndexValue);
    }

    //select the dropdown using "select by value"
    public static void dropDownSelectByValue(WebElement webElement, String Value){
        Select selObj=new Select(webElement);
        selObj.selectByValue(Value);
    }


}
