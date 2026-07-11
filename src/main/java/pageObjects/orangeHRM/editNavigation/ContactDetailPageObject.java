package pageObjects.orangeHRM.editNavigation;

import org.openqa.selenium.WebDriver;
import pageUIs.orangHRM.BasePageUI;

public class ContactDetailPageObject extends EditNavigatorPageObject {
    private WebDriver driver;

    public ContactDetailPageObject(WebDriver driver) {
        super(driver);  //driver nay cua B
        this.driver = driver;

        //Khi kế thừa từ 1 Class tự định nghĩa driver(B),
        //thì thằng A cũng cần được gán driver, do đó phải dùng super() tai A để lấy contructor của cha(thằng B)

    }


    public boolean isContactDetailsHeaderDisplayed(String restParam) {
        waitElementVisible(driver, BasePageUI.MODULE_HEADER,restParam);
        return isElementDisplayed(driver, BasePageUI.MODULE_HEADER,restParam);
    }
}
