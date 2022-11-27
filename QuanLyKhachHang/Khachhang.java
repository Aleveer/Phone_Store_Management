package QuanLyKhachHang;
import Person.Person;
public class Khachhang extends Person {
    private String ID_Customer;
    private String kindOfCustomer;
    public Khachhang(String ID_Customer, String name, Integer age, String gender, String address, String email,  String phonenumber, String kindOfCustomer) {
        super();
        this.kindOfCustomer = kindOfCustomer;
        this.ID_Customer = ID_Customer;
    }
    public Khachhang() {
        super();
    }
    public String getID_Customer() {
        return ID_Customer;
    }
    public void setID_Customer(String  ID_Customer) {
        this.ID_Customer = ID_Customer;
    }

    public String getKindOfCustomer() {
        return kindOfCustomer;
    }
    public void setKindOfCustomer(String kindOfCustomer) {
        this.kindOfCustomer = kindOfCustomer;
    }
}