package entity;

public class Customer extends Person{
 	private String ID_Customer;
    private String  kindOfCustomer;
    
    
	public Customer(String ID_Customer, String name, Integer age, String gender, String address, String email,  String phoneNumber, String kindOfCustomer) {
		super(name, gender, address, email, age, phoneNumber);
		this.ID_Customer = ID_Customer;
		this.kindOfCustomer = kindOfCustomer;
	}
	
	public Customer() {
		super();
	}

	public Customer(String name, String gender, String address, String email, Integer age, String phoneNumber) {
		super(name, gender, address, email, age, phoneNumber);
	}

	public String getID_Customer() {
		return ID_Customer;
	}
	public void setID_Customer(String iD_Customer) {
		ID_Customer = iD_Customer;
	}
	public String getKindOfCustomer() {
		return kindOfCustomer;
	}
	public void setKindOfCustomer(String kindOfCustomer) {
		this.kindOfCustomer = kindOfCustomer;
	}
    
}
