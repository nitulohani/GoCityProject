package stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AlInclusivePage;

public class AllInclusiveStepDef {
    private final AlInclusivePage allinclPage = new AlInclusivePage();

    @Given ( "I am on Home Page" )
    public void iAmOnHomePage() {
        System.out.println("I am on Home Page");
        //allinclPage.waitForPageToLoad();
        allinclPage.assertUrl();
    }

    @When ( "I select Pass Option" )
    public void iSelectPassOption() {
        allinclPage.selectPassType(0);
    }

    @And ( "I select no.of passengers" )
    public void iSelectNoOfPassengers() {
        allinclPage.selectPassenger();
    }


    @Then ( "Verify Same amount gets added to the cart" )
    public void verifySameAmountGetsAddedToTheCart() {
        allinclPage.getCartCount();
    }

    @Then ( "Verify logo on Home Page" )
    public void verifyLogoOnHomePage() {
       allinclPage.verifyLogo();
    }



    @Then ( "Verify Broken Links on Home Page" )
    public void verifyBrokenLinksOnHomePage() {
        allinclPage.verifyLinks();
    }
}
