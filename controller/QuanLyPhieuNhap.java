package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import entity.PhieuNhap;
import view.DataAccessObject;

public class QuanLyPhieuNhap extends PhieuNhap implements DataAccessObject{
	public PhieuNhap[] DSPN;
    static Scanner input = new Scanner(System.in);
    public QuanLyPhieuNhap() throws FileNotFoundException {
        super();
        getListPhieuNhap();
    }
    public PhieuNhap[] getListPhieuNhap() throws FileNotFoundException {
        String[] result = Stream.read("src/database/deliveryReceived.txt");
        DSPN = new PhieuNhap[result.length];
        for (int i = 0; i < result.length; i++) {
            String[] row = result[i].split(";");
            DSPN[i] = new PhieuNhap(Float.parseFloat(row[0]), row[1], row[2], row[3], row[4], LocalDate.parse(row[5]), LocalTime.parse(row[6]));
        }
        return DSPN;
    }

    public void waitConsole() {
        System.out.println("\t\t\t\t\t\t\t\t -Ấn Enter để tiếp tục");
        input.nextLine();
    }

    public void Read() throws FileNotFoundException {
        System.out.println("\t\t\t\t\t\t\t\t +----DANH SÁCH PHIẾU NHẬP----+");
        String header = String.format("| %-5s | %-25s | %-4s | %-9s | %-30s | %-25s | %-15s |", "Giá Tiền", "Mã Nhà Cung Cấp", "Mã Nhân Viên", "Mã phiếu nhập", "Tên Nhà Cung Cấp", "Ngày Nhập", "Giờ Nhập");
        System.out.format("+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");
        System.out.println(header);
        System.out.format("+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");

        getListPhieuNhap();
        for (PhieuNhap phieunhap : DSPN) {
                String read = String.format("| %-5s | %-25s | %-4s | %-9s | %-30s | %-25s | %-15s |", phieunhap.getPrice(), phieunhap.getID_Supplier(), phieunhap.getID_Worker(),
                        phieunhap.getID_PhieuNhap(), phieunhap.getName_supplier(), phieunhap.getNgayNhap(), phieunhap.getGioNhap());
                System.out.println(read);
        }
        System.out.format("+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");
        waitConsole();
    }

