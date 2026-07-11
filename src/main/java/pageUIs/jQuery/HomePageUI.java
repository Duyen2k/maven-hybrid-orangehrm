package pageUIs.jQuery;

public class HomePageUI {
   public static final String PAGING_LINK_BY_NUMBER="xpath=//a[@class='qgrd-pagination-page-link' and text()='%s']";
   public static final String PAGING_LINK_BY_NUMBER_ACTIVE="xpath=//a[@class='qgrd-pagination-page-link active' and text()='%s']";
   public static final String SEARCH_INPUT="xpath=//div[text()='%s']/parent::div/following-sibling::input";
   public static final String ROW_ACTIVATE_BY_VALUE="xpath=//td[@data-key='females' and text()='%s']/" +
           "following-sibling::td[@data-key='country' and text()='%s']/" +
           "following-sibling::td[@data-key='males' and text()='%s']/" +
           "following-sibling::td[@data-key='total' and text()='%s']";

   public static final String ACTION_BY_COUNTRY_NAME="xpath=//td[@data-key='country' and text()='%s']//" +
           "preceding-sibling::td[@class='qgrd-actions']/button[@class='qgrd-%s-row-btn']";

   public static final String COLUMN_INDEX_BY_NAME="XPATH=//th[text()='%s']/preceding-sibling::th";
   public static final String CELL_TEXTBOX_INPUT_BY_COLUMN_AND_ROW_INDEX="xpath=//tr[%s]/td[%s]/input";
   public static final String CELL_DROPDOWN_SELECTION_BY_COLUMN_AND_ROW_INDEX="xpath=//tr[%s]/td[%s]/div/select";
   public static final String ALL_PAGING_LINK="xpath=//li[@class='qgrd-pagination-page']/a";
   public static final String COLUMN_INDEX_BY_COLUMN_NAME="xpath=//div[@class='qgrd-header-text' and text()='%s']/ancestor::th/preceding-sibling::th";
   public static final String COLUMN_INDEX="xpath=//td[%s]";

}
