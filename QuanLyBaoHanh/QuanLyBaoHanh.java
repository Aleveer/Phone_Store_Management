package QuanLyBaoHanh;
import QuanLyKhachHang.Khachhang;
import WorkwithFiles.Stream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;
public class QuanLyBaoHanh extends BaoHanh {
    public BaoHanh[] bh;
    public QuanLyBaoHanh() {super();}
    static Scanner input = new Scanner(System.in);
    public BaoHanh[] getListBaoHanh() throws FileNotFoundException {
        String[] result = Stream.read("src/DuLieu/insurance.txt");
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
        System.out.println("\t\t\t\t\t\t\t\t +----DANH SÁCH BẢO HÀNH----+");
        String header = String.format("| %-5s | %-25s | %-4s | %-9s | %-30s | %-25s | %-15s | %-20s |", "ID", "Họ tên", "Tuổi", "Giới Tính", "Địa chỉ", "Email", "Số điện thoại", "Loại khách hàng");
        System.out.format("+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");
        System.out.println(header);
        System.out.format("+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");

        getListBaoHanh();
        for (BaoHanh baoHanh : bh) {
            if (bh[0].getID_Customer().contains("kh")) {
                String read = String.format("| %-5s | %-25s | %-4s | %-9s | %-30s | %-25s | %-15s | %-20s |", khachhang.getID_Customer(), khachhang.getName(), khachhang.getAge(),
                        khachhang.getGender(), khachhang.getAddress(), khachhang.getEmail(), khachhang.getPhoneNumber(), khachhang.getKindOfCustomer());
                System.out.println(read);
            }
        }
        System.out.format("+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");
        waitConsole();
    }
    public void Add() {
        System.out.println("\t\t\t\t\t\t\t\t +----NHẬP THÔNG TIN VỀ BẢO HÀNH----+");
        System.out.print("Nhập số năm bảo hành:");
        setSoNamBaoHanh(input.nextInt());

        input.nextLine();
        System.out.print("Nhập mã khách hàng:");
        setID_Customer(input.nextLine());

        System.out.print("Nhập SDT khách hàng:");
        setPhoneNumber(input.nextLine());

        System.out.print("Nhập ngày mua hàng:");
        setNgayMua(LocalDate.parse(input.nextLine()));

        BaoHanh baoHanh = new BaoHanh(getNgayMua(), getSoNamBaoHanh(), getID_Customer(), getPhoneNumber());
        DSBH.add(baoHanh);
    }
    public void Search_byCategory() {
        ArrayList<BaoHanh> result = new ArrayList<>();
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
            DSBH.forEach((baoHanh) -> {
                switch (choose) {
                    case 1 -> {
                        input.nextLine();
                        System.out.print("Mã khách hàng: ");
                        int ID_Customer = input.nextInt();
                        if (baoHanh.getID_Customer().equals(ID_Customer)) {
                            result.add(baoHanh);
                        }
                    }
                    case 2 -> {
                        input.nextLine();
                        System.out.print("Số điện thoại: ");
                        String PhoneNumber = input.nextLine();
                        if (baoHanh.getPhoneNumber().contains((PhoneNumber))) {
                            result.add(baoHanh);
                        }
                    }
                    case 3 -> {
                        System.out.print("Số năm bảo hành: ");
                        int SoNamBaoHanh = input.nextInt();
                        if (baoHanh.getSoNamBaoHanh().equals(SoNamBaoHanh)) {
                            result.add(baoHanh);
                        }
                    }
                    case 4 -> {
                        input.nextLine();
                        System.out.print("Ngày mua hàng (cú pháp năm-tháng-ngày): ");
                        String date = input.next();
                        if (baoHanh.getNgayMua().isEqual(ngayMua)) {
                            result.add(baoHanh);
                        }
                    }
                }
            });
        }
        System.out.println("\t\t\t\t\t\t\t\t +----TẤT CẢ THÔNG TIN ĐÃ TÌM ĐƯỢC----+");
        String header = String.format("|\t\t%s\t|\t%s\t|\t%s\t\t|\t\t%s\t|",
                "Mã khách hàng", "Số năm bảo hành", "Số điện thoại", "Ngày mua");
        System.out.println(header);
        for(BaoHanh DSBH : result) {
            String row = String.format("|\t\t%s\t\t\t\t|\t%s\t\t\t\t|\t%s\t\t\t|\t\t%s\t\t|",
                    DSBH.getID_Customer(), DSBH.getSoNamBaoHanh(), DSBH.getPhoneNumber(), DSBH.getNgayMua());
            System.out.println(row);
        }
        System.out.println("+----------------------------------------------------------------------+");
    }
    public void Output() {
        System.out.println("\t\t\t\t\t\t\t\t +----TẤT CẢ THÔNG TIN VỀ BẢO HÀNH----+");
        String header = String.format("|\t\t%s\t|\t%s\t|\t%s\t\t|\t\t%s\t|",
                "Mã khách hàng", "Số năm bảo hành", "Số điện thoại", "Ngày mua");
        System.out.println(header);
        for(BaoHanh DSBH : DSBH) {
            String row = String.format("|\t\t%s\t\t\t\t|\t%s\t\t\t\t|\t%s\t\t\t|\t\t%s\t\t|",
                    DSBH.getID_Customer(), DSBH.getSoNamBaoHanh(), DSBH.getPhoneNumber(), DSBH.getNgayMua());
            System.out.println(row);
        }
        System.out.println("+----------------------------------------------------------------------+");
    }
}
