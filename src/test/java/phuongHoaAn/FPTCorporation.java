package phuongHoaAn;

public class FPTCorporation {
    //Thuộc tính(ko có void)
    public String tvName;
    protected String tvColor;
    String tvChanel; //ko set gì là default-chỉ được phép trong package
    private String tvVolumn; //Chỉ có class đó được dùng

    //Phương thức
    public void setTvName() {
        System.out.println(tvName);
    }

    protected void setTVColor(){
        //protected cùng package-hoặc kế thừa thì dùng được-> khác package ko dùng được
    }

    void setTvChanel(){
    }

    private void setTvVolumn(){
    }

}
