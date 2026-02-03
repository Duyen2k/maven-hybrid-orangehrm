package pageObjects.orangeHRM;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageObjects.orangeHRM.editNavigation.PersonalDetailPageObject;
import pageUIs.orangHRM.AddEmployeePageUI;

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

    public PersonalDetailPageObject clickToSaveButton() {
        waitElementVisible(driver,AddEmployeePageUI.SAVE_BUTTON);
        clickToElement(driver,AddEmployeePageUI.SAVE_BUTTON);
        waitListElementInvisible(driver,AddEmployeePageUI.SPINER_ICON);
        return PageGenerator.getPage(PersonalDetailPageObject.class,driver);
    }
}
