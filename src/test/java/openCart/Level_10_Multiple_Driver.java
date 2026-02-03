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

public class Level_10_Multiple_Driver extends BaseTest {
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
        userDriver =getBrowserDriver(userURL,browserName);

        userHomePage= PageGenerator.getPage(UserHomePO.class, userDriver);

        adminDriver=getBrowserDriver(adminURL,browserName);
        adminLoginPage=PageGenerator.getPage(AdminLoginPO.class,adminDriver);

    }

    @Test()
    public void OpenCart_02_Logging_Without_Logout(){
        //Firefox của user
        userLoginPage=userHomePage.clickToMyAcountAtFooter();
        userRegisterPage=userLoginPage.clickToContinueButtonAtUserSiteToLogin();
        userRegisterPage.enterToFirstNameAtUserSite(userFirstname);
        userRegisterPage.enterToLastNameAtUserSite(userLastname);
        userRegisterPage.enterToEmailAtUserSite(enterEmail);
        userRegisterPage.enterToPasswordAtUserSite(enterPassword);
        userRegisterPage.acceptPrivacyCheckbox();
        userRegisterPage.clickContinueButtonToLogin();

        userRegisterPage.isSuccessMessageDisplayed();

//        adminLoginPage=PageGenerator.getPage(AdminLoginPO.class,userDriver);
        //Firefox của Admin chạy tiếp
        adminLoginPage.enterToUserNameAtAdminSite(adminUsername);
        adminLoginPage.enterToPasswordAtAdminSite(adminPassword);
        adminLoginPage.clickToLoginButtonAtAdminSite();
        adminDashboardPage=PageGenerator.getPage(AdminDashboardPO.class, adminDriver);

        adminCustomerPage=adminDashboardPage.openCustomerPageAtAdminSite();

        //Firefox của User chạy tiếp
        userHomePage.clickToMyAcountAtFooter();
        userLoginPage=PageGenerator.getPage(UserLoginPO.class, userDriver);
//        userRegisterPage.isSuccessMessageDisplayed();

    }


    @AfterClass
    public void afterClass(){
        closeBrowser(userDriver);
        closeBrowser(adminDriver);
    }
    private WebDriver userDriver;
    private WebDriver adminDriver;
    private AdminCustomerPO adminCustomerPage;
    private AdminDashboardPO adminDashboardPage;
    private AdminLoginPO adminLoginPage;
    private UserHomePO userHomePage;
    private UserLoginPO userLoginPage;
    private UserRegisterPO userRegisterPage;
    private String userWindownID, adminWindownID;
    private String enterEmail, userFirstname,userLastname,enterPassword, adminUsername,adminPassword ;

}
