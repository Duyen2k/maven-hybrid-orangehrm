package pageFactory.orangHRM;

import core.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PersonalDetailPageObject extends BasePageFactory {
    private WebDriver driver;

    @FindBy(how = How.XPATH,using = "//input[@name='firstName']")
    private WebElement firstnameTextbox;

    @FindBy(name="lastName")
    private  WebElement lastnameTextbox;

    @FindBy(xpath = "//label[text()='Employee Id']/parent::div/following-sibling::div/input")
    private WebElement employeeID;

    @FindBy(xpath = "//div[@class='oxd-loading-spinner']")
    private List<WebElement> loadingSpinner;

    public PersonalDetailPageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getFirstnameTextboxValue() {
        waitElementVisible(driver,firstnameTextbox);
        return getElementDOMProperty(firstnameTextbox,"value");
    }

    public String getLastnameTextboxValue(){
        waitElementVisible(driver,lastnameTextbox);
        return getElementDOMProperty(lastnameTextbox,"value");
    }

    public String getEmployeeIDTextboxValue(){
        waitElementVisible(driver,employeeID);
        return getElementDOMProperty(employeeID,"value");
    }

    public boolean isLoadingIconDisappear(WebDriver driver) {
        return waitListElementInvisible(driver,loadingSpinner);
    }
}
