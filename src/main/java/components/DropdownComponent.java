package components;

import componentUIs.DropdownComponentUI;
import core.BaseComponent;
import org.openqa.selenium.WebDriver;

public class DropdownComponent extends BaseComponent {
    WebDriver driver;
    private String UploadfilePath= System.getProperty("user.dir")+"\\uploadFiles";


    public DropdownComponent(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

//    public void uploadAvatarImage(){
//        waitElementVisible(driver, UploadComponentUI.AVATAR_IMG_DEFAULT);
//        sendkeyToElement(driver, UploadComponentUI.UPLOAD_AVATAR,UploadfilePath+LemonName);
//    }
    public void selectItemInCustomDropdown(String textItem,String labelName){
        waitElementClickable(driver,DropdownComponentUI.DROPDOWN_ICON,labelName);
        selectItemInDropdownCustome(driver, DropdownComponentUI.DROPDOWN_ICON,DropdownComponentUI.DROPDOWN_LIST_BY_LABEL,textItem,labelName);
    }

}
