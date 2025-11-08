package javaFactory;

public class EndUser {
    public static void main(String[] args){
        //CarFactory
        Car car=null;
        //Morning
//        Honda honda=new Honda();
//        honda.viewCar();
//        honda.driveCar();

        //Muốn xem thằng nào thì truyền tên thằng đó vào
        car=getCar("Honda");
        car.viewCar();
        car.driveCar();

        //Afternoon
        Toyota toyota=new Toyota();
        toyota.viewCar();
        toyota.driveCar();

        Huyndai huyndai=new Huyndai();
        huyndai.viewCar();
        huyndai.driveCar();

    }

    public static Car getCar(String carName){
        Car car=null;

        switch (carName){
            case "Honda":
                car=new Honda();
                break;
            case "Huyndai":
                car=new Huyndai();
                break;
            case "Toyota":
                car=new Toyota();
                break;
            case "Ford":
                car=new Ford();
                break;
            default: throw new RuntimeException("No car is supported");
        } return car;
    }
}
