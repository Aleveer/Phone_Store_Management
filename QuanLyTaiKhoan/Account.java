package QuanLyTaiKhoan;

public class Account {
	private String Account_id;
	private String Username;
	private String Password;
	private String Position;
	public Account() {
		super();
	}
	
	public Account(String account_id, String username, String password, String position) {
		super();	
		Account_id = account_id;
		Position = position;
		Username = username;
		Password = password;
	}
	
	public String getAccount_id() {
		return Account_id;
	}
	public void setAccount_id(String account_id) {
		Account_id = account_id;
	}
	public String getPosition() {
		return Position;
	}
	public void setPosition(String position) {
		Position = position;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
}