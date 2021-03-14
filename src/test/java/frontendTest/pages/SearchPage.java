package frontendTest.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.List;

public class SearchPage extends BasePage {

    private static final long TIME_TO_WAIT = 30;

    public SearchPage(){

        PageFactory.initElements(driver,this);
    }
    private static Logger logger = LoggerFactory.getLogger(BasePage.class);
    @FindBy (id="gh-la")
    WebElement logo;
    @FindBy(id="gh-ac")
    WebElement inputSearch;
    @FindBy(id="gh-btn")
    WebElement submitBtn;
    @FindBy(xpath="//*[@id=\"srp-river-results\"]")
    List<WebElement> resultsPage;
    @FindBy(id="gh-cat")
    WebElement categoryFilter;
    @FindBy(xpath="//*[@id=\"srp-river-results\"]/ul/li[1]/div/div[2]/div[5]/div[3]")
    List<WebElement> postagePricelist;
    @FindBy(css="#nid-QLH-2 > button")
    WebElement menuFilter;
    @FindBy(xpath="//*[@id=\"srp-river-results\"]/ul/li[1]/div/div[2]/div[5]/div[3]")
    WebElement postagePrice;
    @FindBy(xpath="//*[@id=\"srp-river-results\"]/ul/li[5]/div/div[2]/div[6]/div[4]")
    WebElement noOfBids;

    public void assertUrl() {
        String currentUrl=driver.getCurrentUrl();
        String expectedUrl="https://www.ebay.co.uk/";
        Assert.assertEquals(currentUrl,expectedUrl);
    }

    public void assertLogo() {
        assertElement(logo);
    }


    public void searchItem(String product,String category) {
        inputSearch.sendKeys(product);
        Select categorySelect=new Select(categoryFilter);
        categorySelect.selectByVisibleText(category);
        submitBtn.click();
    }

    public void searchItem(String product)
    {
        inputSearch.sendKeys(product);
        submitBtn.click();
    }

    public void getResults() {
        Iterator<WebElement> iteratorAllProducts=resultsPage.iterator();
        while(iteratorAllProducts.hasNext()){
            WebElement product=iteratorAllProducts.next();
         logger.debug(product.getText());
         logger.debug("--------------------------------------------------");
        }
    }
    public void assertPostagePrice() {

    }
    public void assertNoOfbids() {

        assertElement(noOfBids);
    }
    public void assertshowBuyItnowTag() {
    }

    public void assertPrice() {
    }

    public void sortPriceLowest() {

    }

    public void sortPriceHighest() {
    }

    public void verifyPagination() {
        new WebDriverWait(
                driver, TIME_TO_WAIT).until(
                ExpectedConditions.presenceOfElementLocated(
                        By.tagName("a")));
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        for (int i = 0; i < elements.size(); i++) {
            String title = elements.get(i).getAttribute("title");
            if (title.equals("Next Page")) {
                elements.get(i).click();
                break;
            }
        }
    }


    public void verifyNavigation() {
        Actions actions = new Actions(driver);
        // Scroll Down using Actions class
        actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
        driver.navigate().forward();


    }
}
