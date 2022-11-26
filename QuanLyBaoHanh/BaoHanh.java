package QuanLyBaoHanh;
import java.time.LocalDate;
public class BaoHanh {
    LocalDate ngayMua;
    private Integer SoNamBaoHanh;
    private String ID_Customer, PhoneNumber, goiBaoHanh;
    public LocalDate getNgayMua() {
        return ngayMua;
    }
    public void setNgayMua(LocalDate ngayMua) {
        this.ngayMua = ngayMua;
    }
    public Integer getSoNamBaoHanh() {
        return SoNamBaoHanh;
    }
    public void setSoNamBaoHanh(Integer soNamBaoHanh) {
        SoNamBaoHanh = soNamBaoHanh;
    }
    public String getID_Customer() {
        return ID_Customer;
    }
    public void setID_Customer(String ID_Customer) {
        this.ID_Customer = ID_Customer;
    }
    public String getPhoneNumber() {
        return PhoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
    public String getGoiBaoHanh() {
        return goiBaoHanh;
    }
    public void setGoiBaoHanh(String goiBaoHanh) {
        this.goiBaoHanh = goiBaoHanh;
    }

    public BaoHanh(LocalDate ngayMua, Integer soNamBaoHanh, String ID_Customer, String phoneNumber, String goiBaoHanh) {
        super();
        this.ngayMua = ngayMua;
        this.SoNamBaoHanh = soNamBaoHanh;
        this.ID_Customer = ID_Customer;
        this.PhoneNumber = phoneNumber;
        this.goiBaoHanh = goiBaoHanh;
    }

    public BaoHanh() {
        super();
    }
}

