package javaSDET;

public interface Topic_02_Interface {
    //default Method
    public default void showStudent(){

    }
    //Abstract ko có thân hàm, chỉ có tên hàm-Những thằng ko có abstract(non-abstract)

    //Abstract method
    public abstract void clearStudent();
}
