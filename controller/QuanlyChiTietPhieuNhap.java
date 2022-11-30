package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import entity.ChiTietPhieuNhap;

public class QuanlyChiTietPhieuNhap extends ChiTietPhieuNhap implements ControllerInterface {
	public ChiTietPhieuNhap[] DSCTPN;
	static Scanner input = new Scanner(System.in);

	public QuanlyChiTietPhieuNhap() throws FileNotFoundException {
		super();
		getListCTPN();
	}

	public ChiTietPhieuNhap[] getListCTPN() {
		String[] result = new String[0];
		try {
			result = Stream.read("src/database/deliveryReceivedDetail.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DSCTPN = new ChiTietPhieuNhap[result.length];
		for (int i = 0; i < result.length; i++) {
			String[] row = result[i].split(";");
			DSCTPN[i] = new ChiTietPhieuNhap(row[0], row[1], Integer.parseInt(row[2]), Float.parseFloat(row[3]));
		}
		return DSCTPN;
	}

	public void waitConsole() {
		System.out.println("\t\t\t\t\t\t\t\t -Ấn Enter để tiếp tục");
		input.nextLine();
	}

	@Override
	public void Read() {
		System.out.println("\t\t\t\t\t\t\t\t +----DANH SÁCH CHI TIẾT PHIẾU NHẬP----+");
		String header = String.format("| %-10s | %-10s | %-10s | %-25s |", "Mã phiếu nhập", "Mã sản phẩm", "Số lượng",
				"Đơn giá");
		System.out.format("+----------------------------------------------------------------------+%n");
		System.out.println(header);
		System.out.format("+----------------------------------------------------------------------+%n");

		getListCTPN();

		// Xuất các phần tử theo cột
		for (ChiTietPhieuNhap chiTietPhieuNhap : DSCTPN) {
			String read = String.format("| %-13s | %-10s | %-11s | %-25s |", chiTietPhieuNhap.getID_PhieuNhap(),
					chiTietPhieuNhap.getID_Product(), chiTietPhieuNhap.getAmount(), chiTietPhieuNhap.getPrice());
			System.out.println(read);
		}
		System.out.format("+----------------------------------------------------------------------+%n");
		waitConsole();
	}

	@Override
	public void Create() {
		System.out.println("\t\t\t\t\t\t\t\t +----NHẬP THÔNG TIN CHI TIẾT PHIẾU NHẬP----+");
		input.nextLine();
		System.out.print("Nhập ID phiếu nhập: ");
		setID_PhieuNhap(input.nextLine());

		int check = 0;
		for (ChiTietPhieuNhap chiTietPhieuNhap : DSCTPN) {
			if (getID_PhieuNhap().equals(chiTietPhieuNhap.getID_PhieuNhap())) {
				check = 1;
				break;
			}
		}

		if (check == 1) {
			System.out.println("\t\t\t\t\t\t\t\t -MÃ PHIẾU NHẬP BỊ TRÙNG!");
			return;
		}

		System.out.print("Nhập mã sản phẩm: ");
		setID_Product(input.nextLine());

		input.nextLine();
		System.out.print("Nhập số lượng: ");
		setAmount(input.nextInt());

		System.out.print("Nhập giá tiền: ");
		setPrice(input.nextFloat());

		try {
			String input = getID_PhieuNhap() + ";" + getID_Product() + ";" + getAmount() + ";" + getPrice();
			Stream.addOneLine("src/database/deliveryReceivedDetail.txt", input);
			System.out.println("\t\t\t\t\t\t\t\t+----NHẬP CHI TIẾT PHIẾU NHẬP THÀNH CÔNG----+");
			waitConsole();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void Update() {
		try {
			System.out.println("\t\t\t\t\t\t\t\t +----CẬP NHẬT THÔNG TIN VỀ CHI TIẾT PHIẾU NHẬP----+");
			System.out.print("\t\t\t\t\t\t\t\t - Mời bạn nhập mã phiếu nhập cần chỉnh sửa: ");
			String ID_PhieuNhap = input.nextLine();
			ChiTietPhieuNhap ctp_nhap = null;

			for (ChiTietPhieuNhap chiTietPhieuNhap : DSCTPN) {
				if (chiTietPhieuNhap.getID_PhieuNhap().equalsIgnoreCase(ID_PhieuNhap)) {
					ctp_nhap = chiTietPhieuNhap;
					break;
				}
			}

			if (ctp_nhap == null) {
				System.out.println("\t\t\t\t\t\t\t\t - MÃ PHIẾU NHẬP KHÔNG TỒN TẠI!");
				return;
			}

			System.out.println("\t\t\t\t\t\t\t\t +----THÔNG TIN CHI TIÊT PHIẾU NHẬP TRƯỚC KHI CHỈNH SỬA----+");
			String header = String.format("|\t\t%s\t\t|\t\t%s\t\t|\t\t%s\t\t|\t\t%s\t\t|", "Mã phiếu nhập",
					"Mã sản phẩm", "Số lượng", "Giá tiền");
			System.out.println(header);
			String row = String.format("|\t\t%s\t\t\t\t\t|\t\t\t%s\t\t|\t\t\t%s\t\t|\t\t%s\t\t|",
					ctp_nhap.getID_PhieuNhap(), ctp_nhap.getID_Product(), ctp_nhap.getAmount(), ctp_nhap.getPrice());
			System.out.println(row);

			String[] data = new String[DSCTPN.length];

			for (int i = 0; i < DSCTPN.length; i++) {
				if (ID_PhieuNhap.equals(getID_PhieuNhap())) {
					System.out.print("Nhập mã sản phẩm:");
					setID_Product(input.nextLine());

					input.nextLine();
					System.out.print("Nhập số lượng:");
					setAmount(input.nextInt());

					System.out.print("Nhập giá tiền:");
					setPrice(input.nextInt());

					DSCTPN[i].setID_Product(getID_Product());
					DSCTPN[i].setAmount(getAmount());
					DSCTPN[i].setPrice(getPrice());
				}
				data[i] = DSCTPN[i].getID_PhieuNhap() + ";" + DSCTPN[i].getID_Product() + ";" + DSCTPN[i].getAmount()
						+ ";" + DSCTPN[i].getPrice();
			}
			try {
				Stream.addAll("src/database/deliveryReceivedDetail.txt", data);
				System.out.println("\t\t\t\t\t\t\t\t+----SỬA THÔNG TIN CHI TIẾT PHIẾU NHẬP THÀNH CÔNG----+");
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
			System.out.println("\t\t\t\t\t\t\t\t +----XÓA THÔNG TIN CHI TIẾT PHIẾU NHẬP----+");
			System.out.print("\t\t\t\t\t\t\t\t -Nhập mã phiếu nhập cần xóa: ");
			String ID_Phieunhap = input.nextLine();
			ChiTietPhieuNhap ctp_nhap = null;

			for (ChiTietPhieuNhap chiTietPhieuNhap : DSCTPN) {
				if (chiTietPhieuNhap.getID_PhieuNhap().equals(ID_Phieunhap)) {
					ctp_nhap = chiTietPhieuNhap;
					break;
				}
			}

			if (ctp_nhap == null) {
				System.out.println("\t\t\t\t\t\t\t\t -MÃ PHIẾU NHẬP KHÔNG TỒN TẠI!");
				return;
			}

			for (int i = 0; i < DSCTPN.length; i++) {
				if (ID_Phieunhap.equals(DSCTPN[i].getID_PhieuNhap())) {
					DSCTPN = deleteCTPN(DSCTPN, i);
					break;
				}
			}
			String[] data = new String[DSCTPN.length];
			for (int i = 0; i < DSCTPN.length; i++) {
				data[i] = DSCTPN[i].getID_PhieuNhap() + ";" + DSCTPN[i].getID_Product() + ";" + DSCTPN[i].getAmount()
						+ ";" + DSCTPN[i].getPrice();
			}
			try {
				Stream.addAll("src/database/deliveryReceivedDetail.txt", data);
				System.out.println("\t\t\t\t\t\t\t\t +----XÓA THÔNG TIN CHI TIẾT PHIẾU NHẬP THÀNH CÔNG----+");
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

	public ChiTietPhieuNhap[] deleteCTPN(ChiTietPhieuNhap[] DSCTPN, int index) {
		ChiTietPhieuNhap[] newCs = new ChiTietPhieuNhap[DSCTPN.length - 1];
		for (int i = 0, j = 0; i < DSCTPN.length; i++) {
			if (i != index) {
				newCs[j++] = DSCTPN[i];
			}
		}
		return newCs;
	}

	public ChiTietPhieuNhap[] addCTPN(ChiTietPhieuNhap[] DSCTPN, ChiTietPhieuNhap chiTietPhieuNhap) {
		DSCTPN = Arrays.copyOf(DSCTPN, DSCTPN.length + 1);
		DSCTPN[DSCTPN.length - 1] = chiTietPhieuNhap;
		return DSCTPN;
	}

	@Override
	public void Search_byCategory() {
		ChiTietPhieuNhap[] result = new ChiTietPhieuNhap[0];
		System.out.println("\t\t\t\t\t\t\t\t +--------NHẬP MỤC LỤC CẨN TÌM KIẾM--------+");
		System.out.println("\t\t\t\t\t\t\t\t |0.Thoát                                  |");
		System.out.println("\t\t\t\t\t\t\t\t +-----------------------------------------+");
		System.out.println("\t\t\t\t\t\t\t\t |1.Mã phiếu nhập                          |");
		System.out.println("\t\t\t\t\t\t\t\t |2.Mã sản phẩm                            |");
		System.out.println("\t\t\t\t\t\t\t\t +-----------------------------------------+");
		System.out.print("\t\t\t\t\t\t\t\t - Mời Bạn Nhập Lựa Chọn: ");
		int choose = input.nextInt();
		if (choose == 0)
			return;
		else {
			switch (choose) {
			case 1 -> {
				input.nextLine();
				System.out.print("Nhập mã phiếu nhập: ");
				String ID_phieunhap = input.nextLine();
				for (ChiTietPhieuNhap chiTietPhieuNhap : DSCTPN) {
					if (chiTietPhieuNhap.getID_PhieuNhap().toLowerCase().contains(ID_phieunhap.toLowerCase())) {
						result = addCTPN(result, chiTietPhieuNhap);
					}
				}
			}
			case 2 -> {
				input.nextLine();
				System.out.print("Nhập mã sản phẩm: ");
				String ID_SanPham = input.nextLine();
				for (ChiTietPhieuNhap chiTietPhieuNhap : DSCTPN) {
					if (chiTietPhieuNhap.getID_Product().toLowerCase().contains(ID_SanPham.toLowerCase())) {
						result = addCTPN(result, chiTietPhieuNhap);
					}
				}
			}
			}
		}
		System.out.println("\t\t\t\t\t\t\t\t +----TẤT CẢ THÔNG TIN ĐÃ TÌM ĐƯỢC----+");
		String header = String.format("| %-10s | %-10s | %-10s | %-25s |", "Mã phiếu nhập", "Mã sản phẩm", "Số lượng",
				"Đơn giá");
		System.out.format("+----------------------------------------------------------------------+%n");
		System.out.println(header);
		for (ChiTietPhieuNhap chiTietPhieuNhap : result) {
			String row = String.format("| %-10s | %-10s | %-10s | %-25s |", chiTietPhieuNhap.getID_PhieuNhap(),
					chiTietPhieuNhap.getID_Product(), chiTietPhieuNhap.getAmount(), chiTietPhieuNhap.getPrice());
			System.out.println(row);
		}
		waitConsole();
		System.out.format("+----------------------------------------------------------------------+%n");
	}
}