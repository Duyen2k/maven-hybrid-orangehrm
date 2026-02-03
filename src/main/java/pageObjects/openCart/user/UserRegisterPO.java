package pageObjects.openCart.user;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.openCart.user.UserRegisterPageUI;

public class UserRegisterPO extends BasePage {
    WebDriver driver;

    public UserRegisterPO(WebDriver driver) {
        this.driver = driver;
    }


    public void enterToFirstNameAtUserSite(String firstname) {
        waitElementVisible(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX);
        sendkeyToElement(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX, firstname);
    }

    public void enterToLastNameAtUserSite(String lastname) {
        waitElementVisible(driver, UserRegisterPageUI.LASTNAME_TEXTBOX);
        sendkeyToElement(driver, UserRegisterPageUI.LASTNAME_TEXTBOX, lastname);
    }

    public void enterToEmailAtUserSite(String email) {
        waitElementVisible(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
        sendkeyToElement(driver, UserRegisterPageUI.EMAIL_TEXTBOX, email);
    }

    public void enterToPasswordAtUserSite(String password) {
        waitElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXTBOX, password);
    }

    public void acceptPrivacyCheckbox() {
        waitElementVisible(driver, UserRegisterPageUI.AGREE_CHECKBOX);
        clickToElement(driver, UserRegisterPageUI.AGREE_CHECKBOX);
    }

    public void clickContinueButtonToLogin() {
        waitElementVisible(driver, UserRegisterPageUI.CONTINUE_BUTTON);
        clickToElement(driver, UserRegisterPageUI.CONTINUE_BUTTON);
    }

    public boolean isSuccessMessageDisplayed() {
        sleepInSecond(5);
        waitElementVisible(driver,UserRegisterPageUI.SUCCESS_MESSAGE);
        return isElementDisplayed(driver,UserRegisterPageUI.SUCCESS_MESSAGE );
    }

}
