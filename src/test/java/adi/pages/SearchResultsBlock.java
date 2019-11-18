package adi.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultsBlock extends UIInteractionSteps {

    @FindBy(css = "ul.styles__resultsList__2-Km4 li a")
    private List<WebElementFacade> results;

    public List<String> getResults() {
        return results.stream().map(WebElementFacade::getTextContent)
                .collect(Collectors.toList());
    }

    public void selectLocation(String location) {
        getResults().forEach(res -> {
            if(res.equalsIgnoreCase(location)){
                find(By.linkText(location)).click();
            }
        });
    }
}
