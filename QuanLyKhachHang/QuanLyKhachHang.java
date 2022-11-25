package QuanLyKhachHang;

import GiaoDien.DataAccessObject;
import WorkwithFiles.Stream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class QuanLyKhachHang extends Khachhang implements DataAccessObject {
    public Khachhang[] kh;

    public QuanLyKhachHang() {
        super();
    }

    static Scanner input = new Scanner(System.in);

    public Khachhang[] getListCustomer() throws FileNotFoundException {
        String[] result = Stream.read("src/database/customer.txt");
        kh = new Khachhang[result.length];
        for (int i = 0; i < result.length; i++) {
            String[] row = result[i].split(";");
            kh[i] = new Khachhang(row[0], row[1], row[2], row[3], Integer.parseInt(row[4]), row[5], row[6], row[7]);
        }
        return kh;
    }

    public void waitConsole() {
        input.nextLine();
        System.out.println("Ấn Enter để tiếp tục");
        input.nextLine();
    }
    public void read() throws FileNotFoundException {
        System.out.println("Danh sách khách hàng:");
        String header = String.format("| %-5s | %-25s | %-4s | %-9s | %-30s | %-25s | %-15s | %-20s |", "ID", "Họ tên", "Tuổi", "Giới Tính", "Địa chỉ", "Email", "Số điện thoại", "Loại khách hàng");
        System.out.format("+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");
        System.out.println(header);
        System.out.format("+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");

        getListCustomer();
        for (Khachhang khachhang : kh) {
            if (kh[0].getID_Customer().contains("kh")) {
                String read = String.format("| %-5s | %-25s | %-4s | %-9s | %-30s | %-25s | %-15s | %-20s |", khachhang.getID_Customer(), khachhang.getName(), khachhang.getAge(),
                        khachhang.getGender(), khachhang.getAddress(), khachhang.getEmail(), khachhang.getPhoneNumber(), khachhang.getKindOfCustomer());
                System.out.println(read);
            }
        }
        System.out.format("+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");
        waitConsole();
    }

    @Override
    public void Add() {
        System.out.println("\t\t\t\t\t\t\t\t +----NHẬP THÔNG TIN KHÁCH HÀNG----+");
        System.out.print("Nhập ID khách hàng: ");
        setID_Customer(input.nextLine());

        int check = 0;
        for (Khachhang khachhang : kh) {
            if (getID_Customer().equals(khachhang.getID_Customer())) {
                check = 1;
                break;
            }
        }

        if (check == 1) {
            System.out.println("Mã khách hàng bị trùng.");
            return;
        }
        super.Add();

        System.out.print("Nhập loại khách hàng: ");
        setKindOfCustomer(input.nextLine());

        try {
            String input = getID_Customer() + ";" + getName() + ";" + getAge() + ";" + getGender() + ";" + getAddress() + ";" + getEmail() + ";" + getPhoneNumber() + ";" + getKindOfCustomer();
            Stream.addOneLine("src/database/customer.txt", input);
            System.out.println("Nhập khách hàng thành công");
            waitConsole();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Update() {
        try {
            System.out.println("\t\t\t\t\t\t\t\t +----CẬP NHẬT LẠI THÔNG TIN KHÁCH HÀNG----+");
            System.out.print("\t\t\t\t\t\t\t\t - Mời bạn nhập mã khách hàng cần chỉnh sửa: ");
            String ID_Khachhang = input.nextLine();
            Khachhang k_hang = null;

            for (Khachhang khachhang : kh) {
                if (khachhang.getID_Customer().equalsIgnoreCase(ID_Khachhang)) {
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

            String[] data = new String[kh.length];

            for (int i = 0; i < kh.length; i++) {
                if (ID_Khachhang.equalsIgnoreCase(getID_Customer())) {
                    System.out.println("Nhập thông tin khách hàng:");
                    super.Add();

                    System.out.print("Nhập loại khách hàng: ");
                    setKindOfCustomer(input.nextLine());

                    kh[i].setName(getName());
                    kh[i].setGender(getGender());
                    kh[i].setAddress(getAddress());
                    kh[i].setEmail(getEmail());
                    kh[i].setAge(getAge());
                    kh[i].setPhoneNumber(getPhoneNumber());
                    kh[i].setKindOfCustomer(getKindOfCustomer());
                }
                data[i] = kh[i].getID_Customer() + ";" + kh[i].getName() + ";" + kh[i].getAge() + ";" + kh[i].getGender() + ";" + kh[i].getAddress() + ";" + kh[i].getEmail() + ";" + kh[i].getPhoneNumber() + ";" + kh[i].getKindOfCustomer();
            }
            try {
                Stream.addAll("src/database/customer.txt", data);
                System.out.println("\t\t\t\t\t\t\t\t----Sửa thông tin khách hàng thành công----");
                waitConsole();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (InputMismatchException ei) {
            System.out.println("Nhập giá trị không hợp lệ, vui lòng nhập lại!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

        public void Delete () {
            try {
                System.out.println("\t\t\t\t\t\t\t\t +----XÓA THÔNG TIN KHÁCH HÀNG----+");
                System.out.println("\t\t\t\t\t\t\t\t Nhập mã khách hàng cần xóa: ");
                String  ID_Khachhang = input.nextLine();
                Khachhang k_hang = null;

                for (Khachhang khachhang : kh) {
                    if (khachhang.getID_Customer().equals(ID_Khachhang)) {
                        k_hang = khachhang;
                        break;
                    }
                }

                if (k_hang == null) {
                    System.out.println("Mã khách hàng không tồn tại!");
                    return;
                }

                for (int i = 0; i < kh.length; i++) {
                    if (ID_Khachhang.equals(kh[i].getID_Customer())) {
                        kh = deleteCustomer(kh, i);
                        break;
                    }
                }
                String[] data = new String[kh.length];
                for (int i = 0; i < kh.length; i++) {
                    data[i] = kh[i].getID_Customer() + ";" + kh[i].getName() + ";" + kh[i].getAge() + ";" + kh[i].getGender() + ";" + kh[i].getAddress() + ";" + kh[i].getEmail() + ";" + kh[i].getPhoneNumber() + ";" + kh[i].getKindOfCustomer();
                }
                try {
                    Stream.addAll("src/database/customer.txt", data);
                    System.out.println("Xóa khách hàng thành công");
                    waitConsole();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (InputMismatchException ei) {
                System.out.println("Nhập giá trị không hợp lệ, vui lòng nhập lại!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    public Khachhang[] deleteCustomer(Khachhang[] kh, int index) {
        Khachhang[] newCs = new Khachhang[kh.length - 1];
        for (int i = 0, j = 0; i < kh.length; i++) {
            if (i != index) {
                newCs[j++] = kh[i];
            }
        }
        return newCs;
    }
        public Khachhang[] addCustomer(Khachhang[] kh, Khachhang khachhang) {
            kh = Arrays.copyOf(kh, kh.length + 1);
            kh[kh.length -1] = khachhang;
            return kh;
        }

        public void Search_byCategory () {
            Khachhang[] result = new Khachhang[0];
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
            if (choose == 0) return;
            else {
                    switch (choose) {
                        case 1 -> {
                            System.out.print("Nhập mã khách hàng: ");
                            String ID_Customer = input.nextLine();
                            for (Khachhang khachhang : kh) {
                                if (ID_Customer.contains(khachhang.getID_Customer())) {
                                    result = addCustomer(result, khachhang);
                                }
                            }
                        }
                        case 2 -> {
                            input.nextLine();
                            System.out.print("Nhập tên khách hàng: ");
                            String nameCustomer = input.nextLine();
                            for(Khachhang khachhang: kh) {
                                if (khachhang.getName().toLowerCase().contains(nameCustomer.toLowerCase())) {
                                    result = addCustomer(result, khachhang);
                                }
                            }
                        }
                        case 3 -> {
                            input.nextLine();
                            System.out.print("Nhập địa chỉ của khách hàng: ");
                            String address = input.nextLine();
                            for(Khachhang khachhang: kh) {
                                if (khachhang.getAddress().toLowerCase().contains(address.toLowerCase())) {
                                    result = addCustomer(result, khachhang);
                                }
                            }
                        }
                        case 4 -> {
                            input.nextLine();
                            System.out.print("Nhập số điện thoại của khách hàng: ");
                            String phoneNumber = input.nextLine();
                            for(Khachhang khachhang : kh) {
                                if (khachhang.getPhoneNumber().toLowerCase().contains(phoneNumber.toLowerCase())) {
                                    result = addCustomer(result, khachhang);
                                }
                            }
                        }
                    }
            }
            System.out.println("\t\t\t\t\t\t\t\t +----THÔNG TIN KHÁCH HÀNG TÌM ĐƯỢC----+");
            String header = String.format("|\t\t%s\t\t|\t%s\t|\t%s\t|\t\t%s\t|\t%s\t|\t%s\t|\t%s\t|\t%s\t|",
                    "Họ tên khách hàng", "Tuổi", "Giới tính", "Địa chỉ", "Email", "Mã khách hàng", "Loại khách hàng", "SDT");
            System.out.println(header);

            for (Khachhang DSKH : result) {
                String row = String.format("|\t\t%s\t\t|\t%s\t|\t%s\t|\t\t%s\t|\t%s\t|\t%s\t|\t%s\t|\t%s\t|", DSKH.getName(), DSKH.getAge(), DSKH.getGender(), DSKH.getAddress(),
                        DSKH.getEmail(), DSKH.getID_Customer(), DSKH.getKindOfCustomer(), DSKH.getPhoneNumber());
                System.out.println(row);
                waitConsole();
            }
        }
        public void Output () {
            System.out.println("\t\t\t\t\t\t\t\t +----DANH SÁCH KHÁCH HÀNG----+");
            String header = String.format("|\t\t%s\t\t\t|\t\t%s\t\t\t|\t\t%s\t\t|\t\t\t\t\t\t%s\t\t\t\t\t\t|\t\t\t\t%s\t\t\t\t|\t\t%s\t\t|\t\t%s\t\t|\t\t%s\t\t|",
                    "Họ tên khách hàng", "Tuổi", "Giới tính", "Địa chỉ", "Email", "Mã khách hàng", "Loại khách hàng", "SDT");
            System.out.println(header);
            for (Khachhang DSKH : kh) {
                String row = String.format("|\t\t%s\t\t|\t%s\t|\t%s\t|\t\t%s\t|\t%s\t|\t%s\t|\t%s\t|\t%s\t|", DSKH.getName(), DSKH.getAge(), DSKH.getGender(), DSKH.getAddress(),
                        DSKH.getEmail(), DSKH.getID_Customer(), DSKH.getKindOfCustomer(), DSKH.getPhoneNumber());
                System.out.println(row);
            }
    }
}