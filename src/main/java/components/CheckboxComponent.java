package components;

import componentUIs.CheckboxComponentUI;
import componentUIs.HeaderComponentUI;
import core.BaseComponent;
import org.openqa.selenium.WebDriver;

public class CheckboxComponent extends BaseComponent {
    WebDriver driver;

    public CheckboxComponent(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


}
