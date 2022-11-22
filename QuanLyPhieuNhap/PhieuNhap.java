package QuanLyPhieuNhap;

import java.time.LocalDate;
import java.time.LocalTime;
public class PhieuNhap {
    float Price = 0;
    private Integer ID_Supplier, ID_Worker, ID_PhieuNhap;
    private String Name_supplier;
    private LocalDate ngayNhap;
    private LocalTime gioNhap;

    public PhieuNhap() {

        super();
        this.ngayNhap = LocalDate.now();
        this.gioNhap = LocalTime.now();
    }
    public PhieuNhap(float price, Integer ID_Supplier, Integer ID_Worker, Integer ID_PhieuNhap, String name_supplier, LocalDate ngayNhap, LocalTime gioNhap) {
        super();
        this.Price = price;
        this.ID_Supplier = ID_Supplier;
        this.ID_Worker = ID_Worker;
        this.ID_PhieuNhap = ID_PhieuNhap;
        this.Name_supplier = name_supplier;
        this.ngayNhap = ngayNhap;
        this.gioNhap = gioNhap;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        this.Price = price;
    }

    public Integer getID_Supplier() {
        return ID_Supplier;
    }

    public void setID_Supplier(Integer ID_Supplier) {
        this.ID_Supplier = ID_Supplier;
    }

    public Integer getID_Worker() {
        return ID_Worker;
    }

    public void setID_Worker(Integer ID_Worker) {
        this.ID_Worker = ID_Worker;
    }

    public Integer getID_PhieuNhap() {
        return ID_PhieuNhap;
    }

    public void setID_PhieuNhap(Integer ID_PhieuNhap) {
        this.ID_PhieuNhap = ID_PhieuNhap;
    }

    public String getName_supplier() {
        return Name_supplier;
    }

    public void setName_supplier(String name_supplier) {
        Name_supplier = name_supplier;
    }

    public LocalDate getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(LocalDate ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public LocalTime getGioNhap() {
        return gioNhap;
    }

    public void setGioNhap(LocalTime gioNhap) {
        this.gioNhap = gioNhap;
    }
}
