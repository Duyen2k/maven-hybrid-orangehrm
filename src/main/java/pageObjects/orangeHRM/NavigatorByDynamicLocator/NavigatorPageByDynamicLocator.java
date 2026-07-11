package pageObjects.orangeHRM.NavigatorByDynamicLocator;

import core.BaseComponent;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageObjects.orangeHRM.editNavigation.ContactDetailPageObject;
import pageUIs.orangHRM.AddEmployeePageUI;
import pageUIs.orangHRM.BaseComponentUI;
import pageUIs.orangHRM.BasePageUI;

public class NavigatorPageByDynamicLocator extends BaseComponent {
    WebDriver driver;

    public NavigatorPageByDynamicLocator(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public ContactDetailPO openContactDetailsPage(String valueName){
        waitElementVisible(driver, BaseComponentUI.SUB_MENU,valueName);
        clickToElement(driver, BaseComponentUI.SUB_MENU,valueName);
        return PageGenerator.getPage(ContactDetailPO.class,driver);
    }

   public PersonalDetailPO openPersonalDetailsPage(String valueName){
        waitElementVisible(driver, BaseComponentUI.SUB_MENU,valueName);
        clickToElement(driver, BaseComponentUI.SUB_MENU,valueName);
        return PageGenerator.getPage(PersonalDetailPO.class,driver);
    }

    public DependencyPO openDependencyPage(String valueName){
        waitElementVisible(driver, BaseComponentUI.SUB_MENU,valueName);
        clickToElement(driver, BaseComponentUI.SUB_MENU,valueName);
        return PageGenerator.getPage(DependencyPO.class,driver);
    }


}
