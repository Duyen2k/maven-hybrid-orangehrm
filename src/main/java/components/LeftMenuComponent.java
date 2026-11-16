package components;

import componentUIs.LeftModuleComponentUI;
import core.BaseComponent;
import org.openqa.selenium.WebDriver;
import pageUIs.orangHRM.BaseComponentUI;


public class LeftMenuComponent extends BaseComponent {
    WebDriver driver;

    public LeftMenuComponent(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public void clickToLeftMenuByText(String valueName){
        waitElementClickable(driver, LeftModuleComponentUI.LEFT_MODULE_BY_NAME,valueName);
        clickToElement(driver, LeftModuleComponentUI.LEFT_MODULE_BY_NAME,valueName);
    }

    public void clickToLeftMenuOfListEmployee(String leftmenuName){
        waitElementClickable(driver,LeftModuleComponentUI.LEFT_MENU_BY_TEXT_OF_LISTEMPLOYEE,leftmenuName);
        clickToElement(driver,LeftModuleComponentUI.LEFT_MENU_BY_TEXT_OF_LISTEMPLOYEE,leftmenuName);
        waitListElementVisible(driver,BaseComponentUI.SPINER_ICON);
        waitListElementInvisible(driver,BaseComponentUI.SPINER_ICON);
        //waitForAllSpinnersInvisible(driver,BaseComponentUI.SPINER_ICON);
    }

    public void clickToLeftMenuOfListEmployeeAndLoaingSpiner(String leftmenuName){
        waitElementClickable(driver,LeftModuleComponentUI.LEFT_MENU_BY_TEXT_OF_LISTEMPLOYEE,leftmenuName);
        clickToElement(driver,LeftModuleComponentUI.LEFT_MENU_BY_TEXT_OF_LISTEMPLOYEE,leftmenuName);
        waitListElementVisible(driver,BaseComponentUI.LOADING_SPINER);
        waitListElementInvisible(driver,BaseComponentUI.LOADING_SPINER);
    }
}
