package orangehrm;
//import từ thư viện

import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.orangeHRM.*;
import pageObjects.orangeHRM.editNavigation.ContactDetailPagePageObject;
import pageObjects.orangeHRM.editNavigation.DependentsPageObject;
import pageObjects.orangeHRM.editNavigation.JobPageObject;
import pageObjects.orangeHRM.editNavigation.PersonalDetailPageObject;

public class Level_08_Page_Navigator extends BaseTest {


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
    public void TC_01_CreateNewEmployee(){
        //Phải nắm rõ business để chuyển hướng/ gọi trang cho chính xác
        //Ràng buộc giữa các page về coding
        //Các hàm chuyển trang chỉ dùng cho các sự kiện nhâ định phải đưa vào các class PageObject
        //(page cụ thể-ko đưa vào BasePage)
        //Action of Login
        loginPage.enterToUsernameTextbox(adminUsername);
        loginPage.enterToPasswordTextbox(adminPassword);
        dashboardPage=loginPage.clickToLoginButton();

        //Khoi tao
//        dashboardPage=new DashboardPageObject(driver);

        Assert.assertTrue(dashboardPage.isLoadingIconDisappear(driver));

        employeeListPage=dashboardPage.clickToPIMModule();

        //Khoi tao
//        employeeListPage=new EmployeeListPageObject(driver);

        Assert.assertTrue(employeeListPage.isLoadingIconDisappear(driver));

        addEmployeePage=employeeListPage.clickToAddEmployeeButton();

        //Khoi tao
//        addEmployeePage=new AddEmployeePageObject(driver);

        Assert.assertTrue(addEmployeePage.isLoadingIconDisappear(driver));

        addEmployeePage.enterToFirstnameTextbox(employeeFirstname);
        Assert.assertTrue(addEmployeePage.isLoadingIconDisappear(driver));

        addEmployeePage.enterToLastnameTextbox(employeeLastname);
        employeeID =addEmployeePage.getEmployeeID();

        personalDetailPage= addEmployeePage.clickToSaveButton();

        //Khoi tao
//        personalDetailPage=new PersonalDetailPageObject(driver);

        Assert.assertTrue(personalDetailPage.isLoadingIconDisappear(driver));

//        Assert.assertEquals(personalDetailPage.getFirstnameTextboxValue(),employeeFirstname);
//        Assert.assertEquals(personalDetailPage.getLastnameTextboxValue(),employeeLastname);
//        Assert.assertEquals(personalDetailPage.getEmployeeIDTextboxValue(),employeeID);

    }

    //Chưa che dấu được hết sự khởi tạo(của Login)

    @Test
    public void TC_02_ContactDetail(){
//        loginPage.openDependentsPage(driver); => ko ke thua EditNavigatorPageObject nen ko goi ra duoc

        //Từ Personal qua Contact
        contactDetailPage=personalDetailPage.openContactDetailPage();

        //Từ Contact qua Job
        jobPage=contactDetailPage.openJobPage();

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
    private ContactDetailPagePageObject contactDetailPage;
    private JobPageObject jobPage;
    private DependentsPageObject dependentsPage;
    private String employeeID,adminUsername,adminPassword,employeeFirstname,employeeLastname;

    @AfterClass
    public void afterClass(){

}
}
