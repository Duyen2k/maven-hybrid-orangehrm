package ex_pageObject;

import core.BasePage;
import ex_pageUIs.DashboardPageUIs_Ex;
import org.openqa.selenium.WebDriver;

public class DashboardPageObject_Ex extends BasePage {

    private WebDriver driver;

    public DashboardPageObject_Ex(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToAdminButton(WebDriver driver) {
        clickToElement(driver, DashboardPageUIs_Ex.ADMIN_BUTTON);
    }
}
