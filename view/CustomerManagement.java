package view;

import java.io.FileNotFoundException;
import java.util.Scanner;
import controller.QuanLyBaoHanh;
import controller.CustomerManager;
import controller.QuanLySanPham;
import controller.ReceiptManager;

public class CustomerManagement {
	public static void method() {
		System.out.println("--------- Quản Lý Khách Hàng ---------");
		System.out.println("1.Quản lý khách hàng");
		System.out.println("2.Quản lý hóa đơn");
        System.out.println("3.Quản lý bảo hành");
		System.out.println("0.Thoát chương trình.");
		System.out.println("--------------------------------------");
	}

    public static void quanLyKhachHang() throws FileNotFoundException {
        CustomerManager qlkh = new CustomerManager();
        Scanner input = new Scanner(System.in);
        int subCheck = 0;
        do {
            System.out.println("Danh Sách chức năng:");
            System.out.println("1.Xem danh sách khách hàng");
            System.out.println("2.Thêm khách hàng");
            System.out.println("3.Sửa khách hàng");
            System.out.println("4.Xóa khách hàng");
            System.out.println("5.Tìm kiếm");
            System.out.println("0.Thoát");
            System.out.println("Mời nhập: ");
                int choose = input.nextInt();
                switch (choose) {
                    case 1 -> qlkh.Read();
                    case 2 -> qlkh.Create();
                    case 3 -> qlkh.Update();
                    case 4 -> qlkh.Delete();
                    case 5 -> qlkh.Search_byCategory();
                    case 0 -> System.out.println("Thoát quản lý khách hàng");
                    default -> System.out.println("\nBạn nhập sai chức năng, vui lòng nhập lại \n");
                        }
                    }
                    while(subCheck != 0);
                }


    public static void quanLyHoaDon() throws FileNotFoundException {
        ReceiptManager qlhd = new ReceiptManager();
        Scanner input = new Scanner(System.in);
        int subCheck = 0;
            do {
                System.out.println("Danh Sách chức năng:");
                System.out.println("1.Xem danh sách hóa đơn");
                System.out.println("2.Thêm hóa đơn");
                System.out.println("3.Sửa hóa đơn");
                System.out.println("4.Xóa hóa đơn");
                System.out.println("5.Tìm kiếm");
                System.out.println("0.Thoát");
                System.out.println("Mời nhập: ");
                int choose = input.nextInt();
                switch (choose) {
                    case 1 -> qlhd.Read();
                    case 2 -> qlhd.Create();
                    case 3 -> qlhd.Update();
                    case 4 -> qlhd.Delete();
                    case 5 -> qlhd.Search_byCategory();
                    case 0 -> System.out.println("Thoát quản lý hóa đơn");
                    default -> System.out.println("\nBạn nhập sai chức năng, vui lòng nhập lại \n");
                }
            }
            while(subCheck != 0);
    }


    public static void quanLyBaoHanh() throws FileNotFoundException {
        QuanLyBaoHanh qlbh = new QuanLyBaoHanh();
        Scanner input = new Scanner(System.in);
        int subCheck = 0;
        do {
            System.out.println("Danh Sách chức năng:");
            System.out.println("1.Xem danh sách bảo hành");
            System.out.println("2.Thêm danh sách bảo hành");
            System.out.println("3.Tìm kiếm");
            System.out.println("0.Thoát");
            System.out.println("Mời nhập: ");
            int choose = input.nextInt();
            switch (choose) {
            case 1 -> qlbh.read();
            case 2 -> qlbh.Create();
            case 3 -> qlbh.Search_byCategory();
            case 0 -> System.out.println("Thoát quản lý bảo hành");
            default -> System.out.println("\nBạn nhập sai chức năng, vui lòng nhập lại \n");
            }
        }while(subCheck != 0);
}

    public CustomerManagement() throws FileNotFoundException {
        int check = 0;
        do {
            method();
            Scanner input = new Scanner(System.in);
            System.out.print("Chọn chức năng: ");
            check = input.nextInt();
            switch (check) {
                case 1 -> {
                    quanLyKhachHang();
                }
                case 2 -> {
                    quanLyHoaDon();
                }
                case 3 -> {
                    quanLyBaoHanh();
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
                    quanLyKhachHang();
                }
                case 2 -> {
                    quanLyHoaDon();
                }
                case 3 -> {
                    quanLyBaoHanh();
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

