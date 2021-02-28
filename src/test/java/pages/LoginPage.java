package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
    public LoginPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy (id="edit-email")
    WebElement userName;
    @FindBy(id="edit-actions-submit")
    WebElement submitBtn;

    public String setUsername(String username){
        userName.sendKeys(username);
        return username;
    }

    public void clickSubmit() {
        submitBtn.click();

    }
}
