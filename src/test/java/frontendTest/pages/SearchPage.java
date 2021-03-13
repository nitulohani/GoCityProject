package frontendTest.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.List;

public class SearchPage extends BasePage {

    public SearchPage(){

        PageFactory.initElements(driver,this);
    }
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
            System.out.println(product.getText());
            System.out.println("--------------------------------------------------");
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
    }



}
