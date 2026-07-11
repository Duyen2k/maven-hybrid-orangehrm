package pageObjects.orangeHRM.NavigatorByDynamicLocator;

import org.openqa.selenium.WebDriver;

public class ContactDetailPO extends NavigatorPageByDynamicLocator{
    WebDriver driver;
    public ContactDetailPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


}
