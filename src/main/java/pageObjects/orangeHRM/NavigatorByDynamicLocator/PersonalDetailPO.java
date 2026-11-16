package pageObjects.orangeHRM.NavigatorByDynamicLocator;

import componentUIs.DropdownComponentUI;
import componentUIs.TextboxComponentUI;
import components.*;
import dataTest.json.PersonInfo;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.PageGenerator;
import pageUIs.BaseUI;
import pageUIs.orangHRM.BaseComponentUI;

import java.util.List;

public class PersonalDetailPO extends NavigatorPageByDynamicLocator{

    WebDriver driver;
    private ToastMessageComponent toastMessageComponent;
    private GetValueByLabelComponent getValueByLabelComponent;
    private DropdownComponent uploadComponent;
    private ButtonComponent buttonComponent;
    private ValidationMessageComponent validationMessageComponent;
    private DropdownComponent dropdownComponent;
    private LeftMenuComponent leftMenuComponent;

    public PersonalDetailPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
        toastMessageComponent = new ToastMessageComponent(driver);
        getValueByLabelComponent=new GetValueByLabelComponent(driver);
        uploadComponent=new DropdownComponent(driver);
        buttonComponent=new ButtonComponent(driver);
        validationMessageComponent=new ValidationMessageComponent(driver);
        dropdownComponent=new DropdownComponent(driver);
        leftMenuComponent=new LeftMenuComponent(driver);
    }

    public boolean isSuccessfulSavedMsgDisplay(){
       return toastMessageComponent.isToastMsgDisplay("Successfully Saved");
    }


    public String getEmployeeIdAtDetailPage(){
        return getValueByLabelComponent.getValueByLabel("Employee Id");
    }

    private void clickToAvatarImg(){
        waitElementVisible(driver, BaseComponentUI.AVATAR_IMG);
        clickToElement(driver,BaseComponentUI.AVATAR_IMG);
    }

    //pattern-object
    public void uploadAvatar(String imgName){
        clickToAvatarImg();
        waitElementPresence(driver, BaseUI.UPLOAD_FILE_TYPE);
        uploadMultipleFiles(driver,imgName);
        buttonComponent.clickToButtonByText("Change Profile Picture","Save");
    }

    public boolean isSuccessfulUpdatedMsgDisplay(){
        return toastMessageComponent.isToastMsgDisplay("Successfully Updated");
    }
    public boolean isInvalidTypeMsgDisplay(){
        return validationMessageComponent.isErrorMessageByHeaderDisplay("Change Profile Picture","File type not allowed");
    };

    public void selectNationalityValue(){
        waitElementClickable(driver, DropdownComponentUI.DROPDOWN_ICON,"Nationality");
        dropdownComponent.selectItemInCustomDropdown("Austrian","Nationality");
        Assert.assertEquals(getValueByLabelComponent.getElementTextByLabel("Nationality"),"Austrian");
    }

    public void selectMaritalStatusValue(){
        waitElementClickable(driver, DropdownComponentUI.DROPDOWN_ICON,"Marital Status");
        dropdownComponent.selectItemInCustomDropdown("Married","Marital Status");
        Assert.assertEquals(getValueByLabelComponent.getElementTextByLabel("Marital Status"),"Married");
    }

    public void selectBloodTypeValue(){
        waitElementClickable(driver, DropdownComponentUI.DROPDOWN_ICON,"Blood Type");
        dropdownComponent.selectItemInCustomDropdown("B+","Blood Type");
        Assert.assertEquals(getValueByLabelComponent.getElementTextByLabel("Blood Type"),"B+");

    }

    public void openPersonalDetail(){
        //waitElementVisible(driver, LeftModuleComponentUI.LEFT_MENU_BY_TEXT_OF_LISTEMPLOYEE,"Personal Details");
        leftMenuComponent.clickToLeftMenuOfListEmployee("Personal Details");
    }

    public void clickSavebutton(){
        buttonComponent.clickToButtonByText("Personal Details","Save");
        //buttonComponent.clickToButtonByText("Custom Fields","Save");
    }

    public ContactDetailPO openContactDetails(){
        leftMenuComponent.clickToLeftMenuOfListEmployee("Contact Details");
        return PageGenerator.getPage(ContactDetailPO.class,driver);
    }

}

