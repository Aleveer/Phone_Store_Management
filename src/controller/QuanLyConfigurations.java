package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import entity.Configuation;

public class QuanLyConfigurations extends Configuation implements ControllerInterface{
	 public Configuation[] cfg;
	    public QuanLyConfigurations() {
	       super();
	   }
	    static Scanner input = new Scanner(System.in);
	    public Configuation[] getListConfigurations() {
	        String[] result = new String[0];
			try {
				result = Stream.read("src/DuLieu/configurations.txt");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        cfg = new Configuation[result.length];
	        for (int i = 0; i < result.length; i++) {
	            String[] row = result[i].split(";");
	            cfg[i] = new Configuation(row[0], row[1], row[2], row[3], row[4], row[5], row[6], row[7], row[8]);
	        }
	        return cfg;
	    }
	    public void waitConsole() {
	        input.nextLine();
	        System.out.println("\t\t\t\t\t\t\t\t -Ấn Enter để tiếp tục");
	        input.nextLine();
	    }
	    
	    @Override
	    public void Read() {
	        System.out.println("\t\t\t\t\t\t\t\t +----DANH SÁCH THÔNG TIN CẤU HÌNH----+");
	        String header = String.format("| %-5s | %-10s | %-30s | %-30s | %-30s | %-10s | %-10s | %-20s | %-30s |", "ID", "Màn hình", "Hệ điều hành", "Cấu hình", "RAM", "Bộ nhớ", "Dung lượng pin", "Camera trước", "Camera Sau");
	        System.out.format("+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");
	        System.out.println(header);
	        System.out.format("+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");

	        getListConfigurations();
	        for (Configuation configuation : cfg) {
	            if (cfg[0].getID_Product().contains("cfg")) {
	                String read = String.format("| %-5s | %-10s | %-30s | %-30s | %-30s | %-10s | %-10s | %-10s | %-20s | %-30s |", "ID", configuation.getID_Product(), configuation.getScreen(), configuation.getOS(),
	                        configuation.getChip(), configuation.getRam(), configuation.getMemory(), configuation.getBattery(), configuation.getFrontCamera(), configuation.getRearCamera());
	                System.out.println(read);
	            }
	        }
	        System.out.format("+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");
	        waitConsole();
	    }
	    
	    @Override
	    public void Create() {
	        System.out.println("\t\t\t\t\t\t\t\t +----NHẬP THÔNG TIN CẤU HÌNH SẢN PHẨM----+");
	        System.out.print("Nhập mã sản phẩm: ");
	        setID_Product(input.nextLine());

	        int check = 0;
	        for (Configuation configuation : cfg) {
	            if(getID_Product().equals(configuation.getID_Product())) {
	                check = 1;
	                break;
	            }
	        }

	        if (check == 1) {
	            System.out.println("\t\t\t\t\t\t\t\t -MÃ SẢN PHẨM BỊ TRÙNG!");
	            return;
	        }
	        System.out.print("Nhập Screen: ");
	        setScreen(String.valueOf((input.nextLine())));

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

	        try {
	            String input = getID_Product() + ";" + getScreen() + ";" + getOS() + ";" + getChip() + ";" + getRam() + ";" + getMemory() + ";" + getBattery() + ";" + getFrontCamera() + ";" + getRearCamera();
	            Stream.addOneLine("src/DuLieu/configuration.txt", input);
	            System.out.println("\t\t\t\t\t\t\t\t +----NHẬP CONFIGURATION THÀNH CÔNG----+");
	            waitConsole();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    @Override
	    public void Update() {
	        try {
	            System.out.println("\t\t\t\t\t\t\t\t +----CẬP NHẬT LẠI THÔNG TIN CONFIGURATION----+");
	            System.out.print("\t\t\t\t\t\t\t\t - Mời bạn nhập mã sản phẩm cần chỉnh sửa: ");
	            String ID_Product = input.nextLine();
	            Configuation ID_Product_cur = null;

	            for (Configuation config : cfg) {
	                if (config.getID_Product().equals(ID_Product)) {
	                    ID_Product_cur = config;
	                    break;
	                }
	            }

	            if(ID_Product_cur == null) {
	                System.out.println("\t\t\t\t\t\t\t\t - MÃ SẢN PHẨM KHÔNG TỒN TẠI!");
	                return;
	            }

	            System.out.println("\t\t\t\t\t\t\t\t +----THÔNG TIN CONFIGURATION TRƯỚC KHI CHỈNH SỬA----+");
	            String header = String.format("| %-5s | %-10s | %-30s | %-30s | %-30s | %-10s | %-10s | %-20s | %-30s |", "ID", "Màn hình", "Hệ điều hành", "Cấu hình", "RAM", "Bộ nhớ", "Dung lượng pin", "Camera trước", "Camera Sau");
	            System.out.format("+------------------------------------------------------------------------------------------------------------------------------------------------------------+%n");
	            System.out.println(header);

	            String row = String.format("| %-5s | %-10s | %-30s | %-30s | %-30s | %-10s | %-10s | %-20s | %-30s |",
	                    ID_Product_cur.getID_Product(), ID_Product_cur.getScreen(), ID_Product_cur.getOS(), ID_Product_cur.getChip(), ID_Product_cur.getRam(),
	                    ID_Product_cur.getMemory(), ID_Product_cur.getBattery(), ID_Product_cur.getFrontCamera(), ID_Product_cur.getRearCamera());
	            System.out.println(row);

	            String [] data = new String[cfg.length];
	            for (int i = 0; i < cfg.length; i++) {
	                if (ID_Product.equals(getID_Product())) {
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

	                    cfg[i].setScreen(getScreen());
	                    cfg[i].setOS(getOS());
	                    cfg[i].setChip(getChip());
	                    cfg[i].setRam(getRam());
	                    cfg[i].setMemory(getMemory());
	                    cfg[i].setBattery(getBattery());
	                    cfg[i].setFrontCamera(getFrontCamera());
	                    cfg[i].setRearCamera(getRearCamera());
	                }
	                data[i] = cfg[i].getID_Product() + ";" + cfg[i].getScreen() + ";" + cfg[i].getOS() + ";" + cfg[i].getChip() + ";" + cfg[i].getRam() + ";" + cfg[i].getMemory() + ";" + cfg[i].getBattery() + ";" + cfg[i].getFrontCamera() + ";" + cfg[i].getRearCamera();
	            }
	            try {
	                Stream.addAll("src/DuLieu/configuration.txt", data);
	                System.out.println("\t\t\t\t\t\t\t\t+----SỬA THÔNG TIN CONFIGURATION THÀNH CÔNG----+");
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
	    
	    @Override
	    public void Delete() {
	        try {
	            System.out.println("\t\t\t\t\t\t\t\t +----XÓA THÔNG TIN CONFUGURATION----+");
	            System.out.println("\t\t\t\t\t\t\t\t -Nhập mã sản phẩm cần xóa: ");
	            String ID_Product = input.nextLine();

	            Configuation cur_product = null;
	            for (Configuation config : cfg) {
	                if (config.getID_Product().equals(ID_Product)) {
	                    cur_product = config;
	                    break;
	                }
	            }
	            for (int i = 0; i < cfg.length; i++) {
	                if (ID_Product.equals(cfg[i].getID_Product())) {
	                    cfg = deleteConfiguration(cfg, i);
	                    break;
	                }
	            }

	            if (cur_product == null) {
	                System.out.println("\t\t\t\t\t\t\t\t - MÃ SẢN PHẨM KHÔNG TỒN TẠI!");
	                return;
	            }

	            for (int i = 0; i < cfg.length; i++) {
	                if (ID_Product.equals(cfg[i].getID_Product())) {
	                    cfg = deleteConfiguration(cfg, i);
	                    break;
	                }
	            }
	            String[] data = new String[cfg.length];
	            for (int i = 0; i < cfg.length; i++) {
	                data[i] = cfg[i].getID_Product() + ";" + cfg[i].getScreen() + ";" + cfg[i].getOS() + ";" + cfg[i].getChip() + ";" + cfg[i].getRam() + ";" + cfg[i].getMemory() + ";" + cfg[i].getBattery() + ";" + cfg[i].getFrontCamera() + ";" + cfg[i].getRearCamera();
	            }
	            try {
	                Stream.addAll("src/DuLieu/configuration.txt", data);
	                System.out.println("\t\t\t\t\t\t\t\t +----XÓA THÔNG TIN CONFIGURATION THÀNH CÔNG----+");
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
	    public Configuation[] deleteConfiguration(Configuation[] cfg, int index) {
	        Configuation[] newCs = new Configuation[cfg.length - 1];
	        for (int i = 0, j = 0; i < cfg.length; i++) {
	            if (i != index) {
	                newCs[j++] = cfg[i];
	            }
	        }
	        return newCs;
	    }
	    public Configuation[] addConfiguration(Configuation[] cfg, Configuation configuation) {
	        cfg = Arrays.copyOf(cfg, cfg.length + 1);
	        cfg[cfg.length -1] = configuation;
	        return cfg;
	    }
	    
	    @Override
	    public void Search_byCategory() {
	        Configuation[] result = new Configuation[0];
	        System.out.println("\t\t\t\t\t\t\t\t +--------NHẬP MỤC LỤC CẨN TÌM KIẾM--------+");
	        System.out.println("\t\t\t\t\t\t\t\t |0.Thoát                                  |");
	        System.out.println("\t\t\t\t\t\t\t\t +-----------------------------------------+");
	        System.out.println("\t\t\t\t\t\t\t\t |1.Mã sản phẩm                            |");
	        System.out.println("\t\t\t\t\t\t\t\t |2.Màn hình                               |");
	        System.out.println("\t\t\t\t\t\t\t\t |3.Hệ điều hành                           |");
	        System.out.println("\t\t\t\t\t\t\t\t |4.Cấu hình chip                          |");
	        System.out.println("\t\t\t\t\t\t\t\t |5.RAM                                    |");
	        System.out.println("\t\t\t\t\t\t\t\t |6.Bộ nhớ (ROM)                           |");
	        System.out.println("\t\t\t\t\t\t\t\t |7.Dung lượng pin                         |");
	        System.out.println("\t\t\t\t\t\t\t\t |8.Số pixel Camera trước                  |");
	        System.out.println("\t\t\t\t\t\t\t\t |9.Số pixel Camera sau                    |");
	        System.out.println("\t\t\t\t\t\t\t\t +-----------------------------------------+");
	        System.out.print("\t\t\t\t\t\t\t\t - Mời Bạn Nhập Lựa Chọn: ");
	        int choose = input.nextInt();
	        if (choose == 0)
	            return;
	        else {
	                switch (choose) {
	                    case 1 -> {
	                        input.nextLine();
	                        System.out.print("Nhập mã sản phẩm: ");
	                        String ID_cauhinh = input.nextLine();
	                        for (Configuation configuation : cfg) {
	                            if (configuation.getID_Product().toLowerCase().contains(ID_cauhinh.toLowerCase())) {
	                                result = addConfiguration(result, configuation);
	                            }
	                        }
	                    }
	                    case 2 -> {
	                        input.nextLine();
	                        System.out.print("Nhập Screen: ");
	                        String Screen = input.nextLine();
	                        for (Configuation configuation : cfg) {
	                            if (configuation.getScreen().toLowerCase().contains(Screen.toLowerCase())) {
	                                result = addConfiguration(result, configuation);
	                            }
	                        }
	                    }
	                    case 3 -> {
	                        System.out.print("Nhập OS: ");
	                        input.nextLine();
	                        String OS = input.nextLine();
	                        for (Configuation configuation : cfg) {
	                            if (configuation.getOS().toLowerCase().contains(OS.toLowerCase())) {
	                                result = addConfiguration(result, configuation);
	                            }
	                        }
	                    }
	                    case 4 -> {
	                        input.nextLine();
	                        System.out.print("Nhập Chip: ");
	                        String Chip = input.nextLine();
	                        for (Configuation configuation : cfg) {
	                            if (configuation.getChip().toLowerCase().contains(Chip.toLowerCase())) {
	                                result = addConfiguration(result, configuation);
	                            }
	                        }
	                    }
	                    case 5 -> {
	                        System.out.print("Nhập Ram: ");
	                        input.nextLine();
	                        String Ram = input.nextLine();
	                        for (Configuation configuation : cfg) {
	                            if (configuation.getRam().toLowerCase().contains(Ram.toLowerCase())) {
	                                result = addConfiguration(result, configuation);
	                            }
	                        }
	                    }
	                    case 6 -> {
	                        System.out.print("Nhập Memory: ");
	                        input.nextLine();
	                        String Memory = input.nextLine();
	                        for (Configuation configuation : cfg) {
	                            if (configuation.getMemory().toLowerCase().contains(Memory.toLowerCase())) {
	                                result = addConfiguration(result, configuation);
	                            }
	                        }
	                    }
	                    case 7 -> {
	                        System.out.print("Nhập Battery: ");
	                        input.nextLine();
	                        String Battery = input.nextLine();
	                        for (Configuation configuation : cfg) {
	                            if (configuation.getBattery().toLowerCase().contains(Battery.toLowerCase())) {
	                                result = addConfiguration(result, configuation);
	                            }
	                        }
	                    }
	                    case 8 -> {
	                        System.out.print("Nhập Front Camera: ");
	                        input.nextLine();
	                        String FrontCamera = input.nextLine();
	                        for (Configuation configuation : cfg) {
	                            if (configuation.getFrontCamera().toLowerCase().contains(FrontCamera.toLowerCase())) {
	                                result = addConfiguration(result, configuation);
	                            }
	                        }
	                    }
	                    case 9 -> {
	                        System.out.print("Nhập Rear Camera: ");
	                        input.nextLine();
	                        String RearCamera = input.nextLine();
	                        for (Configuation configuation : cfg) {
	                            if (configuation.getRearCamera().toLowerCase().contains(RearCamera.toLowerCase())) {
	                                result = addConfiguration(result, configuation);
	                            }
	                        }
	                    }
	                }
	            }
	        System.out.println("\t\t\t\t\t\t\t\t +----TẤT CẢ THÔNG TIN ĐÃ TÌM ĐƯỢC----+");
	        String header = String.format("| %-5s | %-10s | %-30s | %-30s | %-30s | %-10s | %-10s | %-20s | %-30s |", "ID", "Màn hình", "Hệ điều hành", "Cấu hình", "RAM", "Bộ nhớ", "Dung lượng pin", "Camera trước", "Camera Sau");
	        System.out.format("+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");
	        System.out.println(header);

	        for (Configuation configuation : result) {
	            String read = String.format("| %-5s | %-10s | %-30s | %-30s | %-30s | %-10s | %-10s | %-10s | %-20s | %-30s |", "ID", configuation.getID_Product(), configuation.getScreen(), configuation.getOS(),
	                    configuation.getChip(), configuation.getRam(), configuation.getMemory(), configuation.getBattery(), configuation.getFrontCamera(), configuation.getRearCamera());
	            System.out.println(read);
	        }
            waitConsole();
	    }
}
