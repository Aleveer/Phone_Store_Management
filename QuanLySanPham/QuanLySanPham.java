package QuanLySanPham;

import Configurations.Configuation;
import WorkwithFiles.Stream;

import java.beans.Introspector;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class QuanLySanPham extends SanPham {
    public SanPham[] DSSP;
    public QuanLySanPham() {
        super();
    }
    static Scanner input = new Scanner(System.in);

    public SanPham[] getListSanPham() throws FileNotFoundException {
        String[] result = Stream.read("src/DuLieu/product.txt");
        DSSP = new SanPham[result.length];
        for (int i = 0; i < result.length; i++) {
            String[] row = result[i].split(";");
            DSSP[i] = new SanPham(row[0], row[1], row[2], Integer.parseInt(row[3]), Integer.parseInt(row[4]), Float.parseFloat(row[5]), row[6]);
        }
        return DSSP;
    }

    public void waitConsole() {
        input.nextLine();
        System.out.println("\t\t\t\t\t\t\t\t -Ấn Enter để tiếp tục");
        input.nextLine();
    }
    public void read() throws FileNotFoundException {
        System.out.println("\t\t\t\t\t\t\t\t +----DANH SÁCH SẢN PHẨM----+");
        String header = String.format("| %-5s | %-25s | %-4s | %-9s | %-30s | %-25s | %-15s |", "Tên", "Mã Sản Phẩm", "Mã Loại Sản Phẩm", "Số Lượng", "Số Lượng Còn Lại", "Giá Tiền", "Trạng Thái");
        System.out.format("+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");
        System.out.println(header);
        System.out.format("+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");

        getListSanPham();
        for (SanPham sanpham : DSSP) {
            if ( DSSP[0].getID_Product().contains("DSSP")) {
                String read = String.format("| %-5s | %-25s | %-4s | %-9s | %-30s | %-25s | %-15s |", sanpham.getName(), sanpham.getID_Product(), sanpham.getID_Typeofproduct(),
                        sanpham.getAmount(), sanpham.getAmount_remaining(), sanpham.getPrice(), sanpham.getStatus());
                System.out.println(read);
            }
        }
        System.out.format("+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");
        waitConsole();
    }

    public void Add() {
        System.out.println("\t\t\t\t\t\t\t\t +----NHẬP THÔNG TIN SẢN PHẨM----+");
        int check = 0;
        for (SanPham sanpham : DSSP) {
            if (getID_Product().equals(sanpham.getID_Product())) {
                check = 1;
                break;
            }
        }

        if (check == 1) {
            System.out.println("\t\t\t\t\t\t\t\t -MÃ KHÁCH SẢN PHẨM BỊ TRÙNG!");
            return;
        }

        System.out.print("Nhập Tên: ");
        setName(input.nextLine());

        System.out.print("Nhập Mã Sản Phẩm: ");
        setID_Product(input.nextLine());

        System.out.print("Nhập Mã Loại Sản Phẩm: ");
        setID_Typeofproduct(input.nextLine());

        System.out.print("Nhập Số Lượng: ");
        setAmount(input.nextInt());

        System.out.print("Nhập Số Lượng Còn Lại: ");
        setAmount_remaining(input.nextInt());

        System.out.print("Nhập Giá Tiền: ");
        setPrice(input.nextFloat());

        System.out.print("Nhập Trạng Thái: ");
        setStatus(input.nextLine());

        try {
            String input = getName() + ";" + getID_Product() + ";" + getID_Typeofproduct() + ";" + getAmount() + ";" + getAmount_remaining() + ";" + getPrice() + ";" + getStatus();
            Stream.addOneLine("src/DuLieu/product.txt", input);
            System.out.println("\t\t\t\t\t\t\t\t+----NHẬP SẢN PHẨM THÀNH CÔNG----+");
            waitConsole();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Update() {
        try {
            System.out.println("\t\t\t\t\t\t\t\t +----CẬP NHẬT LẠI THÔNG TIN SẢN PHẨM----+");
            System.out.print("\t\t\t\t\t\t\t\t - Mời bạn nhập mã sản phẩm chỉnh sửa: ");
            String ID_Product = input.nextLine();
            SanPham s_pham = null;

        for (SanPham sanpham : DSSP) {
                if (sanpham.getID_Product().equalsIgnoreCase(ID_Product)) {
                    s_pham = sanpham;
                    break;
                }
            }

            if (s_pham == null) {
                System.out.println("\t\t\t\t\t\t\t\t -MÃ KHÁCH HÀNG KHÔNG TỒN TẠI!");
                return;
            }

            System.out.println("\t\t\t\t\t\t\t\t +----THÔNG TIN SẢN PHẨM TRƯỚC KHI CHỈNH SỬA----+");
            String header = String.format("| %-5s | %-25s | %-4s | %-9s | %-30s | %-25s | %-15s |", "Tên", "Mã Sản Phẩm", "Mã Loại Sản Phẩm", "Số Lượng", "Số Lượng Còn Lại", "Giá Tiền", "Trạng Thái");
            System.out.format("+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");
            System.out.println(header);
            System.out.format("+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");

            String row = String.format("|\t\t%s\t\t|\t%s\t|\t%s\t|\t\t%s\t|\t%s\t|\t%s\t|\t%s\t|\t%s\t|",
                    s_pham.getName(), s_pham.getID_Product(), s_pham.getID_Typeofproduct(),
                    s_pham.getAmount(), s_pham.getAmount_remaining(), s_pham.getPrice(), s_pham.getStatus());
            System.out.println(row);

            String[] data = new String[DSSP.length];

            for (int i = 0; i < DSSP.length; i++) {
                if (ID_Product.equals(getID_Product())) {
                    System.out.print("Nhập thông tin sản phẩm:");
                    input.nextLine();

                    System.out.print("Nhập Tên: ");
                    setName(input.nextLine());

                    System.out.print("Nhập Mã Loại Sản Phẩm: ");
                    setID_Typeofproduct(input.nextLine());

                    System.out.print("Nhập Số Lượng: ");
                    setAmount(input.nextInt());

                    System.out.print("Nhập Số Lượng Còn Lại: ");
                    setAmount_remaining(input.nextInt());

                    System.out.print("Nhập Giá Tiền: ");
                    setPrice(input.nextFloat());

                    System.out.print("Nhập Trạng Thái: ");
                    setStatus(input.nextLine());

                    DSSP[i].setName(getName());
                    DSSP[i].setID_Product(getID_Product());
                    DSSP[i].setID_Typeofproduct(getID_Typeofproduct());
                    DSSP[i].setAmount(getAmount());
                    DSSP[i].setAmount_remaining(getAmount_remaining());
                    DSSP[i].setPrice(getPrice());
                    DSSP[i].setStatus(getStatus());
                }
                data[i] = DSSP[i].getName() + ";" + DSSP[i].getID_Product() + ";" + DSSP[i].getID_Typeofproduct() + ";" + DSSP[i].getAmount() + ";" + DSSP[i].getAmount_remaining() + ";" + DSSP[i].getPrice() + ";" + DSSP[i].getStatus();
            }
            try {
                Stream.addAll("src/DuLieu/product.txt", data);
                System.out.println("\t\t\t\t\t\t\t\t+----SỬA THÔNG TIN SẢN PHẨM THÀNH CÔNG----+");
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
            System.out.println("\t\t\t\t\t\t\t\t +----XÓA THÔNG TIN SẢN PHẨM----+");
            System.out.println("\t\t\t\t\t\t\t\t -Nhập mã sản phẩm cần xóa: ");
            String ID_Product = input.nextLine();

            SanPham cur_product = null;
            for (SanPham sanpham: DSSP) {
                if (sanpham.getID_Product().equals(ID_Product)) {
                    cur_product = sanpham;
                    break;
                }
            }
            for (int i = 0; i < DSSP.length; i++) {
                if (ID_Product.equals(DSSP[i].getID_Product())) {
                    DSSP = deleteSanPham(DSSP, i);
                    break;
                }
            }

            if (cur_product == null) {
                System.out.println("\t\t\t\t\t\t\t\t - MÃ SẢN PHẨM KHÔNG TỒN TẠI!");
                return;
            }

            for (int i = 0; i < DSSP.length; i++) {
                if (ID_Product.equals(DSSP[i].getID_Product())) {
                    DSSP = deleteSanPham(DSSP, i);
                    break;
                }
            }
            String[] data = new String[DSSP.length];
            for (int i = 0; i < DSSP.length; i++) {
                data[i] = DSSP[i].getName() + ";" + DSSP[i].getID_Product() + ";" + DSSP[i].getID_Typeofproduct() + ";" + DSSP[i].getAmount() + ";" + DSSP[i].getAmount_remaining() + ";" + DSSP[i].getPrice() + ";" + DSSP[i].getStatus();
            }
            try {
                Stream.addAll("src/DuLieu/.producttxt", data);
                System.out.println("\t\t\t\t\t\t\t\t +----XÓA THÔNG TIN SẢN PHẨM THÀNH CÔNG----+");
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
    public SanPham[] deleteSanPham(SanPham[] DSSP, int index) {
        SanPham[] newCs = new SanPham[DSSP.length - 1];
        for (int i = 0, j = 0; i < DSSP.length; i++) {
            if (i != index) {
                newCs[j++] = DSSP[i];
            }
        }
        return newCs;
    }
    public SanPham[] addSanPham(SanPham[] DSSP, SanPham sanpham) {
        DSSP = Arrays.copyOf(DSSP, DSSP.length + 1);
        DSSP[DSSP.length -1] = sanpham;
        return DSSP;
    }

    public void Search_byCategory() {
        SanPham[] result = new SanPham[0];
        System.out.println("\t\t\t\t\t\t\t\t +--------NHẬP MỤC LỤC CẨN TÌM KIẾM--------+");
        System.out.println("\t\t\t\t\t\t\t\t |0.Thoát                                  |");
        System.out.println("\t\t\t\t\t\t\t\t +-----------------------------------------+");
        System.out.println("\t\t\t\t\t\t\t\t |1.Tên sản phẩm                           |");
        System.out.println("\t\t\t\t\t\t\t\t |2.Mã Sản Phẩm                            |");
        System.out.println("\t\t\t\t\t\t\t\t |3.Mã loại sản phẩm                       |");
        System.out.println("\t\t\t\t\t\t\t\t |4.Số lượng                               |");
        System.out.println("\t\t\t\t\t\t\t\t |5.Số lượng còn lại                       |");
        System.out.println("\t\t\t\t\t\t\t\t |6.Giá Tiền                               |");
        System.out.println("\t\t\t\t\t\t\t\t |7.Trạng thái                             |");
        System.out.println("\t\t\t\t\t\t\t\t +-----------------------------------------+");
        System.out.print("\t\t\t\t\t\t\t\t - Mời Bạn Nhập Lựa Chọn: ");
        int choose = input.nextInt();
        if (choose == 0)
            return;
        else {
            switch (choose) {
                case 1 -> {
                    input.nextLine();
                    System.out.print("Nhập Tên: ");
                    String name = input.nextLine();
                    for (SanPham sanpham : DSSP) {
                        if (sanpham.getName().toLowerCase().contains(name.toLowerCase())) {
                            result = addSanPham(result, sanpham);
                        }
                    }
                }
                case 2 -> {
                    input.nextLine();
                    System.out.print("Nhập Mã Sản Phẩm: ");
                    String ID_Product = input.nextLine();
                    for (SanPham sanpham : DSSP) {
                        if (sanpham.getID_Product().toLowerCase().contains(ID_Product.toLowerCase())) {
                            result = addSanPham(result, sanpham);
                        }
                    }
                }
                case 3 -> {
                    System.out.print("Nhập mã loại sản phẩm: ");
                    input.nextLine();
                    String ID_Typeofproduct = input.nextLine();
                    for (SanPham sanpham : DSSP) {
                        if (sanpham.getID_Typeofproduct().toLowerCase().contains(ID_Typeofproduct.toLowerCase())) {
                            result = addSanPham(result, sanpham);
                        }
                    }
                }
                case 4 -> {
                    input.nextLine();
                    System.out.print("Nhập Số Lượng: ");
                    Integer amount = input.nextInt();
                    for (SanPham sanpham : DSSP) {
                        if (amount.equals(getAmount())) {
                            result = addSanPham(result, sanpham);
                        }
                    }
                }
                case 5 -> {
                    input.nextLine();
                    System.out.print("Nhập Số Lượng Còn lại: ");
                    Integer amount_remaining = input.nextInt();
                    for (SanPham sanpham : DSSP) {
                        if (amount_remaining.equals(getAmount_remaining())) {
                            result = addSanPham(result, sanpham);
                        }
                    }
                }
                case 6 -> {
                    input.nextLine();
                    System.out.print("Nhập Giá Tiền: ");
                    Float price = input.nextFloat();
                    for (SanPham sanpham : DSSP) {
                        if (price.equals(getPrice())) {
                            result = addSanPham(result, sanpham);
                        }
                    }
                }
                case 7 -> {
                    input.nextLine();
                    System.out.print("Nhập Trạng Thái: ");
                    String status = input.nextLine();
                    for (SanPham sanpham : DSSP) {
                        if (status.equals(getStatus())) {
                            result = addSanPham(result, sanpham);
                        }
                    }
                }
            }
        }
        System.out.println("\t\t\t\t\t\t\t\t +----TẤT CẢ THÔNG TIN ĐÃ TÌM ĐƯỢC----+");
        String header = String.format("| %-5s | %-10s | %-30s | %-30s | %-30s | %-10s | %-10s |", "ID", "Tên", "Mã Sản Phẩm", "Mã Loại Sản Phẩm", "Số Lượng", "Số Lượng Còn Lại", "Giá Tiền", "Trạng Thái");
        System.out.format("+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");
        System.out.println(header);

        for (SanPham sanpham : result) {
            String read = String.format("| %-5s | %-10s | %-30s | %-30s | %-30s | %-10s | %-10s | %-10s |", "ID", sanpham.getName(), sanpham.getID_Product(), sanpham.getID_Typeofproduct(),
                    sanpham.getAmount(), sanpham.getAmount_remaining(), sanpham.getPrice(), sanpham.getPrice(), sanpham.getStatus());
            System.out.println(read);
            waitConsole();
        }
    }

    public void Output() {
        System.out.println("\t\t\t\t\t\t\t\t +----TẤT CẢ THÔNG TIN SẢN PHẨM----+");
        String header = String.format("| %-5s | %-10s | %-30s | %-30s | %-30s | %-10s | %-10s |", "Mã Sản Phẩm", "Mã Loại Sản Phẩm", "Số Lượng", "Số Lượng Còn Lại", "Giá Tiền", "Trạng Thái");
        System.out.format("+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");
        System.out.println(header);

        for (SanPham DSSP : DSSP) {
            String row = String.format("|\t\t%s\t\t\t|\t%s\t\t|\t%s|\t\t%s\t\t|\t%s\t|\t%s\t\t|\t%s\t|\t\t%s\t\t\t|\t\t%s\t\t" + "|",
                    DSSP.getName(), DSSP.getID_Product(), DSSP.getID_Typeofproduct(), DSSP.getAmount(), DSSP.getAmount_remaining(),
                    DSSP.getPrice(), DSSP.getStatus());
            System.out.println(row);
            waitConsole();
        }
    }
}


