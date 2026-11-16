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

public class Level_13_Undisplayed extends BaseTest {


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
        valueSendTofirstname="Hanna";
        valueSendTolastname="Nguyen";

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
        verifyTrue(employeeListPage.isPIMHeaderDisplayed(driver));

        employeeListPage.openAddEmployeeTab("Add Employee");

        addEmployeePage=PageGenerator.getPage(AddEmployeePO.class,driver);
        //Khoi tao
//      addEmployeePage=new AddEmployeePageObject(driver); => doi sang verifyTrue
        verifyTrue(addEmployeePage.isLoadingIconDisappear(driver));

        addEmployeePage.enterToTextboxByName(valueSendTofirstname,"firstName");
        verifyTrue(addEmployeePage.isLoadingIconDisappear(driver));


        addEmployeePage.enterToTextboxByName(valueSendTolastname,"lastName");
//        employeeID =addEmployeePage.getEmployeeID();

        addEmployeePage.clickToAddDetailCheckbox();

        //TH1: Element co hien thi tren UI va xuat hien trong DOM (Visible/Displayed)
        verifyTrue(addEmployeePage.isTextboxDisplay(driver,"Username"));
        verifyTrue(addEmployeePage.isTextboxDisplay(driver,"Password"));
        verifyTrue(addEmployeePage.isTextboxDisplay(driver,"Confirm Password"));

        addEmployeePage.enterToTextboxByLabelName(createUsername,"Username");
        addEmployeePage.enterToTextboxByLabelName("Admin@12345","Password");
        addEmployeePage.enterToTextboxByLabelName("Admin@12345","Confirm Password");

//        personalDetailPage= addEmployeePage.clickToSaveButton();

        //TH2: Element ko hien thi tren UI va co xuat hien trong DOM (Invisible)
        addEmployeePage.clickToHiddenMenuIcon();
        //verifyFalse(addEmployeePage.isPIMModuleDisplay("PIM")); //=> có thể dùng cách finds.size()>0
        verifyTrue(addEmployeePage.isElementHidden("PIM"));



        //TH3: Element khong hien thi tren UI va khong xuat hien trong DOM (Non-presence)

        //Nếu dùng cách isDisplay thi khi nó tìm ko thấy (ko có trong DOM), cần đợi hết 30s mới ném ra exception => rất lâu
        //=> tao ham non-presence su dung findSize()==0
        addEmployeePage.clickToAddDetailCheckbox();
        //verifyFalse(addEmployeePage.isUsernameTextboxDisplay(driver,"Username"));
        //addEmployeePage.clickToHiddenMenuIcon();
        verifyTrue(addEmployeePage.isTextboxNonPresence("Username"));
        verifyTrue(addEmployeePage.isTextboxNonPresence("Password"));
        verifyTrue(addEmployeePage.isTextboxNonPresence("Confirm Password"));



//        verifyTrue(personalDetailPage.isLoadingIconDisappear(driver));
//
//        contactDetailPage=personalDetailPage.openContactDetailsPage("Contact Details");
//        dependentsPage=contactDetailPage.openDependencyPage("Dependents");
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
    private String employeeID,adminUsername,adminPassword,employeeFirstname,employeeLastname,createUsername,valueSendTofirstname,valueSendTolastname;

    @AfterClass
    public void afterClass(){

}
}
