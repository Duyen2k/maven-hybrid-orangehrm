package pageObjects.orangeHRM.NavigatorByDynamicLocator;

import core.BaseComponent;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.orangHRM.AddEmployeePageUI;
import pageUIs.orangHRM.BasePageUI;

public class AddEmployeePO extends BaseComponent {
    WebDriver driver;

    public AddEmployeePO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public PersonalDetailPO clickToSaveButton() {
        waitElementVisible(driver, AddEmployeePageUI.SAVE_BUTTON);
        clickToElement(driver,AddEmployeePageUI.SAVE_BUTTON,"");
        waitListElementInvisible(driver, BasePageUI.SPINER_ICON);
        return PageGenerator.getPage(PersonalDetailPO.class,driver);
    }
}
