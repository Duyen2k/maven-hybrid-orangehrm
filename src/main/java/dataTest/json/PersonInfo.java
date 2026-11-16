package dataTest.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.GlobalConstants;

import java.io.File;
import java.util.List;

public class PersonInfo {

    @JsonProperty("PersonList")
    private List<Person> personList;

    public List<Person> getPersonList() {
        return personList;
    }

    public static PersonInfo getPersonInfo() {
        try {

            ObjectMapper mapper = new ObjectMapper();
            //mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(new File(GlobalConstants.JSON_DATA_TEST_PATH+"personInfo.json"), PersonInfo.class);
        } catch (Exception ex) {
            ex.printStackTrace();
//            return null;
            throw new RuntimeException("Không thể đọc được file employee.json tại đường dẫn trên!", ex);
        }
    }

    public static class Person{

        @JsonProperty("personName")
        private String personName;

        @JsonProperty("personCity")
        private String personCity;

        @JsonProperty("personAddress")
        private String personAddress;

        public String getPersonName() {
            return personName;
        }

        public String getPersonCity() {
            return personCity;
        }

        public String getPersonAddress() {
            return personAddress;
        }
    }
}
