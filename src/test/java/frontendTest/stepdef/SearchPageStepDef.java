package frontendTest.stepdef;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import frontendTest.pages.SearchPage;

public class SearchPageStepDef {
    private final SearchPage searchPage=new SearchPage();

    @Given ( "I am a non-registered customer" )
    public void iAmANonRegisteredCustomer() {

        searchPage.assertLogo();
    }

    @And ( "I navigate to www.ebay.co.uk" )
    public void iNavigateToWwwEbayCoUk() {
        searchPage.assertUrl();
    }

    @When ( "I search for an item" )
    public void iSearchForAnItem() {
        searchPage.searchItem();
    }

    @Then ( "I get a list of matching results" )
    public void iGetAListOfMatchingResults() {
        searchPage.getResults();
    }

    @And ( "the resulting items cards show: postage price, No of bids, price or show BuyItNow tag" )
    public void theResultingItemsCardsShowPostagePriceNoOfBidsPriceOrShowBuyItNowTag() {
          searchPage.getPostagePrice();
          //searchPage.getNoOfbids();
         // searchPage.getPrice();
         // searchPage.showBuyItnowTag();
    }

    @Then ( "I can sort the results by Lowest Price" )
    public void iCanSortTheResultsByLowestPrice() {
    }

    @And ( "the results are listed in the page in the correct order" )
    public void theResultsAreListedInThePageInTheCorrectOrder() {
    }

    @Then ( "I can sort the results by Highest Price" )
    public void iCanSortTheResultsByHighestPrice() {
    }

    @Then ( "I can filter the results by {string}" )
    public void iCanFilterTheResultsByBuyItNow() {
    }

    @And ( "all the results shown in the page have the {string} tag" )
    public void allTheResultsShownInThePageHaveTheBuyItNowTag() {
    }

    @When ( "I enter a search term and select a specific Category" )
    public void iEnterASearchTermAndSelectASpecificCategory() {
    }

    @And ( "I can verify that the results shown as per the the selected category" )
    public void iCanVerifyThatTheResultsShownAsPerTheTheSelectedCategory() {
    }

    @And ( "the results show more than one page" )
    public void theResultsShowMoreThanOnePage() {
    }


    @Then ( "the user can navigate through the pages to continue looking at the items" )
    public void theUserCanNavigateThroughThePagesToContinueLookingAtTheItems() {
    }
}
