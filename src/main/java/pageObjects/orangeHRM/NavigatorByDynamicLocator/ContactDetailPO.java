package pageObjects.orangeHRM.NavigatorByDynamicLocator;

import componentUIs.TextboxComponentUI;
import components.*;
import dataTest.json.PersonInfo;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;

public class ContactDetailPO extends NavigatorPageByDynamicLocator{
    WebDriver driver;
    private LeftMenuComponent leftMenuComponent;
    private TextboxComponent textboxComponent;
    private DropdownComponent dropdownComponent;
    private GetValueByLabelComponent getValueByLabelComponent;
    private ButtonComponent buttonComponent;
    private ToastMessageComponent toastMessageComponent;

    public ContactDetailPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
        leftMenuComponent=new LeftMenuComponent(driver);
        textboxComponent=new TextboxComponent(driver);
        dropdownComponent=new DropdownComponent(driver);
        getValueByLabelComponent=new GetValueByLabelComponent(driver);
        buttonComponent=new ButtonComponent(driver);
        toastMessageComponent =new ToastMessageComponent(driver);
    }

    public void enterStreet1value(){
        textboxComponent.enterToTextboxByLabel("Hoang Mai","Street 1");
    }

    public void enterCityvalue(){
        textboxComponent.enterToTextboxByLabel("Ha Noi","City");
    }

    public void selectCountryInDropdwon(){
        dropdownComponent.selectItemInCustomDropdown("Angola","Country");
        Assert.assertEquals(getValueByLabelComponent.getValueByLabel("Country"),"Angola");
    }

    public void clickSavebutton(){
        buttonComponent.clickToButtonByText("Contact Details","Save");
        Assert.assertTrue(toastMessageComponent.isToastMsgDisplay("Successfully Updated"));
    }

    public void enterToPersonalDetail(List<PersonInfo.Person> personList) {
        for(PersonInfo.Person per: personList){
            sendkeyToElement(driver, TextboxComponentUI.TEXTBOX_BY_NAME,per.getPersonName(),"firstname");
        }
    }
}
