package components;

import componentUIs.MessageComponentUI;
import core.BaseComponent;
import org.openqa.selenium.WebDriver;

public class ToastMessageComponent extends BaseComponent {
    WebDriver driver;

    public ToastMessageComponent(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isToastMsgDisplay(String messageText){
        waitElementVisible(driver, MessageComponentUI.TOAST_MSG,messageText);
        return isElementDisplayed(driver,MessageComponentUI.TOAST_MSG,messageText);
    }

}
