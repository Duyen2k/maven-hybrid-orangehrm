package pageObjects.orangeHRM.NavigatorByDynamicLocator;

import componentUIs.ButtonComponentUI;
import componentUIs.LeftModuleComponentUI;
import componentUIs.TextboxComponentUI;
import components.ButtonComponent;
import components.GetValueByLabelComponent;
import components.TextboxComponent;
import core.BaseComponent;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.orangHRM.AddEmployeePageUI;
import pageUIs.orangHRM.BasePageUI;

import java.util.Random;

public class AddEmployeePO extends BaseComponent {
    WebDriver driver;
    private TextboxComponent textboxComponent;
    private ButtonComponent buttonComponent;
    private GetValueByLabelComponent getValueByLabelComponent;

    public AddEmployeePO(WebDriver driver) {
        super(driver);
        this.driver = driver;
        textboxComponent = new TextboxComponent(this.driver);
        buttonComponent = new ButtonComponent(this.driver);
        getValueByLabelComponent=new GetValueByLabelComponent(this.driver);
    }
String createdUsername="John"+new Random().nextInt(100);


    public PersonalDetailPO clickToSaveButton() {
        waitElementVisible(driver, AddEmployeePageUI.SAVE_BUTTON);
        clickToElement(driver,AddEmployeePageUI.SAVE_BUTTON,"");
        waitListElementInvisible(driver, BasePageUI.SPINER_ICON);
        return PageGenerator.getPage(PersonalDetailPO.class,driver);
    }

    public boolean isTextboxDisplay(WebDriver driver, String restparam) {
        waitElementVisible(driver, TextboxComponentUI.TEXTBOX_BY_LABEL,restparam);
        return isElementDisplayed(driver, TextboxComponentUI.TEXTBOX_BY_LABEL,restparam);
    }

    public void clickToHiddenMenuIcon() {
        waitElementClickable(driver, ButtonComponentUI.HIDDEN_MENU_ICON);
        clickToElement(driver, ButtonComponentUI.HIDDEN_MENU_ICON);
        sleepInSecond(2);
    }

    public boolean isPIMModuleDisplay(String moduleName) {
        //waitElementVisible(driver, LeftModuleComponentUI.LEFT_MODULE_BY_NAME,moduleName); (clickHiddenIcon: ko con hien thi nua)
        return isElementDisplayed(driver, LeftModuleComponentUI.LEFT_MODULE_BY_NAME,moduleName);
    }

    //Tìm element ko hển thị thì isDisplayed là lâu nhất vì phải mất đúng khoảng time mới fail
    //Cách 1: ko dùng try-catch(có overrideTimeout) - Dùng finds.size()==0
    public boolean isTextboxNonPresence(String textboxName) {
        return isElementNonPresence(driver,TextboxComponentUI.TEXTBOX_BY_LABEL,textboxName);
    }

    //Cách 2: Dùng try-catch
    public boolean isTextboxNotPresence(String textboxName) {
        return isElementNotPresence(driver,TextboxComponentUI.TEXTBOX_BY_LABEL,textboxName);
    }

    //Cách 3: Dùng explicitWait (ko dùng isDisplay/ko dùng finds.size()==0)
    public boolean isTextboxNonePresence(String textboxName) {
        return isElementNonePresence(driver,TextboxComponentUI.TEXTBOX_BY_LABEL,textboxName);
    }

    public boolean isElementHidden(String valueName) {
        return isElementHidden(driver,LeftModuleComponentUI.LEFT_MODULE_BY_NAME,valueName);
    }

    public void sendkeyToTextboxByName(String textboxName,String keyToSend) {
        waitElementVisible(driver,TextboxComponentUI.TEXTBOX_BY_NAME,textboxName);
        sendkeyToElement(driver,TextboxComponentUI.TEXTBOX_BY_NAME,keyToSend,textboxName);
    }

    //LiveCode:OrangeHRM - ComponentPattern
    public PersonalDetailPO addNewEmployee(String firstName, String lastName, String createdUsername, String password, String confirmPassword) {
        textboxComponent.enterToTextboxByName(firstName,"firstName");
        textboxComponent.enterToTextboxByName(lastName,"lastName");
        clickToAddDetailCheckbox();
        textboxComponent.enterToTextboxByLabel(createdUsername,"Username");
        textboxComponent.enterToTextboxByLabel(password,"Password");
        System.out.println(password);
        textboxComponent.enterToTextboxByLabel(confirmPassword,"Confirm Password");
        System.out.println(confirmPassword);
        buttonComponent.clickToButtonByText("Add Employee","Save");
        return PageGenerator.getPage(PersonalDetailPO.class,driver);
    }

    public String getEmployeeId(){
        return getValueByLabelComponent.getValueByLabel("Employee Id");
    }
}
