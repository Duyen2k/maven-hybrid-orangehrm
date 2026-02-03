package pageObjects.openCart.admin;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.openCart.admin.AdminDashboardPageUI;

public class AdminDashboardPO extends BasePage {
    WebDriver driver;

    public AdminDashboardPO(WebDriver driver) {
        this.driver = driver;
    }

    public AdminCustomerPO openCustomerPageAtAdminSite() {
        waitElementClickable(driver, AdminDashboardPageUI.CUSTOMER_MENU);
        clickToElement(driver, AdminDashboardPageUI.CUSTOMER_MENU);
        clickToElement(driver, AdminDashboardPageUI.CUSTOMER_MODULE);
        return PageGenerator.getPage(AdminCustomerPO.class,driver);
    }
}
