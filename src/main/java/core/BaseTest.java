package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import reportConfig.VerificationFailures;

import java.time.Duration;

public class BaseTest {
    private WebDriver driver;

    protected WebDriver getBrowserDriver(String appUrl,String browserName){
        BrowserList browserList=BrowserList.valueOf(browserName.toUpperCase());
        switch (browserList){
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case CHROME:
                driver=new ChromeDriver();
                break;
            case EDGE:
                driver=new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Browser name is invalid");
        }

        driver.get(appUrl);
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }

    protected void closeBrowser(WebDriver driver){
        if(!(null==driver));
        driver.quit();
    }

    protected boolean verifyTrue(boolean condition) {
        boolean pass = true;
        try {
            Assert.assertTrue(condition);
        } catch (Throwable e) {
            pass = false;

            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyFalse(boolean condition) {
        boolean pass = true;
        try {
            Assert.assertFalse(condition);
        } catch (Throwable e) {
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyEquals(Object actual, Object expected) {
        boolean pass = true;
        try {
            Assert.assertEquals(actual, expected);
        } catch (Throwable e) {
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }

    protected boolean verifyNotEquals(Object actual, Object expected) {
        boolean pass = true;
        try {
            Assert.assertNotEquals(actual, expected);
        } catch (Throwable e) {
            pass = false;
            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
            Reporter.getCurrentTestResult().setThrowable(e);
        }
        return pass;
    }
}
