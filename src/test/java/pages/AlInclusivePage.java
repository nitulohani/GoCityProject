package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AlInclusivePage extends BasePage {
    @FindBy (xpath = "/html/body/div[2]/div/main/div/div/div/div[2]/div/div/section[1]/div/div/div/div/div/div/div[1]/div/select")
    WebElement dropdown;
    @FindBy(xpath="/html/body/div[2]/div/main/div/div/div/div[2]/div/div/section[1]/div/div/div/div/div/div/div[2]/div[1]/div/div[1]/div[3]/div[2]/div/div[3]")
    WebElement cartIncrease;
    @FindBy(linkText = "Checkout")
    WebElement checkOut;
    @FindBy(xpath="//*[@id=\"block-secondarylinks\"]/div/div/div/div/div/div[2]/div/div/div")
    WebElement cartCount;

   public AlInclusivePage(){

    PageFactory.initElements(driver,this);
}

  public void selectPassType(int passType){
      Select drpPassType = new Select(dropdown);
      drpPassType.selectByIndex(0);
  }

  public void selectPassenger(){

       cartIncrease.click();
  }

  public void checkOut()
  {
    checkOut.click();
  }
    public void waitForPageToLoad() {
        waitForPageToLoad(checkOut);
    }

    public void assertUrl()
    {
        String currentUrl=driver.getCurrentUrl();
        String expectedUrl="https://gocity.com/boston/en-us/products/all-inclusive";
        Assert.assertEquals(currentUrl,expectedUrl);

    }

   public WebElement getCartCount(){
      cartCount.getText();
      return cartCount;
}

}
