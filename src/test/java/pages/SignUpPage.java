package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends BasePage{
    public SignUpPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy (id="edit-email")
    WebElement userName;
    @FindBy(id="edit-actions-submit")
    WebElement submitBtn;
    @FindBy(css="#edit-container--WiQ1-Zjf-M8 > div.form-item.js-form-item.form-type-email.js-form-type-email.form-item-email.js-form-item-email.form-no-label.form-group.error.has-error > div")
    WebElement errorMsg;

    public String setUsername(String username){
        userName.sendKeys(username);
        return username;
    }

    public void clickSubmit() {
        submitBtn.click();

    }

    public void verifyError() {
        Boolean errorMsgPresent=errorMsg.isDisplayed();
         Assert.assertTrue(errorMsgPresent);

    }
}
