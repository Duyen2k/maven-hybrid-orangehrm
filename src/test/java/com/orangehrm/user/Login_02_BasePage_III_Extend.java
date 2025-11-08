package com.orangehrm.user;
//import từ thư viện

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Login_02_BasePage_III_Extend extends BasePage {
    private WebDriver driver;
    private String appUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";


    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();

        //Ko cần new Basepage=> đảm bảo tính đóng gói(lập trình hướng đối tượng)-ko nhìn thấy khởi tạp trực tiếp
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void TC_01_Empty() {
        openPageUrl(driver, appUrl);

        sendkeyToElement(driver, "//input[@name='username']", "");
        sendkeyToElement(driver, "//input[@name='password']", "");
        waitElementClickable(driver,"//button[contains(@class,'orangehrm-login-button')]");
        clickToElement(driver, "//button[contains(@class,'orangehrm-login-button')]");

        Assert.assertEquals(getElementText(driver, "//input[@name='username']/parent::div/following-sibling::span"), "Required");
        Assert.assertEquals(getElementText(driver, "//input[@name='password']/parent::div/following-sibling::span"), "Required");
    }

    @Test
    public void TC_02_Invalid_Username() {
        openPageUrl(driver, appUrl);

        sendkeyToElement(driver, "//input[@name='username']", "duyen@gmail.com");
        sendkeyToElement(driver, "//input[@name='password']", "12345");
        clickToElement(driver, "//button[contains(@class,'orangehrm-login-button')]");

        Assert.assertEquals(getElementText(driver,"//div[@class='orangehrm-login-error']//p[contains(@class,'oxd-alert-content-text')]"),"Invalid credentials");
    }


    @Test
    public void TC_03_Invalid_Password() {
        openPageUrl(driver, appUrl);

        sendkeyToElement(driver, "//input[@name='username']", "Admin");
        sendkeyToElement(driver, "//input[@name='password']", "123455678");
        clickToElement(driver, "//button[contains(@class,'orangehrm-login-button')]");

        Assert.assertEquals(getElementText(driver,"//div[@class='orangehrm-login-error']//p[contains(@class,'oxd-alert-content-text')]"),"Invalid credentials");
    }

    @Test
    public void TC_04_Valid_Password() {
        openPageUrl(driver, appUrl);

        sendkeyToElement(driver, "//input[@name='username']", "Admin");
        sendkeyToElement(driver, "//input[@name='password']", "admin123");
        clickToElement(driver, "//button[contains(@class,'orangehrm-login-button')]");

        waitListElementInvisible(driver,"//div[contains(@class,'oxd-loading-spinner-container')]");
        //        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElement(By.cssSelector("div.oxd-loading-spinner"))));

//        Assert.assertTrue(isAllLoadingiconInvisible());
        Assert.assertEquals(getElementText(driver,"//div[@class='oxd-topbar-header-title']//h6"),"Dashboard");
    }

//    public boolean isAllLoadingiconInvisible() {}

//        return explicitWait.until(ExpectedConditions.invisibilityOfAllElements(driver.findElements(By.cssSelector("div.oxd-loading-spinner"))));
}