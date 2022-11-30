package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;
import entity.BaoHanh;

public class QuanLyBaoHanh extends BaoHanh {
	public BaoHanh[] bh;
    static Scanner input = new Scanner(System.in);

    public QuanLyBaoHanh() throws FileNotFoundException {
        super();
        getListBaoHanh();
    }

    //Lây danh sách bảo hành từ file
    public BaoHanh[] getListBaoHanh() throws FileNotFoundException {
        String[] result = Stream.read("src/database/insurance.txt");
        bh = new BaoHanh[result.length];
        for (int i = 0; i < result.length; i++) {
            String[] row = result[i].split(";");
            bh[i] = new BaoHanh(row[0], LocalDate.parse(row[1]), Integer.parseInt(row[2]), row[3], row[4], row[5], row[6]);
        }
        return bh;
    }

    //Đợi cho đến khi người dùng enter lần
	public void waitConsole() {
    	System.out.println("\t\t\t\t\t\t\t\t -Ấn Enter để tiếp tục");
	    input.nextLine();
    }

    public void read() throws FileNotFoundException {
            System.out.println("\t\t\t\t\t\t\t\t +----DANH SÁCH BẢO HÀNH----+");
            String header = String.format("| %-5s | %-25s | %-4s | %-25s | %-30s | %-25s | %-18s |", "Mã sản phẩm", "Ngày mua", "Số năm bảo hành", "Gói bảo hành", "Mã khách hàng", "Họ tên khách hàng", "Số điện thoại");
            System.out.format("+-------------+---------------------------+-----------------+---------------------------+--------------------------------+---------------------------+--------------------+%n");
            System.out.println(header);
            System.out.format("+-------------+---------------------------+-----------------+---------------------------+--------------------------------+---------------------------+--------------------+%n");

            getListBaoHanh();
            //Xuất các phần tử theo cột
            for (BaoHanh baoHanh : bh) {
                    String read = String.format("| %-11s | %-25s | %-15s | %-25s | %-30s | %-25s | %-18s |", baoHanh.getID_Product(), baoHanh.getNgayMua(), baoHanh.getSoNamBaoHanh(),
                            baoHanh.getGoiBaoHanh(), baoHanh.getID_Customer(), baoHanh.getHoTenKH(), baoHanh.getPhoneNumber());
                    System.out.println(read);
            }
        System.out.format("+-------------+---------------------------+-----------------+---------------------------+--------------------------------+---------------------------+--------------------+%n");
            waitConsole();
    }

    public void Create() {
        System.out.println("\t\t\t\t\t\t\t\t +----NHẬP THÔNG TIN VỀ BẢO HÀNH----+");
        System.out.println("Nhập mã sản phẩm: ");
        setID_Product(input.nextLine());

        int check = 0;
        for (BaoHanh baohanh : bh) {
            if (getID_Product().equals(baohanh.getID_Product())) {
                check = 1;
                break;
            }
        }

        if (check == 1) {
            System.out.println("\t\t\t\t\t\t\t\t -MÃ BẢO HÀNH BỊ TRÙNG!");
            return;
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
            Stream.addOneLine("src/database/insurance.txt", input);
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
        int choose = input.nextInt();
        if (choose == 0) return;
        else {
            switch (choose) {
                case 1 -> {
                    input.nextLine();
                    System.out.print("Mã khách hàng: ");
                    String ID_Customer = input.nextLine();
                    for (BaoHanh baoHanh : bh) {
                        if (baoHanh.getID_Customer().toLowerCase().contains(ID_Customer.toLowerCase())) {
                            result = addBH(result, baoHanh);
                        }
                    }
                }
                case 2 -> {
                    input.nextLine();
                    System.out.print("Số điện thoại: ");
                    String PhoneNumber = input.nextLine();
                    for (BaoHanh baoHanh : bh) {
                        if (baoHanh.getID_Customer().toLowerCase().contains(PhoneNumber.toLowerCase())) {
                            result = addBH(result, baoHanh);
                        }
                    }
                }
                case 3 -> {
                    input.nextLine();
                    System.out.print("Số năm bảo hành: ");
                    Integer sonambaohanh = input.nextInt();
                    for (BaoHanh baoHanh : bh) {
                        if (sonambaohanh.equals(getSoNamBaoHanh())) {
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
        System.out.format("+-------------+---------------------------+-----------------+---------------------------+--------------------------------+---------------------------+--------------------+%n");
        System.out.println(header);

        for (BaoHanh baoHanh : result) {
            String row = String.format("| %-5s | %-25s | %-4s | %-9s | %-30s | %-25s | %-18s |", baoHanh.getID_Product(), baoHanh.getNgayMua(), baoHanh.getSoNamBaoHanh(),
                    baoHanh.getGoiBaoHanh(), baoHanh.getID_Customer(), baoHanh.getHoTenKH(), baoHanh.getPhoneNumber());
            System.out.println(row); 
        }
        System.out.format("+-------------+---------------------------+-----------------+---------------------------+--------------------------------+---------------------------+--------------------+%n");
        waitConsole();
    }
}
