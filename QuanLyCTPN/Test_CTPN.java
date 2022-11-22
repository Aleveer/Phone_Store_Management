package QuanLyCTPN;

public class Test_CTPN {
    public static void main(String[] args){
        QuanLyChiTietPhieuNhap CTPN = new QuanLyChiTietPhieuNhap();
            CTPN.Add();
            //CTPN.Add();
            //CTPN.Add();
            CTPN.Update();
            CTPN.Output();
            //CTPN.Delete();
            //CTPN.Output();

        CTPN.Search_byCategory();
    }
}
