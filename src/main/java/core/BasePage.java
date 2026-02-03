package core;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.PageGenerator;
import pageObjects.openCart.admin.AdminLoginPO;
import pageObjects.openCart.user.UserHomePO;
import pageUIs.openCart.CommonOpenCartPageUI;
import pageUIs.orangHRM.BasePageUI;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {

    //1-Acess Modifier:
    // public: Tất cả các class trong cùng/khác package đều sử dụng được các hàm này
    //Chỉ muốn cho class nào kế thừa mới dùng thôi -> ko dùng public
    //protected: chỉ class nào kế thừa mới dùng
    //private: chỉ cho các hàm  trong cùng class này sử dụng
    //default: chỉ cho các class trong cùng package sử dụng => ko dùng default

    //2-Kiểu dữ liệu của hàm (data type): void/int/String/boolean/WebElement/List <WebElement>/...
    // Nó sẽ liên quan đến cái chức năng mình đang cần viết
    //Mình dùng cái hàm nào của Selenium thì nó trả về cái gì => Define kiểu dữ liệu của hàm tương ứng

    //3-Tên hàm: đặt tên có nghĩa theo chức năng đang cần viết
    //Convention tuân theo tiêu chuẩn của từng ngôn ngữ lập trình(Java)
    //lowerCamelCase: từ đâ tiên viết thường - chữ cái đầu tiên của các từ tiếp theo sẽ viết hoa

    //4- Có tham số hay không(tùy vào chức năng cần viết)
    //Dùng cái hàm nào của Selenium

    //5- Kiểu đữ liệu trả về cho hàm
    //Nếu như có return dữ liệu thì sẽ khớp vs kiểu dữ liệu ở số 2
    //Nếu như có return thì nó là cái step cuối cùng


    //Hàm static có nhiệm vụ lấy ra instance của chính class này
    //Một biến static /hàm của static có thể gọi ra trực tiếp từ phạm vi class
    public static BasePage getBasePage(){return new BasePage();}

    public void openPageUrl(WebDriver driver,String pageUrl){
        driver.get(pageUrl);
    }

    //Ngoại trừ kiểu dữ liệu hàm là void: tất cả những thằng khác đều cần return
    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getPageUrl(WebDriver driver){
        return driver.getCurrentUrl();
    }

    public String getPageSource(WebDriver driver){
        return driver.getPageSource();
    }

    public void backToPage(WebDriver driver){
        driver.navigate().back();
    }

    public void forwardToPage(WebDriver driver){
        driver.navigate().forward();
    }

    public void refreshPage(WebDriver driver){
        driver.navigate().refresh();
    }

//**Alert
    public Alert waitAlertPresence(WebDriver driver){
        return new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.alertIsPresent());
    }

    public void acceptToAlert(WebDriver driver){
        //Do đoan trên alertIsPresent đã có switchTo rồi nên dưới này mình accept luôn để tránh lặp code
//        driver.switchTo().alert().accept(); => như sau:
        waitAlertPresence(driver).accept();
    }

    public void cancelToAlert(WebDriver driver){
        waitAlertPresence(driver).dismiss();
    }

    public void sendkeyToAlert(WebDriver driver){
        waitAlertPresence(driver).sendKeys("");
    }

    public String getAlertText(WebDriver driver) {
      return waitAlertPresence(driver).getText();
    }

    public void sleepInSecond(int timeInSecond){
        try { //dùng try/catch để ko pahir throw ra
            Thread.sleep(timeInSecond*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public void closeAllExceptMainWindow(WebDriver driver,String GithubID) throws InterruptedException {
        Set<String> allWindow=driver.getWindowHandles();
        for(String otherWindow:allWindow){
            //Nếu WindowID khác GithubID thì close Tab
            if(!otherWindow.equals(GithubID)){
                driver.switchTo().window(otherWindow);
                Thread.sleep(2000);
                driver.close();
                Thread.sleep(2000);
                //Ko dùng break, để quét hết các Tab
            }
        }
    }

    //Chỉ có thể dùng cho duy nhất 2 window
    public void switchToWindowByID(WebDriver driver,String GitWindow) {
        Set<String> allWindows=driver.getWindowHandles();
        for(String googlewindow:allWindows){
            if(!googlewindow.equals(GitWindow)){
                driver.switchTo().window(googlewindow);
                break;
            }
        }
    }

    //Dùng cho từ 2 Tab trở lên(All trường hợp đều dùng đc)
    public void switchToWindowByTitle(WebDriver driver,String expectedTitle) {
        //Lấy ra windowID cửa 2 cứa sổ/Tab
        Set<String> allWindows = driver.getWindowHandles();
        //Duyệt qua từng ID
        for (String window : allWindows) {
            //Switch trước vào từng Window
            driver.switchTo().window(window);
            //Lấy ra pageTitle đang active
            String pageTitle = driver.getTitle();
            //Nếu pageTitle hiện tại bằng vs Title mong đợi=> thì break luôn
            if (pageTitle.equals(expectedTitle)) {
                break;
            }
        }
    }

    public void switchToWindowByTitleContains(WebDriver driver,String expectedTitle) {
        //Lấy ra windowID cửa 2 cứa sổ/Tab
        Set<String> allWindows = driver.getWindowHandles();
        //Duyệt qua từng ID
        for (String window : allWindows) {
            //Switch trước vào từng Window
            driver.switchTo().window(window);
            //Lấy ra pageTitle đang active
            String pageTitle = driver.getTitle();
            //Nếu pageTitle hiện tại bằng vs Title mong đợi=> thì break luôn
            if (pageTitle.contains(expectedTitle)) {
                break;
            }
        }
    }

    //Viết cho By.xpath
    private By getByXpath(String locator){
        return By.xpath(locator);
    }

    private WebElement getWebElement(WebDriver driver,String locator){
        return driver.findElement(By.xpath(locator));
    }

    private List<WebElement> getListElement(WebDriver driver,String locator){
        return driver.findElements(By.xpath(locator));
    }

    public void clickToElement(WebDriver driver,String locator) {
//        driver.findElement(By.xpath(locator)).click();
        //Viết thế này tái sdung code-> ít lặp lại
        getWebElement(driver,locator).click();
    }

    public void sendkeyToElement(WebDriver driver,String locator,String keyToSend){
//        driver.findElement(By.xpath(locator)).sendKeys(keyToSend);
        getWebElement(driver,locator).sendKeys(keyToSend);
    }

    public void selectItemInDropdownSelection(WebDriver driver,String locator,String valueItem){
//        Select select=new Select(getWebElement(driver,locator));
//        select.selectByVisibleText(valueItem);  => dùng một lần nên gọi trực tiếp luôn ko cần khai báo

        new Select(getWebElement(driver,locator)).selectByVisibleText(valueItem);
    }

    public String getSelectedItem(WebDriver driver,String locator){
        return new Select(getWebElement(driver,locator)).getFirstSelectedOption().getText();
    }

    public boolean isDropdownMultiple(WebDriver driver,String locator){
        return new Select(getWebElement(driver,locator)).isMultiple();
    }

    public void selectItemInDropdownCustome(WebDriver driver,String parentLocator, String childLocator, String textItem)  {
//        clickToElement(driver,parentLocator);
        driver.findElement(By.xpath(parentLocator)).click();

//        sleepInSecond(2); throws InterruptedException
        //đợi xổ hết dữ liệu
        new WebDriverWait(driver, Duration.ofSeconds(LONG_TIMEOUT)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(childLocator)));
        //list ra tất cả các item bên trong và lưu vào một biê(kiểu dữ liệu là List)
        //Tips: Lấy locator pahir lấy đến cái thẻ chứa Text của item (vì mình đang getText)
        List<WebElement> Allitem = getListElement(driver,childLocator);
        //Duyệt qua từng cái element để kiểm tra
        for (WebElement item: Allitem ){
            //Kiêm tra điều kiện: nếu text của item lấy ra bằng với mong đợi
            if (item.getText().equals(textItem)){
                item.click();
                break;
            }
        }
    }

    public String getElementDOMAttribute(WebDriver driver,String locator,String atributeName){
        return getWebElement(driver,locator).getDomAttribute(atributeName);
    }

    public String getElementDOMProperty(WebDriver driver,String locator,String atributeName){
        return getWebElement(driver,locator).getDomProperty(atributeName);
    }

    public String getElementText(WebDriver driver,String locator){
        return getWebElement(driver,locator).getText();
    }


    public String getElementCss(WebDriver driver,String locator,String propertyName){
       return getWebElement(driver,locator).getCssValue(propertyName);
    }

    public String getHexbYrgba(String rgbaColor){
        return Color.fromString(rgbaColor).asHex().toUpperCase();
    }

    public int getElementsNumber(WebDriver driver,String locator){
        return getListElement(driver,locator).size();
    }

    public void checkToCheckbox(WebDriver driver,String locator){
        if (!isElementSelected(driver,locator)){
            getWebElement(driver,locator).click();
        }
    }

    public void uncheckToCheckbox(WebDriver driver,String locator){
        if (isElementSelected(driver,locator)){
            getWebElement(driver,locator).click();
        }
    }

    public boolean isElementDisplayed(WebDriver driver,String locator){
        waitElementVisible(driver,locator);
        return getWebElement(driver,locator).isDisplayed();
    }

    public boolean isElementSelected(WebDriver driver,String locator){
        waitElementSelected(driver,locator);
        return getWebElement(driver,locator).isSelected();
    }

    public boolean isElementEnable(WebDriver driver,String locator){
        return getWebElement(driver,locator).isEnabled();
    }

    //ko cần trả về kiểu driver, vì khi switch nó sẽ tự chuyển sang
    public void switchToFrame(WebDriver driver,String locator){
        driver.switchTo().frame(getWebElement(driver,locator));
    }

    public void switchToDefaultContent(WebDriver driver,String locator){
        driver.switchTo().defaultContent();
    }

    public void doubleClick(WebDriver driver,String locator){
        new Actions(driver).doubleClick(getWebElement(driver,locator)).perform();
    }

    public void rightClick(WebDriver driver,String locator){
        new Actions(driver).contextClick(getWebElement(driver,locator)).perform();
    }

    public void moveToElement(WebDriver driver,String locator){
        new Actions(driver).moveToElement(getWebElement(driver,locator)).perform();
    }

    public void dragAndDrop(WebDriver driver,String sourcceLocator,String targetLocator){
        new Actions(driver).dragAndDrop(getWebElement(driver,sourcceLocator),
                getWebElement(driver,targetLocator)).perform();
    }

    public void sendKeyboardToElement(WebDriver driver, String locator, Keys key){
        new Actions(driver).sendKeys(getWebElement(driver,locator),key).perform();
    }

    public Object executeForBrowser(WebDriver driver,String javaScript) {
        return ((JavascriptExecutor) driver).executeScript(javaScript);
    }

    public void scrollToBottomPage(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }


    public void hightlightElement(WebDriver driver,String locator) {
        WebElement element = getWebElement(driver,locator);
        String originalStyle = getElementDOMAttribute(driver,locator,"Style");
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSecond(2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS(WebDriver driver,String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(driver,locator));
        sleepInSecond(3);
    }

    public String getElementTextByJS(WebDriver driver,String locator) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].textContent;", getWebElement(driver,locator));
    }

    public void scrollToElementOnTop(WebDriver driver,String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver,locator));
        sleepInSecond(1);
    }

    public void scrollToElementOnDown(WebDriver driver,String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getWebElement(driver,locator));
    }

    public String getAttributeInDOM(WebDriver driver,String locator, String attributeName) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].getAttribute('" + attributeName + "');", getWebElement(driver,locator));
    }

    public String getElementValidationMessage(WebDriver driver,String locator) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getWebElement(driver,locator));
    }

    public boolean isImageLoaded(WebDriver driver,String locator) {
         return (boolean) ((JavascriptExecutor) driver).executeScript(
                "return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getWebElement(driver,locator));

    }

    public void waitElementVisible(WebDriver driver,String locator){
        new WebDriverWait(driver,Duration.ofSeconds(LONG_TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public void waitListElementVisible(WebDriver driver,String locator){
        new WebDriverWait(driver,Duration.ofSeconds(LONG_TIMEOUT)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locator)));
    }

    public void waitElementSelected(WebDriver driver,String locator){
        new WebDriverWait(driver,Duration.ofSeconds(LONG_TIMEOUT)).until(ExpectedConditions.elementToBeSelected(By.xpath(locator)));
    }

    public void waitElementClickable(WebDriver driver,String locator){
        new WebDriverWait(driver,Duration.ofSeconds(LONG_TIMEOUT)).until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }

    public void waitElementInvisible(WebDriver driver,String locator){
        new WebDriverWait(driver,Duration.ofSeconds(LONG_TIMEOUT)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
    }

    public boolean waitListElementInvisible(WebDriver driver,String locator){
       return new WebDriverWait(driver,Duration.ofSeconds(LONG_TIMEOUT)).until(ExpectedConditions.invisibilityOfAllElements(getListElement(driver,locator)));
    }

    public void waitElementPresence(WebDriver driver,String locator){
        new WebDriverWait(driver,Duration.ofSeconds(LONG_TIMEOUT)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    public void waitListElementPresence(WebDriver driver,String locator){
        new WebDriverWait(driver,Duration.ofSeconds(LONG_TIMEOUT)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    public void openUrlByNewTAB(WebDriver driver, String url){
        driver.switchTo().newWindow(WindowType.TAB).get(url);
    }

    public void openUrlByNewWindown(WebDriver driver, String url){
        driver.switchTo().newWindow(WindowType.WINDOW).get(url);
    }

    public String getCurrentWindownID(WebDriver driver){
        return driver.getWindowHandle();
    }

    //OrangeHRM
    public boolean isLoadingIconDisappear(WebDriver driver){
       return waitListElementInvisible(driver, BasePageUI.SPINER_ICON);
    }

    //OpenCart
    //Vì tất cả các thằng đều có thể logout
    public UserHomePO clickToLogoutLinkAtUserSite(WebDriver driver) {
        scrollToElementOnTop(driver, CommonOpenCartPageUI.MY_ACCOUNT_MODULE);
        waitElementClickable(driver, CommonOpenCartPageUI.MY_ACCOUNT_MODULE);
        clickToElement(driver, CommonOpenCartPageUI.MY_ACCOUNT_MODULE);
        sleepInSecond(1);

//        waitElementClickable(driver,CommonOpenCartPageUI.LOGOUT_LINK);
//        waitListElementInvisible(driver,CommonOpenCartPageUI.LIST_MODULE);
        waitElementClickable(driver,CommonOpenCartPageUI.LOGOUT_LINK);
        sleepInSecond(1);
        clickToElement(driver,CommonOpenCartPageUI.LOGOUT_LINK);

//        waitElementClickable(driver,CommonOpenCartPageUI.CONTINUE_BUTTON);
//        clickToElement(driver,CommonOpenCartPageUI.CONTINUE_BUTTON);

        return PageGenerator.getPage(UserHomePO.class,driver);
    }

    public AdminLoginPO clickToLogoutLinkAtAdminSite(WebDriver driver) {
        waitElementClickable(driver,CommonOpenCartPageUI.ADMIN_LOGOUT_BUTTON);
        clickToElement(driver,CommonOpenCartPageUI.ADMIN_LOGOUT_BUTTON);
        //wait clickable to Logout link
        //click to log out link
        return PageGenerator.getPage(AdminLoginPO.class,driver);
    }

    public void openAdminSite(WebDriver driver,String adminURL) {
        openPageUrl(driver, adminURL);
    }

    public UserHomePO openUserSite(WebDriver driver,String userURL) {
        openPageUrl(driver, userURL);
        return PageGenerator.getPage(UserHomePO.class,driver);
    }

    private final int SHORT_TIMEOUT = 10;
    private final int LONG_TIMEOUT = 30;
}
