package Receipt;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class QuanLyHoaDon extends HoaDon {
    private float TongTien = 0;
    private static final ArrayList<HoaDon> DSHD = new ArrayList<>();
    private static final ArrayList<HoaDon> DSSP = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    public void Add() {
        System.out.print("Nhập mã hóa đơn: ");
        setID_receipt(input.nextInt());

        System.out.print("Nhập mã nhân viên: ");
        setID_Worker(input.nextInt());

        System.out.print("Nhập mã khách hàng: ");
        setID_Customer(input.nextInt());

        System.out.print("Nhập họ tên khách hàng: ");
        input.nextLine();
        setCustomer_name(input.nextLine());

        System.out.print("Nhập phương pháp giao hàng: ");
        setDeliveryMethod(input.nextLine());

        System.out.print("Nhập phương pháp mua hàng: ");
        input.nextLine();
        setPurchaseMethod(input.nextLine());

        HoaDon hoaDon = new HoaDon(getID_receipt(), getID_Worker(), getID_Customer(), getCustomer_name(), getDeliveryMethod(), getPurchaseMethod(), getDatePurchase(), getTimePurchase());
        DSHD.add(hoaDon);
    }

    public void AddSP() {
        Integer n = null;
        System.out.print("Nhập so san pham da mua: ");
        n = input.nextInt();
        for (int i = 1; i <= n; i++) {
            System.out.print("Nhập ten san pham thu ");
            System.out.print(i + ": ");
            input.nextLine();
            setName_Product(input.nextLine());

            System.out.print("Nhập gia san pham thu ");
            System.out.print(i + ": ");
            setPrice(input.nextFloat());

            HoaDon SP = new HoaDon(getName_Product(), getPrice());
            DSSP.add(SP);
        }
    }


    public void Update() {
        try {
            System.out.print("Nhập ID hóa đơn cần chỉnh sửa: ");
            Integer ID_Receipt = input.nextInt();
            HoaDon hdon = null;

            for (HoaDon receipt : DSHD) {
                if (receipt.getID_receipt().equals(ID_Receipt)) {
                    hdon = receipt;
                    break;
                }
            }

            if(hdon == null) {
                System.out.println("ID hóa đơn không tồn tại. Xin vui lòng nhập lại!");
                return;
            }

            System.out.println("Thông tin hóa đơn: ");
            String row = String.format("%s %15s %15s %50s %10s %10s %10s  %10s", hdon.getID_receipt(), hdon.getID_Worker(), hdon.getID_Customer(), hdon.getCustomer_name(), hdon.getDeliveryMethod(),
                    hdon.getPurchaseMethod(), hdon.getDatePurchase(), hdon.getPrice());
            System.out.println(row);

            for (HoaDon receipt : DSHD) {
                if (ID_Receipt.equals(receipt.getID_receipt())) {
                    System.out.println("Nhập thông tin hóa đơn:");
                    System.out.print("Nhập mã nhân viên: ");
                    setID_Worker(input.nextInt());

                    System.out.print("Nhập mã khách hàng: ");
                    setID_Worker(input.nextInt());

                    System.out.print("Nhập phương pháp giao hàng: ");
                    setDeliveryMethod(input.nextLine());

                    System.out.print("Nhập phương pháp mua hàng: ");
                    input.nextLine();
                    setPurchaseMethod(input.nextLine());

                    receipt.setID_Worker(getID_Worker());
                    receipt.setID_Customer(getID_Customer());
                    receipt.setDeliveryMethod(getDeliveryMethod());
                    receipt.setPurchaseMethod(getPurchaseMethod());
                    new HoaDon();
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
            System.out.print("Nhập ID hóa đơn cần xóa: ");
            Integer ID_HoaDon = input.nextInt();
            HoaDon hdon = null;

            for (HoaDon hoadon : DSHD) {
                if (hoadon.getID_receipt().equals(ID_HoaDon)) {
                    hdon = hoadon;
                    break;
                }
            }

            if(hdon == null) {
                System.out.println("ID hóa đơn không tồn tại. Xin vui lòng nhập lại!");
                return;
            }

            for (int i=0; i< DSHD.size(); i++) {
                if (ID_HoaDon.equals(DSHD.get(i).getID_receipt())) {
                    DSHD.remove(i);
                }
            }
        } catch (InputMismatchException ei) {
            System.out.println("Nhập giá trị không hợp lệ, vui lòng nhập lại!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void Search_byCategory() {
        ArrayList<HoaDon> result = new ArrayList<>();
//        LocalDate _ngay1;
//        LocalDate _ngay2;
//        int _tong1;
//        int _tong2;
        System.out.println("Nhập mục lục cần tìm kiếm: ");
        System.out.println("1.Mã hóa đơn");
        System.out.println("2.Mã nhân viên");
        System.out.println("3.Mã khách hàng");
        System.out.println("4.Tên khách hàng");
        System.out.println("5.Ngày mua hàng");
        System.out.println("6.Tổng tiền của 1 hóa đơn");
        int choose = input.nextInt();
        DSHD.forEach((hoadon) -> {
            switch (choose) {
                case 1 -> {
                    System.out.print("Nhập mã hóa đơn: ");
                    int ID_Receipt = input.nextInt();
                    if (hoadon.getID_receipt().equals(ID_Receipt)) {
                        result.add(hoadon);
                    }
                }
                case 2 -> {
                    System.out.print("Nhập mã nhân viên: ");
                    int ID_Worker = input.nextInt();
                    if (hoadon.getID_Worker().equals(ID_Worker)) {
                        result.add(hoadon);
                    }
                }
                case 3 -> {
                    System.out.print("Nhập mã khách hàng: ");
                    int ID_Customer = input.nextInt();
                    if (hoadon.getID_Worker().equals(ID_Customer)) {
                        result.add(hoadon);
                    }
                }
                case 4 -> {
                    System.out.print("Nhập tên khách hàng: ");
                    input.nextLine();
                    String Customer_name = input.nextLine();
                    if (hoadon.getCustomer_name().toLowerCase().contains(Customer_name.toLowerCase())) {
                        result.add(hoadon);
                    }
                }
                case 5 -> {
                    System.out.print("Nhập ngày mua hàng: ");
                    LocalDate time = LocalDate.parse(input.nextLine());
                    if (hoadon.getDatePurchase().isEqual(time)) {
                        result.add(hoadon);
                    }
                }
                case 6 -> {
                    System.out.print("Nhập tổng tiền: ");
                    Float money = input.nextFloat();
                    if(hoadon.getPrice().equals(money)) {
                        result.add(hoadon);
                    }
                }
            }
        });

//        for (int i = result.size() - 1; i >= 0; i--) {
//            HoaDon hd = result.get(i);
//            LocalDate ngaylap = hd.getDatePurchase();
//            float tongtien = hd.getPrice();
//
//            Boolean ngayKhongThoa = (_ngay1 != null && ngaylap.isBefore(_ngay1)) || (_ngay2 != null && ngaylap.isAfter(_ngay2));
//            Boolean tienKhongThoa = (_tong1 != -1 && tongtien < _tong1) || (_tong2 != -1 && tongtien > _tong2);
//
//            if (ngayKhongThoa || tienKhongThoa) {
//                result.remove(hd);
//            }
//        }

        String header = String.format("%s %15s %15s %15s %50s %40s %10s %15s", "Mã hóa đơn", "Mã nhân viên", "Mã khách hàng", "PP Giao hàng", "PP Mua hàng", "Họ tên khách hàng", "Ngày mua", "Giờ mua");
        System.out.println(header);
        for(HoaDon DSHD : result) {
            String row = String.format("%s %15s %15s %15s %50s %40s %10s %15s", DSHD.getID_receipt(), DSHD.getID_Worker(), DSHD.getID_Customer(),
                    DSHD.getDeliveryMethod(), DSHD.getPurchaseMethod(), DSHD.getCustomer_name(), DSHD.getDatePurchase(), DSHD.getTimePurchase());
            System.out.println(row);
        }
    }

    public Float Tong(){
        for (HoaDon DSSP : DSSP) {
            TongTien += DSSP.getPrice();
        }
        return TongTien + (0.1f * TongTien);
    }
    public void Output(){
        System.out.println("Hóa Đơn:");
        String info = String.format("%s %15s %15s %15s %15s %15s %15s %15s", "Mã hóa đơn", "Mã nhân viên", "Mã khách hàng", "Họ tên khách hàng", "PP Giao hàng", "PP Mua hàng", "Ngày mua", "Giờ mua");
        System.out.println(info);
        for(HoaDon DSHD : DSHD) {
            String row = String.format("%s %15s %15s %15s %15s %30s %30s %30s", DSHD.getID_receipt(), DSHD.getID_Worker(), DSHD.getID_Customer(),
                    DSHD.getCustomer_name(), DSHD.getDeliveryMethod(), DSHD.getPurchaseMethod(), DSHD.getDatePurchase(), DSHD.getTimePurchase());
            System.out.println(row);
        }

        String header = String.format("%s %15s ", "Name Product", "Price");
        System.out.println(header);
        for (HoaDon DSSP : DSSP) {
            String row = String.format("%15s %15s ", DSSP.getName_Product(), DSSP.getPrice());
            System.out.println(row);
        }
        String price = String.format("%s", "Tổng Tiền: ");
        System.out.println(price);
        String row_total = String.format("%f", Tong());
        System.out.println(row_total);
    }

}
