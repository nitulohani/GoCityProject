package stepdef;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.LoginPage;

import java.util.List;

public class LoginPageStepDef {
   private final LoginPage loginPage=new LoginPage();

    @Then ( "Click on Submit and Sign Up" )
    public void clickOnSubmitAndSignUp() {
      loginPage.clickSubmit();
    }


    @When ( "Enter <Username> as {string}" )
    public void enterUsernameAs(String arg0) {
      loginPage.setUsername(arg0);
    }
}
