package pageUIs.orangHRM;

public class BaseComponentUI {

    public static final String TEXTBOX_BY_NAME="xpath=//input[@name='%s']";
    public static final String TEXTBOX_BY_LABEL="xpath=//label[text()='%s']/parent::div/following-sibling::div/input";
    public static final String CREATE_DETAIL_CHECKBOX="xpath=//span[contains(@class,'oxd-switch-input')]";
    public static final String SUB_MENU="xpath=//div[@class='orangehrm-tabs-wrapper']/a[text()='%s']";
    public static final String AVATAR_IMG="CSS=div.orangehrm-edit-employee-image";
    public static final String SPINER_ICON = "xpath= //div[@class='oxd-form-loader']";
    public static final String LOADING_SPINER ="XPATH=//div[@class='oxd-loading-spinner']";
}
