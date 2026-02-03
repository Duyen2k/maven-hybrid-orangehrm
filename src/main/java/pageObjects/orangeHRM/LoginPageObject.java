package pageObjects.orangeHRM;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.orangHRM.LoginPageUI;

public class LoginPageObject extends BasePage {
    private WebDriver driver;

    //Hàm khởi tạo (Constructor Method)
    //Map driver từ Test Class qua bên Page Object class
    public LoginPageObject(WebDriver driver){

        //Trong trường hợp 2 biến cùng tên, 1 biến là Global-1 biến là local
        //Nếu ko dùng từ khóa this thì nó ưu tiên biến local
        this.driver=driver;
    }

    //Sẽ được chạy đầu tiên khi class này được gọi tới
    //Nếu không viết hàm khởi tạo thì trình biên dịch nó sẽ tạo cho class này 1 hàm khởi tạo rỗng(built-in)
    //Nếu viết thì nó sẽ dùng hàm do mình define(user define)
    //Cùng tên với class chứa nó
    //Không có giá trị trả về
    //Có 1 hoặc nhiều tham số/ có 1 hoặc nhiều hàm khởi tạo
    //Thể hiện tính chất đa hình trong OOP
    
    public void enterToUsernameTextbox(String username) {
        //Ráp Action + UI với nhau
        waitElementVisible(driver,LoginPageUI.USER_NAME_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.USER_NAME_TEXTBOX,username);
    }

    public void enterToPasswordTextbox(String password) {
        waitElementVisible(driver,LoginPageUI.USER_NAME_PASSWORD);
        sendkeyToElement(driver, LoginPageUI.USER_NAME_PASSWORD,password);
    }

    public DashboardPageObject clickToLoginButton() {
        waitElementVisible(driver,LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver,LoginPageUI.LOGIN_BUTTON);
        return PageGenerator.getPage(DashboardPageObject.class,driver);
    }
}
