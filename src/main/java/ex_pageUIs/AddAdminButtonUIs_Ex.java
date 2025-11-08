package ex_pageUIs;

public class AddAdminButtonUIs_Ex {
    public static final String ADD_BUTTON="//div[@class='orangehrm-header-container']/button";
    //Add Admin screen
    public static final String USER_ROLE_PARENT="//label[text()='User Role']/parent::div/following-sibling::div";
    public static final String USER_ROLE_CHILDREN="//div[@class='oxd-select-option']";
    public static final String STATUS_PARENT="//label[text()='Status']/parent::div/following-sibling::div";
    public static final String STATUS_CHILDREN="//div[@class='oxd-select-dropdown --positon-bottom']/div";
    public static final String PASSWORD="//label[text()='Password']/parent::div/following-sibling::div/input";
    public static final String EMPLOYEE_NAME="//label[text()='Employee Name']/parent::div/following-sibling::div";
    public static final String EMPLoYEE_NAME_INPUT="//div[@class='oxd-autocomplete-option']/span";
    public static final String USERNAME="//label[text()='Username']/parent::div/following-sibling::div";
    public static final String CONFIRM_PASSWORD="//label[text()='Confirm Password']/parent::div/following-sibling::div";
    public static final String SUBMIT_BUTTON="//button[@type='submit']";
    //Khai báo final(hằng số) để nó được cố định.
    //static để dùng hàm UI trực tiếp mà ko cần khời tạo pageUI(non-static thì ko được)
}
