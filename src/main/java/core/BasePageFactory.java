package core;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePageFactory {
    
    //Vì bên PageFacory đã tạo hàm với WebElement rồi nên bên đây ko dùng locator
    //Mà dùng WebElement element

    //Viết cho By.xpath

    public void clickToElement(WebDriver driver,WebElement element) {
//        driver.findElement(By.xpath(locator)).click();
        //Viết thế này tái sdung code-> ít lặp lại
        element.click();
    }

    public void sendkeyToElement(WebDriver driver,WebElement element,String keyToSend){
        element.clear();
        element.sendKeys(keyToSend);
    }



    public String getElementDOMAttribute(WebElement element,String atributeName){
        return element.getDomAttribute(atributeName);
    }

    public String getElementDOMProperty(WebElement element,String atributeName){
        return element.getDomProperty(atributeName);
    }

    public String getElementText(WebDriver driver,WebElement element){
        return element.getText();
    }


    public boolean isElementDisplayed(WebDriver driver,WebElement element){
        return element.isDisplayed();
    }

    public boolean isElementSeBlected(WebDriver driver,WebElement element){
        return element.isSelected();
    }

    public boolean isElementEnable(WebDriver driver,WebElement element){
        return element.isEnabled();
    }

    public void waitElementVisible(WebDriver driver,WebElement element){
        new WebDriverWait(driver,Duration.ofSeconds(LONG_TIMEOUT)).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitListElementVisible(WebDriver driver,List<WebElement> elements){
        new WebDriverWait(driver,Duration.ofSeconds(LONG_TIMEOUT)).until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public void waitElementSelected(WebDriver driver,WebElement element){
        new WebDriverWait(driver,Duration.ofSeconds(LONG_TIMEOUT)).until(ExpectedConditions.elementToBeSelected(element));
    }

    public void waitElementClickable(WebDriver driver,WebElement element){
        new WebDriverWait(driver,Duration.ofSeconds(LONG_TIMEOUT)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitElementInvisible(WebDriver driver, List<WebElement> element){
        new WebDriverWait(driver,Duration.ofSeconds(LONG_TIMEOUT)).until(ExpectedConditions.invisibilityOf((WebElement) element));
    }

    public boolean waitListElementInvisible(WebDriver driver,List<WebElement> elements){
       return new WebDriverWait(driver,Duration.ofSeconds(LONG_TIMEOUT)).until(ExpectedConditions.invisibilityOfAllElements(elements));
    }

    //Khá mất công nếu khai báo ở đây, vì phải khai báo thêm qua hàm trung gian => khai báo từng nơi sdung một
//    public boolean isLoadingIconDisappear(WebDriver driver, List<WebElement> elements){
//       return waitListElementInvisible(driver, elements);
//    }

    private final int SHORT_TIMEOUT = 10;
    private final int LONG_TIMEOUT = 30;

    }
