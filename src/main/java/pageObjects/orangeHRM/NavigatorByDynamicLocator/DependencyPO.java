package pageObjects.orangeHRM.NavigatorByDynamicLocator;

import org.openqa.selenium.WebDriver;

public class DependencyPO extends NavigatorPageByDynamicLocator{
    WebDriver driver;
    public DependencyPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


}
