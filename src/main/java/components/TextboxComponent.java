package components;

import componentUIs.TextboxComponentUI;
import core.BaseComponent;
import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.orangHRM.BaseComponentUI;

public class TextboxComponent extends BaseComponent {
    WebDriver driver;

    public TextboxComponent(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void enterToTextboxByName(String valueToSend, String valueName){
        waitElementVisible(driver, TextboxComponentUI.TEXTBOX_BY_NAME,valueName);
        sendkeyToElement(driver,TextboxComponentUI.TEXTBOX_BY_NAME,valueToSend,valueName);
    }

    public void enterToTextboxByLabel(String valueToSend,String valueName){
        waitElementVisible(driver,TextboxComponentUI.TEXTBOX_BY_LABEL,valueName);
        sendkeyToElement(driver,TextboxComponentUI.TEXTBOX_BY_LABEL,valueToSend,valueName);
    }


}
