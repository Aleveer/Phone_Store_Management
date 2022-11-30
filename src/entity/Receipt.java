package entity;


public class Receipt {
	    private String ID_receipt;
	    private int Price;
	    private String DatePurchase;
	    private String PurchaseMethod;
	    private String ID_Worker;
	    private String ID_Customer;
		public Receipt() {
			super();
		}
		public Receipt(String iD_receipt, int price, String datePurchase, String purchaseMethod, String iD_Customer, String iD_Worker) {
			super();
			ID_receipt = iD_receipt;
			Price = price;
			DatePurchase = datePurchase;
			PurchaseMethod = purchaseMethod;
			ID_Worker = iD_Worker;
			ID_Customer = iD_Customer;
		}
		public String getID_receipt() {
			return ID_receipt;
		}
		public void setID_receipt(String iD_receipt) {
			ID_receipt = iD_receipt;
		}
		public int getPrice() {
			return Price;
		}
		public void setPrice(int price) {
			Price = price;
		}
		public String getDatePurchase() {
			return DatePurchase;
		}
		public void setDatePurchase(String datePurchase) {
			DatePurchase = datePurchase;
		}
		public String getPurchaseMethod() {
			return PurchaseMethod;
		}
		public void setPurchaseMethod(String purchaseMethod) {
			PurchaseMethod = purchaseMethod;
		}
		public String getID_Worker() {
			return ID_Worker;
		}
		public void setID_Worker(String iD_Worker) {
			ID_Worker = iD_Worker;
		}
		public String getID_Customer() {
			return ID_Customer;
		}
		public void setID_Customer(String iD_Customer) {
			ID_Customer = iD_Customer;
		}
}