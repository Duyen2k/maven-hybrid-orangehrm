package pageObjects.orangeHRM.editNavigation;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.orangHRM.editNavigationUI.EditNavigatorPageUI;

public class EditNavigatorPageObject extends BasePage {
    WebDriver driver;

    public EditNavigatorPageObject(WebDriver driver) {
        this.driver = driver;
    }
//9 page là có đúng duy nhất 9 hàn và ko trùng lặp ở bâ kỳ vị trí nào
// Da co driver cua contructor
    public JobPageObject openJobPage() {
        waitElementVisible(driver,  EditNavigatorPageUI.JOB_MODULE);
        clickToElement(driver, EditNavigatorPageUI.JOB_MODULE);
        return PageGenerator.getPage(JobPageObject.class,driver);
    }

    public DependentsPageObject openDependentsPage() {
        waitElementVisible(driver, EditNavigatorPageUI.DEPENDENCES_MODULE);
        clickToElement(driver, EditNavigatorPageUI.DEPENDENCES_MODULE);
        return PageGenerator.getPage(DependentsPageObject.class,driver);
    }

    public PersonalDetailPageObject openPersonalDetailPage() {
        waitElementVisible(driver, EditNavigatorPageUI.PERSONAL_DETAIL_MODULE);
        clickToElement(driver, EditNavigatorPageUI.PERSONAL_DETAIL_MODULE);
        return PageGenerator.getPage(PersonalDetailPageObject.class,driver);
    }

    public ContactDetailPagePageObject openContactDetailPage() {
        waitElementVisible(driver,EditNavigatorPageUI.CONTACT_DETAIL_MODULE);
        clickToElement(driver,EditNavigatorPageUI.CONTACT_DETAIL_MODULE);
        return PageGenerator.getPage(ContactDetailPagePageObject.class,driver) ;
    }
}
