package core;

import org.openqa.selenium.WebDriver;
import pageUIs.orangHRM.BaseComponentUI;

public class BaseComponent extends BasePage {
    WebDriver driver;

    public BaseComponent(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToTextboxByName(String valueToSend,String valueName){
        waitElementVisible(driver, BaseComponentUI.TEXTBOX_BY_NAME,valueName);
        sendkeyToElement(driver,BaseComponentUI.TEXTBOX_BY_NAME,valueToSend,valueName);
    }

    public void clickToAddDetailCheckbox(){
        waitElementVisible(driver,BaseComponentUI.CREATE_DETAIL_CHECKBOX);
        clickToElement(driver,BaseComponentUI.CREATE_DETAIL_CHECKBOX,"");
    }

    public void enterToTextboxByLabel(String valueToSend,String valueName){
        waitElementVisible(driver,BaseComponentUI.TEXTBOX_BY_LABEL,valueName);
        sendkeyToElement(driver,BaseComponentUI.TEXTBOX_BY_LABEL,valueToSend,valueName);
    }
}
