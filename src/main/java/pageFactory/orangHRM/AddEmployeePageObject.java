package pageFactory.orangHRM;

import core.BasePageFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddEmployeePageObject extends BasePageFactory {
    private WebDriver driver;

    @CacheLookup
    @FindBy(how= How.XPATH,using = "//input[@name='firstName']")
    private WebElement firstNameTextbox;

    @CacheLookup
    @FindBy(name = "lastName") //hoặc dùng luôn @FindBy(css="")
    private WebElement lastNameTextbox;

    @CacheLookup
    @FindBy(xpath = "//button[contains(string(),'Save')]")
    private WebElement saveButtonElement;

    @CacheLookup
    @FindBy(xpath = "//label[text()='Employee Id']/parent::div/following-sibling::div/input")
    private WebElement employeeIDTextbox;

    @FindBy(xpath = "//div[@class='oxd-loading-spinner']")
    private List<WebElement> loadingSpinner;

    public AddEmployeePageObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void enterToFirstnameTextbox(String firstname) {
        waitElementVisible(driver,firstNameTextbox);
        sendkeyToElement(driver,firstNameTextbox,firstname);
    }

    public void enterToLastnameTextbox(String lastname) {
        waitElementVisible(driver,lastNameTextbox);
        sendkeyToElement(driver,lastNameTextbox,lastname);
    }

    public String getEmployeeID() {
        waitElementVisible(driver,employeeIDTextbox);
        return getElementDOMProperty(employeeIDTextbox,"value");
    }

    public void clickToSaveButton() {
        waitElementVisible(driver,saveButtonElement);
        clickToElement(driver,saveButtonElement);
    }

    public boolean isLoadingIconDisappear() {
        return waitListElementInvisible(driver,loadingSpinner);
    }
}
