package adi.steps;

import adi.pages.WeatherHomePage;
import net.thucydides.core.annotations.Step;

public class SearchSteps {

    private WeatherHomePage weatherHomePage;

    @Step("Search for the city by name")
    public void searchFor(String city) {
        weatherHomePage.getHeaderBlock().searchForTheCity(city);
    }

    @Step("Search for the city by abbreviation")
    public void searchByAbbreviation(String city) {
        weatherHomePage.getHeaderBlock().searchByAbbreviation(city);
    }

    @Step("Select city from the dropdown")
    public void selectCityFromDropdown(String city) {
        weatherHomePage.getHeaderBlock().selectCityFromTheDropdown(city);
    }
}
