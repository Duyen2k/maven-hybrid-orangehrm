package pageObjects.orangeHRM.NavigatorByDynamicLocator;

import componentUIs.HeaderComponentUI;
import componentUIs.LeftModuleComponentUI;
import core.BaseComponent;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
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
        waitElementVisible(driver, LeftModuleComponentUI.LEFT_MODULE_BY_NAME,moduleName);
        clickToElement(driver, LeftModuleComponentUI.LEFT_MODULE_BY_NAME,moduleName);
    }

    //LiveCode-Component Pattern:OrangeHRM
    public boolean isDashboardHeaderTextDisplayed(WebDriver driver) {
        waitElementVisible(driver, HeaderComponentUI.HEADER_NAME,"Dashboard");
        return isElementDisplayed(driver, HeaderComponentUI.HEADER_NAME,"Dashboard");
    }

    public EmployeeListPO openPIMModule() {
        waitElementVisible(driver,LeftModuleComponentUI.LEFT_MODULE_BY_NAME,"PIM");
        clickToElement(driver,LeftModuleComponentUI.LEFT_MODULE_BY_NAME,"PIM");
        isLoadingIconDisappear(driver);
        return PageGenerator.getPage(EmployeeListPO.class,driver);
    }


}
