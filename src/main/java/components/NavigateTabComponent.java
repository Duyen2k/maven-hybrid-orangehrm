package components;

import componentUIs.ButtonComponentUI;
import componentUIs.NavigateTabComponentUI;
import core.BaseComponent;
import org.openqa.selenium.WebDriver;

public class NavigateTabComponent extends BaseComponent {
    WebDriver driver;

    public NavigateTabComponent(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickToNavigateMenuByText(String valueName){
        waitElementClickable(driver, NavigateTabComponentUI.NAV_TAB_BY_NAME,valueName);
        clickToElement(driver, NavigateTabComponentUI.NAV_TAB_BY_NAME,valueName);
    }

}
