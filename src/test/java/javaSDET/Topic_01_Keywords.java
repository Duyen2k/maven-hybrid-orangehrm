package javaSDET;
//Class-class: cùng kiểu - kế thừa:extend
//Một class-kế thừa một Interface-> sủ dụng implement

//Đây là những hàm non-abstract: ko có các từ khóa abstract
//Không được có abtract method
//Khởi tạo bình thường
//Cho phép kế thừa

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Topic_01_Keywords extends Topic_06 implements Topic_02 {
    //Data type
    int i=1234;
    char c='A';
    byte bNumber=10;
    long iNumber=2345644;

    float fNumber=15.99F;
    double dNumber=19.39934D;
    boolean maritalStatus=true;

    //Access modifier

    //Variableb( biến)
    private String studentName="";
    String studentAddress="";
    protected int studentAge=30;
    public double studentPoint=9.5;

    //Method
    private void TC_01(){
        WebDriver driver=new FirefoxDriver();
        Topic_01_Keywords topic=new Topic_01_Keywords();
//        Topic_06 topic06=new Topic_06() : sẽ bị lỗi do là abstract class
    }

    void TC_02(){
    }

    protected void TC_03(){
    }

    public void TC_04(){
    }

    @Override
    public void clearStudent() {

    }

    //Class/Interface/Enum/Annotation/Record
}
