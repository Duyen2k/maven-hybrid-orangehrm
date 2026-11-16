package pageObjects.orangeHRM.NavigatorByDynamicLocator;

import components.HeaderComponent;
import components.LeftMenuComponent;
import components.NavigateTabComponent;
import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.orangHRM.EmployeeListPageUI;

public class EmployeeListPO extends BasePage {
    private WebDriver driver;
    private LeftMenuComponent leftMenuComponent;
    private NavigateTabComponent navigateTabComponent;
    private HeaderComponent headerComponent;

    public EmployeeListPO(WebDriver driver) {

        this.driver = driver;
        leftMenuComponent=new LeftMenuComponent(driver);
        navigateTabComponent=new NavigateTabComponent(driver);
        headerComponent=new HeaderComponent(driver);
    }

    public AddEmployeePO clickToAddEmployeeButton() {
        waitElementClickable(driver, EmployeeListPageUI.ADD_EMPLOYEE_BUTTON,"");
        clickToElement(driver,EmployeeListPageUI.ADD_EMPLOYEE_BUTTON,"");
        return PageGenerator.getPage(AddEmployeePO.class,driver);
    }

    public boolean isPIMHeaderDisplayed(WebDriver driver) {
        waitElementVisible(driver,EmployeeListPageUI.PIM_HEADER,"");
        return isElementDisplayed(driver,EmployeeListPageUI.PIM_HEADER,"");
    }

    public void openAddEmployeeTab(String valueName) {
//        waitElementVisible(driver, NavigateTabComponentUI.NAV_TAB_BY_NAME,tabName);
//        clickToElement(driver, NavigateTabComponentUI.NAV_TAB_BY_NAME,tabName);
        leftMenuComponent.clickToLeftMenuByText("PIM");
    }

    //LiveCode-Component Pattern:OrangeHRM
    public boolean isPIMHeaderTextDisplayed(WebDriver driver) {
//        waitElementVisible(driver, HeaderComponentUI.HEADER_NAME,"PIM");
//        return isElementDisplayed(driver, HeaderComponentUI.HEADER_NAME,"PIM");
       return headerComponent.isHeaderTextDisplay("PIM");
    }

    public AddEmployeePO openAddEmployeeNavTab() {
//        waitElementVisible(driver, NavigateTabComponentUI.NAV_TAB_BY_NAME,"Add Employee");
//        clickToElement(driver, NavigateTabComponentUI.NAV_TAB_BY_NAME,"Add Employee");
//        isLoadingIconDisappear(driver);
        navigateTabComponent.clickToNavigateMenuByText("Add Employee");
        return PageGenerator.getPage(AddEmployeePO.class,driver);
    }

    public ContactDetailPO openContactDetailsPage(){
        leftMenuComponent.clickToLeftMenuOfListEmployee("Contact Details");
        return PageGenerator.getPage(ContactDetailPO.class,driver);
    }

    public EmergencyDetailsPO openEmergencyDetailsPage(){
        leftMenuComponent.clickToLeftMenuOfListEmployeeAndLoaingSpiner("Emergency Contacts");
        return PageGenerator.getPage(EmergencyDetailsPO.class,driver);
    }

}
