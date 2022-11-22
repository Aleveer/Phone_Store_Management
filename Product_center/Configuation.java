package Product_center;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Configuation{
    private String Screen, OS, Chip, Ram, Memory, Battery, FrontCamera, RearCamera;
    private Integer ID_Product;
    public Configuation() {

    }

    public Configuation(Integer ID_Product, String Screen, String OS, String Chip, String Ram, String Memory, String Battery, String FrontCamera, String RearCamera) {
        this.ID_Product = ID_Product;
        this.Screen = Screen;
        this.OS = OS;
        this.Chip = Chip;
        this.Ram = Ram;
        this.Memory = Memory;
        this.Battery = Battery;
        this.FrontCamera = FrontCamera;
        this.RearCamera = RearCamera;
    }
    public Integer getID_Product() {
        return ID_Product;
    }

    public void setID_Product(Integer ID_Product) {
        this.ID_Product = ID_Product;
    }

    public String getScreen() {
        return Screen;
    }

    public void setScreen(String Screen) {
        this.Screen = Screen;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public String getChip() {
        return Chip;
    }

    public void setChip(String Chip) {
        this.Chip = Chip;
    }

    public String getRam() {
        return Ram;
    }

    public void setRam(String Ram) {
        this.Ram = Ram;
    }

    public String getMemory() {
        return Memory;
    }

    public void setMemory(String Memory) {
        this.Memory = Memory;
    }

    public String getBattery() {
        return Battery;
    }

    public void setBattery(String Battery) {
        this.Battery = Battery;
    }

    public String getFrontCamera() {
        return FrontCamera;
    }

    public void setFrontCamera(String FrontCamera) {
        this.FrontCamera = FrontCamera;
    }

    public String getRearCamera() {
        return RearCamera;
    }

    public void setRearCamera(String RearCamera) {
        this.RearCamera = RearCamera;
    }

    public ArrayList<Configuation> DSCH = new ArrayList<Configuation>();
    static Scanner input = new Scanner(System.in);
    public void Add() {

        input.nextLine();
        System.out.print("Nhập ID_Product: ");
        setID_Product(input.nextInt());

        input.nextLine();
        System.out.print("Nhập Screen: ");
        setScreen(input.nextLine());

        input.nextLine();
        System.out.print("Nhập OS: ");
        setOS(input.nextLine());

        input.nextLine();
        System.out.print("Nhập Chip: ");
        setChip(input.nextLine());

        input.nextLine();
        System.out.print("Nhập Ram: ");
        setRam(input.nextLine());

        input.nextLine();
        System.out.print("Nhập Memory: ");
        setMemory(input.nextLine());

        input.nextLine();
        System.out.print("Nhập Battery: ");
        setBattery(input.nextLine());

        input.nextLine();
        System.out.print("Nhập Front Camera: ");
        setFrontCamera(input.nextLine());

        input.nextLine();
        System.out.print("Nhập Rear Camera: ");
        setRearCamera(input.nextLine());

        Configuation config = new Configuation(getID_Product(), getScreen(), getOS(), getChip(), getRam(), getMemory(), getBattery(), getFrontCamera(), getRearCamera());
        DSCH.add(config);
    }

    public void Update() {
        try {
            System.out.print("Nhập mã sản phẩm cần update cấu hinnh: ");
            Integer ID_Product = input.nextInt();
            Configuation ID_Product_cur = null;

            for (Configuation config : DSCH) {
                if (config.getID_Product().equals(ID_Product)) {
                    ID_Product_cur = config;
                    break;
                }
            }

            if(ID_Product_cur == null) {
                System.out.println("Mã sản phẩm không tồn tại!");
                return;
            }

            System.out.println("Thông tin sản phẩm: ");
            String header = String.format("%s %15s %15s %15s %15s %15s %15s  %15s %15s", "ID Product", "Screen", "OS", "Chip", "Ram", "Memory", "Battery", "Front Camera", "Rear Camera");
            System.out.println(header);

            String row = String.format("%d %15s %15s %15s %15s %15s %15s %15s %15s", ID_Product_cur.getID_Product(), ID_Product_cur.getScreen(), ID_Product_cur.getOS(), ID_Product_cur.getChip(), ID_Product_cur.getRam(),
                    ID_Product_cur.getMemory(), ID_Product_cur.getBattery(), ID_Product_cur.getFrontCamera(), ID_Product_cur.getRearCamera());
            System.out.println(row);

            for (Configuation config: DSCH) {
                if (ID_Product.equals(config.getID_Product())) {
                    input.nextLine();
                    System.out.print("Nhập Screen: ");
                    setScreen(input.nextLine());

                    System.out.print("Nhập OS: ");
                    setOS(input.nextLine());

                    System.out.print("Nhập Chip: ");
                    setChip(input.nextLine());

                    System.out.print("Nhập Ram: ");
                    setRam(input.nextLine());

                    System.out.print("Nhập Memory: ");
                    setMemory(input.nextLine());

                    System.out.print("Nhập Battery: ");
                    setBattery(input.nextLine());

                    System.out.print("Nhập Front Camera: ");
                    setFrontCamera(input.nextLine());

                    System.out.print("Nhập Rear Camera: ");
                    setRearCamera(input.nextLine());

                    config.setScreen(getScreen());
                    config.setOS(getOS());
                    config.setChip(getChip());
                    config.setRam(getRam());
                    config.setMemory(getMemory());
                    config.setBattery(getBattery());
                    config.setFrontCamera(getFrontCamera());
                    config.setRearCamera(getRearCamera());
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

        Configuation cur_product = null;
        for (Configuation config : DSCH) {
            if (config.getID_Product().equals(ID_Product)) {
                cur_product = config;
                break;
            }
        }
        if (cur_product == null) {
            System.out.println("Wrong ID");
        } else {
            for (int i = 0; i < DSCH.size(); i++) {
                if (ID_Product.equals(DSCH.get(i).getID_Product())) {
                    DSCH.remove(i);
                }
            }
        }
    }

    public void Search_byCategory() {
        ArrayList<Configuation> result = new ArrayList<Configuation>();
        System.out.println("Nhập mục lục cần tìm kiếm: ");
        System.out.println("1.ID Product");
        System.out.println("2.Screen");
        System.out.println("3.OS");
        System.out.println("4.Chip");
        System.out.println("5.Ram");
        System.out.println("6.Memory");
        System.out.println("7.Battery");
        System.out.println("8.Front Camera");
        System.out.println("9.Rear Camera");
        int choose = input.nextInt();
        DSCH.forEach((config) -> {
                    switch (choose) {
                        case 1 -> {
                            input.nextLine();
                            System.out.print("Nhập ID Product: ");
                            int ID_cauhinh = input.nextInt();
                            if (ID_cauhinh == config.getID_Product()) {
                                result.add(config);
                            }
                        }
                        case 2 -> {
                            input.nextLine();
                            System.out.print("Nhập Screen: ");
                            String Screen = input.nextLine();
                            if (config.getScreen().toLowerCase().contains(Screen.toLowerCase())) {
                                result.add(config);
                            }
                        }
                        case 3 -> {
                            System.out.print("Nhập OS: ");
                            input.nextLine();
                            String OS = input.nextLine();
                            if (config.getOS().toLowerCase().contains(OS.toLowerCase())) {
                                result.add(config);
                            }
                        }
                        case 4 -> {
                            System.out.print("Nhập Chip: ");
                            input.nextLine();
                            String Chip = input.nextLine();
                            if (config.getChip().toLowerCase().contains(Chip.toLowerCase())) {
                                result.add(config);
                            }
                        }
                        case 5 -> {
                            System.out.print("Nhập Ram: ");
                            input.nextLine();
                            String Ram = input.nextLine();
                            if (config.getRam().toLowerCase().contains(Ram.toLowerCase())) {
                                result.add(config);
                            }
                        }
                        case 6 -> {
                            System.out.print("Nhập Memory: ");
                            input.nextLine();
                            String Memory = input.nextLine();
                            if (config.getMemory().toLowerCase().contains(Memory.toLowerCase())) {
                                result.add(config);
                            }
                        }
                        case 7 -> {
                            System.out.print("Nhập Battery: ");
                            input.nextLine();
                            String Battery = input.nextLine();
                            if (config.getBattery().toLowerCase().contains(Battery.toLowerCase())) {
                                result.add(config);
                            }
                        }
                        case 8 -> {
                            System.out.print("Nhập Front Camera: ");
                            input.nextLine();
                            String FrontCamera = input.nextLine();
                            if (config.getFrontCamera().toLowerCase().contains(FrontCamera.toLowerCase())) {
                                result.add(config);
                            }
                        }
                        case 9 -> {
                            System.out.print("Nhập Rear Camera: ");
                            input.nextLine();
                            String RearCamera = input.nextLine();
                            if (config.getRearCamera().toLowerCase().contains(RearCamera.toLowerCase())) {
                                result.add(config);
                            }
                        }
                    }
                }
        );

        System.out.print("List Product:");
        String header = String.format("%s %15s %15s %15s %15s %15s %15s  %15s %15s", "ID Product", "Screen", "OS", "Chip", "Ram", "Memory", "Battery", "Front Camera", "Rear Camera");
        System.out.println(header);
        for (Configuation DSCH : result) {
            String row = String.format("%d %15s %15s %15s %15s %15s %15s %15s %15s", DSCH.getID_Product(), DSCH.getScreen(), DSCH.getOS(), DSCH.getChip(), DSCH.getRam(),
                    DSCH.getMemory(), DSCH.getBattery(), DSCH.getFrontCamera(), DSCH.getRearCamera());
            System.out.println(row);
        }
    }

    public void Output() {
        System.out.println("List Config:");
        String header = String.format("%s %15s %15s %15s %15s %15s %15s  %15s %15s", "ID Product", "Screen", "OS", "Chip", "Ram", "Memory", "Battery", "Front Camera", "Rear Camera");
        System.out.println(header);
        for (Configuation DSCH : DSCH) {
            String row = String.format("%d %15s %15s %15s %15s %15s %15s %15s %15s", DSCH.getID_Product(), DSCH.getScreen(), DSCH.getOS(), DSCH.getChip(), DSCH.getRam(),
                    DSCH.getMemory(), DSCH.getBattery(), DSCH.getFrontCamera(), DSCH.getRearCamera());
            System.out.println(row);
        }
    }
}



