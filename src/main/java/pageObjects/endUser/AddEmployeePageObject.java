package pageObjects.endUser;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.AddEmployeePageUI;

public class AddEmployeePageObject extends BasePage {
    private WebDriver driver;

    public AddEmployeePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToFirstnameTextbox(String firstname) {
        waitElementClickable(driver, AddEmployeePageUI.FIRSTNAME_TEXTBOX);
        sendkeyToElement(driver,AddEmployeePageUI.FIRSTNAME_TEXTBOX,firstname);
    }

    public void enterToLastnameTextbox(String lastname) {
        waitElementClickable(driver,AddEmployeePageUI.LASTNAME_TEXTBOX);
        sendkeyToElement(driver,AddEmployeePageUI.LASTNAME_TEXTBOX,lastname);
    }

    public String getEmployeeID() {
        waitElementVisible(driver,AddEmployeePageUI.EMPLOYEE_ID_TEXTBOX);
        return getElementDOMProperty(driver,AddEmployeePageUI.EMPLOYEE_ID_TEXTBOX,"value");
    }

    public void clickToSaveButton() {
        waitElementVisible(driver,AddEmployeePageUI.SAVE_BUTTON);
        clickToElement(driver,AddEmployeePageUI.SAVE_BUTTON);
    }
}
