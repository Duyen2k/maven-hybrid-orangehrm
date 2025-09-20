package javaSDET;

public class Topic_10 extends Topic_09 {
    //Phạm vi toàn cục (class)
    String address;

    //Constructor lớp con
    public Topic_10(String name, String address) {//Phạm vi cục bộ
        super(name);
        this.address = address;
        //Khi có 2 biến cùng tên: Sử dụng this để lấy cái toàn cục bên trên, nếu ko this thì dùng cái cục bộ
        //Supper phải ở vị trí đầu(như hiện tại đang để)
    }
}
