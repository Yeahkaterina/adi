package adi.steps;

import adi.pages.WeatherHomePage;
import net.thucydides.core.annotations.Step;

public class NavigationSteps {

    private WeatherHomePage weatherHomePage;

    @Step("Open the Weather.com home page")
    public void openWeatherHomePage() {
        weatherHomePage.open();
    }
}
