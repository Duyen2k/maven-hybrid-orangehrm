package javaSDET;
//Interface kế thừa Interface
public interface Topic_07 extends Topic_02 {
    //default Method
    public default void showStudent(){

    }
    //Abstract ko có thân hàm, chỉ có tên hàm-Những thằng ko có abstract(non-abstract)

    //Abstract method
    public abstract void clearStudent();
}
