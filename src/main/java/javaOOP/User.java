package javaOOP;

public class User {
    public static void main(String[] args) {
        //Khởi tạo: public class được kế thừa và khởi tạo
        Car car = new Car();
        car.setFullName();
        car.fullName="Honda Civic";

        Car secondCar=new Car();

        //Khởi tạo: ko được => abstract class được kế thừa nhuwg ko khởi tạo
//        Animal animal= new Animal();

        //Khởi tạo:final class-> ko được kế thừa, nhưng được khởi tạo
        Computer computer=new Computer();

        //Person: firstEmp: gọi là object hay instant/ person: gọi là class(ví dụ: Webdriver driver)
        Person firstEmp=new Person("John","27","NewYork");
        Person secondEmp=new Person("Marry","26","Italy");

    //Nếu thằng nào ko kế thừa mà vẫn muốn dùng thì phải khởi tạo lên: ko liên quan mqh cha-con
    //Còn kế thừa thì dùng đc các biến của thằng cha: phải có mqh cha-con
    }
}
