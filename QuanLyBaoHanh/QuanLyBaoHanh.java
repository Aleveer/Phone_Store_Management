package QuanLyBaoHanh;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyBaoHanh extends BaoHanh {
    public ArrayList<BaoHanh> DSBH = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    public void Add() {
        input.nextLine();
        System.out.print("Nhập số năm bảo hành:");
        setSoNamBaoHanh(input.nextInt());

        System.out.print("Nhập mã khách hàng:");
        setID_Customer(input.nextInt());

        System.out.print("Nhập SDT khách hàng:");
        input.nextLine();
        setPhoneNumber(input.nextLine());

        setNgayMua(LocalDate.now());

        BaoHanh baoHanh = new BaoHanh(getNgayMua(), getSoNamBaoHanh(), getID_Customer(), getPhoneNumber());
        DSBH.add(baoHanh);
    }

    public void Search_byCategory() {
        ArrayList<BaoHanh> result = new ArrayList<>();
//        LocalDate _ngay1;
//        LocalDate _ngay2;
//        int _tong1;
//        int _tong2;
        System.out.println("Nhập mục lục cần tìm kiếm: ");
        System.out.println("1.Mã khách hàng");
        System.out.println("2.Số điện thoại");
        System.out.println("3.Số năm bảo hành");
        System.out.println("4.Ngày mua hàng");
        int choose = input.nextInt();
        DSBH.forEach((baoHanh) -> {
            switch (choose) {
                case 1 -> {
                    System.out.print("Mã khách hàng: ");
                    int ID_Customer = input.nextInt();
                    if (baoHanh.getID_Customer().equals(ID_Customer)) {
                        result.add(baoHanh);
                    }
                }
                case 2 -> {
                    System.out.print("Số điện thoại: ");
                    int PhoneNumber = input.nextInt();
                    if (baoHanh.getPhoneNumber().equals(PhoneNumber)) {
                        result.add(baoHanh);
                    }
                }
                case 3 -> {
                    System.out.print("Số năm bảo hành: ");
                    int SoNamBaoHanh = input.nextInt();
                    if (baoHanh.getSoNamBaoHanh().equals(SoNamBaoHanh)) {
                        result.add(baoHanh);
                    }
                }
                case 4 -> {
                    System.out.print("Ngày mua hàng: ");
                    input.nextLine();
                    LocalDate ngayMua = LocalDate.parse(input.nextLine());
                    if (baoHanh.getNgayMua().isEqual(ngayMua)) {
                        result.add(baoHanh);
                    }
                }

            }
        });

        System.out.println("----------------------------------------------------------------------");
        String header = String.format("%s   |%15s | %15s | %15s |", "Mã khách hàng", "Số năm bảo hành", "Số điện thoại", "Ngày mua");
        System.out.println(header);
        for(BaoHanh DSBH : result) {
            System.out.println("----------------------------------------------------------------------");

            String row = String.format("%s \t\t\t\t| %s \t\t\t | %15s | %15s |", DSBH.getID_Customer(), DSBH.getSoNamBaoHanh(), DSBH.getPhoneNumber(),
                    DSBH.getPhoneNumber());
            System.out.println(row);
        }
        System.out.println("----------------------------------------------------------------------");
    }

    public void Output() {
        System.out.print("Danh sách phiếu bảo hành của khách hàng: \n");
        System.out.println("----------------------------------------------------------------------");
        String header = String.format("%s   |%15s | %15s | %15s |", "Mã khách hàng", "Số năm bảo hành", "Số điện thoại", "Ngày mua");
        System.out.println(header);
        for(BaoHanh DSBH : DSBH) {
            System.out.println("----------------------------------------------------------------------");
            String row = String.format("%s \t\t\t\t| %s \t\t\t | %15s | %15s |", DSBH.getID_Customer(), DSBH.getSoNamBaoHanh(), DSBH.getPhoneNumber(),
                    DSBH.getNgayMua());
            System.out.println(row);
        }
        System.out.println("----------------------------------------------------------------------");
    }
}
