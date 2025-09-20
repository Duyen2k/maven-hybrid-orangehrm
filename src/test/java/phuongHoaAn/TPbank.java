package phuongHoaAn;

public class TPbank {
    //Phạm vi sử dụng ngoài Class, nhưng trong cùng package

    public void showTVName(){
        FPTCorporation fptCorporation=new FPTCorporation();
        fptCorporation.tvName="TPbank LCD";
    //protected: Vẫn sử dụng được khi nó khác Class-nhưng cùng package
        fptCorporation.tvColor="TPbank Color";
        fptCorporation.setTVColor();

        fptCorporation.tvChanel="TPbank Chanel";
        fptCorporation.setTvChanel();

//        fptCorporation.tvVolumn="";     => ko truy cập được-private acess
//        fptCorporation.setTvVolumn();
    }
}
