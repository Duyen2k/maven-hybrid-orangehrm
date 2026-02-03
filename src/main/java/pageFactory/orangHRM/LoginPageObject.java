package pageFactory.orangHRM;

import core.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject extends BasePageFactory {
    private WebDriver driver;


    //Define các locator/element
    @FindBy(how = How.CSS,using = "input[name='username']")
    private WebElement usernameTextbox;

    @FindBy(name = "password")
    private WebElement passwordTextbox;

    @FindBy(xpath = "//button[contains(@class,orangehrm-login-button)]")
    private WebElement loginButton;

    //Init(khởi tạo các element-kết nối hàm private kia với element)
    public LoginPageObject(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);  //Trong contructor luôn có dòng code này
    }

    //Đoạn trên là pageFactory- Đoạn dưới là dùng pageObjectFactory
    public void enterToUsernameTextbox(String username) {
        waitElementVisible(driver,usernameTextbox);
        sendkeyToElement(driver,usernameTextbox,username);
    }

    public void enterToPasswordTextbox(String password) {
        waitElementVisible(driver,passwordTextbox);
        sendkeyToElement(driver,passwordTextbox,password);
    }

    public void clickToLoginButton() {
        waitElementVisible(driver,loginButton);
        clickToElement(driver,loginButton);
    }
}
