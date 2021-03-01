package stepdef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SignUpPage;

public class SignUpPageStepDef {
   private final SignUpPage loginPage=new SignUpPage();

    @Then ( "Click on Submit and Sign Up" )
    public void clickOnSubmitAndSignUp() {
      loginPage.clickSubmit();
    }


    @When ( "Enter <Username> as {string}" )
    public void enterUsernameAs(String arg0) {
      loginPage.setUsername(arg0);
    }


}
