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

    public void Output() {
        System.out.print("Danh sách phiếu bảo hành của khách hàng:");
        String header = String.format("%s %15s %15s %15s", "Ngày mua", "Số năm bảo hành", "Mã khách hàng", "SDT khách hàng");
        System.out.println(header);
        for(BaoHanh DSBH : DSBH) {
            String row = String.format("%s %15s %15s %15s ",DSBH.getNgayMua(),DSBH.getSoNamBaoHanh(),DSBH.getID_Customer(),
                    DSBH.getPhoneNumber());
            System.out.println(row);
        }
    }
}
