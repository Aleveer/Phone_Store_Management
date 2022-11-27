package QuanLyBaoHanh;

import QuanLyKhachHang.Khachhang;
import WorkwithFiles.Stream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;
public class QuanLyBaoHanh extends BaoHanh {
    public BaoHanh[] bh = null;

    public QuanLyBaoHanh(int size) {
        super();
        bh = new BaoHanh[size];
    }

    public QuanLyBaoHanh() {
        super();
    }

    static Scanner input = new Scanner(System.in);

    public BaoHanh[] getListBaoHanh() throws FileNotFoundException {
        String[] result = Stream.read("C:\\Users\\duyph\\Desktop\\ProjectOOP_Final\\DuLieu\\insurance.txt");
        bh = new BaoHanh[result.length];
        for (int i = 0; i < result.length; i++) {
            String[] row = result[i].split(";");
            bh[i] = new BaoHanh(row[0], LocalDate.parse(row[1]), Integer.parseInt(row[2]), row[3], row[4], row[5], row[6]);
        }
        return bh;
    }

    public void waitConsole() {
        input.nextLine();
        System.out.println("\t\t\t\t\t\t\t\t -Ấn Enter để tiếp tục");
        input.nextLine();
    }

    public void read() throws FileNotFoundException {
        try {
            System.out.println("\t\t\t\t\t\t\t\t +----DANH SÁCH BẢO HÀNH----+");
            String header = String.format("| %-5s | %-25s | %-4s | %-9s | %-30s | %-25s | %-18s |", "Mã sản phẩm", "Ngày mua", "Số năm bảo hành", "Gói bảo hành", "Mã khách hàng", "Họ tên khách hàng", "Số điện thoại");
            System.out.format("+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");
            System.out.println(header);
            System.out.format("+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");

            getListBaoHanh();
            for (BaoHanh baoHanh : bh) {
                if (bh[0].getID_Product().contains("sp")) {
                    String read = String.format("| %-11s | %-25s | %-15s | %-12s | %-30s | %-25s | %-18s |", baoHanh.getID_Product(), baoHanh.getNgayMua(), baoHanh.getSoNamBaoHanh(),
                            baoHanh.getGoiBaoHanh(), baoHanh.getID_Customer(), baoHanh.getHoTenKH(), baoHanh.getPhoneNumber());
                    System.out.println(read);
                }
            }
            System.out.format("+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");
            waitConsole();
        } catch (FileNotFoundException ex) {
            System.out.println("Wrong!!!");
        }
    }

