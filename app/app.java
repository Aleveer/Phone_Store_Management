package app;

import java.io.FileNotFoundException;
import java.util.Scanner;
import controller.Login;
import view.HRManagement;
import view.ProductManagement;
import view.CustomerManagement;

public class app {
	
	// hàm main check đăng nhập theo phân quyền
	public static void main(String[] args) throws FileNotFoundException {
			Login login = new Login();
			Scanner sc = new Scanner(System.in);
			System.out.println("User name: ");
			String User = sc.nextLine();
			System.out.println("Password: ");
			String Pass = sc.nextLine();
			
			int check = login.check(User, Pass);
			if(check == 0) {
				System.out.println("Tên tài khoản hoặc mật khẩu không chính xác, Vui lòng nhập lại sau.");
			}
			if(check == 1) {
				new CustomerManagement();
			}
			if(check == 2) {
				new HRManagement();
			}
			if(check == 3) {
				new ProductManagement();
			}
	}
	
}
