package components;

import componentUIs.ButtonComponentUI;
import componentUIs.HeaderComponentUI;
import core.BaseComponent;
import org.openqa.selenium.WebDriver;

public class HeaderComponent extends BaseComponent {
    WebDriver driver;

    public HeaderComponent(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isHeaderTextDisplay(String headerName){
        waitElementVisible(driver, HeaderComponentUI.HEADER_NAME,headerName);
        return isElementDisplayed(driver,HeaderComponentUI.HEADER_NAME,headerName);
    }

}
