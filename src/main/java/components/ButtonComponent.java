package components;

import componentUIs.ButtonComponentUI;
import core.BaseComponent;
import org.openqa.selenium.WebDriver;
import pageUIs.orangHRM.BaseComponentUI;

public class ButtonComponent extends BaseComponent {
    WebDriver driver;

    public ButtonComponent(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickToButtonByName(String valueName){
        waitElementClickable(driver, ButtonComponentUI.BUTTON_BY_NAME,valueName);
        clickToElement(driver, ButtonComponentUI.BUTTON_BY_NAME,valueName);
    }

    public void clickToButtonByText(String headerName,String buttonText){
        waitElementClickable(driver,ButtonComponentUI.BUTTON_BY_TEXT,headerName,buttonText);
        clickToElement(driver,ButtonComponentUI.BUTTON_BY_TEXT,headerName,buttonText);
        waitListElementInvisible(driver, BaseComponentUI.SPINER_ICON);
    }

    public void clickToAddButtonByText(String headerName,String buttonName){
        waitElementClickable(driver,ButtonComponentUI.BUTTON_ADD_BY_TEXT,headerName,buttonName);
        clickToElement(driver,ButtonComponentUI.BUTTON_ADD_BY_TEXT,headerName,buttonName);
    }

    public void clickToUploadButtonByText(String titleName,String buttonText){
        waitElementClickable(driver,ButtonComponentUI.BUTTON_UPLOAD_FILE,titleName,buttonText);
        clickToElement(driver,ButtonComponentUI.BUTTON_UPLOAD_FILE,titleName,buttonText);
    }

}
