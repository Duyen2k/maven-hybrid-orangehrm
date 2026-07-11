package pageObjects.orangeHRM.NavigatorByDynamicLocator;

import org.openqa.selenium.WebDriver;

public class PersonalDetailPO extends NavigatorPageByDynamicLocator{
    WebDriver driver;
    public PersonalDetailPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


}
