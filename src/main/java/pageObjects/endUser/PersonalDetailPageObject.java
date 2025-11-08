package pageObjects.endUser;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.PersonalDetailPageUI;

public class PersonalDetailPageObject extends BasePage {
    private WebDriver driver;

    public PersonalDetailPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public String getFirstnameTextboxValue(){
        waitElementVisible(driver, PersonalDetailPageUI.FIRSTNAME_TEXTBOX);
        return getElementDOMProperty(driver,PersonalDetailPageUI.FIRSTNAME_TEXTBOX,"value");
    }

    public String getLasttnameTextboxValue(){
        waitElementVisible(driver, PersonalDetailPageUI.LASTNAME_TEXTBOX);
        return getElementDOMProperty(driver,PersonalDetailPageUI.LASTNAME_TEXTBOX,"value");
    }

    public String getEmployeeIDTextboxValue(){
        waitElementVisible(driver, PersonalDetailPageUI.EMPLOYEE_ID_TEXTBOX);
        return getElementDOMProperty(driver,PersonalDetailPageUI.EMPLOYEE_ID_TEXTBOX,"value");
    }
}
