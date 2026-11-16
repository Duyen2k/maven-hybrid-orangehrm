package componentUIs;

import javax.xml.xpath.XPath;

public class ButtonComponentUI {
    public static final String BUTTON_BY_NAME="XPATH=//button[contains(text(),%s)]";
    public static final String HIDDEN_MENU_ICON="CSS=div.oxd-main-menu-search>button";
    public static final String BUTTON_BY_TEXT="XPath=//h6[text()='%s']/parent::div//div[@class='oxd-form-actions']//button[text()=' %s ']";
    public static final String BUTTON_ADD_BY_TEXT="XPATH=//h6[text()='%s']/parent::div//i[contains(text(),%s)]";
    public static final String BUTTON_UPLOAD_FILE="xpath=//label[text()='%s']/parent::div/following-sibling::div//div[text()='%s']";

}
