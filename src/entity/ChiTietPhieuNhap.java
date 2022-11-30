package entity;

public class ChiTietPhieuNhap {
	 private String ID_PhieuNhap, ID_Product;
	    private float Price;
	    private Integer Amount;

	    public ChiTietPhieuNhap(String ID_PhieuNhap, String ID_Product, Integer Amount, float Price) {
	        super();
	        this.ID_PhieuNhap = ID_PhieuNhap;
	        this.ID_Product = ID_Product;
	        this.Amount = Amount;
	        this.Price = Price;
	    }

	    public ChiTietPhieuNhap() {
	        super();
	    }
	    public String getID_PhieuNhap() {
	        return ID_PhieuNhap;
	    }
	    public void setID_PhieuNhap(String ID_PhieuNhap) {
	        this.ID_PhieuNhap = ID_PhieuNhap;
	    }

	    public String getID_Product() {
	        return ID_Product;
	    }
	    public void setID_Product(String ID_Product) {
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
