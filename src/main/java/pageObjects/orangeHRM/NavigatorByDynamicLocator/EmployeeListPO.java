package pageObjects.orangeHRM.NavigatorByDynamicLocator;

import componentUIs.ButtonComponentUI;
import components.ButtonComponent;
import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageObjects.orangeHRM.AddEmployeePageObject;
import pageUIs.orangHRM.EmployeeListPageUI;

public class EmployeeListPO extends BasePage {
    private WebDriver driver;

    public EmployeeListPO(WebDriver driver) {
        this.driver = driver;
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

    public void openAddEmployeeTab(String tabName) {
        waitElementVisible(driver, ButtonComponentUI.PIM_TAB_BY_NAME,tabName);
        clickToElement(driver, ButtonComponentUI.PIM_TAB_BY_NAME,tabName);
    }
}
