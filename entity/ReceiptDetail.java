package entity;

public class ReceiptDetail {
	String ID_Receipt;
	String ID_Product;
	int Amount;
	int Price;
	
	public ReceiptDetail() {
		super();
	}
	public ReceiptDetail(String iD_Receipt, String iD_Product, int amount, int price) {
		super();
		ID_Receipt = iD_Receipt;
		ID_Product = iD_Product;
		Amount = amount;
		Price = price;
	}
	public String getID_Receipt() {
		return ID_Receipt;
	}
	public void setID_Receipt(String iD_Receipt) {
		ID_Receipt = iD_Receipt;
	}
	public String getID_Product() {
		return ID_Product;
	}
	public void setID_Product(String iD_Product) {
		ID_Product = iD_Product;
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	
	
}
