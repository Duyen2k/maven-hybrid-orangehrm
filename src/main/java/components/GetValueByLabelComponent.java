package components;

import componentUIs.GetValueByLabelComponentUI;
import componentUIs.MessageComponentUI;
import core.BaseComponent;
import org.openqa.selenium.WebDriver;

public class GetValueByLabelComponent extends BaseComponent {
    WebDriver driver;

    public GetValueByLabelComponent(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getValueByLabel(String labelName){
        waitElementVisible(driver, GetValueByLabelComponentUI.VALUE_BY_LABEL,labelName);
        return getElementDOMProperty(driver,GetValueByLabelComponentUI.VALUE_BY_LABEL,"_value",labelName);
    }

    public String getElementTextByLabel(String labelName){
        return getElementText(driver,GetValueByLabelComponentUI.ATTRIBUTE_VALUE_BY_LABEL,labelName);
    }
}
