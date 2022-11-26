package QuanLyTaiKhoan;

import GiaoDien.DataAccessObject;
import WorkwithFiles.Stream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class AccountManager extends Account implements DataAccessObject {
	public Account[] acc;
	public static Scanner input = new Scanner(System.in);
	public AccountManager() {
		super();
	}
	
	public Account[] getListAccount() throws FileNotFoundException{
    	String[] result = Stream.read("src/database/Account.txt");
    	acc = new Account[result.length];
    	for(int i = 0; i < result.length; i++) {
        	String[] row = result[i].split(";");
        	acc[i] = new Account(row[0], row[1], row[2] , row[3]);
    	}
    	return acc;
    }
	
	 public void read() throws FileNotFoundException {
		System.out.println("Danh sách khách hàng:");
		String header = String.format("| %-5s | %-25s | %-20s | %-10s | ", "ID", "UserName", "Password", "Position");
		System.out.format("+-------+---------------------------+------------------------+------------+%n");
	    System.out.println(header);
	    System.out.format("+-------+---------------------------+------------------------+------------+%n");
        
	    getListAccount();
		 for (Account account : acc) {
			 String read = String.format("| %-5s | %-25s | %-20s | %-10s |", account.getAccount_id(), account.getUsername(), account.getPassword(), account.getPosition());
			 System.out.println(read);
		 }
        System.out.format("+-------+---------------------------+------------------------+------------+%n");
        waitConsole();
	}
	 
	public void Add() {
		System.out.println("Nhập ID tài khoản: ");
		setAccount_id(input.nextLine());
		int check = 0;
		for (Account account : acc) {
			if (getAccount_id().equals(account.getAccount_id())) {
				check = 1;
				break;
			}
		}
        if(check == 1) {
        	System.out.println("id của khách hàng bị trùng");
        	return;
        }
		System.out.println("Nhập tên tài khoản");
		setUsername(input.nextLine());
		System.out.println("Nhập mật khẩu");
		setPassword(input.nextLine());
		System.out.println("Nhập phân Quyền");
		setPosition(input.nextLine());
		
		try {
			String input = getAccount_id() + ";" + getUsername() + ";" + getPassword() + ";" + getPosition();
			Stream.addOneLine("src/database/Account.txt", input);
			System.out.println("Nhập tài khoản thành công");
			waitConsole();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	 public void Update() {
		 System.out.println("Nhập id tài khoản cần chỉnh sửa");
		 String id = input.nextLine();
		 Account account = null;
		 
		 for(Account tk : acc) {
			 if(tk.getAccount_id().equals(id)) {
				 account = tk;
				 break;
			 }
		 }
		 
		 if(account == null) {
			 System.out.println("Bạn nhập sai id tài khoản");
			 return;
		 }
		 
		 System.out.println("Thông tin tài khoản:");
		 String row = String.format("%-5s %-25s %-4s  ", account.getAccount_id(), account.getUsername(), account.getPassword(), account.getPosition());
	        System.out.println(row);
		 String[] data = new String[acc.length];
		 for(int i = 0; i < acc.length; i++) {
			 if(acc[i].getAccount_id().equals(id)) {
				System.out.println("Nhập ID tài khoản: ");
				setAccount_id(input.nextLine());
				System.out.println("Nhập tên tài khoản");
				setUsername(input.nextLine());
				System.out.println("Nhập mật khẩu");
				setPassword(input.nextLine());
				System.out.println("Nhập phân Quyền");
				setPosition(input.nextLine());
				
				acc[i].setAccount_id(getAccount_id());
				acc[i].setUsername(getUsername());
				acc[i].setPassword(getPassword());
				acc[i].setPosition(getPosition());
			 }
			 data[i] = acc[i].getAccount_id() + ";" + acc[i].getUsername() + ";" + acc[i].getPassword() + ";" + acc[i].getPosition();
		 }
		  try {
				Stream.addAll("src/database/Account.txt", data);
				System.out.println("Sửa thông tin tài khoản thành công");
				waitConsole();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	 
	public void Delete() {
		 System.out.print("Nhập ID tài khoản cần xóa: ");
	        String id = input.nextLine();
	        Account account = null;

	        for (Account tk : acc) {
	            if (tk.getAccount_id().equals(id)) {
	                account = tk;
	                break;
	            }
	        }

	        if (account == null) {
	            System.out.println("ID tài khoản không tồn tại");
	            return;
	        }

	        for (int i = 0; i < acc.length; i++) {
	            if (id.equals(acc[i].getAccount_id())) {
	                acc = deleteAccount(acc, i);
	                break;
	            }
	        }
	        String[] data = new String[acc.length];
	        for (int i = 0; i < acc.length; i++) {
	        	data[i] = acc[i].getAccount_id() + ";" + acc[i].getUsername() + ";" + acc[i].getPassword() + ";" + acc[i].getPosition();
	        }
	        try {
				Stream.addAll("src/database/Account.txt", data);
				System.out.println("Xóa tài khoản thành công");
				waitConsole();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public Account[] deleteAccount(Account[] acc, int index) {
		Account[] newAcc = new Account[acc.length - 1];
        for (int i = 0, j = 0; i < acc.length; i++) {
            if (i != index) {
                newAcc[j++] = acc[i];
            }
        }
        return newAcc;
    }

	 public Account[] addAccount(Account[] acc, Account account) {
    	acc = Arrays.copyOf(acc, acc.length + 1);
    	acc[acc.length -1] = account;
    	return acc;
	}
	 
	 public void Search_byCategory() {
		 Account[] result = new Account[0];
		 System.out.println("Nhập từ bạn muốn tìm kiếm: ");
		 String key = input.nextLine();
		 for (Account account : acc) {
			 if (account.getUsername().toLowerCase().contains(key.toLowerCase()) || account.getAccount_id().toLowerCase().contains(key.toLowerCase())) {
				 result = addAccount(result, account);
				 System.out.println(result.length);
			 }
		 }
		 
		System.out.println("Danh sách khách hàng tìm được:");
		String header = String.format("| %-5s | %-25s | %-20s | %-10s | ", "ID", "UserName", "Password", "Position");
		System.out.format("+-------+---------------------------+------------------------+------------+%n");
	    System.out.println(header);
	    System.out.format("+-------+---------------------------+------------------------+------------+%n");
		 for (Account account : result) {
			 String read = String.format("| %-5s | %-25s | %-20s | %-10s |", account.getAccount_id(), account.getUsername(), account.getPassword(), account.getPosition());
			 System.out.println(read);
		 }
        System.out.format("+-------+---------------------------+------------------------+------------+%n");
		waitConsole();
	 }

	public void waitConsole() {
    	input.nextLine();
    	System.out.println("Ấn Enter để tiếp tục");
	    input.nextLine();
    }
}