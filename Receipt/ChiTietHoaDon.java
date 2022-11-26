package Receipt;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class ChiTietHoaDon {
    protected Integer ID_Receipt;
    protected Integer ID_Product;
    protected Integer Amount;
    protected Float Price;
    public Integer getID_Receipt() {
        return ID_Receipt;
    }
    public void setID_Receipt(Integer ID_Receipt) {
        this.ID_Receipt = ID_Receipt;
    }
    public Integer getID_Product() {
        return ID_Product;
    }
    public void setID_Product(Integer ID_Product) {
        this.ID_Product = ID_Product;
    }
    public Integer getAmount() {
        return Amount;
    }
    public void setAmount(Integer Amount) {
        this.Amount = Amount;
    }
    public Float getPrice() {
        return Price;
    }
    public void setPrice(float Price) {
        this.Price = Price;
    }
    public ChiTietHoaDon(Integer ID_Receipt, Integer ID_Product, Integer Amount, Float Price) {
        super();
        this.ID_Receipt = ID_Receipt;
        this.ID_Product = ID_Product;
        this.Amount = Amount;
        this.Price = Price;
    }
    public ChiTietHoaDon() {super();}
    private static final ArrayList<ChiTietHoaDon> CTHD = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    public void Add() {
        System.out.print("Nhập mã hóa đơn: ");
        setID_Receipt(input.nextInt());

        System.out.print("Nhập mã sản phẩm: ");
        setID_Product(input.nextInt());

        System.out.print("Nhập số lượng: ");
        setAmount(input.nextInt());

        System.out.print("Nhập họ tên khách hàng: ");
        input.nextLine();
        setPrice(input.nextFloat());

        ChiTietHoaDon chitiet = new ChiTietHoaDon(getID_Receipt(), getID_Product(), getAmount(), getPrice());
        CTHD.add(chitiet);
    }


    public void Update() {
        try {
            System.out.print("Nhập ID hóa đơn cần chỉnh sửa: ");
            Integer ID_Receipt = input.nextInt();
            ChiTietHoaDon chitiet = null;

            for (ChiTietHoaDon chitiethoadon : CTHD) {
                if (chitiethoadon.getID_Receipt().equals(ID_Receipt)) {
                    chitiet = chitiethoadon;
                    break;
                }
            }

            if(chitiet == null) {
                System.out.println("ID hóa đơn không tồn tại. Xin vui lòng nhập lại!");
                return;
            }

            System.out.println("Thông tin hóa đơn: ");
            String row = String.format("%s %15s %15s %15s", chitiet.getID_Receipt(), chitiet.getID_Product(), chitiet.getAmount(),  chitiet.getPrice());
            System.out.println(row);

            for (ChiTietHoaDon chitiethoadon : CTHD) {
                if (ID_Receipt.equals(chitiethoadon.getID_Receipt())) {
                    System.out.println("Nhập thông tin hóa đơn:");
                    System.out.print("Nhập mã hóa đơn: ");
                    setID_Receipt(input.nextInt());

                    System.out.print("Nhập mã sản phẩm: ");
                    setID_Product(input.nextInt());

                    System.out.print("Nhập số lượng: ");
                    setAmount(input.nextInt());

                    System.out.print("Nhập Giá: ");
                    setPrice(input.nextFloat());

                    chitiethoadon.setID_Receipt(getID_Receipt());
                    chitiethoadon.setID_Product(getID_Product());
                    chitiethoadon.setAmount(getAmount());
                    chitiethoadon.setPrice(getPrice());
                    new ChiTietHoaDon();
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
            Integer ID_Receipt = input.nextInt();
            ChiTietHoaDon chitiet = null;

            for (ChiTietHoaDon chitiethoadon: CTHD) {
                if (chitiethoadon.getID_Receipt().equals(ID_Receipt)) {
                    chitiet = chitiethoadon;
                    break;
                }
            }

            if(chitiet == null) {
                System.out.println("ID hóa đơn không tồn tại. Xin vui lòng nhập lại!");
                return;
            }

            for (int i=0; i< CTHD.size(); i++) {
                if (ID_Receipt.equals(CTHD.get(i).getID_Receipt())) {
                    CTHD.remove(i);
                }
            }
        } catch (InputMismatchException ei) {
            System.out.println("Nhập giá trị không hợp lệ, vui lòng nhập lại!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void Search_byCategory() {
        ArrayList<ChiTietHoaDon> result = new ArrayList<>();
        System.out.println("Nhập mục lục cần tìm kiếm: ");
        System.out.println("1.Mã hóa đơn");
        System.out.println("2.Mã sản phẩm");
        System.out.println("3.Số lượng");
        System.out.println("4.Giá");
        int choose = input.nextInt();
        CTHD.forEach((chitiet) -> {
            switch (choose) {
                case 1 -> {
                    System.out.print("Nhập mã hóa đơn: ");
                    int ID_Receipt = input.nextInt();
                    if (chitiet.getID_Receipt().equals(ID_Receipt)) {
                        result.add(chitiet);
                    }
                }
                case 2 -> {
                    System.out.print("Nhập mã sản phẩm: ");
                    int ID_Product = input.nextInt();
                    if (chitiet.getID_Product().equals(ID_Product)) {
                        result.add(chitiet);
                    }
                }
                case 3 -> {
                    System.out.print("Nhập mã sản phẩm: ");
                    int Amount = input.nextInt();
                    if (chitiet.getAmount().equals(Amount)) {
                        result.add(chitiet);
                    }
                }
                case 4 -> {
                    System.out.print("Nhập Giá: ");
                    float Price = input.nextFloat();
                    if (chitiet.getPrice().equals(Price)) {
                        result.add(chitiet);
                    }
                }
            }
        String header = String.format("%s %15s %15s %15s ", "Mã hóa đơn", "Mã sản phẩm", "Số lượng", "Tổng tiền");
        System.out.println(header);
        for(ChiTietHoaDon CTHD : result) {
            String row = String.format("%s %15s %15s %15s ", CTHD.getID_Receipt(), CTHD.getID_Product(), CTHD.getAmount(), CTHD.getPrice());
            System.out.println(row);
        }
    });
    }
    

    
    public void Output() {
        System.out.println("Chi Tiết Hóa Đơn:");
        String info = String.format("%s %15s %15s %15s", "Mã hóa đơn", "Mã sản phẩm", "Số lượng", "Tổng tiên");
        System.out.println(info);
        for (ChiTietHoaDon CTHD : CTHD) {
            String row = String.format("%s %15s %15s %15s ", CTHD.getID_Receipt(), CTHD.getID_Product(), CTHD.getAmount(), CTHD.getPrice());
            System.out.println(row);
        }
    }
}
