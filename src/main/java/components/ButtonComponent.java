package components;

import componentUIs.ButtonComponentUI;
import componentUIs.TextboxComponentUI;
import core.BaseComponent;
import org.openqa.selenium.WebDriver;

public class ButtonComponent extends BaseComponent {
    WebDriver driver;

    public ButtonComponent(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickToButtonByText(String valueName){
        waitElementVisible(driver, ButtonComponentUI.BUTTON_BY_NAME,valueName);
        clickToElement(driver, ButtonComponentUI.BUTTON_BY_NAME,valueName);
    }
}
