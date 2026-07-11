package orangehrm;
//import từ thư viện

import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.orangeHRM.NavigatorByDynamicLocator.*;

import java.time.Duration;
import java.util.Random;

public class Level_11_Component_II extends BaseTest {


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

        Random rand=new Random();
        createUsername="Admin"+ rand.nextInt(100);
    }

    @Test
    public void Employee_03_NewEmployee(){
        loginPage.loginToApplication(adminUsername,adminPassword);

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));

        dashboardPage=PageGenerator.getPage(DashboardPO.class,driver);
        verifyTrue(dashboardPage.isLoadingIconDisappear(driver));
        verifyTrue(dashboardPage.isDashboardHeaderDisplayed(driver));



        dashboardPage.openModuleByText("PIM");

        employeeListPage=PageGenerator.getPage(EmployeeListPO.class,driver);

        verifyTrue(employeeListPage.isLoadingIconDisappear(driver));
        verifyTrue(employeeListPage.isPIMHeaderDisplayed(driver)); //Loi

        employeeListPage.openAddEmployeeTab("Add Employee");

        addEmployeePage=PageGenerator.getPage(AddEmployeePO.class,driver);
        //Khoi tao
//      addEmployeePage=new AddEmployeePageObject(driver); => doi sang verifyTrue
        verifyTrue(addEmployeePage.isLoadingIconDisappear(driver));

        addEmployeePage.enterToTextboxByName("John","firstName");
        verifyTrue(addEmployeePage.isLoadingIconDisappear(driver));

        addEmployeePage.enterToTextboxByName("Smith","lastName");
//        employeeID =addEmployeePage.getEmployeeID();

        addEmployeePage.clickToAddDetailCheckbox();
        addEmployeePage.enterToTextboxByLabel(createUsername,"Username");
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
    private String employeeID,adminUsername,adminPassword,employeeFirstname,employeeLastname,createUsername;

    @AfterClass
    public void afterClass(){

}
}
