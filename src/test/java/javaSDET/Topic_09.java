package javaSDET;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_09 {
    String name;

    //Constructor: hàm khởi tạo

    public Topic_09(String name) {
        this.name = name;
    }

    //Khi chạy đa luồng và gọi ến hàm này thì phải chạy theo thứ tự(áp dụng khi chạy đa luồng)
    public synchronized WebDriver getDriver(){
        WebDriver driver=null;

        if(driver instanceof WebDriver){
            //Action
            driver=new FirefoxDriver();
        }
        return driver;
    }
}
