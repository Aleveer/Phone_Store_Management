package QuanLyKhachHang;

import Person.Person;

public class Khachhang extends Person {
    private String ID_Customer;
    private String  kindOfCustomer;
    public Khachhang(String name, String gender, String address, String email, Integer age, String phonenumber, String ID_Customer, String kindOfCustomer) {
        super();
        this.setName(name);
        this.setGender(gender);
        this.setAddress(address);
        this.setEmail(email);
        this.setAge(age);
        this.setPhoneNumber(phonenumber);
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