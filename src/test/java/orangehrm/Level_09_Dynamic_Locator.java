package orangehrm;
//import từ thư viện

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Level_09_Dynamic_Locator  {

    @BeforeClass
    public void beforeClass(){
    }

    @Test
    public static void main(String[] args){
        String dynamicLocator= String.format("Xpath=//a[text()='%s']");

//        System.out.println();
    }

    @Test
    public void constLocator(){

    }

    @AfterClass
    public void afterClass(){

}
}