    public void Create() {
        System.out.println("\t\t\t\t\t\t\t\t +----NHẬP THÔNG TIN PHIẾU NHẬP----+");
        input.nextLine();
        System.out.print("Nhập ID phiếu nhập:");
        setID_PhieuNhap(input.nextLine());
        int check = 0;
        for (PhieuNhap phieunhap : DSPN) {
            if (getID_PhieuNhap().equals(phieunhap.getID_PhieuNhap())) {
                check = 1;
                break;
            }
        }

        if (check == 1) {
            System.out.println("\t\t\t\t\t\t\t\t -MÃ PHIẾU NHẬP BỊ TRÙNG!");
            return;
        }

        System.out.print("Nhập giá tiền: ");
        setPrice(input.nextFloat());

        input.nextLine();
        System.out.print("Nhập mã của nhà cung cấp:");
        setID_Supplier(input.nextLine());

        System.out.print("Nhập mã của nhân viên:");
        setID_Worker(input.nextLine());

        System.out.print("Nhập tên nhà cung cấp:");
        setName_supplier(input.nextLine());

        setNgayNhap(LocalDate.now());
        setGioNhap(LocalTime.now());

        try {
            String input = getPrice() + ";" + getID_Supplier() + ";" + getID_Worker() + ";" + getID_PhieuNhap() + ";" + getName_supplier() + ";" + getNgayNhap() + ";" + getGioNhap();
            Stream.addOneLine("src/database/deliveryReceived.txt", input);
            System.out.println("\t\t\t\t\t\t\t\t+----NHẬP PHIẾU NHẬP THÀNH CÔNG----+");
            waitConsole();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Update() {
        try {
            System.out.println("\t\t\t\t\t\t\t\t +----CẬP NHẬT LẠI THÔNG TIN PHIẾU NHẬP----+");
            input.nextLine();
            System.out.print("\t\t\t\t\t\t\t\t - Mời bạn nhập mã sản phẩm chỉnh sửa: ");
            String ID_PhieuNhap = input.nextLine();
            PhieuNhap p_nhap = null;

            for (PhieuNhap phieunhap : DSPN) {
                if (phieunhap.getID_PhieuNhap().equalsIgnoreCase(ID_PhieuNhap)) {
                    p_nhap = phieunhap;
                    break;
                }
            }

            if (p_nhap == null) {
                System.out.println("\t\t\t\t\t\t\t\t -MÃ PHIẾU NHẬP KHÔNG TỒN TẠI!");
                return;
            }

            System.out.println("\t\t\t\t\t\t\t\t +----THÔNG TIN PHIẾU NHẬP TRƯỚC KHI CHỈNH SỬA----+");
            String header = String.format("| %-5s | %-25s | %-4s | %-9s | %-30s | %-25s | %-15s |", "Giá Tiền", "Mã Nhà Cung Cấp", "Mã Nhân Viên", "Mã phiếu nhập", "Tên Nhà Cung Cấp", "Ngày Nhập", "Giờ Nhập");
            System.out.format("+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");
            System.out.println(header);
            String row = String.format("|\t\t%s\t\t|\t%s\t|\t%s\t|\t\t%s\t|\t%s\t|\t%s\t|\t%s\t|",
                    p_nhap.getPrice(), p_nhap.getID_Supplier(), p_nhap.getID_Worker(),
                    p_nhap.getID_PhieuNhap(), p_nhap.getName_supplier(), p_nhap.getNgayNhap(), p_nhap.getGioNhap());
            System.out.println(row);

            String[] data = new String[DSPN.length];

            for (int i = 0; i < DSPN.length; i++) {
                if (DSPN[i].getID_PhieuNhap().equals(ID_PhieuNhap)) {
                    System.out.print("Nhập giá tiền: ");
                    setPrice(input.nextFloat());

                    input.nextLine();
                    System.out.print("Nhập ID phiếu nhập:");
                    setID_PhieuNhap(input.nextLine());

                    System.out.print("Nhập mã của nhà cung cấp:");
                    setID_Supplier(input.nextLine());

                    System.out.print("Nhập mã của nhân viên:");
                    setID_Worker(input.nextLine());

                    System.out.print("Nhập tên nhà cung cấp:");
                    input.nextLine();
                    setName_supplier(input.nextLine());

                    setNgayNhap(LocalDate.now());
                    setGioNhap(LocalTime.now());

                    DSPN[i].setPrice(getPrice());
                    DSPN[i].setID_Supplier(getID_Supplier());
                    DSPN[i].setID_Worker(getID_Worker());
                    DSPN[i].setName_supplier(getName_supplier());
                    DSPN[i].setNgayNhap(getNgayNhap());
                    DSPN[i].setGioNhap(getGioNhap());
                }
                data[i] = DSPN[i].getPrice() + ";" + DSPN[i].getID_Supplier() + ";" + DSPN[i].getID_Worker() + ";" + DSPN[i].getID_PhieuNhap() + ";" + DSPN[i].getName_supplier() + ";" + DSPN[i].getNgayNhap() + ";" + DSPN[i].getGioNhap();
            }
            try {
                Stream.addAll("src/database/deliveryReceived.txt", data);
                System.out.println("\t\t\t\t\t\t\t\t+----SỬA THÔNG TIN PHIẾU NHẬP THÀNH CÔNG----+");
                waitConsole();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (InputMismatchException ei) {
            System.out.println("\t\t\t\t\t\t\t\t GIÁ TRỊ KHÔNG HỢP LỆ. VUI LÒNG NHẬP LẠI!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void Delete() {
        try {
            System.out.println("\t\t\t\t\t\t\t\t +----XÓA THÔNG TIN PHIẾU NHẬP----+");
            System.out.println("\t\t\t\t\t\t\t\t -Nhập mã phiếu nhập cần xóa: ");
            String ID_PhieuNhap = input.nextLine();

            PhieuNhap cur_phieunhap = null;
            for (PhieuNhap phieunhap : DSPN) {
                if (phieunhap.getID_PhieuNhap().equals(ID_PhieuNhap)) {
                    cur_phieunhap = phieunhap;
                    break;
                }
            }
            for (int i = 0; i < DSPN.length; i++) {
                if (ID_PhieuNhap.equals(DSPN[i].getID_PhieuNhap())) {
                    DSPN = deletePhieuNhap(DSPN, i);
                    break;
                }
            }

            if (cur_phieunhap == null) {
                System.out.println("\t\t\t\t\t\t\t\t - MÃ PHIẾU NHẬP KHÔNG TỒN TẠI!");
                return;
            }

            for (int i = 0; i < DSPN.length; i++) {
                if (ID_PhieuNhap.equals(DSPN[i].getID_PhieuNhap())) {
                    DSPN = deletePhieuNhap(DSPN, i);
                    break;
                }
            }
            String[] data = new String[DSPN.length];
            for (int i = 0; i < DSPN.length; i++) {
                data[i] = DSPN[i].getPrice() + ";" + DSPN[i].getID_Supplier() + ";" + DSPN[i].getID_Worker() + ";" + DSPN[i].getID_PhieuNhap() + ";" + DSPN[i].getName_supplier() + ";" + DSPN[i].getNgayNhap() + ";" + DSPN[i].getGioNhap();
            }
            try {
                Stream.addAll("src/database/deliveryReceived.txt", data);
                System.out.println("\t\t\t\t\t\t\t\t +----XÓA THÔNG TIN PHIẾU NHẬP THÀNH CÔNG----+");
                waitConsole();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (InputMismatchException ei) {
            System.out.println("\t\t\t\t\t\t\t\t GIÁ TRỊ KHÔNG HỢP LỆ. VUI LÒNG NHẬP LẠI!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public PhieuNhap[] deletePhieuNhap(PhieuNhap[] DSPN, int index) {
        PhieuNhap[] newCs = new PhieuNhap[DSPN.length - 1];
        for (int i = 0, j = 0; i < DSPN.length; i++) {
            if (i != index) {
                newCs[j++] = DSPN[i];
            }
        }
        return newCs;
    }

    public PhieuNhap[] addPhieuNhap(PhieuNhap[] DSPN, PhieuNhap phieunhap) {
        DSPN = Arrays.copyOf(DSPN, DSPN.length + 1);
        DSPN[DSPN.length - 1] = phieunhap;
        return DSPN;
    }


    public void Search_byCategory() {
        PhieuNhap[] result = new PhieuNhap[0];
        System.out.println("\t\t\t\t\t\t\t\t +--------NHẬP MỤC LỤC CẨN TÌM KIẾM--------+");
        System.out.println("\t\t\t\t\t\t\t\t |0.Thoát                                  |");
        System.out.println("\t\t\t\t\t\t\t\t +-----------------------------------------+");
        System.out.println("\t\t\t\t\t\t\t\t |1.Giá tiền                               |");
        System.out.println("\t\t\t\t\t\t\t\t |2.Mã nhà cung cấp                        |");
        System.out.println("\t\t\t\t\t\t\t\t |3.Mã nhân viên                           |");
        System.out.println("\t\t\t\t\t\t\t\t |4.Mã phiếu nhập                          |");
        System.out.println("\t\t\t\t\t\t\t\t |5.Tên nhà cung cấp                       |");
        System.out.println("\t\t\t\t\t\t\t\t +-----------------------------------------+");
        System.out.print("\t\t\t\t\t\t\t\t - Mời Bạn Nhập Lựa Chọn: ");
        int choose = input.nextInt();
        if (choose == 0)
            return;
        else {
            switch (choose) {
                case 1 -> {
                    input.nextLine();
                    System.out.print("Nhập Giá tiền: ");
                    Float price = input.nextFloat();
                    for (PhieuNhap phieunhap : DSPN) {
                        if (price.equals(getPrice())) {
                            result = addPhieuNhap(result, phieunhap);
                        }
                    }
                }
                case 2 -> {
                    input.nextLine();
                    System.out.print("Nhập Mã Nhà Cung Cấp: ");
                    String ID_Supplier = input.nextLine();
                    for (PhieuNhap phieunhap : DSPN) {
                        if (phieunhap.getID_Supplier().toLowerCase().contains(ID_Supplier.toLowerCase())) {
                            result = addPhieuNhap(result, phieunhap);
                        }
                    }
                }
                case 3 -> {
                    input.nextLine();
                    System.out.print("Nhập Mã Nhân Viên: ");
                    String ID_Worker = input.nextLine();
                    for (PhieuNhap phieunhap : DSPN) {
                        if (phieunhap.getID_Worker().toLowerCase().contains(ID_Worker.toLowerCase())) {
                            result = addPhieuNhap(result, phieunhap);
                        }
                    }
                }
                case 4 -> {
                    input.nextLine();
                    System.out.print("Nhập Mã Phiếu Nhập: ");
                    String ID_PhieuNhap = input.nextLine();
                    for (PhieuNhap phieunhap : DSPN) {
                        if (phieunhap.getID_PhieuNhap().toLowerCase().contains(ID_PhieuNhap.toLowerCase())) {
                            result = addPhieuNhap(result, phieunhap);
                        }
                    }
                }
                case 5 -> {
                    input.nextLine();
                    System.out.print("Nhập Tên Nhà Cung Cấp: ");
                    String name_supplier = input.nextLine();
                    for (PhieuNhap phieunhap : DSPN) {
                        if (phieunhap.getName_supplier().toLowerCase().contains(name_supplier.toLowerCase())) {
                            result = addPhieuNhap(result, phieunhap);
                        }
                    }
                }
            }
        }
        System.out.println("\t\t\t\t\t\t\t\t +----TẤT CẢ THÔNG TIN ĐÃ TÌM ĐƯỢC----+");
        String header = String.format("| %-5s | %-10s | %-30s | %-30s | %-30s | %-10s | %-10s |", "Giá Tiền", "Mã Nhà Cung Cấp", "Mã Nhân Viên", "Mã phiếu nhập", "Tên Nhà Cung Cấp", "Ngày Nhập", "Giờ Nhập");
        System.out.format("+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");
        System.out.println(header);

        for (PhieuNhap phieunhap : result) {
            String read = String.format("| %-5s | %-10s | %-30s | %-30s | %-30s | %-10s | %-10s |", phieunhap.getPrice(), phieunhap.getID_Supplier(),
                    phieunhap.getID_Worker(), phieunhap.getID_PhieuNhap(), phieunhap.getName_supplier(), phieunhap.getNgayNhap(), phieunhap.getGioNhap());
            System.out.println(read);
        }
        waitConsole();
    }
}
