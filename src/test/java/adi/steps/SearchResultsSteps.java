package adi.steps;

import adi.pages.WeatherHomePage;
import net.thucydides.core.annotations.Step;

import java.util.List;

public class SearchResultsSteps {

    private WeatherHomePage weatherHomePage;

    @Step("Get results")
    public List<String> getResults() {
        return weatherHomePage.getSearchResultsBlock().getResults();
    }

    @Step("Get selected city in header")
    public String getSelectedCity() {
        return weatherHomePage.getHeaderBlock().getSelectedLocation();
    }

    @Step("Get selected city")
    public String getNowCardSelectedCity() {
        return weatherHomePage.getNowCardContainerBlock().getNowCardLocation();
    }

    @Step("Select city from dropdown list")
    public void selectCityFromList(String location) {
        weatherHomePage.getSearchResultsBlock().selectLocation(location);
    }

    @Step("Get results from dropdown list")
    public List<String> getResultsFromDropdown() {
        return weatherHomePage.getHeaderBlock().getResultsFromDropdown();
    }

    @Step("Get saved locations")
    public List<String> getSavedLocations() {
        return weatherHomePage.getHeaderBlock().getLocations();
    }
}
