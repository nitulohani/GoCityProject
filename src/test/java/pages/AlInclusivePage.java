package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class AlInclusivePage extends BasePage {
    @FindBy (xpath = "/html/body/div[2]/div/main/div/div/div/div[2]/div/div/section[1]/div/div/div/div/div/div/div[1]/div/select")
    WebElement dropdown;
    @FindBy(xpath="/html/body/div[2]/div/main/div/div/div/div[2]/div/div/section[1]/div/div/div/div/div/div/div[1]/div/select")
    WebElement cartIncrease;
   /* @FindBy(linkText = "Checkout")
    WebElement checkOut;*/
    @FindBy(xpath="//*[@id=\"block-secondarylinks\"]/div/div/div/div/div/div[2]")
    WebElement cartCount;
    @FindBy(xpath="/html/body/div[2]/div/header/div/div/div[1]/a")
    WebElement logo;
    @FindBy(tagName = "a")
    WebElement headerLinks;

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

      //checkOut.click();
  }
    public void waitForPageToLoad() {

       waitForPageToLoad(dropdown);
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

    public void verifyLogo() {
        Boolean logoPresent = logo.isDisplayed();
        Assert.assertTrue(logoPresent);
    }

    public void verifyLinks() {
        List<WebElement> links=driver.findElements(By.tagName("a"));

        System.out.println("Total links are "+links.size());

        for(int i=0;i<links.size();i++)
        {

            WebElement ele= links.get(i);

            String url=ele.getAttribute("href");

            verifyLinkActive(url);

        }
    }

    private static void verifyLinkActive(String linkUrl) {
        try
        {
            URL url = new URL(linkUrl);

            HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();

            httpURLConnect.setConnectTimeout(3000);

            httpURLConnect.connect();

            if(httpURLConnect.getResponseCode()==200)
            {
                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
            }
            if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)
            {
                System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
            }
        } catch (Exception e) {

        }
    }
}
