package adi.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;


@DefaultUrl("https://weather.com")
public class WeatherHomePage extends PageObject {
    private HeaderBlock headerBlock;
    private SearchResultsBlock searchResultsBlock;
    private NowCardContainerBlock nowCardContainerBlock;

    public HeaderBlock getHeaderBlock() {
        return headerBlock;
    }

    public SearchResultsBlock getSearchResultsBlock() {
        return searchResultsBlock;
    }

    public NowCardContainerBlock getNowCardContainerBlock(){
        return nowCardContainerBlock;
    }

    @WhenPageOpens
    public void waitLocationAppears() {
        headerBlock.weatherDataLink.waitUntilVisible();
    }
}
