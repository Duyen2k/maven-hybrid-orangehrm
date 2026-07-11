package javaSDET;

import org.testng.annotations.Test;

@Test
public class Topic_13_DataTable {

    public void dynamicLocator() {
        String pageLocator = "xpath=//td[@class='qgrd-actions']/following-sibling::td[@data-key='females' and text()='%s']/following-sibling::td[@data-key='country' and text()='%s']" +
                "/following-sibling::td[@data-key='males' and text()='%s']/following-sibling::td[@data-key='total' and text()='%s']";


        openHomePage(pageLocator, "384187", "Afghanistan","407124","791312");
    }


    public void openHomePage(String pageLocator,String...restParam){
        System.out.println("Click to page"+ String.format(pageLocator, (Object[]) restParam));
    }

}
