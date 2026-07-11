package pageObjects.orangeHRM.editNavigation;

import org.openqa.selenium.WebDriver;
import pageUIs.orangHRM.BasePageUI;

public class JobPageObject extends EditNavigatorPageObject {
    private WebDriver driver;

    public JobPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isJobDetailsHeaderDisplayed(String restParam) {
        waitElementVisible(driver,BasePageUI.MODULE_HEADER,restParam);
        return isElementDisplayed(driver,BasePageUI.MODULE_HEADER,restParam);
    }
}
