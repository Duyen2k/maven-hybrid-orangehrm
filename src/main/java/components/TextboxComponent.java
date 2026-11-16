package components;

import componentUIs.TextboxComponentUI;
import core.BaseComponent;
import org.openqa.selenium.WebDriver;

public class TextboxComponent extends BaseComponent {
    WebDriver driver;

    public TextboxComponent(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void enterToTextboxByName(WebDriver driver,String valueToSend, String valueName){
        waitElementVisible(driver, TextboxComponentUI.TEXTBOX_BY_NAME,valueName);
        sendkeyToElement(driver,TextboxComponentUI.TEXTBOX_BY_NAME,valueToSend,valueName);
    }

    public void enterToTextboxByLabel(String valueToSend, String valueName){
        waitElementVisible(driver,TextboxComponentUI.TEXTBOX_BY_LABEL,valueName);
        sendkeyToElement(driver,TextboxComponentUI.TEXTBOX_BY_LABEL,valueToSend,valueName);
    }


}
