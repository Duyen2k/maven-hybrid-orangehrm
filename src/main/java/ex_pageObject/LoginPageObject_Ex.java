package ex_pageObject;

import core.BasePage;
import core.BaseTest;
import ex_pageUIs.LoginPageUIs_Ex;
import org.openqa.selenium.WebDriver;

public class LoginPageObject_Ex extends BasePage {
    private WebDriver driver;

    public LoginPageObject_Ex(WebDriver driver) {
        this.driver = driver;
    }

    public void enterToUserNameTextbox(String username) {
        waitElementVisible(driver, LoginPageUIs_Ex.USER_NAME_TEXTBOX);
        sendkeyToElement(driver, LoginPageUIs_Ex.USER_NAME_TEXTBOX,username);
    }

    public void enterToPasswordTextbox(String password) {
        waitElementVisible(driver, LoginPageUIs_Ex.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, LoginPageUIs_Ex.PASSWORD_TEXTBOX,password);
    }

    public void clickToLoginButton() {
        waitElementVisible(driver, LoginPageUIs_Ex.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUIs_Ex.LOGIN_BUTTON);
    }
}
