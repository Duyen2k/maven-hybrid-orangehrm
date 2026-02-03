package pageObjects.orangeHRM.editNavigation;

import org.openqa.selenium.WebDriver;

public class ContactDetailPagePageObject extends EditNavigatorPageObject {
    private WebDriver driver;

    public ContactDetailPagePageObject(WebDriver driver) {
        super(driver);  //driver nay cua B
        this.driver = driver;

        //Khi kế thừa từ 1 Class tự định nghĩa driver(B),
        //thì thằng A cũng cần được gán driver, do đó phải dùng super() tai A để lấy contructor của cha(thằng B)

    }





}
