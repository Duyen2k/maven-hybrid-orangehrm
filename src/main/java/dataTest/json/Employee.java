package dataTest.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.GlobalConstants;

import java.io.File;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Employee {
    public static Employee getEmployee() {
        try {

            ObjectMapper mapper = new ObjectMapper();
            //mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(new File(GlobalConstants.JSON_DATA_TEST_PATH+"employee.json"), Employee.class);
        } catch (Exception ex) {
            ex.printStackTrace();
//            return null;
            throw new RuntimeException("Không thể đọc được file employee.json tại đường dẫn trên!", ex);
        }
    }

    @JsonProperty("adminUsername")
    private String adminUsername;

    @JsonProperty("adminPassword")
    private String adminPassword;


    public static class NewEmployee{
        @JsonProperty("firstname")
        private String firstName;

        @JsonProperty("lastname")
        private String lastName;

        @JsonProperty("email")
        private String emailAddress;

        @JsonProperty("password")
        private String password;

        @JsonProperty("userName")
        private String createUserName;
    }

    @JsonProperty("NewEmployee")
   NewEmployee newEmployee;  //cho nay ko tao getter cho newEmployee vi phai tao cua tung bien, gan voi du lieu tu NewEmployee trong file json

    @JsonProperty("language")  //map dung voi ten bien trong file json
    private List<String> language;

    public List<String> getLanguage() {
        return language;  //Se tra ve list gia tri
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public String getFirstName() {
        return newEmployee.firstName;
    }

    public String getLastName() {
        return newEmployee.lastName;
    }

    public String getEmailAddress() {
        return newEmployee.emailAddress;
    }

    public String getPassword() {
        return newEmployee.password;
    }

    public String getCreateUserName() {
        return newEmployee.createUserName;
    }
}
