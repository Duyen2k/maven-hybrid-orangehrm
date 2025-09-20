package phuongHoaAn;

public class FPTTelecom extends FPTCorporation {
    //Ngoài Class, trong cùng package nhưng trong mqh kế thừa
    public void showTVName(){
        //gọi ra trực tiếp
        showTVName();
        tvName="FPT Telecom LCD";

        tvColor="FPT Color";
        setTVColor();

        tvChanel="FPT Chanel";
        setTvChanel();

//        tvVolumn="";      => ko truy cập được-private acess
//        setTvVolumn();
    }
}
