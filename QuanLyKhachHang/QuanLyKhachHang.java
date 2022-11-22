package QuanLyKhachHang;

import Person.DataAccessObject;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class QuanLyKhachHang extends Khachhang implements DataAccessObject {
    public ArrayList<Khachhang> DSKH = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    @Override
    public void Add() {
        System.out.println("Nhập thông tin khách hàng:");
        super.Add();

        System.out.print("Nhập ID khách hàng: ");
        setID_Customer(input.nextInt());

        input.nextLine();
        System.out.print("Nhập loại khách hàng: ");
        setKindOfCustomer(input.nextLine());

        Khachhang kh = new Khachhang(getName(), getGender(), getAddress(), getEmail(), getAge(), getPhoneNumber(), getID_Customer(), getKindOfCustomer());
        DSKH.add(kh);
    }

    public void Update() {
        try {
            System.out.print("Nhập ID khách hàng cần chỉnh sửa: ");
            Integer ID_Khachhang = input.nextInt();
            Khachhang k_hang = null;

            for (Khachhang khachhang : DSKH) {
                if (khachhang.getID_Customer().equals(ID_Khachhang)) {
                    k_hang = khachhang;
                    break;
                }
            }

            if (k_hang == null) {
                System.out.println("ID khách hàng không tồn tại!");
                return;
            }

            System.out.println("Thông tin khách hàng: ");
            String row = String.format("%s %15s %15s %15s %50s %40s %10s %11s", k_hang.getName(), k_hang.getAge(), k_hang.getGender(),
                    k_hang.getAddress(), k_hang.getEmail(), k_hang.getID_Customer(), k_hang.getKindOfCustomer(), k_hang.getPhoneNumber());
            System.out.println(row);

            for (Khachhang khachhang : DSKH) {
                if (ID_Khachhang.equals(khachhang.getID_Customer())) {
                    System.out.println("Nhập thông tin khách hàng:");
                    super.Add();

                    input.nextLine();
                    System.out.print("Nhập loại khách hàng: ");
                    setKindOfCustomer(input.nextLine());

                    khachhang.setName(getName());
                    khachhang.setGender(getGender());
                    khachhang.setAddress(getAddress());
                    khachhang.setEmail(getEmail());
                    khachhang.setAge(getAge());
                    khachhang.setPhoneNumber(getPhoneNumber());
                    khachhang.setKindOfCustomer(getKindOfCustomer());
                }
            }
        } catch (InputMismatchException ei) {
            System.out.println("Nhập giá trị không hợp lệ, vui lòng nhập lại!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void Delete() {
        try {
            System.out.print("Nhập ID khách hàng cần xóa: ");
            Integer ID_Khachhang = input.nextInt();
            Khachhang k_hang = null;

            for (Khachhang khachhang : DSKH) {
                if (khachhang.getID_Customer().equals(ID_Khachhang)) {
                    k_hang = khachhang;
                    break;
                }
            }

            if (k_hang == null) {
                System.out.println("ID khách hàng không tồn tại. Xin vui lòng nhập lại!");
                return;
            }

            for (int i = 0; i < DSKH.size(); i++) {
                if (ID_Khachhang.equals(DSKH.get(i).getID_Customer())) {
                    DSKH.remove(i);
                }
            }
        } catch (InputMismatchException ei) {
            System.out.println("Nhập giá trị không hợp lệ, vui lòng nhập lại!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void Search_byCategory() {
        ArrayList<Khachhang> result = new ArrayList<>();
        System.out.println("Nhập mục lục cần tìm kiếm: ");
        System.out.println("1.Mã khách hàng");
        System.out.println("2.Tên khách hàng");
        System.out.println("3.Địa chỉ khách hàng");
        System.out.println("4.Số điện thoại khách hàng");
        int choose = input.nextInt();

        DSKH.forEach((khachhang) -> {
            switch (choose) {
                case 1 -> {
                    System.out.print("Nhập ID khách hàng: ");
                    int ID_Customer = input.nextInt();
                    if (ID_Customer == khachhang.getID_Customer()) {
                        result.add(khachhang);
                    }
                }
                case 2 -> {
                    input.nextLine();
                    System.out.print("Nhập tên khách hàng: ");
                    String nameCustomer = input.nextLine();
                    if (khachhang.getName().toLowerCase().contains(nameCustomer.toLowerCase())) {
                        result.add(khachhang);
                    }
                }
                case 3 -> {
                    input.nextLine();
                    System.out.print("Nhập địa chỉ của khách hàng: ");
                    String address = input.nextLine();
                    if (khachhang.getAddress().toLowerCase().contains(address.toLowerCase())) {
                        result.add(khachhang);
                    }
                }
                case 4 -> {
                    input.nextLine();
                    System.out.print("Nhập số điện thoại của khách hàng: ");
                    String phoneNumber = input.nextLine();
                    if (khachhang.getPhoneNumber().toLowerCase().contains(phoneNumber.toLowerCase())) {
                        result.add(khachhang);
                    }
                }
            }
        });

        String header = String.format("%s %15s %15s %15s %50s %40s %10s %11s", "Họ tên", "Tuổi", "Giới Tính", "Địa chỉ", "Email", "ID Khách hàng", "Loại khách hàng", "Số điện thoại");
        System.out.println(header);
        for (Khachhang DSKH : result) {
            String row = String.format("%s %15s %15s %15s %50s %40s %10s %5s %11s",DSKH.getName(), DSKH.getID_Customer(), DSKH.getAge(), DSKH.getGender(),
                    DSKH.getAddress(), DSKH.getEmail(), DSKH.getID_Customer(), DSKH.getKindOfCustomer(), DSKH.getPhoneNumber());
            System.out.println(row);
        }
    }
    public void Output() {
        System.out.println("Danh sách khách hàng:");
        String header = String.format("%s %15s %15s %15s %50s %40s %10s %11s", "Họ tên", "Tuổi", "Giới Tính", "Địa chỉ", "Email", "ID Khách hàng", "Loại khách hàng", "Số điện thoại");
        System.out.println(header);
        for (Khachhang DSKH : DSKH) {
            String row = String.format("%s %15s %15s %15s %50s %40s %10s %11s", DSKH.getName(), DSKH.getAge(), DSKH.getGender(),
                    DSKH.getAddress(), DSKH.getEmail(), DSKH.getID_Customer(), DSKH.getKindOfCustomer(), DSKH.getPhoneNumber());
            System.out.println(row);
        }
    }
}
