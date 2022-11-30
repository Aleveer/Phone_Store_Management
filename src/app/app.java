package app;

import java.io.FileNotFoundException;
import java.util.Scanner;
import controller.Login;
import view.QuanLyNhanSuUI;
import view.QuanLyKhoHangUI;
import view.QuanLyBanHangUI;

public class app {
	
	// hàm main check đăng nhập theo phân quyền
	public static void main(String[] args) throws FileNotFoundException {
			Login login = new Login();
			boolean isContinue = true;
			Scanner sc = new Scanner(System.in);
			while(isContinue) {
				System.out.println("ĐĂNG NHẬP HỆ THỐNG: ");
				System.out.println("User name: ");
				String User = sc.nextLine();
				System.out.println("Password: ");
				String Pass = sc.nextLine();
				
				int check = login.check(User, Pass);
				
				if(check == 0) {
					System.out.println("Tên tài khoản hoặc mật khẩu không chính xác, Vui lòng nhập lại sau.");
					System.out.println();
					System.out.println();
				}
				if(check == 1) {
					new QuanLyBanHangUI();
				}
				if(check == 2) {
					new QuanLyNhanSuUI();
				}
				if(check == 3) {
					new QuanLyKhoHangUI();
				}
			}
	}
	
}
