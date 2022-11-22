package QuanLyNhanVien;
import Person.Person;

public class NhanVien extends Person {
    private Integer ID_Worker;
    private String Role;
    private String Shift;

    public NhanVien(String name, String gender, String address, String email, Integer age, String phoneNumber, Integer ID_Worker, String role, String shift) {
        super();
        this.setName(name);
        this.setGender(gender);
        this.setAddress(address);
        this.setEmail(email);
        this.setAge(age);
        this.setPhoneNumber(phoneNumber);
        this.setID_Worker(ID_Worker);
        this.Role = role;
        this.Shift = shift;
    }
    public NhanVien() {
        super();
    }

    public Integer getID_Worker() {
        return ID_Worker;
    }
    public void setID_Worker(Integer ID_Worker) {
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
