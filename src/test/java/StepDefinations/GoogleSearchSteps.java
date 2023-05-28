package StepDefinations;

import PageObjects.GoogleSearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class GoogleSearchSteps  {
    public GoogleSearchPage googleSearchPage =new GoogleSearchPage();

    @And("User open {string} search engine")
    public void userOpenGoogleSearchEngine(String arg0) {
        googleSearchPage.openURL(arg0);

    }

    @When("User enters {string} in search text box")
    public void userEntersInSearchTextBox(String arg0) {

        googleSearchPage.enterSearchItem(arg0);
    }

    @Then("Verify first search result on the page is {string}")
    public void verifyFirstSearchResultOnThePageIs(String arg0) {
    String st =googleSearchPage.getFirstResultName();
        Assert.assertEquals(st,arg0);
    }
}
