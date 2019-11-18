package adi.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractionSteps;

public class NowCardContainerBlock extends UIInteractionSteps {

    @FindBy(css = "h1.h4.today_nowcard-location")
    private WebElementFacade location;

    public String getNowCardLocation(){
        return location.getTextContent();
    }
}
