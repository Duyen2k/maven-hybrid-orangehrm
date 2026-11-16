import com.github.javafaker.Faker;

import java.util.Locale;

public class Topic_02_DataFaker {
    public static void main(String[] args){
        Faker faker=new Faker();

        Faker fakerVi=new Faker(new Locale("vi"));

//        System.out.println(faker.address().firstName());
//        System.out.println(faker.address().lastName());
//        System.out.println(faker.address().country());
//        System.out.println(faker.address().state());
//        System.out.println(faker.address().zipCode());
//        System.out.println(faker.address().timeZone());
//        System.out.println(faker.address().longitude());
//        System.out.println(faker.address().latitude());


        System.out.println(fakerVi.address().firstName());
        System.out.println(fakerVi.address().lastName());

        System.out.println(fakerVi.name().firstName());
        System.out.println(fakerVi.name().lastName());
        System.out.println(fakerVi.name().name());

    }


}
