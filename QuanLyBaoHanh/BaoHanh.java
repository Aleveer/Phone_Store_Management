package QuanLyBaoHanh;

import java.time.LocalDate;

public class BaoHanh {
    LocalDate ngayMua;
    private Integer SoNamBaoHanh;
    private Integer ID_Customer;
    private String PhoneNumber;

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

    public Integer getID_Customer() {
        return ID_Customer;
    }

    public void setID_Customer(Integer ID_Customer) {
        this.ID_Customer = ID_Customer;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public BaoHanh(LocalDate ngayMua, Integer soNamBaoHanh, Integer ID_Customer, String phoneNumber) {
        super();
        this.ngayMua = ngayMua;
        this.SoNamBaoHanh = soNamBaoHanh;
        this.ID_Customer = ID_Customer;
        this.PhoneNumber = phoneNumber;
    }

    public BaoHanh() {
        super();
    }
}

