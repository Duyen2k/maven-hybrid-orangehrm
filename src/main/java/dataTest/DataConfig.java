package dataTest;

import com.github.javafaker.Faker;

public class DataConfig {
    private Faker faker=new Faker();

    public static DataConfig getDataConfig(){
        return new DataConfig();
    }

    public String getFirstName(){
         return faker.name().firstName();
    }

    public String getLastName(){
        return faker.name().lastName();
    }

    public String getPassword(){
        return faker.internet().password(8,16,true,true, true);
    }
}
