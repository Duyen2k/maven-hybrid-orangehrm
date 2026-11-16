package components;

import componentUIs.ValidationMessageUI;
import core.BaseComponent;
import org.openqa.selenium.WebDriver;

public class ValidationMessageComponent extends BaseComponent {
    WebDriver driver;
    private String UploadfilePath= System.getProperty("user.dir")+"\\uploadFiles";


    public ValidationMessageComponent(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public boolean isErrorMessageByHeaderDisplay(String headerName, String errorMsg){
        waitElementVisible(driver, ValidationMessageUI.ERROR_MESSAGE_BY_HEADER,headerName,errorMsg);
        return isElementDisplayed(driver, ValidationMessageUI.ERROR_MESSAGE_BY_HEADER,headerName,errorMsg);
    }

    public boolean isErrorMessageByLabelDisplay(String labelName,String errorMsg){
        waitElementVisible(driver,ValidationMessageUI.ERROR_MESSAGE_BY_LABEL,labelName,errorMsg);
        return isElementDisplayed(driver,ValidationMessageUI.ERROR_MESSAGE_BY_LABEL,labelName,errorMsg);
    }

}
