package org.campuscoffee.steps;
import io.cucumber.java.ParameterType;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.Before;
import jdk.javadoc.doclet.Taglet;
import org.campuscoffee.CoffeStore;
import org.campuscoffee.Search;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SearchSteps {
    Search search = new Search();
    CoffeStore output;
    CoffeStore input;
    @ParameterType("true|false")
    public Boolean booleanValue(String value) {
        return Boolean.parseBoolean(value);
    }

    @Before
    public void before() {
         search = new Search();
         output = null;
         input= null;
     }

    @Given("there are no registered CoffeShops")
    public void there_are_no_registered_CoffeShops() {
        search.clearStores();
        assertTrue(search.getAllStores().isEmpty());
    }
    @When("a CoffeShop with Name {string},Location {string} and returnpoint {booleanValue} and {string} Price {int} is added to the System")
    public void add_store_with_price(final String name, final String location, final boolean reuse, final String coffetype, final int price) {
        CoffeStore cs = new CoffeStore(name, org.campuscoffee.Location.valueOf(location.toUpperCase()),reuse);
        cs.setPrice(coffetype, price);
        input=cs;
        search.addStore(cs);
    }
    @When("the price for {string} gets compared for {string} and {string}")
    public void comparePrices(final String coffetype, final String name1, final String name2) {
        output = search.compareByPrice(name1,name2,coffetype);
    }
    @Then("the System should show {string} as the one with cheaper coffee")
    public void checkOutput(final String storeName) {
        assertEquals(output.getName(), storeName);
    }
    @Then ("the CoffeeShop with Name {string}, Location {string} and returnpoint {booleanValue} should appear")
    public void  checkInput(final String storeName, final String location, boolean inside ){assertEquals(input.getName(),storeName);
  assertTrue(search.getAllStores().stream().anyMatch(store->store.getName().equals(storeName)&&store.getLocation().equals(location.valueOf(location.toUpperCase())))&&store.getReturnPoint());
    }

    @And("it should be with the only one")
    public void itShouldBeWithTheOnlyOne() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();//assertEquals(1,search.getAllStore().Size())
    }



    //...
}
