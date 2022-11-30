package view;

import java.io.FileNotFoundException;
import java.util.Scanner;

import controller.AccountManager;
import controller.QuanLyNhanVien;
import controller.QuanlyChiTietPhieuNhap;
import controller.QuanlyNhaCungCap;
import controller.ReceiptDetailManager;

public class HRManagement {
	public static void listFunctionsView() {
		System.out.println("---------Quản lý nhân sự---------");
		System.out.println("1.Quản lý tài khoản");
		System.out.println("2.Quản lý nhân viên");
		System.out.println("3.Quản lý chi tiết phiếu nhập");
		System.out.println("4.Quản lý nhà cung cấp");
		System.out.println("5.Quản lý chi tiết hóa đơn");
		System.out.println("0.Thoát chương trình.");
		System.out.println("-------------------------------------");
	}
	
//	Hàm xuất danh sách chức năng và gọi hàm từ lớp quản lý tài khoản
	public static void quanLyTaiKhoanUI() throws FileNotFoundException {
		AccountManager qltk = new AccountManager();
		Scanner input = new Scanner(System.in);
		int subCheck = 0;
		do {
			System.out.println("Quản lý tài khoản:");
			System.out.println("1.Xem danh sách tài khoản");
			System.out.println("2.Thêm tài khoản");
			System.out.println("3.Sửa tài khoản");
			System.out.println("4.Xóa tài khoản");
			System.out.println("5.Tìm kiếm tài khoản");
			System.out.println("0.Thoát");
			System.out.println("Mời nhập: ");
			subCheck = input.nextInt();
			switch (subCheck) {
			case 1 -> qltk.Read();
			case 2 -> qltk.Create();
			case 3 -> qltk.Update();
			case 4 -> qltk.Delete();
			case 5 -> qltk.Search_byCategory();
			case 0 -> System.out.println("Thoát quản lý tài khoản");
			default -> System.out.println("\nBạn nhập sai chức năng, vui lòng nhập lại \n");
			}
		} while (subCheck != 0);
	}

	// Hàm xuất danh sách chức năng và gọi hàm từ quản lý nhân viên
	public static void quanLyNhanVienUI() throws FileNotFoundException {
		QuanLyNhanVien qlnv = new QuanLyNhanVien();
		Scanner input = new Scanner(System.in);
		int subCheck = 0;
		do {
			System.out.println("Quản lý nhập hàng:");
			System.out.println("1.Xem danh sách nhân viên");
			System.out.println("2.Thêm nhân viên");
			System.out.println("3.Sửa nhân viên");
			System.out.println("4.Xóa nhân viên");
			System.out.println("5.Tìm kiếm nhân viên");
			System.out.println("0.Thoát");
			System.out.println("Mời nhập: ");
			subCheck = input.nextInt();
			switch (subCheck) {
			case 1 -> qlnv.Read();
			case 2 -> qlnv.Create();
			case 3 -> qlnv.Update();
			case 4 -> qlnv.Delete();
			case 5 -> qlnv.Search_byCategory();
			case 0 -> System.out.println("Thoát quản lý nhân viên");
			default -> System.out.println("\nBạn nhập sai chức năng, vui lòng nhập lại \n");
			}
		} while (subCheck != 0);
	}

	public static void quanLyChiTietPhieuNhapUI() throws FileNotFoundException {
		QuanlyChiTietPhieuNhap qlctpn = new QuanlyChiTietPhieuNhap();
		Scanner input = new Scanner(System.in);
		int subCheck = 0;
		do {
			System.out.println("Quản lý nhập hàng:");
			System.out.println("1.Xem danh sách chi tiết phiếu nhập");
			System.out.println("2.Thêm chi tiết phiếu nhập");
			System.out.println("3.Sửa chi tiết phiếu nhập");
			System.out.println("4.Xóa chi tiết phiếu nhập");
			System.out.println("5.Tìm kiếm chi tiết phiếu nhập");
			System.out.println("0.Thoát");
			System.out.println("Mời nhập: ");
			subCheck = input.nextInt();
			switch (subCheck) {
				case 1 -> qlctpn.Read();
				case 2 -> qlctpn.Create();
				case 3 -> qlctpn.Update();
				case 4 -> qlctpn.Delete();
				case 5 -> qlctpn.Search_byCategory();
				case 0 -> System.out.println("Thoát quản lý chi tiết phiếu nhập");
				default -> System.out.println("\nBạn nhập sai chức năng, vui lòng nhập lại \n");
			}
		} while (subCheck != 0);
	}

