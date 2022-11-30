package controller;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import entity.Customer;
import entity.NhanVien;
import view.DataAccessObject;
public class QuanLyNhanVien extends NhanVien implements DataAccessObject{
	 	public NhanVien[] nv;
		public static Scanner input = new Scanner(System.in);
		public QuanLyNhanVien() throws FileNotFoundException {
			super();
			getListNhanVien();
		}
	    public NhanVien[] getListNhanVien() throws FileNotFoundException {
	        String[] result = Stream.read("src/database/employee.txt");
	        nv = new NhanVien[result.length];
	        for (int i = 0; i < result.length; i++) {
	            String[] row = result[i].split(";");
	            nv[i] = new NhanVien(row[0], row[1], Integer.parseInt(row[2]), row[3], row[4], row[5], row[6], row[7], row[8]);
	        }
	        return nv;
	    }
	    public void waitConsole() {
	        System.out.println("\t\t\t\t\t\t\t\t -Ấn Enter để tiếp tục");
	        input.nextLine();
	    }
	    public void Read() throws FileNotFoundException {
	        System.out.println("\t\t\t\t\t\t\t\t +----DANH SÁCH NHÂN VIÊN----+");
	        String header = String.format("| %-5s | %-25s | %-4s | %-9s | %-30s | %-25s | %-15s | %-20s | %-20s |", "ID", "Họ tên", "Tuổi", "Giới Tính", "Địa chỉ", "Email", "Số điện thoại", "Chức vụ", "Ca trực");
	        System.out.format("+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");
	        System.out.println(header);
	        System.out.format("+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");

	        getListNhanVien();
	        for (NhanVien nhanVien : nv) {
				if (nv[0].getID_Worker().indexOf("nv") >= 0) {
					String read = String.format("| %-5s | %-25s | %-4s | %-9s | %-30s | %-25s | %-15s | %-20s | %-20s |", nhanVien.getID_Worker(), nhanVien.getName(), nhanVien.getAge(),
							nhanVien.getGender(), nhanVien.getAddress(), nhanVien.getEmail(), nhanVien.getPhoneNumber(),
							nhanVien.getRole(), nhanVien.getShift());
					System.out.println(read);
				}
	        }
	        System.out.format("+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");
	        waitConsole();
	    }
	    @Override
	    public void Create() {
	        try {
	            System.out.println("\t\t\t\t\t\t\t\t +----NHẬP THÔNG TIN NHÂN VIÊN----+");
	            System.out.print("Nhập ID nhân viên:");
	            setID_Worker(input.nextLine());

				for (NhanVien nhanvien : nv) {
					if (nhanvien != null) {
						if (getID_Worker().equals(nhanvien.getID_Worker())) {
							System.out.println("\t\t\t\t\t\t\t\t -MÃ NHÂN VIÊN BỊ TRÙNG!");
							break;
						}
					}
				}

	            super.Add();
	            input.nextLine();
	            System.out.print("Nhập chức vụ của nhân viên:");
	            setRole(input.nextLine());

	            System.out.print("Nhập ca làm việc của nhân viên: ");
	            setShift(input.nextLine());

	            try {
	                String input = getID_Worker() + ";" + getName() + ";" + getAge() + ";" + getGender() + ";" + getAddress() + ";" + getEmail() + ";" + getPhoneNumber() + ";" + getRole() + ";" + getShift();
	                Stream.addOneLine("src/database/employee.txt", input);
	                System.out.println("\t\t\t\t\t\t\t\t -NHẬP NHÂN VIÊN THÀNH CÔNG");
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
	    public void Update() {
	        try {
	            System.out.println("\t\t\t\t\t\t\t\t +----CẬP NHẬT LẠI THÔNG TIN NHÂN VIÊN----+");
				input.nextLine();
	            System.out.print("\t\t\t\t\t\t\t\t - Mời bạn nhập mã nhân viên cần chỉnh sửa: ");
	            String ID_NhanVien = input.nextLine();
	            NhanVien n_vien = null;

	            for (NhanVien nhanVien : nv) {
	                if (nhanVien.getID_Worker().equals(ID_NhanVien)) {
	                    n_vien = nhanVien;
	                    break;
	                }
	            }

	            if(n_vien == null) {
	                System.out.println("\t\t\t\t\t\t\t\t -MÃ NHÂN VIÊN KHÔNG TỒN TẠI!");
	                return;
	            }

	            System.out.println("\t\t\t\t\t\t\t\t +----THÔNG TIN NHÂN VIÊN TRƯỚC KHI ĐƯỢC CHỈNH SỬA----+");
	            String header = String.format("| %-5s | %-25s | %-4s | %-9s | %-30s | %-25s | %-15s | %-20s | %-20s |", "ID", "Họ tên", "Tuổi", "Giới Tính", "Địa chỉ", "Email", "Số điện thoại", "Chức vụ", "Ca trực");
	            System.out.format("+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");
	            System.out.println(header);
	            System.out.format("+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");
	            String row = String.format("| %-5s | %-25s | %-4s | %-9s | %-30s | %-25s | %-15s | %-20s | %-20s |", n_vien.getID_Worker(), n_vien.getName(), n_vien.getAge(), n_vien.getGender(),
	                    n_vien.getAddress(), n_vien.getEmail(), n_vien.getPhoneNumber(), n_vien.getRole(), n_vien.getShift());
	            System.out.println(row);

	            String[] data = new String[nv.length];

	            for (int i=0; i < nv.length; i++) {
	                if (ID_NhanVien.equals(nv[i].getID_Worker())) {
	                    System.out.println("Nhập thông tin nhân viên:");
	                    super.Add();

	                    input.nextLine();
	                    System.out.print("Nhập chức vụ của nhân viên: ");
	                    setRole(input.nextLine());

	                    System.out.print("Nhập ca làm việc của nhân viên: ");
	                    setShift(input.nextLine());

	                    nv[i].setName(getName());
	                    nv[i].setGender(getGender());
	                    nv[i].setAddress(getAddress());
	                    nv[i].setEmail(getEmail());
	                    nv[i].setAge(getAge());
	                    nv[i].setPhoneNumber(getPhoneNumber());
	                    nv[i].setShift(getShift());
	                }
	                data[i] = nv[i].getID_Worker() + ";" + nv[i].getName() + ";" + nv[i].getAge() + ";" + nv[i].getGender() + ";" + nv[i].getAddress() + ";" + nv[i].getEmail() + ";" + nv[i].getPhoneNumber() + ";" + nv[i].getRole() + ";" + nv[i].getShift();
	            }
	            try {
	                Stream.addAll("src/database/employee.txt", data);
	                System.out.println("\t\t\t\t\t\t\t\t----SỬA THÔNG TIN NHÂN VIÊN THÀNH CÔNG----");
	                waitConsole();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	        catch (InputMismatchException ei) {
	            System.out.println("\t\t\t\t\t\t\t\t GIÁ TRỊ KHÔNG HỢP LỆ. VUI LÒNG NHẬP LẠI!");
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	    }
	    public void Delete() {
	        try {
	            System.out.println("\t\t\t\t\t\t\t\t +----XÓA THÔNG TIN NHÂN VIÊN----+");
	            System.out.print("\t\t\t\t\t\t\t\t -Nhập mã nhân viên cần xóa: ");
	            String ID_Nhanvien = input.nextLine();
	            NhanVien n_vien = null;

	            for (NhanVien nhanVien : nv) {
	                if (nhanVien.getID_Worker().equals(ID_Nhanvien)) {
	                    n_vien = nhanVien;
	                    break;
	                }
	            }

	            if(n_vien == null) {
	                System.out.println("\t\t\t\t\t\t\t\t -MÃ NHÂN VIÊN KHÔNG TỒN TẠI!");
	                return;
	            }

	            for (int i = 0; i < nv.length; i++) {
	                if (ID_Nhanvien.equals(nv[i].getID_Worker())) {
	                    nv = deleteNhanVien(nv, i);
	                    break;
	                }
	            }

	            String[] data = new String[nv.length];
	            for (int i=0; i< nv.length; i++) {
	                data[i] = nv[i].getID_Worker() + ";" + nv[i].getName() + ";" + nv[i].getAge() + ";" + nv[i].getGender() + ";" + nv[i].getAddress() + ";" + nv[i].getEmail() + ";" + nv[i].getPhoneNumber() + ";" + nv[i].getRole() + ";" + nv[i].getShift();
	            }
	            try {
	                Stream.addAll("src/database/employee.txt", data);
	                System.out.println("\t\t\t\t\t\t\t\t +----XÓA THÔNG TIN NHÂN VIÊN THÀNH CÔNG----+");
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
	    public NhanVien[] deleteNhanVien(NhanVien[] nv, int index) {
	        NhanVien[] newCs = new NhanVien[nv.length - 1];
	        for (int i = 0, j = 0; i < nv.length; i++) {
	            if (i != index) {
	                newCs[j++] = nv[i];
	            }
	        }
	        return newCs;
	    }

	    public NhanVien[] addNhanVien(NhanVien[] nv, NhanVien nhanVien) {
	        nv = Arrays.copyOf(nv, nv.length + 1);
	        nv[nv.length -1] = nhanVien;
	        return nv;
	    }
	    public void Search_byCategory() {
	        NhanVien[] result = new NhanVien[0];
	        System.out.println("\t\t\t\t\t\t\t\t +--------NHẬP MỤC LỤC CẨN TÌM KIẾM--------+");
	        System.out.println("\t\t\t\t\t\t\t\t |0.Thoát                                  |");
	        System.out.println("\t\t\t\t\t\t\t\t +-----------------------------------------+");
	        System.out.println("\t\t\t\t\t\t\t\t |1.Mã nhân viên                           |");
	        System.out.println("\t\t\t\t\t\t\t\t |2.Tên nhân viên                          |");
	        System.out.println("\t\t\t\t\t\t\t\t |3.Địa chỉ nhân viên                      |");
	        System.out.println("\t\t\t\t\t\t\t\t |4.Số điện thoại nhân viên                |");
	        System.out.println("\t\t\t\t\t\t\t\t |5.Chức vụ nhân viên                      |");
	        System.out.println("\t\t\t\t\t\t\t\t |6.Ca trực của nhân viên                  |");
	        System.out.println("\t\t\t\t\t\t\t\t +-----------------------------------------+");
	        System.out.print("\t\t\t\t\t\t\t\t - Mời Bạn Nhập Lựa Chọn: ");
	        int choose = input.nextInt();
	        if (choose == 0) return;
	        else {
	            switch (choose) {
	                case 1 -> {
	                    input.nextLine();
	                    System.out.print("Nhập mã nhân viên: ");
	                    String ID_Worker = input.nextLine();
	                   for(NhanVien nhanVien : nv) {
	                       if(ID_Worker.contains(nhanVien.getID_Worker())) {
	                           result = addNhanVien(result, nhanVien);
	                       }
	                   }
	                }
	                case 2 -> {
	                    input.nextLine();
	                    System.out.print("Nhập họ tên nhân viên: ");
	                    String nameWorker = input.nextLine();
	                    for (NhanVien nhanVien : nv) {
	                        if (nhanVien.getName().toLowerCase().contains(nameWorker.toLowerCase())) {
	                            result = addNhanVien(result, nhanVien);
	                        }
	                    }
	                }
	                case 3 -> {
	                    input.nextLine();
	                    System.out.print("Nhập địa chỉ của nhân viên: ");
	                    String address = input.nextLine();
	                    for(NhanVien nhanVien : nv) {
	                        if (nhanVien.getAddress().toLowerCase().contains(address.toLowerCase())) {
	                            result = addNhanVien(result, nhanVien);
	                        }
	                    }
	                }
	                case 4 -> {
	                    input.nextLine();
	                    System.out.print("Nhập số điện thoại của nhân viên: ");
	                    String phoneNumber = input.nextLine();
	                    for(NhanVien nhanVien : nv) {
	                        if (nhanVien.getPhoneNumber().toLowerCase().contains(phoneNumber.toLowerCase())) {
	                            result = addNhanVien(result, nhanVien);
	                        }
	                    }
	                }
	                case 5 -> {
	                    input.nextLine();
	                    System.out.print("Nhập chức vụ của nhân viên: ");
	                    String Role = input.nextLine();
	                    for(NhanVien nhanVien : nv) {
	                        if (nhanVien.getRole().toLowerCase().contains(Role.toLowerCase())) {
	                            result = addNhanVien(result, nhanVien);
	                        }
	                    }
	                }
	                case 6 -> {
	                    input.nextLine();
	                    System.out.print("Nhập ca trực của nhân viên: ");
	                    String Shift = input.nextLine();
	                    for(NhanVien nhanVien : nv) {
	                        if (nhanVien.getShift().toLowerCase().contains(Shift.toLowerCase())) {
	                            result = addNhanVien(result, nhanVien);
	                        }
	                    }
	                }
	            }
	            System.out.println("\t\t\t\t\t\t\t\t +----THÔNG TIN NHÂN VIÊN TÌM ĐƯỢC----+");
	            String header = String.format("| %-5s | %-25s | %-4s | %-9s | %-30s | %-25s | %-15s | %-20s | %-20s |", "ID", "Họ tên", "Tuổi", "Giới Tính", "Địa chỉ", "Email", "Số điện thoại", "Chức vụ", "Ca trực");
	            System.out.format("+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");
	            System.out.println(header);
	            System.out.format("+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");

	            for (NhanVien DSNV : result) {
	                String row = String.format("| %-5s | %-25s | %-4s | %-9s | %-30s | %-25s | %-15s | %-20s | %-20s |", DSNV.getName(), DSNV.getAge(), DSNV.getGender(),
	                        DSNV.getAddress(), DSNV.getEmail(), DSNV.getID_Worker(), DSNV.getRole(), DSNV.getShift(), DSNV.getPhoneNumber());
	                System.out.println(row);
	                waitConsole();
	            }
	        }
	    }
	    public void Output() {
	        System.out.println("\t\t\t\t\t\t\t\t +----DANH SÁCH NHÂN VIÊN----+");
	        String header = String.format("| %-5s | %-25s | %-4s | %-9s | %-30s | %-25s | %-15s | %-20s | %-20s |", "ID", "Họ tên", "Tuổi", "Giới Tính", "Địa chỉ", "Email", "Số điện thoại", "Chức vụ", "Ca trực");
	        System.out.format("+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");
	        System.out.println(header);
	        for(NhanVien DSNV : nv) {
	            String row = String.format("| %-5s | %-25s | %-4s | %-9s | %-30s | %-25s | %-15s | %-20s | %-20s |", DSNV.getName(), DSNV.getAge(), DSNV.getGender(),
	                    DSNV.getAddress(), DSNV.getEmail(), DSNV.getID_Worker(), DSNV.getRole(), DSNV.getShift(), DSNV.getPhoneNumber());
	            System.out.println(row);
	        }
	    }
}
