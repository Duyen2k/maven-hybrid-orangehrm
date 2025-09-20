package javaSDET;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Topic_08 {
    WebDriver driver;
    //Non-static: muốn dùng phải khởi tạo lại(new lại)
    String address="";

    //Static: phạm vi chia sẻ cho toàn bộ system sử dụng
    static String name="";

    //Là hằng s: ko được phép thay đổi(ko thể gán gtri khác)
    static final String AGE="52";

    @Test
    public void TC_01() {
        //Đối tượng là tp(thộc phạm vi đối tượng), phải new lại mơ dùng được cái address
        Topic_08 tp=new Topic_08();
        tp.address="";

        //Còn name nó thuộc phạm vi class nên dùng trư tiếp luôn
        Topic_08.name="";

//        Topic_08.AGE=""; => là hằng số, ko thể gán lai



        String osName = "Window 11";
        String separator = null;

        //Condition Statement
        //if-else
        if (osName.contains("Windows")) {
            separator = "\\";
        } else {
            separator = "/";
        }

        String browserName = "Chrome";
        //switch-case
        switch (browserName) {
            case "Chrome":
                driver = new ChromeDriver();
                break;
            case "Firefox":
                driver = new FirefoxDriver();
                break;
            case "Edge":
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Browser name is not support");
        }

        //Loop Statement
        int studentNumber = 10;
        //Classic for(Interation for)
        //for
        for (int i = 0; i < studentNumber; i++) {
            if (i == 5) {
                System.out.println(i);
            }
        }

        List<String> stdName=new ArrayList<>();
        //for-each
        for(String std:stdName){
            System.out.println(std);
        }
        // while (): kiểm tra điều kiện trước rồi mới thực thi
        int x=0;
        while (x<studentNumber){
            System.out.println(x);
            x++;
        }
        //do-while: thực thi xong mới check điều kiên(TH này vẫn in ra đc 1 thằng 11)
        int z=10;
        do {
            System.out.println(z);
            z++;
        }while (z<studentNumber);

        //try-catch dùng để xử lý case lỗi expection
        //Nếu như ko tìm thấy thì cũng ko bị lỗi
        try{
            //Try:happy case
        driver.findElement(By.cssSelector("")).isDisplayed();
        }catch(NoSuchElementException exception){
            //catch:Edge case(unhappy case) làm TC bị fail, thì catch bắt lại=> testcase vẫn chạy và log ra lỗi
            System.out.println(exception.getMessage());
        } finally {
            //Close connection: db/file/...Nếu có thì bắt buộc chạy qua, dù try hay catch
        }
        //throw

    }
}
