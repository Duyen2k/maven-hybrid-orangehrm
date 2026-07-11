package javaSDET;

public class Topic_11_String {
    public static void main(String[] args) {
        String a = "Automation Testing";
        String b = a;
        String c = b;

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        String locator = "id=username";
        locator = locator.substring(3);
        System.out.println(locator);

        String locator2="  id  = username";
        String[] locatorArr=locator2.split("="); //phai dung [] la dang mang
        System.out.println(locatorArr[0]);
        System.out.println(locatorArr[1].trim());
    }
}
