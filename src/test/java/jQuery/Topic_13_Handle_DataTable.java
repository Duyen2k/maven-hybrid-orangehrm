package jQuery;

import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.jQuery.HomePage;
import pageUIs.jQuery.HomePageUI;

public class Topic_13_Handle_DataTable extends BaseTest {

    private WebDriver driver;

    @Parameters({"appUrl","browser"})
    @BeforeClass
    public void beforeClass(String appURL, String browserName) {
        driver=getBrowserDriver(appURL,browserName);

        homePage=PageGenerator.getPage(HomePage.class,driver);

        //Sleep cung 10s tat quang cao
        homePage.sleepInSecond(15);
    }

    @Test (enabled = false)
    public void DataTable_01_Paging(){
        homePage.openPageByNumber("8");
        Assert.assertTrue(homePage.isPageActiveByClickNumber("8"));

        homePage.sleepInSecond(5);

        homePage.openPageByNumber("11");
        Assert.assertTrue(homePage.isPageActiveByClickNumber("11"));
    }

    @Test(enabled = false)
    public void DataTable_02_Search(){
        homePage.sendkeyToSearch("Females","384187");
        homePage.sendkeyToSearch("Country","Afghanistan");
        homePage.sendkeyToSearch("Males","407124");
        homePage.sendkeyToSearch("Total","791312");

        homePage.isRowActiveByValue("384187","Afghanistan","407124","791312");

        homePage.refreshPage(driver);

        homePage.sendkeyToSearch("Females","276880");
        homePage.sendkeyToSearch("Country","Angola");
        homePage.sendkeyToSearch("Males","276472");
        homePage.sendkeyToSearch("Total","553353");

        homePage.isRowActiveByValue("276880","Angola","276472","553353");
    }

    @Test(enabled = false)
    public void DataTable_03_Action(){
        homePage.clickToIconByCountryName("Argentina","edit");
    }

    @Test(enabled = false)
    public void DataTable_04_Index(){
        homePage.enterToTextboxByColumnNameAndRowIndex("Contact Person","2","John Henry");
        homePage.sleepInSecond(2);
        homePage.enterToTextboxByColumnNameAndRowIndex("Company","1","FPT");
        homePage.sleepInSecond(2);
        homePage.enterToTextboxByColumnNameAndRowIndex("Order Placed","3","15");

        homePage.selectToDropdownByColumnNameAndBrowserIndex("Country","1","Malaysia");
    }

    @Test
    public void DataTable_05_Index() {
        homePage.getAllValueByColumnName("Country");
    }
    private HomePage homePage;
}
