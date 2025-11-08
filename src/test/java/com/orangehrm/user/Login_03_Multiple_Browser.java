package com.orangehrm.user;
//import từ thư viện

import core.BasePage;
import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class Login_03_Multiple_Browser extends BaseTest {
    private WebDriver driver;
    private BasePage basePage;
    private String appUrl;

    @Parameters({"appUrl","browser"})
    @BeforeClass
    public void beforeClass(String appUrl,String browserName) {
        this.appUrl=appUrl;
        basePage=BasePage.getInstance();
        driver=getBrowserDriver(appUrl,browserName);
    }

    @Test
    public void TC_01_Empty() {
        basePage.openPageUrl(driver, appUrl);

        basePage.sendkeyToElement(driver, "//input[@name='username']", "");
        basePage.sendkeyToElement(driver, "//input[@name='password']", "");
        basePage.waitElementClickable(driver,"//button[contains(@class,'orangehrm-login-button')]");
        basePage.clickToElement(driver, "//button[contains(@class,'orangehrm-login-button')]");

        Assert.assertEquals(basePage.getElementText(driver, "//input[@name='username']/parent::div/following-sibling::span"), "Required");
        Assert.assertEquals(basePage.getElementText(driver, "//input[@name='password']/parent::div/following-sibling::span"), "Required");
    }

    @Test
    public void TC_02_Invalid_Username() {
        basePage.openPageUrl(driver, appUrl);

        basePage.sendkeyToElement(driver, "//input[@name='username']", "duyen@gmail.com");
        basePage.sendkeyToElement(driver, "//input[@name='password']", "12345");
        basePage.clickToElement(driver, "//button[contains(@class,'orangehrm-login-button')]");

        Assert.assertEquals(basePage.getElementText(driver,"//div[@class='orangehrm-login-error']//p[contains(@class,'oxd-alert-content-text')]"),"Invalid credentials");
    }


    @Test
    public void TC_03_Invalid_Password() {
        basePage.openPageUrl(driver, appUrl);

        basePage.sendkeyToElement(driver, "//input[@name='username']", "Admin");
        basePage.sendkeyToElement(driver, "//input[@name='password']", "123455678");
        basePage.clickToElement(driver, "//button[contains(@class,'orangehrm-login-button')]");

        Assert.assertEquals(basePage.getElementText(driver,"//div[@class='orangehrm-login-error']//p[contains(@class,'oxd-alert-content-text')]"),"Invalid credentials");
    }

    @Test
    public void TC_04_Valid_Password() {
        basePage.openPageUrl(driver, appUrl);

        basePage.sendkeyToElement(driver, "//input[@name='username']", "Admin");
        basePage.sendkeyToElement(driver, "//input[@name='password']", "admin123");
        basePage.clickToElement(driver, "//button[contains(@class,'orangehrm-login-button')]");

        basePage.waitListElementInvisible(driver,"//div[contains(@class,'oxd-loading-spinner-container')]");
        //        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElement(By.cssSelector("div.oxd-loading-spinner"))));

//        Assert.assertTrue(isAllLoadingiconInvisible());
        Assert.assertEquals(basePage.getElementText(driver,"//div[@class='oxd-topbar-header-title']//h6"),"Dashboard");
    }

//    public boolean isAllLoadingiconInvisible() {}

//        return explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("div.oxd-loading-spinner"))));
}