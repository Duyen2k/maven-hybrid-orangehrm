package pageObjects.orangeHRM.NavigatorByDynamicLocator;

import components.*;
import core.BaseComponent;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.PageGenerator;

public class EmergencyDetailsPO extends BaseComponent {
    WebDriver driver;
    private ButtonComponent buttonComponent;
    private TextboxComponent textboxComponent;
    private ValidationMessageComponent validationMessageComponent;
    private LeftMenuComponent leftMenuComponent;
    private ToastMessageComponent toastMessageComponent;

    public EmergencyDetailsPO(WebDriver driver) {
        super(driver);
        this.driver=driver;
        buttonComponent=new ButtonComponent(driver);
        textboxComponent=new TextboxComponent(driver);
        validationMessageComponent=new ValidationMessageComponent(driver);
        leftMenuComponent=new LeftMenuComponent(driver);
        toastMessageComponent=new ToastMessageComponent(driver);
    }

    public void addInvalidEmergecyContact(){
        buttonComponent.clickToAddButtonByText("Assigned Emergency Contacts","Add");
        buttonComponent.clickToButtonByText("Save Emergency Contact","Save");
        Assert.assertTrue(validationMessageComponent.isErrorMessageByLabelDisplay("Name","Required"));
        Assert.assertTrue(validationMessageComponent.isErrorMessageByLabelDisplay("Relationship","Required"));
        Assert.assertTrue(validationMessageComponent.isErrorMessageByLabelDisplay("Home Telephone","At least one phone number is required"));

    }

    public void addValidEmergecyContact(){
        //buttonComponent.clickToAddButtonByText("Add");
        textboxComponent.enterToTextboxByLabel("Julie Nguyen","Name");
        textboxComponent.enterToTextboxByLabel("Friend","Relationship");
        textboxComponent.enterToTextboxByLabel("0987654321","Home Telephone");
        buttonComponent.clickToButtonByText("Save Emergency Contact","Save");
        toastMessageComponent.isToastMsgDisplay("Successfully Saved");
    }

    public DependencyPO openDependentsPage(){
        leftMenuComponent.clickToLeftMenuOfListEmployeeAndLoaingSpiner("Dependents");
        return PageGenerator.getPage(DependencyPO.class,driver);
    }



}
