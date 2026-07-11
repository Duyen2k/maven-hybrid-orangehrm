package pageObjects.orangeHRM.NavigatorByDynamicLocator;

import components.ButtonComponent;
import components.TextboxComponent;
import core.BaseComponent;
import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageObjects.orangeHRM.DashboardPageObject;
import pageUIs.orangHRM.LoginPageUI;

public class LoginPO extends BaseComponent {
    private WebDriver driver;
    private TextboxComponent textboxComponent;
    private ButtonComponent buttonComponent;

    public LoginPO(WebDriver driver){
        super(driver);
        this.driver=driver;
        textboxComponent = new TextboxComponent(this.driver);
        buttonComponent = new ButtonComponent(this.driver);

    }

    public void enterToUsernameTextbox(String username) {
        //Ráp Action + UI với nhau
        waitElementVisible(driver,LoginPageUI.USER_NAME_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.USER_NAME_TEXTBOX,username);
    }

    public void enterToPasswordTextbox(String password) {
        waitElementVisible(driver,LoginPageUI.USER_NAME_PASSWORD);
        sendkeyToElement(driver, LoginPageUI.USER_NAME_PASSWORD,password);
    }

    public DashboardPO clickToLoginButton() {
        waitElementVisible(driver,LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver,LoginPageUI.LOGIN_BUTTON,"");
        return PageGenerator.getPage(DashboardPO.class,driver);
    }

    public void loginToApplication(String adminUsername, String adminPassword) {
        textboxComponent.enterToTextboxByName(adminUsername,"username");
        textboxComponent.enterToTextboxByName(adminPassword,"password");
        buttonComponent.clickToButtonByText("Login");
        //return PageGenerator.getPage(DashboardPO.class,driver);
        //khoi tao luon tren man hinh nen dung them wait vi luc load Dashboard no lau, ma minh dang doi load Dashboard
        //tu step login, nen khi khoi tao doc lap Dashboard luc no hung duoc tu login, luc ko
    }
}
