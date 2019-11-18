package adi.stepdefenitions;

import adi.steps.NavigationSteps;
import adi.steps.SearchResultsSteps;
import adi.steps.SearchSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class SearchWeatherStepDefinition {

    @Steps
    private NavigationSteps navigationSteps;

    @Steps
    private SearchSteps searchSteps;

    @Steps
    private SearchResultsSteps searchResultsSteps;

    @Given("I am on Weather.com home page")
    public void iAmOnWeatherComHomePage() {
        navigationSteps.openWeatherHomePage();
    }

    @When("^I search the weather forecast for city by name(.*)$")
    public void iSearchTheWeatherForecastForCity(String city) {
        searchSteps.searchFor(city);
    }

    @When("^I search the weather forecast for city by abbreviation(.*)$")
    public void iSearchTheWeatherForecastForCityBy(String abbreviation) {
        searchSteps.searchByAbbreviation(abbreviation);
    }

    @And("^I select the city (.*) from the dropdown$")
    public void iSelectTheCityFromTheDropdown(String city) {
        searchSteps.selectCityFromDropdown(city);
    }

    @Then("^I see the weather forecast for city (.*)$")
    public void iSeeTheWeatherForecastForCity(String city) {
        Assert.assertTrue(String.format("%s city should be selected in header", city), searchResultsSteps.getSelectedCity()
                .contains(city));
        Assert.assertTrue(String.format("%s city should be selected", city), searchResultsSteps.getNowCardSelectedCity()
                .contains(city));
    }

    @Then("^I see the list of cities with abbreviation (.*)$")
    public void iSeeTheListOfCitiesWithAbbreviationAbbreviation(String city) {
        Assert.assertTrue("All results should contains abbreviation", searchResultsSteps.getResults().stream()
                .anyMatch(s -> s.contains(city)));
    }

    @When("^I select the city by (.*)$")
    public void iSelectTheCityByLocation(String location) {
        searchResultsSteps.selectCityFromList(location);
    }

    @Then("^I see the error message (.*)$")
    public void iSeeTheErrorMessage(String error) {
        Assert.assertTrue("Error message should be displayed", searchResultsSteps.getResultsFromDropdown()
                .contains(error));
    }

    @And("I see selected cities in saved locations bar")
    public void iSeeSelectedCitiesInSavedLocationsBar(List<String> locations) {
        Assert.assertEquals("Locations should be saved", locations.stream().sorted().collect(Collectors.toList()),
                searchResultsSteps.getSavedLocations());
    }
}
