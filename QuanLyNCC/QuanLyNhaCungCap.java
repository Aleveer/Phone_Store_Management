package QuanLyNCC;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class QuanLyNhaCungCap extends NhaCungCap {
    public ArrayList<NhaCungCap> DSNCC = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public void Add() {
        input.nextLine();
        System.out.print("Nhập mã nhà cung cấp:");
        setMaNCC(input.nextInt());

        input.nextLine();
        System.out.print("Nhập tên nhà cung cấp:");
        setTenNCC(input.nextLine());

        input.nextLine();
        System.out.print("Nhập địa chỉ:");
        setDiaChi(input.nextLine());

        input.nextLine();
        System.out.print("Nhập số điện thoaị:");
        setSDT(input.nextLine());

        input.nextLine();
        System.out.print("Nhập Fax nhà cung cấp:");
        setFax(input.nextLine());

        NhaCungCap nhaCungCap = new NhaCungCap(getMaNCC(), getTenNCC(), getDiaChi(), getSDT(), getFax());
        DSNCC.add(nhaCungCap);
    }

    public void Update() {
        try {
            System.out.print("Nhập mã nhà cung cấp cần chỉnh sửa: ");
            Integer ID_ncc = input.nextInt();
            NhaCungCap ncc = null;

            for (NhaCungCap nhaCungCap : DSNCC) {
                if (nhaCungCap.getMaNCC().equals(ID_ncc)) {
                    ncc = nhaCungCap;
                    break;
                }
            }

            if(ncc == null) {
                System.out.println("Mã nhà cung cấp không tồn tại!");
                return;
            }

            System.out.println("Thông tin phiếu nhập: ");
            String header = String.format("%s %15s %15s %15s %15s", "Mã nhà cung cấp", "Tên nhà cung cấp", "Địa chỉ", "Số điện thoại", "Fax");
            System.out.println(header);

            String row = String.format("%s %10s %10s %10s %10s", ncc.getMaNCC(), ncc.getTenNCC(), ncc.getDiaChi(),
                    ncc.getSDT(), ncc.getFax());
            System.out.println(row);

            for (NhaCungCap nhaCungCap : DSNCC) {
                if (ID_ncc.equals(nhaCungCap.getMaNCC())) {

                    input.nextLine();
                    System.out.print("Nhập tên nhà cung cấp:");
                    setTenNCC(input.nextLine());

                    input.nextLine();
                    System.out.print("Nhập địa chỉ:");
                    setDiaChi(input.nextLine());

                    input.nextLine();
                    System.out.print("Nhập số điện thoại:");
                    setSDT(input.nextLine());

                    input.nextLine();
                    System.out.print("Nhập số Fax:");
                    setFax(input.nextLine());

                    nhaCungCap.setTenNCC(getTenNCC());
                    nhaCungCap.setDiaChi(getDiaChi());
                    nhaCungCap.setSDT(getSDT());
                    nhaCungCap.setFax(getFax());
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
            System.out.print("Nhập mã nhà cung cấp cần xóa: ");
            Integer ID_ncc = input.nextInt();
            NhaCungCap ncc = null;

            for (NhaCungCap nhaCungCap : DSNCC) {
                if (nhaCungCap.getMaNCC().equals(ID_ncc)) {
                    ncc = nhaCungCap;
                    break;
                }
            }

            if(ncc == null) {
                System.out.println("Mã nhà cung cấp không tồn tại!");
                return;
            }

            for (int i=0; i< DSNCC.size(); i++) {
                if (ID_ncc.equals(DSNCC.get(i).getMaNCC())) {
                    DSNCC.remove(i);
                }
            }
        } catch (InputMismatchException ei) {
            System.out.println("Nhập giá trị không hợp lệ, vui lòng nhập lại!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void Search_byCategory() {
        ArrayList<NhaCungCap> result = new ArrayList<>();
        System.out.println("Nhập mục lục cần tìm kiếm: ");
        System.out.println("1.Mã nhà cung cấp");
        System.out.println("2.Tên nhà cung cấp");
        System.out.println("3.Địa chỉ nhà cung cấp");
        System.out.println("4.Số điện thoại");
        System.out.println("5.Số Fax");
        int choose = input.nextInt();
        DSNCC.forEach((nhaCungCap) -> {
            switch (choose) {
                case 1 -> {
                    input.nextLine();
                    System.out.print("Nhập mã nhà cung cấp: ");
                    int ID_ncc = input.nextInt();
                    if (ID_ncc == nhaCungCap.getMaNCC()) {
                        result.add(nhaCungCap);
                    }
                }
                case 2 -> {
                    input.nextLine();
                    System.out.print("Nhập tên nhà cung cấp: ");
                    String name = input.nextLine();
                    if (nhaCungCap.getTenNCC().toLowerCase().contains(name.toLowerCase())) {
                        result.add(nhaCungCap);
                    }
                }
                case 3 -> {
                    input.nextLine();
                    System.out.print("Nhập địa chỉ: ");
                    String address = input.nextLine();
                    if (nhaCungCap.getDiaChi().toLowerCase().contains(address.toLowerCase())) {
                        result.add(nhaCungCap);
                    }
                }
                case 4 -> {
                    input.nextLine();
                    System.out.print("Nhập số điện thoại: ");
                    String sdt = input.nextLine();
                    if (nhaCungCap.getSDT().toLowerCase().contains(sdt.toLowerCase())) {
                        result.add(nhaCungCap);
                    }
                }
                case 5 -> {
                    input.nextLine();
                    System.out.print("Nhập số Fax: ");
                    String fax = input.nextLine();
                    if (nhaCungCap.getFax().toLowerCase().contains(fax.toLowerCase())) {
                        result.add(nhaCungCap);
                    }
                }
            }
        });
        String header = String.format("%s %15s %15s %15s %15s", "Mã nhà cung cấp", "Tên nhà cung cấp", "Địa chỉ", "Số điện thoại", "Số Fax");
        System.out.println(header);
        for(NhaCungCap DSNCC : result) {
            String row = String.format("%s %15s %15s %15s %15s",DSNCC.getMaNCC(),DSNCC.getTenNCC(),DSNCC.getDiaChi(),
                    DSNCC.getSDT(),DSNCC.getFax());
            System.out.println(row);
        }
    }

    public void Output() {
        String header = String.format("%s %15s %15s %15s %15s", "Mã nhà cung cấp", "Tên nhà cung cấp", "Địa chỉ", "Số điện thoại", "Số Fax");
        System.out.println(header);
        for(NhaCungCap DSNCC : DSNCC) {
            String row = String.format("%s %15s %15s %15s %15s",DSNCC.getMaNCC(),DSNCC.getTenNCC(),DSNCC.getDiaChi(),
                    DSNCC.getSDT(),DSNCC.getFax());
            System.out.println(row);
        }
    }
}