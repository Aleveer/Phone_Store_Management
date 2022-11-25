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
        System.out.println("\t\t\t\t\t\t\t\t +----NHẬP THÔNG TIN KHÁCH HÀNG----+");
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
            System.out.println("\t\t\t\t\t\t\t\t +----CẬP NHẬT LẠI THÔNG TIN KHÁCH HÀNG----+");
            System.out.print("\t\t\t\t\t\t\t\t - Mời bạn nhập mã khách hàng cần chỉnh sửa: ");
            Integer ID_Khachhang = input.nextInt();
            Khachhang k_hang = null;

            for (Khachhang khachhang : DSKH) {
                if (khachhang.getID_Customer().equals(ID_Khachhang)) {
                    k_hang = khachhang;
                    break;
                }
            }

            if (k_hang == null) {
                System.out.println("Mã khách hàng không tồn tại!");
                return;
            }

            System.out.println("\t\t\t\t\t\t\t\t +----THÔNG TIN KHÁCH HÀNG TRƯỚC KHI CHỈNH SỬA----+");
            String header = String.format("|\t\t%s\t\t|\t%s\t|\t%s\t|\t\t%s\t|\t%s\t|\t%s\t|\t%s\t|\t%s\t|",
                    "Họ tên khách hàng", "Tuổi", "Giới tính", "Địa chỉ", "Email", "Mã khách hàng", "Loại khách hàng", "SDT");
            System.out.println(header);

            String row = String.format("|\t\t%s\t\t|\t%s\t|\t%s\t|\t\t%s\t|\t%s\t|\t%s\t|\t%s\t|\t%s\t|",
                    k_hang.getName(), k_hang.getAge(), k_hang.getGender(),
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
            System.out.println("\t\t\t\t\t\t\t\t +----XÓA THÔNG TIN KHÁCH HÀNG----+");
            System.out.println("\t\t\t\t\t\t\t\t Nhập mã khách hàng cần xóa: ");
            Integer ID_Khachhang = input.nextInt();
            Khachhang k_hang = null;

            for (Khachhang khachhang : DSKH) {
                if (khachhang.getID_Customer().equals(ID_Khachhang)) {
                    k_hang = khachhang;
                    break;
                }
            }

            if (k_hang == null) {
                System.out.println("Mã khách hàng không tồn tại!");
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
        System.out.println("\t\t\t\t\t\t\t\t +--------NHẬP MỤC LỤC CẨN TÌM KIẾM--------+");
        System.out.println("\t\t\t\t\t\t\t\t |0.Thoát                                  |");
        System.out.println("\t\t\t\t\t\t\t\t +-----------------------------------------+");
        System.out.println("\t\t\t\t\t\t\t\t |1.Mã khách hàng                          |");
        System.out.println("\t\t\t\t\t\t\t\t |2.Tên khách hàng                         |");
        System.out.println("\t\t\t\t\t\t\t\t |3.Địa chỉ khách hàng                     |");
        System.out.println("\t\t\t\t\t\t\t\t |4.Số điện thoại khách hàng               |");
        System.out.println("\t\t\t\t\t\t\t\t +-----------------------------------------+");
        System.out.print("\t\t\t\t\t\t\t\t - Mời Bạn Nhập Lựa Chọn: ");
        int choose = input.nextInt();
        if (choose == 0) return; else {
            DSKH.forEach((khachhang) -> {
                switch (choose) {
                    case 1 -> {
                        System.out.print("Nhập mã khách hàng: ");
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
        }
        System.out.println("\t\t\t\t\t\t\t\t +----THÔNG TIN KHÁCH HÀNG TÌM ĐƯỢC----+");
        String header = String.format("|\t\t%s\t\t|\t%s\t|\t%s\t|\t\t%s\t|\t%s\t|\t%s\t|\t%s\t|\t%s\t|",
                "Họ tên khách hàng", "Tuổi", "Giới tính", "Địa chỉ", "Email", "Mã khách hàng", "Loại khách hàng", "SDT");
        System.out.println(header);

        for (Khachhang DSKH : result) {
            String row = String.format("|\t\t%s\t\t|\t%s\t|\t%s\t|\t\t%s\t|\t%s\t|\t%s\t|\t%s\t|\t%s\t|",DSKH.getName(), DSKH.getAge(), DSKH.getGender(), DSKH.getAddress(),
                    DSKH.getEmail(), DSKH.getID_Customer(), DSKH.getKindOfCustomer(), DSKH.getPhoneNumber());
            System.out.println(row);
        }
    }
    public void Output() {
        System.out.println("\t\t\t\t\t\t\t\t +----DANH SÁCH KHÁCH HÀNG----+");
        String header = String.format("|\t\t%s\t\t\t|\t\t%s\t\t\t|\t\t%s\t\t|\t\t\t\t\t\t%s\t\t\t\t\t\t|\t\t\t\t%s\t\t\t\t|\t\t%s\t\t|\t\t%s\t\t|\t\t%s\t\t|",
                "Họ tên khách hàng", "Tuổi", "Giới tính", "Địa chỉ", "Email", "Mã khách hàng", "Loại khách hàng", "SDT");
        System.out.println(header);
        for (Khachhang DSKH : DSKH) {
            String row = String.format("|\t\t%s\t\t|\t%s\t|\t%s\t|\t\t%s\t|\t%s\t|\t%s\t|\t%s\t|\t%s\t|",DSKH.getName(), DSKH.getAge(), DSKH.getGender(), DSKH.getAddress(),
                    DSKH.getEmail(), DSKH.getID_Customer(), DSKH.getKindOfCustomer(), DSKH.getPhoneNumber());
            System.out.println(row);
        }
    }
}
