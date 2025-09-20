package javaSDET;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public abstract class Topic_06 {
//Sẽ có cả hàm non-acstract và abstract
//Ko cho phép khởi tạo
//Chỉ cho phép kế thừa
//OOP: Abstraction(trừu tượng)

    //Lấy dữ liệu ra (khác void)-String la phải return
    public String getFullname(){
        WebDriver driver=new FirefoxDriver();
        driver.findElement(By.cssSelector("")).getText(); //Dùng để thực hiện lấy dữ liệu
        return null;
    }

    //Action(void): thường là những action thì dùng public void/ ko được return
    public void setFullname(){
        WebDriver driver=new FirefoxDriver();
        driver.getWindowHandle(); //Dùng để thực hiện action: VD: findElement,getTitle,...
    }

}
