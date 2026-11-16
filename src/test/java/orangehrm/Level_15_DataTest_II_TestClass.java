package orangehrm;

import core.BaseTest;
import dataTest.DataNetConfig;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.orangeHRM.NavigatorByDynamicLocator.*;

public class Level_15_DataTest_II_TestClass extends BaseTest {
    private DataNetConfig dataNetConfig=DataNetConfig.getDataConfig();


    @Parameters({"appUrl","browser"})
    @BeforeClass
    public void beforeClass(String appUrl,String browserName) {
        driver=getBrowserDriver(appUrl,browserName);

        //Mở URL ra thì nó mở ra trang Login
        loginPage= PageGenerator.getPage(LoginPO.class,driver);

        adminUsername="AutomationDemo";
        adminPassword="Auto222$$";

        //Su dung dataNetConfig
        employeeFirstname=dataNetConfig.getFirstName();
        employeeLastname=dataNetConfig.getLastName();
        valueSendTofirstname=dataNetConfig.getFirstName();
        valueSendTolastname=dataNetConfig.getLastName();
        createdpassword=dataNetConfig.getPassword();
        createdConfirmpassword=createdpassword;


        createUsername=dataNetConfig.getFirstName();
    }

    @Test (groups = {"employee","regression","full"})
    public void Employee_01_Add_New_Employee(){
        dashboardPage=loginPage.loginToApp(adminUsername,adminPassword);
        verifyTrue(dashboardPage.isDashboardHeaderTextDisplayed(driver));

        employeeListPage=dashboardPage.openPIMModule();
        verifyTrue(employeeListPage.isPIMHeaderTextDisplayed(driver));

        addEmployeePage=employeeListPage.openAddEmployeeNavTab();
        String employeeId=addEmployeePage.getEmployeeId();

        personalDetailPage=addEmployeePage.addNewEmployee(valueSendTofirstname,valueSendTolastname,createUsername,createdpassword,createdConfirmpassword);

        Assert.assertTrue(personalDetailPage.isSuccessfulSavedMsgDisplay());
        Assert.assertEquals(personalDetailPage.getEmployeeIdAtDetailPage(),employeeId);

    }

    @Test(enabled = false,groups = {"sanity","full"})
    public void Employee_02_Upload_Avatar(){
        LemonName= "LemonIMG.jpg";
        InvalidFileName="Document.pdf";

        //Valid Avatar
        personalDetailPage.uploadAvatar(LemonName);
        Assert.assertTrue(personalDetailPage.isSuccessfulUpdatedMsgDisplay());

        //Invalid Avatar
        personalDetailPage.uploadAvatar(DocumentName);
        Assert.assertTrue(personalDetailPage.isInvalidTypeMsgDisplay());
    }

    @Test(enabled = false)
    public void Employee_03_Personal_Details(){
        personalDetailPage.openPersonalDetail();
        personalDetailPage.selectNationalityValue();
        personalDetailPage.selectMaritalStatusValue();
        //personalDetailPage.selectBloodTypeValue();
        personalDetailPage.clickSavebutton(); //2 nut save
    }

    @Test(enabled = false)
    public void Employee_04_Contact_Details(){
        contactDetailPage=employeeListPage.openContactDetailsPage();
        contactDetailPage.enterStreet1value();
        contactDetailPage.enterCityvalue();
        contactDetailPage.clickSavebutton();
    }

    @Test(enabled = false)
    public void Employee_05_Emergency_Details(){
        emergencyDetailsPage=employeeListPage.openEmergencyDetailsPage();
        emergencyDetailsPage.addInvalidEmergecyContact();
        emergencyDetailsPage.addValidEmergecyContact();
    }

    @Test(enabled = false)
    public void Employee_06_Assigned_Dependents(){
        LemonName= "LemonIMG.jpg";
        InvalidFileName="InvalidFileUpload_exceedSize.pptx";

        dependentsPage=emergencyDetailsPage.openDependentsPage();
        dependentsPage.addDependentsInfo();
        dependentsPage.addInvalidDependentsAttachment(InvalidFileName);
        dependentsPage.addValidDependentsAttachment(LemonName);
    }

    private WebDriver driver;
    private LoginPO loginPage;
    private DashboardPO dashboardPage;
    private EmployeeListPO employeeListPage;
    private AddEmployeePO addEmployeePage;
    private PersonalDetailPO personalDetailPage;
    private ContactDetailPO contactDetailPage;
    private EmergencyDetailsPO emergencyDetailsPage;
//    private JobPageObject jobPage;
    private DependencyPO dependentsPage;
    private String employeeID,adminUsername,adminPassword,employeeFirstname,employeeLastname,createUsername,valueSendTofirstname,valueSendTolastname,createdpassword,createdConfirmpassword,LemonName,InvalidFileName,DocumentName;

    @AfterClass
    public void afterClass(){

}
}
