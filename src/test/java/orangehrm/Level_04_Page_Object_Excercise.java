package orangehrm;

import core.BaseTest;
import ex_pageObject.AddAdminButtonPageObject_Ex;
import ex_pageObject.DashboardPageObject_Ex;
import ex_pageObject.LoginPageObject_Ex;
import ex_pageObject.SearchAdminButtonPageObject_Ex;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Level_04_Page_Object_Excercise extends BaseTest {

    @Parameters({"appUrl","browser"})
    @BeforeClass
    public void beforeClass (String appUrl, String browserName){
        this.appUrl=appUrl;
        driver=getBrowserDriver(appUrl,browserName);

    //Mở Url Login ra
        loginPage=new LoginPageObject_Ex(driver);

        adminUsername="AutomationDemo";
        adminPassword="Auto222$$";
        status="Enabled";
        userRole="Admin";
        enteredUserPassword="admin123@";
//        enteredEmployeeName="Roker Feller";
        keyToSendName="Admin";
    }

    @Test
    public void Employee_01_CreateNewAdmin() throws InterruptedException {
    //Login vào page
        loginPage.enterToUserNameTextbox(adminUsername);
        loginPage.enterToPasswordTextbox(adminPassword);
        loginPage.clickToLoginButton();

    //Màn Dashboard-sau cần xử lý loading icon
        dashboardPage=new DashboardPageObject_Ex(driver);

        //Cái này đang dùng ké bên ví dụ trên lớp(nên ko cần define lại loading_icon)
        Assert.assertTrue(dashboardPage.isLoadingIconDisappear(driver));

        dashboardPage.clickToAdminButton(driver);

    //Màn Admin: sang màn nào new màn đó
        addAdminButtonPage=new AddAdminButtonPageObject_Ex(driver);
//
        Assert.assertTrue(dashboardPage.isLoadingIconDisappear(driver));
//
//        addAdminButtonPage=new AddAdminButtonPageObject_Ex(driver);
//
//        addAdminButtonPage.clickToAddButton();
//        addAdminButtonPage.enterUserRole();
//        addAdminButtonPage.enterStatus(status);
//        addAdminButtonPage.enterPassword(enteredUserPassword);
//        addAdminButtonPage.enterEmployeeName();
//        addAdminButtonPage.enterUserName(enteredUserName);
//        addAdminButtonPage.enterConfirmPassword(enteredUserPassword);
//        addAdminButtonPage.clickToSaveButton();

    //Màn Search Admin Account
        searchAdminButtonPage=new SearchAdminButtonPageObject_Ex(driver);
        Assert.assertTrue(dashboardPage.isLoadingIconDisappear(driver));

        searchAdminButtonPage.enterRegistedUserName(keyToSendName);
        searchAdminButtonPage.enterRegistedUserRole(userRole);
        searchAdminButtonPage.enterRegistedStatus(status);
        searchAdminButtonPage.clickToSearchButton();
    }

    @Test
    public void Employee_02_SearchAdmin(){


    }

    private WebDriver driver;
    private String appUrl;

    //Import hết các PageObject vào
    private AddAdminButtonPageObject_Ex addAdminButtonPage;
    private SearchAdminButtonPageObject_Ex searchAdminButtonPage;
    private LoginPageObject_Ex loginPage;
    private DashboardPageObject_Ex dashboardPage;
    private String adminUsername,adminPassword,status,userRole,enteredUserPassword,keyToSendName,enteredEmployeeName,enteredUserName;

    @AfterClass
    public void aferClass(){

    }

}
