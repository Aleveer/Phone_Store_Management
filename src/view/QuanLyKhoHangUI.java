package view;

import java.io.FileNotFoundException;
import java.util.Scanner;

import controller.QuanLyConfigurations;
import controller.QuanLyPhieuNhap;
import controller.QuanLySanPham;
import controller.QuanlyNhaCungCap;

public class QuanLyKhoHangUI {
	
	// Hàm xuất ra danh sách chức năng quản lý
	public static void method() {
		System.out.println("---------Danh sách chức năng---------");
		System.out.println("1.Quản lý Sản phẩm");
		System.out.println("2.Quản lý Nhập hàng");
		System.out.println("3.Quản lý Cấu hình sản phẩm");
		System.out.println("4.Quản lý Nhà cung cấp");
		System.out.println("0.Thoát chương trình.");
		System.out.println("-------------------------------------");
	}

	// Hàm xuất danh sách chức năng và gọi hàm từ lớp quản lý sản phẩm
	public static void quanLySanPhamUI() throws FileNotFoundException {
		QuanLySanPham qlsp = new QuanLySanPham();
		Scanner input = new Scanner(System.in);
		int subCheck = 0;
		do {
			System.out.println("Quản lý sản phẩm:");
			System.out.println("1.Xem danh sách sản phẩm");
			System.out.println("2.Thêm sản phẩm");
			System.out.println("3.Sửa sản phẩm");
			System.out.println("4.Xóa sản phẩm");
			System.out.println("5.Tìm kiếm sản phẩm");
			System.out.println("0.Thoát");
			System.out.println("Mời nhập: ");
			subCheck = input.nextInt();
			switch (subCheck) {
			case 1 -> qlsp.Read();
			case 2 -> qlsp.Create();
			case 3 -> qlsp.Update();
			case 4 -> qlsp.Delete();
			case 5 -> qlsp.Search_byCategory();
			case 0 -> System.out.println("Thoát quản lý sản phẩm");
			default -> System.out.println("\nBạn nhập sai chức năng, vui lòng nhập lại \n");
			}
		} while (subCheck != 0);
	}

	// Hàm xuất danh sách chức năng và gọi hàm từ lớp quản lý phiếu nhập
	public static void quanLyNhapHangUI() throws FileNotFoundException {
		QuanLyPhieuNhap qlpn = new QuanLyPhieuNhap();
		Scanner input = new Scanner(System.in);
		int subCheck = 0;
		do {
			System.out.println("Quản lý nhập hàng:");
			System.out.println("1.Xem danh sách phiếu nhập");
			System.out.println("2.Thêm phiếu nhập");
			System.out.println("3.Sửa phiếu nhập");
			System.out.println("4.Xóa phiếu nhập");
			System.out.println("5.Tìm kiếm phiếu nhập");
			System.out.println("0.Thoát");
			System.out.println("Mời nhập: ");
			subCheck = input.nextInt();
			switch (subCheck) {
			case 1 -> qlpn.Read();
			case 2 -> qlpn.Create();
			case 3 -> qlpn.Update();
			case 4 -> qlpn.Delete();
			case 5 -> qlpn.Search_byCategory();
			case 0 -> System.out.println("Thoát quản lý phiếu nhập");
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
				case 1 -> qlncc.Read();
				case 2 -> qlncc.Create();
				case 3 -> qlncc.Update();
				case 4 -> qlncc.Delete();
				case 5 -> qlncc.Search_byCategory();
				case 0 -> System.out.println("Thoát quản lý nhà cung cấp");
				default -> System.out.println("\nBạn nhập sai chức năng, vui lòng nhập lại \n");
			}
		} while (subCheck != 0);
	}

	public static void quanLyCauHinhUI() throws FileNotFoundException {
		QuanLyConfigurations qlch = new QuanLyConfigurations();
		Scanner input = new Scanner(System.in);
		int subCheck = 0;
		do {
			System.out.println("Quản lý cấu hình:");
			System.out.println("1.Xem danh sách cấu hình");
			System.out.println("2.Thêm cấu hình");
			System.out.println("3.Sửa cấu hình");
			System.out.println("4.Xóa cấu hình");
			System.out.println("5.Tìm kiếm cấu hình");
			System.out.println("0.Thoát");
			System.out.println("Mời nhập: ");
			subCheck = input.nextInt();
			switch (subCheck) {
				case 1 -> qlch.Read();
				case 2 -> qlch.Create();
				case 3 -> qlch.Update();
				case 4 -> qlch.Delete();
				case 5 -> qlch.Search_byCategory();
				case 0 -> System.out.println("Thoát quản lý cấu hình sản phẩm");
				default -> System.out.println("\nBạn nhập sai chức năng, vui lòng nhập lại \n");
			}
		} while (subCheck != 0);
	}

	public QuanLyKhoHangUI() throws FileNotFoundException {
		int check = 0;
		do {
			method();
			Scanner input = new Scanner(System.in);
			System.out.print("Chọn chức năng: ");
			check = input.nextInt();
			switch (check) {
				case 1 -> {
					quanLySanPhamUI();
				}
				case 2 -> {
					quanLyNhapHangUI();
				}
				case 3 -> {
					quanLyCauHinhUI();
				}
				case 4 -> {
					quanLyNhaCungCapUI();
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

	public static void main(String[] args) throws FileNotFoundException {
		int check = 0;
		do {
			method();
			Scanner input = new Scanner(System.in);
			System.out.print("Chọn chức năng: ");
			check = input.nextInt();
			switch (check) {
				case 1 -> {
					quanLySanPhamUI();
				}
				case 2 -> {
					quanLyNhapHangUI();
				}
				case 3 -> {
					quanLyCauHinhUI();
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
