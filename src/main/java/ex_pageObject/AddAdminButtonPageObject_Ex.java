package ex_pageObject;

import core.BasePage;
import ex_pageUIs.AddAdminButtonUIs_Ex;
import org.openqa.selenium.WebDriver;

public class AddAdminButtonPageObject_Ex extends BasePage {

    private WebDriver driver;

    public AddAdminButtonPageObject_Ex(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToAddButton() {
        waitElementVisible(driver,AddAdminButtonUIs_Ex.ADD_BUTTON);
        clickToElement(driver,AddAdminButtonUIs_Ex.ADD_BUTTON);

    }

    public void enterConfirmPassword(String confirmPassword) {
        waitElementVisible(driver,AddAdminButtonUIs_Ex.CONFIRM_PASSWORD);
        sendkeyToElement(driver,AddAdminButtonUIs_Ex.CONFIRM_PASSWORD,confirmPassword);
    }

    public void enterUserName(String userName) {
        waitElementVisible(driver,AddAdminButtonUIs_Ex.USERNAME);
        sendkeyToElement(driver,AddAdminButtonUIs_Ex.USERNAME,userName);
    }

    public void enterEmployeeName() {
        waitElementVisible(driver,AddAdminButtonUIs_Ex.EMPLOYEE_NAME);
        sendkeyToElement(driver,AddAdminButtonUIs_Ex.EMPLOYEE_NAME,"John Doe");
        clickToElement(driver,AddAdminButtonUIs_Ex.EMPLoYEE_NAME_INPUT);
    }

    public void enterPassword(String password) {
        waitElementVisible(driver,AddAdminButtonUIs_Ex.PASSWORD);
        sendkeyToElement(driver,AddAdminButtonUIs_Ex.PASSWORD,password);
    }

    public void enterStatus(String status) {
        waitElementVisible(driver,AddAdminButtonUIs_Ex.STATUS_PARENT);
        selectItemInDropdownCustome(driver,AddAdminButtonUIs_Ex.STATUS_PARENT,AddAdminButtonUIs_Ex.STATUS_CHILDREN,"Enabled");
    }

    public void enterUserRole()  {
        waitElementVisible(driver,AddAdminButtonUIs_Ex.USER_ROLE_PARENT);
        selectItemInDropdownCustome(driver,AddAdminButtonUIs_Ex.USER_ROLE_PARENT,AddAdminButtonUIs_Ex.USER_ROLE_CHILDREN,"Admin");
    }

    public void clickToSaveButton() {
        waitElementVisible(driver,AddAdminButtonUIs_Ex.SUBMIT_BUTTON);
        clickToElement(driver,AddAdminButtonUIs_Ex.SUBMIT_BUTTON);
    }
}
