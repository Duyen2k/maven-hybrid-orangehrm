package orangehrm;
//import từ thư viện

import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.orangeHRM.AddEmployeePageObject;
import pageObjects.orangeHRM.DashboardPageObject;
import pageObjects.orangeHRM.EmployeeListPageObject;
import pageObjects.orangeHRM.LoginPageObject;
import pageObjects.orangeHRM.editNavigation.ContactDetailPagePageObject;
import pageObjects.orangeHRM.editNavigation.PersonalDetailPageObject;

public class Level_06_Page_Manager_II extends BaseTest {


    @Parameters({"appUrl","browser"})
    @BeforeClass
    public void beforeClass(String appUrl,String browserName) {
        driver=getBrowserDriver(appUrl,browserName);

        //Mở URL ra thì nó mở ra trang Login
        loginPage=new LoginPageObject(driver);

//        appUrl="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"; => đã có trong file xml
        adminUsername="AutomationDemo";
        adminPassword="Auto222$$";
        employeeFirstname="John";
        employeeLastname="Henry";
    }


    @Test
    public void TC_01_CreateNewEmployee(){
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

//        contactDetailPage=personalDetailPage.openPersonalDetailPage();
    }

    private WebDriver driver;
    private LoginPageObject loginPage;
    private DashboardPageObject dashboardPage;
    private EmployeeListPageObject employeeListPage;
    private AddEmployeePageObject addEmployeePage;
    private PersonalDetailPageObject personalDetailPage;
    private ContactDetailPagePageObject contactDetailPage;
    private String employeeID,adminUsername,adminPassword,employeeFirstname,employeeLastname;

    @AfterClass
    public void afterClass(){

}
}
