package pageObjects.orangeHRM.editNavigation;

import org.openqa.selenium.WebDriver;

public class PersonalDetailPageObject extends EditNavigatorPageObject {
    private WebDriver driver;

    public PersonalDetailPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

//    public String getFirstnameTextboxValue(){
//        waitElementVisible(driver, PersonalDetailPageUI.FIRSTNAME_TEXTBOX);
//        return getElementDOMProperty(driver,PersonalDetailPageUI.FIRSTNAME_TEXTBOX,"value");
//    }
//
//    public String getLastnameTextboxValue(){
//        waitElementVisible(driver, PersonalDetailPageUI.LASTNAME_TEXTBOX);
//        return getElementDOMProperty(driver,PersonalDetailPageUI.LASTNAME_TEXTBOX,"value");
//    }
//
//    public String getEmployeeIDTextboxValue(){
//        waitElementVisible(driver, PersonalDetailPageUI.EMPLOYEE_ID_TEXTBOX);
//        return getElementDOMProperty(driver,PersonalDetailPageUI.EMPLOYEE_ID_TEXTBOX,"value");
//    }
//
//    public ContactDetailPagePageObject openPersonalDetailPage() {
//        waitElementVisible(driver,PersonalDetailPageUI.CONTACT_DETAIL_MODULE);
//        clickToElement(driver,PersonalDetailPageUI.CONTACT_DETAIL_MODULE);
//        return PageGeneratorGeneric.getPage(ContactDetailPagePageObject.class,driver) ;
//    }



}
