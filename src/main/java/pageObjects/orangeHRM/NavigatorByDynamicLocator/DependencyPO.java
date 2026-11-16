package pageObjects.orangeHRM.NavigatorByDynamicLocator;

import componentUIs.ButtonComponentUI;
import components.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DependencyPO extends NavigatorPageByDynamicLocator{
    WebDriver driver;
    private ButtonComponent buttonComponent;
    private TextboxComponent textboxComponent;
    private DropdownComponent dropdownComponent;
    private ToastMessageComponent toastMessageComponent;
    private ValidationMessageComponent validationMessageComponent;

    public DependencyPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
        buttonComponent=new ButtonComponent(driver);
        textboxComponent=new TextboxComponent(driver);
        dropdownComponent=new DropdownComponent(driver);
        dropdownComponent=new DropdownComponent(driver);
        toastMessageComponent=new ToastMessageComponent(driver);
        validationMessageComponent=new ValidationMessageComponent(driver);
    }

    public void addDependentsInfo(){
        buttonComponent.clickToAddButtonByText("Assigned Dependents","Add");
        textboxComponent.enterToTextboxByLabel("Jonson","Name");
        dropdownComponent.selectItemInCustomDropdown("Child","Relationship");
        textboxComponent.enterToTextboxByLabel("2020-10-20","Date of Birth");
        buttonComponent.clickToButtonByText("Add Dependent","Save");
        toastMessageComponent.isToastMsgDisplay("Successfully Saved");
    }

    //parttern-object
//    private void clickToBrowserButton(String fileName){
//        buttonComponent.clickToAddButtonByText("Attachments","Add");
//        uploadMultipleFiles(driver,fileName);
//        Assert.assertTrue(isFileNameUploadedSuccessfully(fileName));
//    }

    private boolean isFileNameUploadedSuccessfully(String fileName){
        waitElementVisible(driver, ButtonComponentUI.BUTTON_UPLOAD_FILE,"Select File",fileName);
        return isElementDisplayed(driver, ButtonComponentUI.BUTTON_UPLOAD_FILE,"Select File",fileName);
    }

    public void addValidDependentsAttachment(String fileName){
        uploadMultipleFiles(driver,fileName);
        buttonComponent.clickToButtonByText("Add Attachment","Save");
        toastMessageComponent.isToastMsgDisplay("Successfully Saved");
    }

    public void addInvalidDependentsAttachment(String invalidFileName){
        buttonComponent.clickToAddButtonByText("Attachments","Add");
        uploadMultipleFiles(driver,invalidFileName);
        Assert.assertTrue(validationMessageComponent
                .isErrorMessageByLabelDisplay("Select File","Attachment Size Exceeded"));


    }
}
