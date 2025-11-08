package com.orangehrm.user;
//import từ thư viện

import core.BasePage;
import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.endUser.*;

public class Login_04_Page_Object extends BaseTest {


    private static final Logger log = LoggerFactory.getLogger(Login_04_Page_Object.class);

    @Parameters({"appUrl","browser"})
    @BeforeClass
    public void beforeClass(String appUrl,String browserName) {
        driver=getBrowserDriver(appUrl,browserName);

        //Mở URL ra thì nó mở ra trang Login
        loginPage=new LoginPageObject(driver);

//        appUrl="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"; => đã có trong file xml
        adminUsername="Admin";
        adminPassword="admin123";
        employeeFirstname="John";
        employeeLastname="Henry";
    }


    @Test
    public void TC_01_CreateNewEmployee(){
        //Action of Login
        loginPage.enterToUsernameTextbox(adminUsername);
        loginPage.enterToPasswordTextbox(adminPassword);
        loginPage.clickToLoginButton();

        //Action of Dashboard
        dashboardPage=new DashboardPageObject(driver);

        //Loading icon
        Assert.assertTrue(dashboardPage.isLoadingIconDisappear(driver));

        dashboardPage.clickToPIMModule();


        //Action of Employee List
        employeeListPage=new EmployeeListPageObject(driver);

        //Loading icon
        Assert.assertTrue(employeeListPage.isLoadingIconDisappear(driver));

        employeeListPage.clickToAddEmployeeButton();

        //Action of adding new employee
        addEmployeePage=new AddEmployeePageObject(driver);


        //Loading icon
        Assert.assertTrue(addEmployeePage.isLoadingIconDisappear(driver));

        addEmployeePage.enterToFirstnameTextbox(employeeFirstname);
        Assert.assertTrue(addEmployeePage.isLoadingIconDisappear(driver));

        addEmployeePage.enterToLastnameTextbox(employeeLastname);
        employeeID =addEmployeePage.getEmployeeID();

        addEmployeePage.clickToSaveButton();
        Assert.assertTrue(addEmployeePage.isLoadingIconDisappear(driver));

        //Action of personal detail
        personalDetailPage=new PersonalDetailPageObject(driver);

        //Loading icon
        Assert.assertTrue(personalDetailPage.isLoadingIconDisappear(driver));

        Assert.assertEquals(personalDetailPage.getFirstnameTextboxValue(),employeeFirstname);
        Assert.assertEquals(personalDetailPage.getLasttnameTextboxValue(),employeeLastname);
        Assert.assertEquals(personalDetailPage.getEmployeeIDTextboxValue(),employeeID);

    }

    @Test
    public void TC_02_EditEmployee(){

    }

    private WebDriver driver;
    private LoginPageObject loginPage;
    private DashboardPageObject dashboardPage;
    private EmployeeListPageObject employeeListPage;
    private AddEmployeePageObject addEmployeePage;
    private PersonalDetailPageObject personalDetailPage;
    private String employeeID,adminUsername,adminPassword,employeeFirstname,employeeLastname;

    @AfterClass
    public void afterClass(){

}
}
