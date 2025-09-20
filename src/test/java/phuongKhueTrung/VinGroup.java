package phuongKhueTrung;

import phuongHoaAn.FPTCorporation;

public class VinGroup {
//Phạm vi ngoài Class-nhưng khác package
    public void showTVName() {
        FPTCorporation fptCorporation = new FPTCorporation();
        fptCorporation.tvName="VinGroup LCD";
        fptCorporation.setTvName();

    //loại protected: tại đây bị giới hạn phạm vi-thông baáo ko truy cập được
//        fptCorporation.tvColor="";
//        fptCorporation.setTVColor();

//        fptCorporation.tvVolumn="";     => ko truy cập được-private acess
//        fptCorporation.setTvVolumn();

    }
}
