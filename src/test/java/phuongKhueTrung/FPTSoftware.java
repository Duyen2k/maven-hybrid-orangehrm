package phuongKhueTrung;

import phuongHoaAn.FPTCorporation;

public class FPTSoftware extends FPTCorporation {
    //Ngoài Class, khác package nhưng trong mqh kế thừa(dùng giống thằng FPTTelecom)
    public void showTVName(){
        showTVName();
        tvName="FPT Telecom LCD";

        tvColor="";
        setTVColor();

        //ko dùng được Default: do khác package(dù cho đã kế thừa)
//        tvChanel="";
    }
}