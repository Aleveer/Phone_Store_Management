package QuanLySanPham;

public class SanPham {
    private Integer ID_Product, ID_Typeofproduct, Amount, Amount_remaining;
    private float Price;
    private String Name, Status;

    public SanPham(){
        super();
    }

    public SanPham(String Name, Integer ID_Product, Integer ID_Typeofproduct, Integer Amount, Integer Amount_remaining, float Price, String Status){
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

    public Integer getID_Product() {
        return ID_Product;
    }
    public void setID_Product(Integer ID_Product) {
        this.ID_Product = ID_Product;
    }

    public Integer getID_Typeofproduct() {
        return ID_Typeofproduct;
    }
    public void setID_Typeofproduct(Integer ID_Typeofproduct) {
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


