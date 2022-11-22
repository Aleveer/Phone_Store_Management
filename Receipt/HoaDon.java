package Receipt;

import java.time.LocalDate;
import java.time.LocalTime;

public class HoaDon {
    private Integer ID_receipt = 0;
    private Integer ID_Worker = 0;
    private Integer ID_Customer = 0;
    private String DeliveryMethod = "";
    private String PurchaseMethod = "";
    private String Customer_name = "";
    private String Name_Product = "";
    private LocalDate DatePurchase;
    private LocalTime TimePurchase;
    protected float Price = 0;

    public Integer getID_receipt() {
        return ID_receipt;
    }
    public void setID_receipt(Integer ID_receipt) {
        this.ID_receipt = ID_receipt;
    }

    public String getDeliveryMethod() {
        return DeliveryMethod;
    }
    public void setDeliveryMethod(String deliveryMethod) {
        this.DeliveryMethod = deliveryMethod;
    }

    public String getPurchaseMethod() {
        return PurchaseMethod;
    }
    public void setPurchaseMethod(String purchaseMethod) {
        this.PurchaseMethod = purchaseMethod;
    }

    public LocalDate getDatePurchase() {
        return DatePurchase;
    }
    public void setDatePurchase(LocalDate datePurchase) {
        this.DatePurchase = datePurchase;
    }

    public LocalTime getTimePurchase() {
        return TimePurchase;
    }
    public void setTimePurchase(LocalTime timePurchase) {
        TimePurchase = timePurchase;
    }

    public Integer getID_Worker() {
        return ID_Worker;
    }
    public void setID_Worker(Integer ID_Worker) {
        this.ID_Worker = ID_Worker;
    }

    public Integer getID_Customer() {
        return ID_Customer;
    }
    public void setID_Customer(Integer ID_Customer) {
        this.ID_Customer = ID_Customer;
    }

    public String getCustomer_name() {
        return Customer_name;
    }

    public void setCustomer_name(String customer_name) {
        Customer_name = customer_name;
    }

    public Float getPrice() {
        return Price;
    }
    public void setPrice(Float price) {
        this.Price = price;
    }

    public String getName_Product() {
        return Name_Product;
    }
    public void setName_Product(String Name_Product) {
        this.Name_Product = Name_Product;
    }

    public HoaDon(Integer ID_receipt, Integer ID_Worker, Integer ID_Customer, String Customer_name, String DeliveryMethod, String PurchaseMethod, LocalDate DatePurchase , LocalTime TimePurchase) {
        super();
        this.ID_receipt = ID_receipt;
        this.ID_Customer = ID_Customer;
        this.ID_Worker = ID_Worker;
        this.Customer_name = Customer_name;
        this.DeliveryMethod = DeliveryMethod;
        this.PurchaseMethod = PurchaseMethod;
        this.DatePurchase = DatePurchase;
        this.TimePurchase = TimePurchase;
    }

    public HoaDon(String Name_Product, Float price) {
        super();
        this.Name_Product = Name_Product;
        this.Price = price;
    }

    public HoaDon() {
        DatePurchase = LocalDate.now();
        TimePurchase = LocalTime.now();
    }
}
