package entity;

public class SanPham {
    private String ID_Product, ID_Typeofproduct, Name, Status;
    private Integer Amount, Amount_remaining;
    private float Price;

    public SanPham(){
        super();
    }

    public SanPham(String Name, String ID_Product, String ID_Typeofproduct, Integer Amount, Integer Amount_remaining, float Price, String Status){
        super();
        this.Name = Name;
        this.ID_Product = ID_Product;
        this.ID_Typeofproduct = ID_Typeofproduct;
        this.Amount = Amount;
        this.Amount_remaining = Amount_remaining;
        this.Price = Price;
        this.Status = Status;
    }

    public String getName(){
        return Name;
    }
    public void setName(String Name){
        this.Name = Name;
    }

    public String getID_Product() {
        return ID_Product;
    }
    public void setID_Product(String ID_Product) {
        this.ID_Product = ID_Product;
    }

    public String getID_Typeofproduct() {
        return ID_Typeofproduct;
    }
    public void setID_Typeofproduct(String ID_Typeofproduct) {
        this.ID_Typeofproduct = ID_Typeofproduct;
    }

    public Integer getAmount() {
        return Amount;
    }
    public void setAmount(Integer Amount) {
        this.Amount = Amount;
    }

    public Integer getAmount_remaining() {
        return Amount_remaining;
    }
    public void setAmount_remaining(Integer Amount_remaining) {
        this.Amount_remaining = Amount_remaining;
    }

    public float getPrice() {
        return Price;
    }
    public void setPrice(float Price) {
        this.Price = Price;
    }

    public String  getStatus() {
        return Status;
    }
    public void setStatus(String Status) {
        this.Status = Status;
    }
}


