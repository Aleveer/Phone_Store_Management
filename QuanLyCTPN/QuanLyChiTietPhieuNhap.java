package QuanLyCTPN;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class QuanLyChiTietPhieuNhap extends ChiTietPhieuNhap {
    public ArrayList<ChiTietPhieuNhap> DSCTPN = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public void Add() {
        input.nextLine();
        System.out.print("Nhập ID phiếu nhập: ");
        setID_PhieuNhap(input.nextInt());

        System.out.print("Nhập mã sản phẩm: ");
        setID_Product(input.nextInt());

        System.out.print("Nhập số lượng: ");
        setAmount(input.nextInt());

        System.out.print("Nhập giá tiền: ");
        setPrice(input.nextFloat());

        ChiTietPhieuNhap chiTietPhieuNhap = new ChiTietPhieuNhap(getID_PhieuNhap(), getID_Product(), getAmount(), getPrice());
        DSCTPN.add(chiTietPhieuNhap);
    }

    public void Update() {
        try {
            System.out.print("Nhập mã phiếu nhập cần update: ");
            Integer ID_PhieuNhap = input.nextInt();
            ChiTietPhieuNhap ctp_nhap = null;

            for (ChiTietPhieuNhap chiTietPhieuNhap : DSCTPN) {
                if (chiTietPhieuNhap.getID_PhieuNhap().equals(ID_PhieuNhap)) {
                    ctp_nhap = chiTietPhieuNhap;
                    break;
                }
            }

            if(ctp_nhap == null) {
                System.out.println("Mã phiếu nhập không tồn tại!");
                return;
            }

            System.out.println("Thông tin phiếu nhập: ");
            String header = String.format("%s %15s %15s %15s", "Mã phiếu nhập", "Mã sản phẩm", "Số lượng", "Giá tiền");
            System.out.println(header);

            String row = String.format("%s %10s %10s %10s ", ctp_nhap.getID_PhieuNhap(), ctp_nhap.getID_Product(), ctp_nhap.getAmount(),
                    ctp_nhap.getPrice());
            System.out.println(row);

            for (ChiTietPhieuNhap chiTietPhieuNhap : DSCTPN) {
                if (ID_PhieuNhap.equals(chiTietPhieuNhap.getID_PhieuNhap())) {

                    System.out.print("Nhập mã sản phẩm:");
                    setID_Product(input.nextInt());

                    System.out.print("Nhập số lượng:");
                    input.nextLine();
                    setAmount(input.nextInt());

                    System.out.print("Nhập giá tiền:");
                    setPrice(input.nextInt());

                    chiTietPhieuNhap.setID_Product(getID_Product());
                    chiTietPhieuNhap.setAmount(getAmount());
                    chiTietPhieuNhap.setPrice(getPrice());
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
            System.out.print("Nhập ID phiếu nhập cần xóa: ");
            Integer ID_Phieunhap = input.nextInt();
            ChiTietPhieuNhap ctp_nhap = null;

            for (ChiTietPhieuNhap chiTietPhieuNhap : DSCTPN) {
                if (chiTietPhieuNhap.getID_PhieuNhap().equals(ID_Phieunhap)) {
                    ctp_nhap = chiTietPhieuNhap;
                    break;
                }
            }

            if(ctp_nhap == null) {
                System.out.println("ID phiếu nhập không tồn tại.");
                return;
            }

            for (int i=0; i< DSCTPN.size(); i++) {
                if (ID_Phieunhap.equals(DSCTPN.get(i).getID_PhieuNhap())) {
                    DSCTPN.remove(i);
                }
            }
        } catch (InputMismatchException ei) {
            System.out.println("Nhập giá trị không hợp lệ, vui lòng nhập lại!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void Search_byCategory() {
        ArrayList<ChiTietPhieuNhap> result = new ArrayList<>();
        System.out.println("Nhập mục lục cần tìm kiếm: ");
        System.out.println("1.Mã phiếu nhập");
        System.out.println("2.Mã sản phẩm");
        System.out.println("3.Số lượng sản phẩm");
        int choose = input.nextInt();
        DSCTPN.forEach((chiTietPhieuNhap) -> {
                    switch (choose) {
                        case 1 -> {
                            input.nextLine();
                            System.out.print("Nhập mã phiếu nhập: ");
                            int ID_phieunhap = input.nextInt();
                            if (ID_phieunhap == chiTietPhieuNhap.getID_PhieuNhap()) {
                                result.add(chiTietPhieuNhap);
                            }
                        }
                        case 2 -> {
                            input.nextLine();
                            System.out.print("Nhập mã sản phẩm: ");
                            int ID_product = input.nextInt();
                            if (ID_product == chiTietPhieuNhap.getID_Product()) {
                                result.add(chiTietPhieuNhap);
                            }
                        }
                        case 3 -> {
                            System.out.print("Nhập số lượng sản phẩm: ");
                            input.nextLine();
                            int amount = input.nextInt();
                            if (amount == chiTietPhieuNhap.getAmount()) {
                                result.add(chiTietPhieuNhap);
                            }
                        }
                    }
                }
        );

        System.out.println("---------------------------------------------------------------------");
        String header = String.format("%s | %15s | %15s | %15s |", "Mã phiếu nhập", "Mã sản phẩm", "Số lượng", "Giá tiền");
        System.out.println(header);
        for(ChiTietPhieuNhap DSCTPN : DSCTPN) {
            System.out.println("---------------------------------------------------------------------");
            String row = String.format("%s \t\t\t  | %15s | %15s | %15s |",DSCTPN.getID_PhieuNhap(),DSCTPN.getID_Product(),DSCTPN.getAmount(),
                    DSCTPN.getPrice());
            System.out.println(row);
        }
        System.out.println("---------------------------------------------------------------------");
    }

    public void Output() {
        System.out.println("Danh sách phiếu nhập \n");
        System.out.println("---------------------------------------------------------------------");
        String header = String.format("%s | %15s | %15s | %15s |", "Mã phiếu nhập", "Mã sản phẩm", "Số lượng", "Giá tiền");
        System.out.println(header);
        for(ChiTietPhieuNhap DSCTPN : DSCTPN) {
            System.out.println("---------------------------------------------------------------------");
            String row = String.format("%s \t\t\t  | %15s | %15s | %15s |",DSCTPN.getID_PhieuNhap(),DSCTPN.getID_Product(),DSCTPN.getAmount(),
                    DSCTPN.getPrice());
            System.out.println(row);
        }
        System.out.println("---------------------------------------------------------------------");

    }
}
