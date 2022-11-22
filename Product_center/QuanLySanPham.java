package Product_center;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class QuanLySanPham extends Product {
    public ArrayList<Product> DSLSP = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    public void Add() {
        input.nextLine();
        System.out.print("Nhập tên sản phẩm: ");
        setName(input.nextLine());

        System.out.print("Nhập mã sản phẩm: ");
        setID_Product(input.nextInt());

        System.out.print("Nhập mã loại sản phẩm: ");
        setID_Typeofproduct(input.nextInt());

        System.out.print("Nhập số lượng: ");
        setAmount(input.nextInt());

        System.out.print("Nhập số lượng còn lại: ");
        setAmount_remaining(input.nextInt());

        System.out.print("Nhập giá: ");
        setPrice(input.nextFloat());

        input.nextLine();
        System.out.print("Nhập tình trạng: ");
        setStatus(input.nextLine());

        Product product = new Product(getName(), getID_Product(), getID_Typeofproduct(), getAmount(), getAmount_remaining(), getPrice(), getStatus());
        DSLSP.add(product);
    }

    public void Update() {
        try {
            System.out.print("Nhập mã sản phẩm cần update: ");
            Integer ID_Product = input.nextInt();
            Product ID_Product_cur = null;

            for (Product product : DSLSP) {
                if (product.getID_Product().equals(ID_Product)) {
                    ID_Product_cur = product;
                    break;
                }
            }

            if(ID_Product_cur == null) {
                System.out.println("Mã sản phẩm không tồn tại!");
                return;
            }

            System.out.println("Thông tin sản phẩm: ");
            String header = String.format("%s %10s %10s %10s %15s %15s %15s", "Name", "ID Product", "ID_Typeofproduct", "Amount", "Amount remaining", "Price", "Status");
            System.out.println(header);

            String row = String.format("%s %10s %10s %10s %15s %15s %15s", ID_Product_cur.getName(), ID_Product_cur.getID_Product(), ID_Product_cur.getID_Typeofproduct(), ID_Product_cur.getAmount(), ID_Product_cur.getAmount_remaining(), ID_Product_cur.getPrice(), ID_Product_cur.getStatus());
            System.out.println(row);

            for (Product product : DSLSP) {
                if (ID_Product.equals(product.getID_Product())) {
                    System.out.print("Nhập ID loại sản phẩm: ");
                    setID_Typeofproduct(input.nextInt());

                    System.out.print("Nhập số lượng: ");
                    setAmount(input.nextInt());

                    System.out.print("Nhập số lượng còn lại: ");
                    setAmount_remaining(input.nextInt());

                    System.out.print("Nhập giá tiền của sản phẩm: ");
                    setPrice(input.nextFloat());

                    input.nextLine();
                    System.out.print("Nhập trạng thái của sản phẩm: ");
                    setStatus(input.nextLine());

                    product.setName(getName());
                    product.setID_Typeofproduct(getID_Typeofproduct());
                    product.setAmount(getAmount());
                    product.setAmount_remaining(getAmount_remaining());
                    product.setStatus(getStatus());
                }
            }
        } catch (InputMismatchException ei) {
            System.out.println("Nhập giá trị không hợp lệ, vui lòng nhập lại!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void Delete() {
        System.out.println("Enter ID to delete: ");
        Integer ID_Product = input.nextInt();

        Product cur_product = null;
        for (Product product : DSLSP) {
            if (product.getID_Product().equals(ID_Product)) {
                cur_product = product;
                break;
            }
        }
        if (cur_product == null) {
            System.out.println("Wrong ID");
        } else {
            for (int i = 0; i < DSLSP.size(); i++) {
                if (ID_Product.equals(DSLSP.get(i).getID_Product())) {
                    DSLSP.remove(i);
                }
            }
        }
    }

    public void Search_byCategory() {
        ArrayList<Product> result = new ArrayList<>();
        System.out.println("Nhập mục lục cần tìm kiếm: ");
        System.out.println("1.ID Product");
        System.out.println("2.ID Typeofproduct");
        System.out.println("3.Amount");
        System.out.println("4.Amount remaining");
        System.out.println("5.Price");
        System.out.println("6.Status");
        int choose = input.nextInt();
        DSLSP.forEach((product) -> {
                    switch (choose) {
                        case 1 -> {
                            input.nextLine();
                            System.out.print("Nhập ID Product: ");
                            int ID_phieunhap = input.nextInt();
                            if (ID_phieunhap == product.getID_Product()) {
                                result.add(product);
                            }
                        }
                        case 2 -> {
                            input.nextLine();
                            System.out.print("Nhập ID Type of product: ");
                            int ID_Typeofproduct = input.nextInt();
                            if (ID_Typeofproduct == product.getID_Product()) {
                                result.add(product);
                            }
                        }
                        case 3 -> {
                            System.out.print("Amount of product: ");
                            input.nextLine();
                            int amount = input.nextInt();
                            if (amount == product.getAmount()) {
                                result.add(product);
                            }
                        }
                        case 4 -> {
                            System.out.print("Amount remaining of product: ");
                            input.nextLine();
                            int amount_remaining = input.nextInt();
                            if (amount_remaining == product.getAmount()) {
                                result.add(product);
                            }
                        }
                        case 5 -> {
                            System.out.print("Price: ");
                            input.nextLine();
                            int price = input.nextInt();
                            if (price == product.getPrice()) {
                                result.add(product);
                            }
                        }
                        case 6 -> {
                            System.out.print("Status: ");
                            input.nextLine();
                            String status = input.nextLine();
                            if (product.getStatus().toLowerCase().contains(status.toLowerCase())) {
                                result.add(product);
                            }
                        }
                    }
                }
        );

        System.out.print("List Product:");
        String header = String.format("%s %15s %15s %15s %15s %15s", "ID Product", "Name", "Amount", "Amount remaining", "Price", "Status");
        System.out.println(header);
        for (Product DSLSP : result) {
            String row = String.format("%d %15s %15d %15d %15s %15s", DSLSP.getID_Product(), DSLSP.getName(), DSLSP.getAmount(), DSLSP.getAmount_remaining(),
                    DSLSP.getPrice(), DSLSP.getStatus());
            System.out.println(row);
        }
    }

    public void Output() {
        System.out.println("List Product:");
        String header = String.format("%s %15s %15s %15s %15s %15s", "ID Product", "Name", "Amount", "Amount remaining", "Price", "Status");
        System.out.println(header);
        for (Product DSLSP : DSLSP) {
            String row = String.format("%d %15s %15d %15d %15s %15s", DSLSP.getID_Product(), DSLSP.getName(), DSLSP.getAmount(), DSLSP.getAmount_remaining(),
                    DSLSP.getPrice(), DSLSP.getStatus());
            System.out.println(row);
        }
    }
}