    public void Add() {
        System.out.println("\t\t\t\t\t\t\t\t +----NHẬP THÔNG TIN VỀ BẢO HÀNH----+");
        System.out.println("Nhập mã sản phẩm: ");
        setID_Product(input.nextLine());

        for (BaoHanh baohanh : bh) {
            if (baohanh != null) {
                if (getID_Product().equals(baohanh.getID_Product())) {
                    System.out.println("\t\t\t\t\t\t\t\t -MÃ SẢN PHẨM BỊ TRÙNG!");
                    break;
                }
            }
        }

        System.out.print("Nhập ngày mua hàng:");
        setNgayMua(LocalDate.parse(input.nextLine()));

        System.out.print("Nhập số năm bảo hành:");
        setSoNamBaoHanh(input.nextInt());

        input.nextLine();
        System.out.print("Nhập gói bảo hành:");
        setGoiBaoHanh(input.nextLine());

        System.out.print("Nhập mã khách hàng:");
        setID_Customer(input.nextLine());

        System.out.print("Nhập họ tên khách hàng:");
        setHoTenKH(input.nextLine());

        System.out.print("Nhập SDT khách hàng:");
        setPhoneNumber(input.nextLine());

        try {
            String input = getID_Product() + ";" + getNgayMua() + ";" + getSoNamBaoHanh() + ";" + getGoiBaoHanh() + ";" + getID_Customer() + ";" + getHoTenKH() + ";" + getPhoneNumber() + ";";
            Stream.addOneLine("C:\\Users\\duyph\\Desktop\\ProjectOOP_Final\\DuLieu\\insurance.txt", input);
            System.out.println("\t\t\t\t\t\t\t\t+----NHẬP BẢO HÀNH THÀNH CÔNG----+");
            waitConsole();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BaoHanh[] addBH(BaoHanh[] bh, BaoHanh baoHanh) {
        bh = Arrays.copyOf(bh, bh.length + 1);
        bh[bh.length - 1] = baoHanh;
        return bh;
    }

    public void Search_byCategory() throws FileNotFoundException {
        BaoHanh[] result = new BaoHanh[0];
        System.out.println("\t\t\t\t\t\t\t\t +--------NHẬP MỤC LỤC CẨN TÌM KIẾM--------+");
        System.out.println("\t\t\t\t\t\t\t\t |0.Thoát                                  |");
        System.out.println("\t\t\t\t\t\t\t\t +-----------------------------------------+");
        System.out.println("\t\t\t\t\t\t\t\t |1.Mã khách hàng                          |");
        System.out.println("\t\t\t\t\t\t\t\t |2.Số điện thoại                          |");
        System.out.println("\t\t\t\t\t\t\t\t |3.Số năm bảo hành                        |");
        System.out.println("\t\t\t\t\t\t\t\t |4.Ngày mua hàng                          |");
        System.out.println("\t\t\t\t\t\t\t\t +-----------------------------------------+");
        System.out.print("\t\t\t\t\t\t\t\t - Mời Bạn Nhập Lựa Chọn: ");
        getListBaoHanh();
        int choose = input.nextInt();
        if (choose == 0) return;
        else {
            switch (choose) {
                case 1 -> {
                    input.nextLine();
                    System.out.print("Mã khách hàng: ");
                    String ID_Customer = input.nextLine();
                    for (BaoHanh baoHanh : bh) {
                        if (ID_Customer.contains(baoHanh.getID_Customer())) {
                            result = addBH(result, baoHanh);
                        }
                    }
                }
                case 2 -> {
                    input.nextLine();
                    System.out.print("Số điện thoại: ");
                    String PhoneNumber = input.nextLine();
                    for (BaoHanh baoHanh : bh) {
                        if (PhoneNumber.contains(baoHanh.getPhoneNumber())) {
                            result = addBH(result, baoHanh);
                        }
                    }
                }
                case 3 -> {
                    input.nextLine();
                    System.out.print("Số năm bảo hành: ");
                    int SoNamBaoHanh = input.nextInt();
                    for (BaoHanh baoHanh : bh) {
                        if (getSoNamBaoHanh().equals(SoNamBaoHanh)) {
                            result = addBH(result, baoHanh);
                        }
                    }
                }
                case 4 -> {
                    input.nextLine();
                    System.out.print("Ngày mua hàng (cú pháp năm-tháng-ngày): ");
                    LocalDate ngayMua = LocalDate.parse(input.nextLine());
                    for (BaoHanh baoHanh : bh) {
                        if (baoHanh.getNgayMua().isEqual(ngayMua)) {
                            result = addBH(result, baoHanh);
                        }
                    }
                }
            }
        }
        System.out.println("\t\t\t\t\t\t\t\t +----TẤT CẢ THÔNG TIN ĐÃ TÌM ĐƯỢC----+");
        String header = String.format("| %-5s | %-25s | %-4s | %-9s | %-30s | %-25s | %-18s |", "Mã sản phẩm", "Ngày mua", "Số năm bảo hành", "Gói bảo hành", "Mã khách hàng", "Họ tên khách hàng", "Số điện thoại");
        System.out.format("+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");
        System.out.println(header);

        for (BaoHanh baoHanh : result) {
            String row = String.format("| %-11s | %-25s | %-15s | %-12s | %-30s | %-25s | %-18s |", baoHanh.getID_Product(), baoHanh.getNgayMua(), baoHanh.getSoNamBaoHanh(),
                    baoHanh.getGoiBaoHanh(), baoHanh.getID_Customer(), baoHanh.getHoTenKH(), baoHanh.getPhoneNumber());
            System.out.println(row);
            waitConsole();
        }
        System.out.println("+----------------------------------------------------------------------+");
    }
}

