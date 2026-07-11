package pageObjects.jQuery;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.jQuery.UploadPageUI;

public class UploadPO extends BasePage {
    private WebDriver driver;

    public UploadPO(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isFileLoadedSuccess(String fileName) {
        waitElementVisible(driver, UploadPageUI.LOADED_FILE_NAME,fileName);
        return isElementDisplayed(driver,UploadPageUI.LOADED_FILE_NAME,fileName);
    }

    public void clickStartbutton() {
        waitElementVisible(driver,UploadPageUI.START_UPLOAD_BUTTON);
        clickToElement(driver,UploadPageUI.START_UPLOAD_BUTTON);
    }

    public boolean isFileUploadedSuccess(String fileName) {
        waitElementVisible(driver, UploadPageUI.UPLOADED_FILE_NAME,fileName);
        return isElementDisplayed(driver,UploadPageUI.UPLOADED_FILE_NAME,fileName);
    }
}
