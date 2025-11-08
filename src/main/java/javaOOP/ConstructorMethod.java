package javaOOP;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConstructorMethod {
    public static void main(String[] args){
        FirefoxDriver ffDriver;

        //1
        ffDriver=new FirefoxDriver();

        //2
        FirefoxOptions ffOption=new FirefoxOptions();
        ffOption.addArguments("--headless");
        ffDriver = new FirefoxDriver(ffOption);

        //3
        WebDriverWait explicit;
        explicit=new WebDriverWait(ffDriver, Duration.ofSeconds(10));
        //Duration 1s: 1s lặp lại tìm 1 lần
        explicit=new WebDriverWait(ffDriver,Duration.ofSeconds(10),Duration.ofSeconds(1));
    }

    public void firstMethod(){
        String name;
        int number;
    }

    //Phạm vi khai báo biến trong khối code thì nớ mới hiểu
    public void secondMethod(String name,int number){
        if (name.equals("Automation")){
            int second=15;
            System.out.println(second); //Nếu viết ra ngaofi block này báo lỗi ngay
        }
    }
}
