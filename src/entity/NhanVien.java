package entity;

public class NhanVien extends Person{
	  private String ID_Worker;
	    private String Role;
	    private String Shift;
	    public NhanVien(String ID_Worker, String name, Integer age, String gender, String address, String email,String phoneNumber, String role, String shift) {
			super(name, gender, address, email, age, phoneNumber);
			this.ID_Worker = ID_Worker;
	        this.Role = role;
	        this.Shift = shift;
	    }
	    public NhanVien() {
	        super();
	    }
	    public String getID_Worker() {
	        return ID_Worker;
	    }
	    public void setID_Worker(String ID_Worker) {
	        this.ID_Worker = ID_Worker;
	    }
	    public String getRole() {
	        return Role;
	    }
	    public void setRole(String role) {
	        this.Role = role;
	    }
	    public String getShift() {
	        return Shift;
	    }
	    public void setShift(String shift) {
	        this.Shift = shift;
	    }
}
