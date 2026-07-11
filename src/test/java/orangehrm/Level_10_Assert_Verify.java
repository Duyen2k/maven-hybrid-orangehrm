package orangehrm;
//import từ thư viện

import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.orangeHRM.AddEmployeePageObject;
import pageObjects.orangeHRM.DashboardPageObject;
import pageObjects.orangeHRM.EmployeeListPageObject;
import pageObjects.orangeHRM.LoginPageObject;
import pageObjects.orangeHRM.editNavigation.ContactDetailPageObject;
import pageObjects.orangeHRM.editNavigation.DependentsPageObject;
import pageObjects.orangeHRM.editNavigation.JobPageObject;
import pageObjects.orangeHRM.editNavigation.PersonalDetailPageObject;

public class Level_10_Assert_Verify extends BaseTest {


    @Parameters({"appUrl","browser"})
    @BeforeClass
    public void beforeClass(String appUrl,String browserName) {
        driver=getBrowserDriver(appUrl,browserName);

        //Mở URL ra thì nó mở ra trang Login
        loginPage= PageGenerator.getPage(LoginPageObject.class,driver);

        adminUsername="AutomationDemo";
        adminPassword="Auto222$$";
        employeeFirstname="John";
        employeeLastname="Henry";
    }

    @Test
    public void Employee_03_NewEmployee(){
        loginPage.enterToUsernameTextbox(adminUsername);
        loginPage.enterToPasswordTextbox(adminPassword);
        dashboardPage=loginPage.clickToLoginButton();
        verifyTrue(dashboardPage.isDashboardHeaderDisplayed(driver));


        //Khoi tao
//        dashboardPage=new DashboardPageObject(driver);

//        Assert.assertTrue(dashboardPage.isLoadingIconDisappear(driver));
        verifyTrue(dashboardPage.isLoadingIconDisappear(driver));

        employeeListPage=dashboardPage.clickToPIMModule();

        //Khoi tao
//        employeeListPage=new EmployeeListPageObject(driver);

        verifyTrue(employeeListPage.isLoadingIconDisappear(driver));
        verifyFalse(employeeListPage.isPIMHeaderDisplayed(driver)); //Loi

        addEmployeePage=employeeListPage.clickToAddEmployeeButton();

        //Khoi tao
//      addEmployeePage=new AddEmployeePageObject(driver); => doi sang verifyTrue
        verifyTrue(addEmployeePage.isLoadingIconDisappear(driver));

        addEmployeePage.enterToFirstnameTextbox(employeeFirstname);
        verifyTrue(addEmployeePage.isLoadingIconDisappear(driver));

        addEmployeePage.enterToLastnameTextbox(employeeLastname);
        employeeID =addEmployeePage.getEmployeeID();

//        personalDetailPage= addEmployeePage.clickToSaveButton(); //sua cho khac

        //Khoi tao
//        personalDetailPage=new PersonalDetailPageObject(driver);

        verifyTrue(personalDetailPage.isLoadingIconDisappear(driver));
    }

    @Test
    public void TC_04_ContactDetail(){
//        loginPage.openDependentsPage(driver); => ko ke thua EditNavigatorPageObject nen ko goi ra duoc

        //Từ Personal qua Contact
        contactDetailPage=personalDetailPage.openContactDetailPage();
        verifyFalse(contactDetailPage.isContactDetailsHeaderDisplayed("Contact Details")); //Loi

        //Từ Contact qua Job
        jobPage=contactDetailPage.openJobPage();
        verifyTrue(jobPage.isJobDetailsHeaderDisplayed("Job Details"));

        //Từ Job qua Dependents
        dependentsPage=jobPage.openDependentsPage();

        //Từ Dependent qua Personal
        personalDetailPage=dependentsPage.openPersonalDetailPage();

        //Từ Personal qua Job
        jobPage=personalDetailPage.openJobPage();

        contactDetailPage=jobPage.openContactDetailPage(  );

    }

    private WebDriver driver;
    private LoginPageObject loginPage;
    private DashboardPageObject dashboardPage;
    private EmployeeListPageObject employeeListPage;
    private AddEmployeePageObject addEmployeePage;
    private PersonalDetailPageObject personalDetailPage;
    private ContactDetailPageObject contactDetailPage;
    private JobPageObject jobPage;
    private DependentsPageObject dependentsPage;
    private String employeeID,adminUsername,adminPassword,employeeFirstname,employeeLastname;

    @AfterClass
    public void afterClass(){

}
}
