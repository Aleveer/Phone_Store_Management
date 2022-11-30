package view;

import java.io.FileNotFoundException;
import java.util.Scanner;

import controller.CustomerManager;
import controller.ReceiptDetailManager;
import controller.ReceiptManager;

public class QuanLyBanHangUI {
	
	private static Scanner input = new Scanner(System.in);
	
	public static void listFunctionsView() {
		System.out.println("--------- Quản Lý Khách Hàng ---------");
		System.out.println("1.Quản lý khách hàng");
		System.out.println("2.Quản lý hóa đơn");
		System.out.println("3.Quản lý bảo hành");
		System.out.println("0.Đăng xuất.");
		System.out.println("--------------------------------------");
	}
	
	public static void quanLyKhachHangUI() throws FileNotFoundException {
		CustomerManager cus = new CustomerManager();
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
            subCheck = input.nextInt();
            switch (subCheck) {
                case 1 -> cus.Read();
                case 2 -> cus.Create();
                case 3 -> cus.Update();
                case 4 -> cus.Delete();
                case 5 -> cus.Search_byCategory();
                case 0 -> System.out.println("\nThoát quản lý khách hàng\n");
                default -> System.out.println("\nBạn nhập sai chức năng, vui lòng nhập lại \n");
            }
        }
        while(subCheck != 0);
	}
	
	public static void quanLyHoaDon() throws FileNotFoundException {
		ReceiptManager rm = new ReceiptManager();
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
            subCheck = input.nextInt();
            switch (subCheck) {
                case 1 -> {
                	rm.Read();
                }
                case 2 -> {
                	rm.Create();

                }
                case 3 -> {
                	rm.Update();
                }
                case 4 -> {
                	rm.Delete();
                }
                case 5 -> {
                	rm.Search_byCategory();
                }
                case 0 -> {
                	System.out.println("\nThoát quản lý khách hàng\n");
                }
                default -> System.out.println("\nBạn nhập sai chức năng, vui lòng nhập lại \n");
            }
       }
       while(subCheck != 0);
	}
	
    public QuanLyBanHangUI() throws FileNotFoundException {
        int function = 0;
        do {
        	listFunctionsView();
            System.out.print("Chọn chức năng: ");
            function = input.nextInt();
            switch(function) {
                case 1 -> {
                	quanLyKhachHangUI();
                }
                case 2 -> {
                	quanLyHoaDon();
                } 
                case 0 ->{
                	System.out.println("\nĐăng xuất thành công");
                }
                default ->{
                	System.out.println("\nNhập sai chức năng, vui lòng nhập lại!\n");
                }
            }
        } 
        while (function != 0);
    }
}
