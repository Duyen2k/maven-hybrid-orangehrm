package dataTest.pojo;

public class EmployeeInfo {

    private String ADMIN_USERNAME="AutomationDemo";
    private String ADMIN_PASSWORD="Auto222$$";
    private String FIRST_NAME="John";
    private String LAST_NAME="Wick";
    private String USER_NAME="John.Wick";
    private String EMAIL_ADDRESS="john.wick";
    private String PASSWORD="Automationtest123@";

    public static EmployeeInfo getEmployeeInfo(){return new EmployeeInfo();}

    public String getADMIN_USERNAME() {
        return ADMIN_USERNAME;
    }

    public String getADMIN_PASSWORD() {
        return ADMIN_PASSWORD;
    }

    public String getFIRST_NAME() {
        return FIRST_NAME;
    }

    public String getLAST_NAME() {
        return LAST_NAME;
    }

    public String getUSER_NAME() {
        return USER_NAME;
    }

    public String getEMAIL_ADDRESS() {
        return EMAIL_ADDRESS;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }




}
