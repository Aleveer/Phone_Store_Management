package QuanLyNhanVien;

import Person.DataAccessObject;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class QuanLyNhanVien extends NhanVien implements DataAccessObject {
    public ArrayList<NhanVien> DSNV = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    @Override
    public void Add() {
        System.out.println("Nhập thông tin nhân viên:");
        super.Add();

        System.out.print("Nhập ID nhân viên:");
        setID_Worker(input.nextInt());

        System.out.print("Nhập chức vụ của nhân viên:");
        input.nextLine();
        setRole(input.nextLine());

        input.nextLine();
        System.out.print("Nhập ca làm việc của nhân viên: ");
        setShift(input.nextLine());

        NhanVien nv = new NhanVien(getName(), getGender(), getAddress(), getEmail(), getAge(), getPhoneNumber(), getID_Worker(), getRole(), getShift());
        DSNV.add(nv);
    }

    public void Update() {
        try {
            System.out.print("Nhập ID nhân viên cần chỉnh sửa: ");
            Integer ID_NhanVien = input.nextInt();
            NhanVien n_vien = null;

            for (NhanVien nhanVien : DSNV) {
                if (nhanVien.getID_Worker().equals(ID_NhanVien)) {
                    n_vien = nhanVien;
                    break;
                }
            }

            if(n_vien == null) {
                System.out.println("ID nhân viên không tồn tại. Xin vui lòng nhập lại!");
                return;
            }

            System.out.println("Thông tin nhân viên: ");
            String row = String.format("%s %15s %15s %15s %50s %40s %10s %10s %11s", n_vien.getName(), n_vien.getAge(), n_vien.getGender(),
                    n_vien.getAddress(), n_vien.getEmail(), n_vien.getID_Worker(), n_vien.getRole(), n_vien.getShift(), n_vien.getPhoneNumber());
            System.out.println(row);

            for (NhanVien nhanVien : DSNV) {
                if (ID_NhanVien.equals(nhanVien.getID_Worker())) {
                    System.out.println("Nhập thông tin nhân viên:");
                    super.Add();

                    input.nextLine();
                    System.out.print("Nhập chức vụ của nhân viên: ");
                    setRole(input.nextLine());

                    System.out.print("Nhập ca làm việc của nhân viên: ");
                    setShift(input.nextLine());

                    nhanVien.setName(getName());
                    nhanVien.setGender(getGender());
                    nhanVien.setAddress(getAddress());
                    nhanVien.setEmail(getEmail());
                    nhanVien.setAge(getAge());
                    nhanVien.setPhoneNumber(getPhoneNumber());
                    nhanVien.setShift(getShift());
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
            System.out.print("Nhập ID nhân viên cần xóa: ");
            Integer ID_Nhanvien = input.nextInt();
            NhanVien n_vien = null;

            for (NhanVien nhanVien : DSNV) {
                if (nhanVien.getID_Worker().equals(ID_Nhanvien)) {
                    n_vien = nhanVien;
                    break;
                }
            }

            if(n_vien == null) {
                System.out.println("ID nhân viênkhông tồn tại. Xin vui lòng nhập lại!");
                return;
            }

            for (int i=0; i< DSNV.size(); i++) {
                if (ID_Nhanvien.equals(DSNV.get(i).getID_Worker())) {
                    DSNV.remove(i);
                }
            }
        } catch (InputMismatchException ei) {
            System.out.println("Nhập giá trị không hợp lệ, vui lòng nhập lại!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void Search_byCategory() {
        ArrayList<NhanVien> result = new ArrayList<>();
        System.out.println("Nhập mục lục cần tìm kiếm: ");
        System.out.println("1.Mã nhân viên");
        System.out.println("2.Tên nhân viên");
        System.out.println("3.Địa chỉ nhân viên");
        System.out.println("4.Số điện thoại nhân viên");
        System.out.println("5.Chức vụ nhân viên");
        System.out.println("6.Ca trực của nhân viên");
        int choose = input.nextInt();
        DSNV.forEach((nhanVien) -> {
            switch (choose) {
                case 1 -> {
                    System.out.print("Nhập ID nhân viên: ");
                    int ID_Worker = input.nextInt();
                    if (ID_Worker == nhanVien.getID_Worker()) {
                        result.add(nhanVien);
                    }
                }
                case 2 -> {
                    System.out.print("Nhập tên nhân viên: ");
                    input.nextLine();
                    String nameWorker = input.nextLine();
                    if (nhanVien.getName().toLowerCase().contains(nameWorker.toLowerCase())) {
                        result.add(nhanVien);
                    }
                }
                case 3 -> {
                    System.out.print("Nhập địa chỉ của nhân viên: ");
                    input.nextLine();
                    String address = input.nextLine();
                    if (nhanVien.getAddress().toLowerCase().contains(address.toLowerCase())) {
                        result.add(nhanVien);
                    }
                }
                case 4 -> {
                    System.out.print("Nhập số điện thoại của nhân viên: ");
                    input.nextLine();
                    String phoneNumber = input.nextLine();
                    if (nhanVien.getPhoneNumber().toLowerCase().contains(phoneNumber.toLowerCase())) {
                        result.add(nhanVien);
                    }
                }
                case 5 -> {
                    System.out.print("Nhập chức vụ của nhân viên: ");
                    input.nextLine();
                    String Role = input.nextLine();
                    if (nhanVien.getRole().toLowerCase().contains(Role.toLowerCase())) {
                        result.add(nhanVien);
                    }
                }
                case 6 -> {
                    System.out.print("Nhập ca trực của nhân viên: ");
                    input.nextLine();
                    String Shift = input.nextLine();
                    if (nhanVien.getShift().toLowerCase().contains(Shift.toLowerCase())) {
                        result.add(nhanVien);
                    }
                }
            }
        });

        String header = String.format("%s %15s %15s %15s %50s %40s %10s %15s %11s", "Họ tên", "Tuổi", "Giới Tính", "Địa chỉ", "Email", "ID nhân viên", "Chức vụ", "Ca trực", "Số điện thoại");
        System.out.println(header);
        for(NhanVien DSNV : result) {
            String row = String.format("%s %15s %15s %15s %50s %40s %10s %15s %11s", DSNV.getName(), DSNV.getAge(), DSNV.getGender(),
                    DSNV.getAddress(), DSNV.getEmail(), DSNV.getID_Worker(), DSNV.getRole(), DSNV.getShift(), DSNV.getPhoneNumber());
            System.out.println(row);
        }
    }

    public void Output() {
        System.out.println("Danh sách nhân viên:");
        String header = String.format("%s %15s %15s %15s %50s %40s %10s %15s %11s", "Họ tên", "Tuổi", "Giới Tính", "Địa chỉ", "Email", "ID nhân viên", "Chức vụ", "Ca trực", "Số điện thoại");
        System.out.println(header);
        for(NhanVien DSNV : DSNV) {
            String row = String.format("%s %15s %15s %15s %50s %40s %10s %15s %11s", DSNV.getName(), DSNV.getAge(), DSNV.getGender(),
                    DSNV.getAddress(), DSNV.getEmail(), DSNV.getID_Worker(), DSNV.getRole(), DSNV.getShift(), DSNV.getPhoneNumber());
            System.out.println(row);
        }
    }
}