	public static void quanLyNhaCungCapUI() throws FileNotFoundException {
		QuanlyNhaCungCap qlncc = new QuanlyNhaCungCap();
		Scanner input = new Scanner(System.in);
		int subCheck = 0;
		do {
			System.out.println("Quản lý nhà cung cấp:");
			System.out.println("1.Xem danh sách nhà cung cấp");
			System.out.println("2.Thêm nhà cung cấp");
			System.out.println("3.Sửa nhà cung cấp");
			System.out.println("4.Xóa nhà cung cấp");
			System.out.println("5.Tìm kiếm nhà cung cấp");
			System.out.println("0.Thoát");
			System.out.println("Mời nhập: ");
			subCheck = input.nextInt();
			switch (subCheck) {
				case 1 -> qlncc.read();
				case 2 -> qlncc.Create();
				case 3 -> qlncc.Update();
				case 4 -> qlncc.Delete();
				case 5 -> qlncc.Search_byCategory();
				case 0 -> System.out.println("Thoát quản lý nhà cung cấp");
				default -> System.out.println("\nBạn nhập sai chức năng, vui lòng nhập lại \n");
			}
		} while (subCheck != 0);
	}

	public static void quanLyChiTietHoaDonUI() throws FileNotFoundException {
		ReceiptDetailManager qlcthd = new ReceiptDetailManager();
		Scanner input = new Scanner(System.in);
		int subCheck = 0;
		do {
			System.out.println("Quản lý nhà cung cấp:");
			System.out.println("1.Xem danh sách chi tiết hóa đơn");
			System.out.println("2.Thêm chi tiết hóa đơn");
			System.out.println("3.Sửa chi tiết hóa đơn");
			System.out.println("4.Xóa chi tiết hóa đơn");
			System.out.println("5.Tìm kiếm chi tiết hóa đơn");
			System.out.println("0.Thoát");
			System.out.println("Mời nhập: ");
			subCheck = input.nextInt();
			switch (subCheck) {
				case 1 -> qlcthd.Read();
				case 2 -> qlcthd.Create();
				case 3 -> qlcthd.Update();
				case 4 -> qlcthd.Delete();
				case 5 -> qlcthd.Search_byCategory();
				case 0 -> System.out.println("Thoát quản lý chi tiết hóa đơn");
				default -> System.out.println("\nBạn nhập sai chức năng, vui lòng nhập lại \n");
			}
		} while (subCheck != 0);
	}

	public static void main(String[] args) throws FileNotFoundException {
		int check = 0;
		do {
			listFunctionsView();
			Scanner input = new Scanner(System.in);
			System.out.print("Chọn chức năng: ");
			check = input.nextInt();
			switch (check) {
				case 1 -> {
					quanLyTaiKhoanUI();
				}
				case 2 -> {
					quanLyNhanVienUI();;
				}
				case 3 -> {
					quanLyChiTietPhieuNhapUI();;
				}
				case 4 -> {
					quanLyNhaCungCapUI();
				}
				case 5 -> {
					quanLyChiTietHoaDonUI();
				}
				case 0 -> {
					System.out.println("\nThoát chương trình quản lý khách hàng thành công");
				}
				default -> {
					System.out.println("\nNhập sai chức năng, vui lòng nhập lại!\n");
				}
			}
		} while (check != 0);
	}
}
