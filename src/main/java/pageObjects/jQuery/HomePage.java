package pageObjects.jQuery;

import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.PageGenerator;
import pageUIs.jQuery.HomePageUI;
import pageUIs.orangHRM.LoginPageUI;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPageByNumber(String pagingNumber) {
        waitElementVisible(driver, HomePageUI.PAGING_LINK_BY_NUMBER,pagingNumber);
        clickToElement(driver, HomePageUI.PAGING_LINK_BY_NUMBER,pagingNumber);
    }

    public boolean isPageActiveByClickNumber(String pageNumber) {
        waitElementVisible(driver,HomePageUI.PAGING_LINK_BY_NUMBER_ACTIVE,pageNumber);
    return isElementDisplayed(driver,HomePageUI.PAGING_LINK_BY_NUMBER_ACTIVE,pageNumber );
    }

    public void sendkeyToSearch(String headerName,String keyToSend) {
        waitElementVisible(driver,HomePageUI.SEARCH_INPUT,headerName);
        sendkeyToElement(driver,HomePageUI.SEARCH_INPUT,keyToSend,headerName);
        //Restparam ở cuối
    }

    public boolean isRowActiveByValue(String female, String country, String male, String total) {
        waitElementVisible(driver,HomePageUI.ROW_ACTIVATE_BY_VALUE,female,country,male,total);
        return isElementDisplayed(driver,HomePageUI.ROW_ACTIVATE_BY_VALUE,female,country,male,total);
    }

    public void clickToIconByCountryName(String countryName, String actionName) {
        waitElementClickable(driver,HomePageUI.ACTION_BY_COUNTRY_NAME,countryName,actionName);
        clickToElement(driver,HomePageUI.ACTION_BY_COUNTRY_NAME,countryName,actionName);
    }

    public void enterToTextboxByColumnNameAndRowIndex(String columnName, String rowIndex, String valueToEnter){
    //Dựa vào column name để lấy được Index của cột
        waitElementVisible(driver,HomePageUI.COLUMN_INDEX_BY_NAME,columnName);
        String columnIndex =String.valueOf(getListElementsSize(driver,HomePageUI.COLUMN_INDEX_BY_NAME,columnName) +1);

    //Sendkey
        waitElementVisible(driver,HomePageUI.CELL_TEXTBOX_INPUT_BY_COLUMN_AND_ROW_INDEX,rowIndex,columnIndex);
        sendkeyToElement(driver,HomePageUI.CELL_TEXTBOX_INPUT_BY_COLUMN_AND_ROW_INDEX,valueToEnter,rowIndex,columnIndex);
    }

    public void selectToDropdownByColumnNameAndBrowserIndex(String columnName, String rowIndex, String selectedValue) {
    //Dựa vào column name để lấy được Index của cột
        waitElementVisible(driver,HomePageUI.COLUMN_INDEX_BY_NAME,columnName);
        String columnIndex=String.valueOf(getListElementsSize(driver,HomePageUI.COLUMN_INDEX_BY_NAME,columnName)+1);
    //SelectItemInDropdown
        waitElementClickable(driver,HomePageUI.CELL_DROPDOWN_SELECTION_BY_COLUMN_AND_ROW_INDEX,rowIndex,columnIndex);
        selectItemInDropdownSelection(driver,HomePageUI.CELL_DROPDOWN_SELECTION_BY_COLUMN_AND_ROW_INDEX,selectedValue,rowIndex,columnIndex);
    }

    public List<String> getAllValueByColumnName(String columnName) {

        List<WebElement> allPaging = getListElement(driver, HomePageUI.ALL_PAGING_LINK);
        List<String> allPageValue = new ArrayList<String>();

        String columnIndex = String.valueOf(getListElementsSize(driver, HomePageUI.COLUMN_INDEX_BY_COLUMN_NAME, columnName)+1);

        for (WebElement page : allPaging) {
            page.click();

            List<WebElement> columnAllValue = getListElementDynamic(driver, HomePageUI.COLUMN_INDEX, columnIndex);

            for (WebElement value : columnAllValue) {
                allPageValue.add(value.getText());
            }

            for (String value:allPageValue){
                System.out.println(value);
            }
        }
        return allPageValue;
    }

}
