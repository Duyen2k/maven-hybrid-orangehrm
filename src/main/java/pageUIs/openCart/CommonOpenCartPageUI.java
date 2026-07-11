package pageUIs.openCart;

public class CommonOpenCartPageUI {
    public static final String MY_ACCOUNT_MODULE="xpath=//nav[@id='top']//span[text()='%s']";
//    public static final String MY_ACCOUNT_MODULE="//div[@class='dropdown']//span[text()='My Account']";
    public static final String LIST_MODULE="xpath=//span[text()='My Account']/parent::a/following-sibling::ul/li";
//    public static final String MY_ACCOUNT_AT_FOOTER="//a[text()='My Account']";
//    public static final String LOGOUT_LINK="//div[@class='dropdown']//a[text()='Logout']";
    public static final String LOGOUT_LINK="xpath=//a[@class='dropdown-item' and text()='%s']";
//    public static final String LOGOUT_LINK="//li/a[text()='Logout']";
    public static final String CONTINUE_BUTTON="xpath=//a[text()='Continue']";
    public static final String ADMIN_LOGOUT_BUTTON="xpath=//span[text()='%s']";

}
