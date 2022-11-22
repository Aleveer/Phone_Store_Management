package QuanLyPhieuNhap;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class QuanLyPhieuNhap extends PhieuNhap {
    public ArrayList<PhieuNhap> DSPN = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    public void Add() {
        input.nextLine();
        System.out.print("Nhập ID phiếu nhập:");
        setID_PhieuNhap(input.nextInt());

        System.out.print("Nhập mã của nhà cung cấp:");
        setID_Supplier(input.nextInt());

        System.out.print("Nhập mã của nhân viên:");
        setID_Worker(input.nextInt());

        System.out.print("Nhập tên nhà cung cấp:");
        input.nextLine();
        setName_supplier(input.nextLine());

        System.out.print("Nhập giá tiền: ");
        setPrice(input.nextFloat());

        setNgayNhap(LocalDate.now());
        setGioNhap(LocalTime.now());

        PhieuNhap phieuNhap = new PhieuNhap(getPrice(), getID_Supplier(), getID_Worker(), getID_PhieuNhap(), getName_supplier(), getNgayNhap(), getGioNhap());
        DSPN.add(phieuNhap);
    }

    public void Update() {
        try {
            System.out.print("Nhập ID phiếu nhập cần chỉnh sửa: ");
            Integer ID_Phieunhap = input.nextInt();
            PhieuNhap p_nhap = null;

            for (PhieuNhap phieuNhap : DSPN) {
                if (phieuNhap.getID_PhieuNhap().equals(ID_Phieunhap)) {
                    p_nhap = phieuNhap;
                    break;
                }
            }

            if(p_nhap == null) {
                System.out.println("Mã phiếu nhập không tồn tại!");
                return;
            }

            System.out.println("Thông tin phiếu nhập: ");
            String header = String.format("%s %15s %15s %15s %15s %15s %15s", "Mã phiếu nhập", "Mã nhà cung cấp", "Tên nhà cung cấp", "Mã nhân viên", "Ngày nhập", "Giờ nhập", "Giá tiền");
            System.out.println(header);

            String row = String.format("%s %10s %10s %10s %10s %10s %10s", p_nhap.getID_PhieuNhap(), p_nhap.getID_Supplier(), p_nhap.getID_Worker(),
                    p_nhap.getName_supplier(), p_nhap.getNgayNhap(), p_nhap.getGioNhap(), p_nhap.getPrice());
            System.out.println(row);

            for (PhieuNhap phieuNhap : DSPN) {
                if (ID_Phieunhap.equals(phieuNhap.getID_PhieuNhap())) {

                    System.out.print("Nhập mã nhà cung cấp:");
                    setID_Supplier(input.nextInt());

                    System.out.print("Nhập tên nhà cung cấp:");
                    input.nextLine();
                    setName_supplier(input.nextLine());

                    System.out.print("Nhập mã nhân viên:");
                    setID_Worker(input.nextInt());

                    System.out.print("Nhập giá tiền: ");
                    setPrice(input.nextFloat());

                    setNgayNhap(LocalDate.now());
                    setGioNhap(LocalTime.now());

                    phieuNhap.setID_Supplier(getID_Supplier());
                    phieuNhap.setName_supplier(getName_supplier());
                    phieuNhap.setID_Worker(getID_Worker());
                    phieuNhap.setPrice(getPrice());
                    phieuNhap.setNgayNhap(getNgayNhap());
                    phieuNhap.setGioNhap(getGioNhap());
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
            PhieuNhap p_nhap = null;

            for (PhieuNhap phieuNhap : DSPN) {
                if (phieuNhap.getID_PhieuNhap().equals(ID_Phieunhap)) {
                    p_nhap = phieuNhap;
                    break;
                }
            }

            if(p_nhap == null) {
                System.out.println("ID phiếu nhập không tồn tại.");
                return;
            }

            for (int i=0; i< DSPN.size(); i++) {
                if (ID_Phieunhap.equals(DSPN.get(i).getID_PhieuNhap())) {
                    DSPN.remove(i);
                }
            }
        } catch (InputMismatchException ei) {
            System.out.println("Nhập giá trị không hợp lệ, vui lòng nhập lại!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void Search_byCategory() {
        ArrayList<PhieuNhap> result = new ArrayList<>();
        System.out.println("Nhập mục lục cần tìm kiếm: ");
        System.out.println("1.Mã phiếu nhập");
        System.out.println("2.Mã nhà cung cấp");
        System.out.println("3.Tên nhà cung cấp");
        System.out.println("4.Mã nhân viên");
        int choose = input.nextInt();
        DSPN.forEach((phieuNhap) -> {
                    switch (choose) {
                        case 1 -> {
                            input.nextLine();
                            System.out.print("Nhập ID phiếu nhập: ");
                            int ID_phieunhap = input.nextInt();
                            if (ID_phieunhap == phieuNhap.getID_PhieuNhap()) {
                                result.add(phieuNhap);
                            }
                        }
                        case 2 -> {
                            input.nextLine();
                            System.out.print("Nhập mã nhà cung cấp: ");
                            int ID_supplier = input.nextInt();
                            if (ID_supplier == phieuNhap.getID_Supplier()) {
                                result.add(phieuNhap);
                            }
                        }
                        case 3 -> {
                            input.nextLine();
                            System.out.print("Nhập tên nhà cung cấp: ");
                            String name = input.nextLine();
                            if (phieuNhap.getName_supplier().toLowerCase().contains(name.toLowerCase())) {
                                result.add(phieuNhap);
                            }
                        }
                        case 4 -> {
                            System.out.print("Nhập mã nhân viên: ");
                            input.nextLine();
                            int ID_worker = input.nextInt();
                            if (ID_worker == phieuNhap.getID_Worker()) {
                                result.add(phieuNhap);
                            }
                        }
                    }
                }
        );

        String header = String.format("%s %15s %15s %15s %15s %15s %15s", "Mã phiếu nhập", "Mã nhà cung cấp", "Tên nhà cung cấp", "Mã nhân viên", "Ngày nhập", "Giờ nhập", "Giá tiền");
        System.out.println(header);
        for(PhieuNhap DSPN : result) {
            String row = String.format("%s %15s %15s %15s %15s %15s %15s",DSPN.getID_PhieuNhap(),DSPN.getID_Supplier(),DSPN.getName_supplier(),
                    DSPN.getID_Worker(),DSPN.getNgayNhap(),DSPN.getGioNhap(),DSPN.getPrice());
            System.out.println(row);
        }
    }

    public void Output() {
        System.out.print("Danh sách phiếu nhập");
        String header = String.format("%s %15s %15s %15s %15s %15s %15s", "Mã phiếu nhập", "Mã nhà cung cấp", "Tên nhà cung cấp", "Mã nhân viên", "Ngày nhập", "Giờ nhập", "Giá tiền");
        System.out.println(header);
        for(PhieuNhap DSPN : DSPN) {
            String row = String.format("%s %15s %15s %15s %15s %15s %15s",DSPN.getID_PhieuNhap(),DSPN.getID_Supplier(),DSPN.getName_supplier(),
                    DSPN.getID_Worker(),DSPN.getNgayNhap(),DSPN.getGioNhap(),DSPN.getPrice());
            System.out.println(row);
        }
    }
}
