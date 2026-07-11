package orangehrm;
//import từ thư viện

import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.orangeHRM.NavigatorByDynamicLocator.*;

public class Level_11_Component_I extends BaseTest {


    @Parameters({"appUrl","browser"})
    @BeforeClass
    public void beforeClass(String appUrl,String browserName) {
        driver=getBrowserDriver(appUrl,browserName);

        //Mở URL ra thì nó mở ra trang Login
        loginPage= PageGenerator.getPage(LoginPO.class,driver);

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
        verifyTrue(employeeListPage.isPIMHeaderDisplayed(driver)); //Loi

        addEmployeePage=employeeListPage.clickToAddEmployeeButton();

        //Khoi tao
//      addEmployeePage=new AddEmployeePageObject(driver); => doi sang verifyTrue
        verifyTrue(addEmployeePage.isLoadingIconDisappear(driver));

        addEmployeePage.enterToTextboxByName("John","firstName");
        verifyTrue(addEmployeePage.isLoadingIconDisappear(driver));

        addEmployeePage.enterToTextboxByName("Smith","lastName");
//        employeeID =addEmployeePage.getEmployeeID();

        addEmployeePage.clickToAddDetailCheckbox();
        addEmployeePage.enterToTextboxByLabel("Admin12345","Username");
        addEmployeePage.enterToTextboxByLabel("Admin@12345","Password");
        addEmployeePage.enterToTextboxByLabel("Admin@12345","Confirm Password");

        personalDetailPage= addEmployeePage.clickToSaveButton();

        verifyTrue(personalDetailPage.isLoadingIconDisappear(driver));

        contactDetailPage=personalDetailPage.openContactDetailsPage("Contact Details");
        dependentsPage=contactDetailPage.openDependencyPage("Dependents");
    }



    private WebDriver driver;
    private LoginPO loginPage;
    private DashboardPO dashboardPage;
    private EmployeeListPO employeeListPage;
    private AddEmployeePO addEmployeePage;
    private PersonalDetailPO personalDetailPage;
    private ContactDetailPO contactDetailPage;
//    private JobPageObject jobPage;
    private DependencyPO dependentsPage;
    private String employeeID,adminUsername,adminPassword,employeeFirstname,employeeLastname;

    @AfterClass
    public void afterClass(){

}
}
