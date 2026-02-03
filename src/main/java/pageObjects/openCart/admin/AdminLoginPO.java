package pageObjects.openCart.admin;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.openCart.admin.AdminLoginPageUI;

public class AdminLoginPO extends BasePage {
    WebDriver driver;

    public AdminLoginPO (WebDriver driver) {
        this.driver = driver;
    }

    public void enterToUserNameAtAdminSite(String adminUsername) {
        waitElementVisible(driver, AdminLoginPageUI.USERNAME_TEXTBOX);
        sendkeyToElement(driver, AdminLoginPageUI.USERNAME_TEXTBOX,adminUsername);
    }

    public void enterToPasswordAtAdminSite(String adminPassword) {
        waitElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX,adminPassword);
    }

    public void clickToLoginButtonAtAdminSite() {
        waitElementClickable(driver,AdminLoginPageUI.lOGIN_BUTTON);
        clickToElement(driver,AdminLoginPageUI.lOGIN_BUTTON);
        sleepInSecond(5);
//        return PageGenerator.getPage(AdminDashboardPO.class,driver);
    }
}
