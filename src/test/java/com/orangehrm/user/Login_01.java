package com.orangehrm.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Login_01 {
    WebDriver driver;
@BeforeClass
    public void beforeClass(){
    driver=new FirefoxDriver();
    driver.get("https://opensource-demo.orangehrmlive.com/");
    driver.manage().window().maximize();
}

@Test
    public void TC_01_Login(){

}
}
