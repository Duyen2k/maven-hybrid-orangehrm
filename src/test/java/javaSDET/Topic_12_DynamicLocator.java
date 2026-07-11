package javaSDET;

import org.testng.annotations.Test;

@Test
public class Topic_12_DynamicLocator {
    public void testDynamicLocator(){
    //Page cụ thể: Personal Details
        String locator ="xpath=//a[text()='Personal Details']";

        String dynamicPageOneParam="xpath=//a[text()='%s']";
        String dynamicPageTwoParam="xpath=//a[text-%s-()='%s']";
        String dynamicPageThreeParam="xpath=//a[text-%s-()='%s']";

    //Mở trang cụ thể:
        openPage(locator);

    //1 - tham số động
        openPageByNameWith1Param(dynamicPageOneParam,"Personal Details");

    //2 - tham số động
        openPageByNameWith2Param(dynamicPageTwoParam,"edit","Personal Details");

    //3 - tham số động


    }

    public void openPage(String pageLocator){
        System.out.println("Click to Page"+ String.format(pageLocator));
    }

    public void openPageByNameWith1Param(String pageLocator, String pageName){
        System.out.println("Click to Page1"+ String.format(pageLocator,pageName));
    }

//    public void openPageByNameWith2Param(String pageLocator, String functionName, String pageName){
//        System.out.println("Click to Page2"+ String.format(pageLocator,functionName,pageName));
//    }

    //Dùng restParam vẫn lấy được dù dùng bao nhiêu tham số(hay chỉ có 1 tham số)
    public void openPageByNameWith2Param(String pageLocator, String...restParam){
        System.out.println("Click to Page2"+ String.format(pageLocator, (Object[]) restParam));
    }
}
