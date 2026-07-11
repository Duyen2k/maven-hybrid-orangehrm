package pageUIs.orangHRM;

public class BaseComponentUI {

    public static final String TEXTBOX_BY_NAME="xpath=//input[@name='%s']";
    public static final String TEXTBOX_BY_LABEL="xpath=//label[text()='%s']/parent::div/following-sibling::div/input";
    public static final String CREATE_DETAIL_CHECKBOX="xpath=//span[contains(@class,'oxd-switch-input')]";
    public static final String SUB_MENU="xpath=//div[@class='orangehrm-tabs-wrapper']/a[text()='%s']";
}
