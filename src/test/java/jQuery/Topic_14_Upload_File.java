package jQuery;

import core.BasePage;
import core.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.PageGenerator;
import pageObjects.jQuery.UploadPO;

public class Topic_14_Upload_File extends BaseTest {
    private WebDriver driver;

    @Parameters({"appUrl","browser"})
    @BeforeClass
    public void beforeClass(String appURL, String browserName){
        driver=getBrowserDriver(appURL,browserName);
        uploadPage= PageGenerator.getPage(UploadPO.class,driver);
    }

    @Test(enabled = false)
    public void uploadFile_Single_01(){
        //Load file len
        uploadPage.uploadMultipleFiles(driver,LemonName);

        //Verify load file len thanh cong
        Assert.assertTrue(uploadPage.isFileLoadedSuccess(LemonName));

        //Click start button de upload
        uploadPage.clickStartbutton();

        //Verify upload file thanh cong
        Assert.assertTrue(uploadPage.isFileUploadedSuccess(LemonName));
    }

    @Test
    public void uploadFile_Multiple(){
        //Load file len
        uploadPage.uploadMultipleFiles(driver,LemonName);
        uploadPage.uploadMultipleFiles(driver,PeonyName);
        uploadPage.uploadMultipleFiles(driver,SantoriniName);

        //Verify load file len thanh cong
        Assert.assertTrue(uploadPage.isFileLoadedSuccess(LemonName));
        Assert.assertTrue(uploadPage.isFileLoadedSuccess(PeonyName));
        Assert.assertTrue(uploadPage.isFileLoadedSuccess(SantoriniName));

        //Click start button de upload
        uploadPage.clickStartbutton();

        //Verify upload file thanh cong
        Assert.assertTrue(uploadPage.isFileUploadedSuccess(LemonName));
        Assert.assertTrue(uploadPage.isFileUploadedSuccess(PeonyName));
        Assert.assertTrue(uploadPage.isFileUploadedSuccess(SantoriniName));
        
    }

    @AfterClass
    public void afterClass(){

    }

    private UploadPO uploadPage;
    private String LemonName= "LemonIMG.jpg";
    private String PeonyName= "PeonyIMG.jpg";
    private String SantoriniName= "SantoriniIMG.jpg";
}
