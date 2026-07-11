package pageObjects.orangeHRM.NavigatorByDynamicLocator;

import componentUIs.TextboxComponentUI;
import core.BaseComponent;
import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageObjects.orangeHRM.EmployeeListPageObject;
import pageUIs.orangHRM.DashboardPageUI;

public class DashboardPO extends BaseComponent {
    private WebDriver driver;

    public DashboardPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public EmployeeListPO clickToPIMModule() {
        waitElementVisible(driver, DashboardPageUI.PIM_MODULE);
        clickToElement(driver,DashboardPageUI.PIM_MODULE);
        return PageGenerator.getPage(EmployeeListPO.class,driver);
    }

    public boolean isDashboardHeaderDisplayed(WebDriver driver) {
        waitElementVisible(driver, DashboardPageUI.DASHBOARD_HEADER);
        return isElementDisplayed(driver, DashboardPageUI.DASHBOARD_HEADER);
    }


    public void openModuleByText(String moduleName) {
        waitElementVisible(driver, TextboxComponentUI.MODULE_BY_TEXT,moduleName);
        clickToElement(driver, TextboxComponentUI.MODULE_BY_TEXT,moduleName);
    }
}
