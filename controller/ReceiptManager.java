package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

import entity.Receipt;
import view.DataAccessObject;

public class ReceiptManager extends Receipt implements DataAccessObject{
	   	public Receipt[] re;
	    static Scanner input = new Scanner(System.in);
	    
	    public ReceiptManager() throws FileNotFoundException{
			super();
			getListReceipt();
		}
	    
	    public Receipt[] getListReceipt() throws FileNotFoundException{
	    	String[] result = Stream.read("src/database/receipt.txt");
	    	re = new Receipt[result.length];
	    	for(int i = 0; i < result.length; i++) {
	        	String[] row = result[i].split(";");
	        	re[i] = new Receipt(row[0], Integer.parseInt(row[1]), row[2], row[3], row[4], row[5]);
	    	}
	    	return re;
	    }
	    
	    public void Read() throws FileNotFoundException {
			System.out.println("Danh sách hóa đơn:");
			String header = String.format("| %-5s | %-15s | %-20s | %-25s | %-5s | %-5s |", "ID", "Giá", "Ngày mua", "Phương thức thanh toán", "Id khách hàng", "Id người lập hóa đơn");
			System.out.format("+-------+---------------------+----------------------------+-----------------------------------+-------+-------+%n");
		    System.out.println(header);
		    System.out.format("+-------+---------------------+----------------------------+-----------------------------------+-------+-------+%n");	        
		    getListReceipt();
			for (Receipt receipt : re) {
				String read = String.format("| %-5s | %-15s | %-20s | %-25s | %-5s | %-5s | ", receipt.getID_receipt(), receipt.getPrice(), receipt.getDatePurchase(), receipt.getPurchaseMethod(), receipt.getID_Customer(), receipt.getID_Worker());
				System.out.println(read);
			}
	        System.out.format("+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");
	        waitConsole();
		}
	    
