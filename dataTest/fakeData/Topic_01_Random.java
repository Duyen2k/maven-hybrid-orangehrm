import java.util.Calendar;
import java.util.Random;

public class Topic_01_Random {
    //Email: Ten + @ + domain name + top domain

    public static void main(String[] args){
        System.out.println(getEmailAddress());
        System.out.println(getUniqueEmailAddress());
        System.out.println(getEmailAddress("autotesting"));
        System.out.println(getEmailAddress("testing","@google.com"));
    }

    public static String getEmailAddress(){
        return  "automationtesting" + new Random().nextInt(99999)+"@gmail.com";

    }

    public static String getUniqueEmailAddress(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e){
        throw new RuntimeException(e);
        }
        return  "automationtesting" + Calendar.getInstance().getTimeInMillis() % 100000 +"@gmail.com";

    }


    public static String getEmailAddress(String fullName){
        return  fullName + new Random().nextInt(99999)+"@gmail.com";

    }

    public static String getEmailAddress(String fullName, String mailServer){
        return  fullName + new Random().nextInt(99999) + mailServer;
    }
}
