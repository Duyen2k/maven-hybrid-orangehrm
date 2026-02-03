package pageObjects;

import core.BasePage;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Constructor;

public class PageGenerator {

    //Dùng hàm này thì ko cần khai báo và khởi tạo nhiều page

    //Note: T là biến pagePage(T:biến đại diên của Page) có thể đặt tên khác- dùng cho tất cả các class(Page)
    public static <T extends BasePage> T getPage(Class<T> pageClass, WebDriver driver) {
        try {
        //Lấy constructor nhận Webdriver
            Constructor<T> constructor = pageClass.getConstructor(WebDriver.class);
        //Tạo instance mới của page class
            return constructor.newInstance(driver);
        } catch (Exception e) {
            throw new RuntimeException("Can not init Page Object Class:" + pageClass.getSimpleName(), e);
        }
    }
}
