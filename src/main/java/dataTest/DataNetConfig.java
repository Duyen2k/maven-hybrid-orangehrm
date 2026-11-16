package dataTest;

import com.github.javafaker.Faker;

public class DataNetConfig {
    private Faker faker=new Faker();

    public static DataNetConfig getDataConfig(){
        return new DataNetConfig();
    }

    public String getFirstName(){
        return faker.name().firstName();
    }

    public String getLastName(){
        return faker.name().lastName();
    }

    public String getName(){
        return faker.name().name();
    }

    public String getPassword(){
        return faker.internet().password(8,16,true,true,true);
    }


}