	    public void Create() {
	        System.out.print("Nhập mã hóa đơn: ");
	        setID_receipt(input.nextLine());
	        
	        int check = 0;
			for (Receipt receipt : re) {
				if (getID_receipt().equals(receipt.getID_receipt())) {
					check = 1;
					break;
				}
			}
	        
	        if(check == 1) {
	        	System.out.println("id của hóa đơn bị trùng");
	        	return;
	        }

			input.nextLine();
	        System.out.print("Nhập giá: ");
	        setPrice(input.nextInt());

	        input.nextLine();
	        System.out.print("Nhập mã khách hàng: ");
	        setID_Customer(input.nextLine());
	        
	        System.out.println("Nhập mã nhân viên");
	        setID_Worker(input.nextLine());

	        System.out.print("Nhập phương pháp mua hàng: ");
	        setPurchaseMethod(input.nextLine());
	        
	        LocalDate date = java.time.LocalDate.now();
	        setDatePurchase(date.format(DateTimeFormatter.ofPattern("d/MM/uuuu")));

	        try {
				String input = getID_receipt() + ";" + getPrice() + ";" + getDatePurchase() + ";" + getPurchaseMethod() + ";" + getID_Customer() + ";" + getID_Worker();
				Stream.addOneLine("src/database/receipt.txt", input);
				System.out.println("Nhập hóa đơn thành công");
				waitConsole();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }

		public void Update() {
            System.out.print("Nhập ID hóa đơn cần chỉnh sửa: ");
            String ID_Receipt = input.nextLine();
            Receipt hdon = null;

            for (Receipt receipt : re) {
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
            String row = String.format("%s %15s %15s %50s %10s %10s", hdon.getID_receipt(), hdon.getPrice(),hdon.getPurchaseMethod(),
            		hdon.getDatePurchase(), hdon.getID_Customer(), hdon.getID_Worker());
            System.out.println(row);
            
            String[] data = new String[re.length];

            for (int i = 0; i < re.length; i++) {
                if (ID_Receipt.equals(re[i].getID_receipt())) {
                    System.out.println("Nhập thông tin hóa đơn:");
                    
                    System.out.print("Nhập giá: ");
        	        setPrice(input.nextInt());

        	        input.nextLine();
        	        System.out.print("Nhập mã khách hàng: ");
        	        setID_Customer(input.nextLine());
        	        
        	        System.out.println("Nhập mã nhân viên");
        	        setID_Worker(input.nextLine());

        	        System.out.print("Nhập phương pháp mua hàng: ");
        	        input.nextLine();
        	        setPurchaseMethod(input.nextLine());

                    re[i].setPrice(getPrice());
                    re[i].setID_Customer(getID_Customer());
                    re[i].setID_Worker(getID_Worker());
                    re[i].setPurchaseMethod(getPurchaseMethod());
                }
                data[i] =  getID_receipt() + ";" + getPrice() + ";" + getDatePurchase() + ";" + getPurchaseMethod() + ";" + getID_Customer() + ";" + getID_Worker();
            }
            try {
    			Stream.addAll("src/database/receipt.txt", data);
    			System.out.println("Sửa thông tin hoá đơn thành công");
    			waitConsole();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
	    }

	    public void Delete() {
				input.nextLine();
	            System.out.print("Nhập ID hóa đơn cần xóa: ");
	            String ID_HoaDon = input.nextLine();

				Receipt hdon = null;
	            for (Receipt hoadon : re) {
	                if (hoadon.getID_receipt().equals(ID_HoaDon)) {
	                    hdon = hoadon;
	                    break;
	                }
	            }
	            if(hdon == null) {
	                System.out.println("ID hóa đơn không tồn tại.");
	                return;
	            }

				for (int i = 0; i < re.length; i++) {
					if (ID_HoaDon.equals(re[i].getID_receipt())) {
						re = deleteReceipt(re, i);
						break;
					}
				}

	            String[] data = new String[re.length];
	            for (int i = 0; i < re.length; i++) {
	                data[i] =  re[i].getID_receipt() + ";" + re[i].getPrice() + ";" + re[i].getDatePurchase() + ";" + re[i].getPurchaseMethod() + ";" + re[i].getID_Customer() + ";" + re[i].getID_Worker();
	            }
	            try {
	    			Stream.addAll("src/database/receipt.txt", data);
	    			System.out.println("Xóa hoá đơn thành công");
	    			waitConsole();
	    		} catch (IOException e) {
	    			e.printStackTrace();
	    		}  
	    }
	    
	    public Receipt[] deleteReceipt(Receipt[] re, int index) {
	    	Receipt[] newRe = new Receipt[re.length - 1];
	        for (int i = 0, j = 0; i < re.length; i++) {
	            if (i != index) {
	                newRe[j++] = re[i];
	            }
	        }
	        return newRe;
	    }
	    
	    public Receipt[] addReceipt(Receipt[] re, Receipt receipt) {
	    	re = Arrays.copyOf(re, re.length + 1);
	    	re[re.length -1] = receipt;
	    	return re;
	    }

	    public void Search_byCategory() {
	    	Receipt[] result = new Receipt[0];
	        System.out.println("Nhập mục lục cần tìm kiếm: ");
	        System.out.println("1.Mã hóa đơn");
	        System.out.println("2.Mã nhân viên lập hóa đơn");
	        System.out.println("3.Mã khách hàng");
	        System.out.println("4.Khoảng ngày mua hàng");
	        System.out.println("5.Tổng tiền của 1 hóa đơn");
	        int choose = input.nextInt();
	        input.nextLine();
	        switch (choose) {
	            case 1 -> {
	                System.out.print("Nhập ID hóa đơn: ");
	                String id = input.nextLine();
					for (Receipt receipt : re) {
						if (id.equals(receipt.getID_receipt())) {
							result = addReceipt(result, receipt);
						}
					}
	            }
	            case 2 -> {
	                input.nextLine();
	                System.out.print("Nhập mã nhân viên lập hóa đơn: ");
	                String id = input.nextLine();
					for (Receipt receipt : re) {
						if (id.equals(receipt.getID_Worker())) {
							result = addReceipt(result, receipt);
						}
					}
	            }
	            case 3 -> {
	                input.nextLine();
	                System.out.print("Nhập mã khách hàng của hóa đơn: ");
	                String id = input.nextLine();
					for (Receipt receipt : re) {
						if (id.equals(receipt.getID_Customer())) {
							result = addReceipt(result, receipt);
						}
					}
	            }
	            case 4 -> {
	                input.nextLine();
	                System.out.print("Nhập ngày bắt đầu: ");
	                String day1 = input.nextLine();
	                System.out.print("Ngày két thúc:");
	                String day2 = input.nextLine();
	                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					try {
						Date start = sdf.parse(day1);
		                Date end = sdf.parse(day2);
						for (Receipt receipt : re) {
							Date day = sdf.parse(receipt.getDatePurchase());
							if (day.after(start) && day.before(end)) {
								result = addReceipt(result, receipt);
							}
						}
					} catch (ParseException e) {
						e.printStackTrace();
					} 
	            }
	            case 5 -> {
	            	input.nextLine();
	                System.out.print("Từ giá: ");
	                int begin = input.nextInt();
	                System.out.print("Đến giá:");
	                int end = input.nextInt();
					for (Receipt receipt : re) {
						if (receipt.getPrice() <= end && receipt.getPrice() >= begin) {
							result = addReceipt(result, receipt);
						}
					}
	            }
	        }

			System.out.println("Danh sách hóa đơn tìm được:");
	        if(result.length == 0) {
	        	System.out.println("Không có hóa đơn cần tìm");
	        }
	        else {
		        String header = String.format("| %-5s | %-25s | %-4s | %-9s | %-30s | %-25s |", "ID", "Giá", "Ngày mua", "Phương thức thanh toán", "Id khách hàng", "Id người lập hóa đơn");
				System.out.format("+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");
			    System.out.println(header);
			    System.out.format("+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");
		        for (Receipt recepit : result) {
		        	String read = String.format("| %-5s | %-25s | %-4s | %-9s | %-30s | %-25s | ", recepit.getID_receipt(), recepit.getPrice(), recepit.getDatePurchase(), recepit.getPurchaseMethod(), recepit.getID_Customer(), recepit.getID_Worker());
		    		System.out.println(read);
		        }
		        System.out.format("+-------+---------------------------+------+-----------+--------------------------------+---------------------------+-----------------+----------------------+%n");
				waitConsole();
	        }
	    }
	    
	    public void waitConsole() {
	    	System.out.println("Ấn Enter để tiếp tục");
		    input.nextLine();
	    }
}
