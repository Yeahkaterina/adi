package adi.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractionSteps;

import java.util.List;
import java.util.stream.Collectors;

public class HeaderBlock extends UIInteractionSteps {

    @FindBy(css = "input")
    private WebElementFacade inputField;

    @FindBy(className = "styles__item__sCSPm")
    private List<WebElementFacade> resultsLinks;

    @FindBy(className = "styles__locationName__2syw7")
    private List<WebElementFacade> locationLinks;

    @FindBy(css = "div.styles__root__2WsSe.styles__mini__1Yzgu a.styles__locationNameBadge__2kobg")
    public WebElementFacade weatherDataLink;

    public void searchForTheCity(String city) {
        inputField.type(city);
    }

    public void searchByAbbreviation(String city) {
        inputField.typeAndEnter(city);
    }

    public String getSelectedLocation() {
        return weatherDataLink.getTextContent();
    }

    public void selectCityFromTheDropdown(String city) {
        resultsLinks.stream().findAny().filter(element -> element.getTextContent()
                .contains(city)).get().click();
    }

    public List<String> getResultsFromDropdown() {
        return resultsLinks.stream().map(WebElementFacade::getTextContent)
                .collect(Collectors.toList());
    }

    public List<String> getLocations() {
        return locationLinks.stream().map(WebElementFacade::getTextContent)
                .collect(Collectors.toList());
    }
}
