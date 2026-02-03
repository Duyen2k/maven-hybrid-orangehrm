package openCart;
//import từ thư viện

import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.openCart.admin.AdminCustomerPO;
import pageObjects.openCart.admin.AdminDashboardPO;
import pageObjects.openCart.admin.AdminLoginPO;
import pageObjects.openCart.user.UserHomePO;
import pageObjects.openCart.user.UserLoginPO;
import pageObjects.openCart.user.UserRegisterPO;

import java.time.Duration;
import java.util.Random;

public class Level_09_Switch_Url extends BaseTest {
    private String userURL,adminURL;

    @Parameters({"userUrl","adminUrl","browser"})
    @BeforeClass
    public void beforeClass(String userURL, String adminURL,String browserName) {

    //Gan du lieu
        this.userURL=userURL;
        this.adminURL=adminURL;

        Random random=new Random();
        enterEmail="Test"+random.nextInt(1000)+"@gmail.com";
        userFirstname = "John";
        userLastname="Henry";
        enterPassword="Auto222$$";
        adminUsername="automationfc";
        adminPassword="Auto222$$";

        //Mo browser len la trang User
        driver=getBrowserDriver(userURL,browserName);

        userHomePage= PageGenerator.getPage(UserHomePO.class,driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait explicitWait=new WebDriverWait(driver,Duration.ofSeconds(5));
    }

    @Test(enabled = false)
    public void OpenCart_01_Loggin_And_Logout(){
        /*GIỐNG HNAHF VI CỦA USER*/
        userLoginPage=userHomePage.clickToMyAcountAtFooter();
        userRegisterPage=userLoginPage.clickToContinueButtonAtUserSiteToLogin();
        userRegisterPage.enterToFirstNameAtUserSite(userFirstname);
        userRegisterPage.enterToLastNameAtUserSite(userLastname);
        userRegisterPage.enterToEmailAtUserSite(enterEmail);
        userRegisterPage.enterToPasswordAtUserSite(enterPassword);
        userRegisterPage.acceptPrivacyCheckbox();
        userRegisterPage.clickContinueButtonToLogin();

        userRegisterPage.isSuccessMessageDisplayed();

        userHomePage=userRegisterPage.clickToLogoutLinkAtUserSite(driver);
//        adminLoginPage=userRegisterPage.clickToContinueButtonAtUserSiteToLogout();

        //User -> Admin(Login)
        userHomePage.openAdminSite(driver,adminURL);
        adminLoginPage=PageGenerator.getPage(AdminLoginPO.class, driver);

        //Thao tac ben Admin
        adminLoginPage.enterToUserNameAtAdminSite(adminUsername);
        adminLoginPage.enterToPasswordAtAdminSite(adminPassword);
        adminLoginPage.clickToLoginButtonAtAdminSite();
        adminDashboardPage=PageGenerator.getPage(AdminDashboardPO.class,driver);

        adminCustomerPage=adminDashboardPage.openCustomerPageAtAdminSite();

        adminLoginPage=adminCustomerPage.clickToLogoutLinkAtAdminSite(driver);
        userHomePage=adminLoginPage.openUserSite(driver,userURL);

        userLoginPage.openAdminSite(driver,adminURL);


    }

    //Chưa che dấu được hết sự khởi tạo(của Login)

    @Test(enabled = false)
    public void OpenCart_02_Logging_Without_Logout(){
        /* TIỆN CHO VIỆC DEVELOP/ TESTING*/
        //User vào đăng ký tài khoản rồi mua hàng
        //User ko Logout
        //Chuyển qua trang Admin -> Login 1 lần
        //Admin vào verify đơn hàng
        //Admin ko Logout
        //Chuyển qua trang User
        //Chuyển qua trang Admin

        userLoginPage=userHomePage.clickToMyAcountAtFooter();
        userRegisterPage=userLoginPage.clickToContinueButtonAtUserSiteToLogin();
        userRegisterPage.enterToFirstNameAtUserSite(userFirstname);
        userRegisterPage.enterToLastNameAtUserSite(userLastname);
        userRegisterPage.enterToEmailAtUserSite(enterEmail);
        userRegisterPage.enterToPasswordAtUserSite(enterPassword);
        userRegisterPage.acceptPrivacyCheckbox();
        userRegisterPage.clickContinueButtonToLogin();

        userRegisterPage.isSuccessMessageDisplayed();
        //Ko logout nên nó vẫn đang ở trang register

        //User -> Admin(Login)
        userHomePage.openAdminSite(driver,adminURL);
        adminLoginPage=PageGenerator.getPage(AdminLoginPO.class, driver);

        //Thao tac ben Admin
        adminLoginPage.enterToUserNameAtAdminSite(adminUsername);
        adminLoginPage.enterToPasswordAtAdminSite(adminPassword);
        adminLoginPage.clickToLoginButtonAtAdminSite();
        adminDashboardPage=PageGenerator.getPage(AdminDashboardPO.class,driver);

        adminCustomerPage=adminDashboardPage.openCustomerPageAtAdminSite();

        //Admin -> user(ko cần login lại)
        userHomePage=adminCustomerPage.openUserSite(driver,userURL);

        userHomePage.clickToMyAcountAtFooter();
        userLoginPage=PageGenerator.getPage(UserLoginPO.class,driver);
//        userRegisterPage.isSuccessMessageDisplayed();


        //User -> Admin(ko cần login lại)
        userHomePage.openAdminSite(driver,adminURL);
        adminDashboardPage=PageGenerator.getPage(AdminDashboardPO.class,driver); //=> Fail vì đang có bug hệ thống

    }

    @Test
    public void OpenCart_03_Open_Muiltiple_Tab(){
        //Phải viết genarator lên đây vì khi switch tab/ open urk thì mình cần khởi tạo page
        /* TIỆN CHO VIỆC DEVELOP/ TESTING*/
        //User vào đăng ký tài khoản rồi mua hàng
        //User ko Logout
        //Chuyển qua trang Admin -> Login 1 lần
        //Admin vào verify đơn hàng
        //Admin ko Logout
        //Chuyển qua trang User
        //Chuyển qua trang Admin

        userLoginPage=userHomePage.clickToMyAcountAtFooter();
        userRegisterPage=userLoginPage.clickToContinueButtonAtUserSiteToLogin();
        userRegisterPage.enterToFirstNameAtUserSite(userFirstname);
        userRegisterPage.enterToLastNameAtUserSite(userLastname);
        userRegisterPage.enterToEmailAtUserSite(enterEmail);
        userRegisterPage.enterToPasswordAtUserSite(enterPassword);
        userRegisterPage.acceptPrivacyCheckbox();
        userRegisterPage.clickContinueButtonToLogin();

        Assert.assertTrue(userRegisterPage.isSuccessMessageDisplayed());
        userWindownID=userRegisterPage.getCurrentWindownID(driver);
        System.out.println(userWindownID);

        userRegisterPage.openUrlByNewTAB(driver,adminURL);

        //User -> Admin(Login)
        userHomePage.openAdminSite(driver,adminURL);
        adminLoginPage=PageGenerator.getPage(AdminLoginPO.class, driver);

        //Thao tac ben Admin
        adminLoginPage.enterToUserNameAtAdminSite(adminUsername);
        adminLoginPage.enterToPasswordAtAdminSite(adminPassword);
        adminLoginPage.clickToLoginButtonAtAdminSite();
        adminDashboardPage=PageGenerator.getPage(AdminDashboardPO.class,driver);

        adminCustomerPage=adminDashboardPage.openCustomerPageAtAdminSite();
        adminWindownID= adminCustomerPage.getCurrentWindownID(driver);
        System.out.println(adminWindownID);

        //Admin -> user(ko cần login lại)
        adminCustomerPage.switchToWindowByID(driver,adminWindownID);

        userRegisterPage=PageGenerator.getPage(UserRegisterPO.class,driver);

        userHomePage.clickToMyAcountAtFooter();
        userLoginPage=PageGenerator.getPage(UserLoginPO.class,driver);
//        userRegisterPage.isSuccessMessageDisplayed();


        //User -> Admin(ko cần login lại)
        userLoginPage.switchToWindowByID(driver,userWindownID);
        adminCustomerPage=PageGenerator.getPage(AdminCustomerPO.class,driver); //=> Fail vì đang có bug hệ thống

    }




    @AfterClass
    public void afterClass(){

    }
    private WebDriver driver;
    private AdminCustomerPO adminCustomerPage;
    private AdminDashboardPO adminDashboardPage;
    private AdminLoginPO adminLoginPage;
    private UserHomePO userHomePage;
    private UserLoginPO userLoginPage;
    private UserRegisterPO userRegisterPage;
    private String userWindownID, adminWindownID;
    private String enterEmail, userFirstname,userLastname,enterPassword, adminUsername,adminPassword ;

}
