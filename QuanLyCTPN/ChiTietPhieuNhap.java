package QuanLyCTPN;

public class ChiTietPhieuNhap {
    private Integer ID_PhieuNhap, ID_Product, Amount;
    private float Price;

    public ChiTietPhieuNhap(Integer ID_PhieuNhap, Integer ID_Product, Integer Amount, float Price) {
        super();
        this.ID_PhieuNhap = ID_PhieuNhap;
        this.ID_Product = ID_Product;
        this.Amount = Amount;
        this.Price = Price;
    }

    public ChiTietPhieuNhap() {
        super();
    }
    public Integer getID_PhieuNhap() {
        return ID_PhieuNhap;
    }
    public void setID_PhieuNhap(Integer ID_PhieuNhap) {
        this.ID_PhieuNhap = ID_PhieuNhap;
    }

    public Integer getID_Product() {
        return ID_Product;
    }
    public void setID_Product(Integer ID_Product) {
        this.ID_Product = ID_Product;
    }

    public Integer getAmount() {
        return Amount;
    }
    public void setAmount(Integer Amount) {
        this.Amount = Amount;
    }

    public float getPrice() {
        return Price;
    }
    public void setPrice(float Price) {
        this.Price = Price;
    }
}
