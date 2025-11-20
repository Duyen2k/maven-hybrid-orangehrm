package ex_pageObject;

import core.BasePage;
import ex_pageUIs.AddAdminButtonUIs_Ex;
import ex_pageUIs.SearchAdminButtonPageUIs_Ex;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchAdminButtonPageObject_Ex extends BasePage {
    private WebDriver driver;

    public SearchAdminButtonPageObject_Ex(WebDriver driver) {
        this.driver = driver;
    }

    //Ko nên gọi hàm từ pageObject khác qua(bị tùy tiện)
    public void enterRegistedUserName(String keyToSend) {
        waitElementVisible(driver,SearchAdminButtonPageUIs_Ex.USER_NAME_TEXTBOX);
        sendkeyToElement(driver,SearchAdminButtonPageUIs_Ex.USER_NAME_TEXTBOX,keyToSend);
//        driver.findElement(By.xpath(SearchAdminButtonPageUIs_Ex.USER_NAME_TEXTBOX)).sendKeys("Admin");
    }

    public void enterRegistedUserRole(String userRole) {
        waitElementVisible(driver,SearchAdminButtonPageUIs_Ex.USER_ROLE_PARENT);
        selectItemInDropdownCustome(driver,SearchAdminButtonPageUIs_Ex.USER_ROLE_PARENT,SearchAdminButtonPageUIs_Ex.USER_ROLE_CHILDREN,userRole);
    }

    public void enterRegistedStatus(String status) { //tạm thời ko dùng
        waitElementVisible(driver,SearchAdminButtonPageUIs_Ex.STATUS_PARENT);
        selectItemInDropdownCustome(driver,SearchAdminButtonPageUIs_Ex.STATUS_PARENT,AddAdminButtonUIs_Ex.STATUS_CHILDREN,status);
    }

    public void clickToSearchButton() {
        waitElementVisible(driver,SearchAdminButtonPageUIs_Ex.SEARCH_BUTTON);
        clickToElement(driver,SearchAdminButtonPageUIs_Ex.SEARCH_BUTTON);
    }
}
