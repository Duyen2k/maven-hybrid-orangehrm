package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
}
