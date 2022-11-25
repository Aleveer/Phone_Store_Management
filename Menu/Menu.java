
//Cần Chỉnh Sửa: Chi tiết sản phẩm

package Menu;

import Configurations.Configuation;
import QuanLySanPham.QuanLySanPham;
import QuanLyBaoHanh.QuanLyBaoHanh;
import QuanLyCTPN.QuanLyChiTietPhieuNhap;
import QuanLyKhachHang.QuanLyKhachHang;
import QuanLyNCC.QuanLyNhaCungCap;
import QuanLyNhanVien.QuanLyNhanVien;
import Receipt.QuanLyHoaDon;
import java.util.Scanner;

public class Menu {
    protected int choice;
    int flag = 0;

    QuanLyKhachHang kh = new QuanLyKhachHang();
    QuanLyNhanVien nv = new QuanLyNhanVien();
    QuanLySanPham sp = new QuanLySanPham();
    QuanLyHoaDon hd = new QuanLyHoaDon();
    QuanLyBaoHanh bh = new QuanLyBaoHanh();
    Configurations.Configuation cfg = new Configuation();
    QuanLyCTPN.QuanLyChiTietPhieuNhap ctpn = new QuanLyChiTietPhieuNhap();
    QuanLyNCC.QuanLyNhaCungCap ncc = new QuanLyNhaCungCap();

    Scanner input = new Scanner(System.in);

    public Menu() {
        flag = 1;
        choice = 0;
        QuanLyKhachHang kh = new QuanLyKhachHang();
        QuanLyNhanVien nv = new QuanLyNhanVien();
        QuanLySanPham sp = new QuanLySanPham();
        QuanLyHoaDon hd = new QuanLyHoaDon(); 
        QuanLyBaoHanh bh = new QuanLyBaoHanh();
        Configurations.Configuation cfg = new Configuation();
        QuanLyChiTietPhieuNhap ctpn = new QuanLyChiTietPhieuNhap();
        QuanLyNCC.QuanLyNhaCungCap ncc = new QuanLyNhaCungCap();

    }

    public void showmenuPrimary() {
        System.out.println("\t\t\t\t\t\t\t\t +----QUẢN LÝ CỬA HÀNG----+");
        System.out.println("\t\t\t\t\t\t\t\t |0.Exit                  |");
        System.out.println("\t\t\t\t\t\t\t\t +------------------------+");
        System.out.println("\t\t\t\t\t\t\t\t |1.Khách Hàng            |");
        System.out.println("\t\t\t\t\t\t\t\t |2.Nhân Viên             |");
        System.out.println("\t\t\t\t\t\t\t\t |3.Bán Hàng              |");
        System.out.println("\t\t\t\t\t\t\t\t |4.Sản phẩm              |");
        System.out.println("\t\t\t\t\t\t\t\t |5.Chi tiết sản phẩm     |");
        System.out.println("\t\t\t\t\t\t\t\t |6.Phiếu nhập            |");
        System.out.println("\t\t\t\t\t\t\t\t |7.Nhà cung cấp          |");
        System.out.println("\t\t\t\t\t\t\t\t |8.Bảo hành              |");
        System.out.println("\t\t\t\t\t\t\t\t +------------------------+");
        System.out.print("\t\t\t\t\t\t\t\t - Mời Bạn Nhập Lựa Chọn: ");
    }

    public void showmenucustomer() {
        System.out.println("\t\t\t\t\t\t\t\t +--------QUẢN LÝ KHÁCH HÀNG---------+");
        System.out.println("\t\t\t\t\t\t\t\t |0.Quay Lại Menu Chính              |");
        System.out.println("\t\t\t\t\t\t\t\t +-----------------------------------+");
        System.out.println("\t\t\t\t\t\t\t\t |1.Thêm Khách Hàng                  |");
        System.out.println("\t\t\t\t\t\t\t\t |2.Xuất Danh Sách Khách Hàng        |");
        System.out.println("\t\t\t\t\t\t\t\t |3.Tìm Thông Tin Khách Hàng         |");
        System.out.println("\t\t\t\t\t\t\t\t |4.Xóa Thông Tin Khách Hàng (ID)    |");
        System.out.println("\t\t\t\t\t\t\t\t |5.Sửa Thông Tin Khách Hàng (ID)    |");
        System.out.println("\t\t\t\t\t\t\t\t +-----------------------------------+");
        System.out.print("\t\t\t\t\t\t\t\t - Mời Bạn Nhập Lựa Chọn: ");
    }

    public void showmenustaff() {
        System.out.println("\t\t\t\t\t\t\t\t +---------QUẢN LÝ NHÂN VIÊN---------+");
        System.out.println("\t\t\t\t\t\t\t\t |0.Quay Lại Menu Chính              |");
        System.out.println("\t\t\t\t\t\t\t\t +-----------------------------------+");
        System.out.println("\t\t\t\t\t\t\t\t |1.Thêm Nhân Viên                   |");
        System.out.println("\t\t\t\t\t\t\t\t |2.Xuất Danh Sách Nhân Viên         |");
        System.out.println("\t\t\t\t\t\t\t\t |3.Tìm Thông Tin Nhân Viên          |");
        System.out.println("\t\t\t\t\t\t\t\t |4.Xóa Thông Tin Nhân Viên (ID)     |");
        System.out.println("\t\t\t\t\t\t\t\t |5.Sửa Thông Tin Nhân Viên (ID)     |");
        System.out.println("\t\t\t\t\t\t\t\t +-----------------------------------+");
        System.out.print("\t\t\t\t\t\t\t\t - Mời Bạn Nhập Lựa Chọn: ");
    }

    public void showmenusell() {
        System.out.println("\t\t\t\t\t\t\t\t +-----QUẢN LÝ BÁN HÀNG----+");
        System.out.println("\t\t\t\t\t\t\t\t |0.Quay Lại Menu Chính    |");
        System.out.println("\t\t\t\t\t\t\t\t +-------------------------+");
        //System.out.println("\t\t\t\t\t\t\t\t |1.Dạo Quanh Cửa Hàng     |");
        System.out.println("\t\t\t\t\t\t\t\t |1.Nhập Hóa Đơn           |");
        System.out.println("\t\t\t\t\t\t\t\t |2.Xuất Hóa Đơn            |");
        System.out.println("\t\t\t\t\t\t\t\t |3.Tìm kiếm Hóa Đơn            |");
        System.out.println("\t\t\t\t\t\t\t\t |4.Xóa Hóa Đơn       |");
        System.out.println("\t\t\t\t\t\t\t\t |5.Sửa Hóa Đơn           |");
        System.out.println("\t\t\t\t\t\t\t\t +-------------------------+");
        System.out.print("\t\t\t\t\t\t\t\t - Mời Bạn Nhập Lựa Chọn: ");
    }

    public void showmenustorage() {
        System.out.println("\t\t\t\t\t\t\t\t +---------QUẢN LÝ SẢN PHẨM---------+");
        System.out.println("\t\t\t\t\t\t\t\t |0.Quay Lại Menu Chính        |");
        System.out.println("\t\t\t\t\t\t\t\t +-----------------------------+");
        System.out.println("\t\t\t\t\t\t\t\t |1.Nhập Sản Phẩm              |");
        System.out.println("\t\t\t\t\t\t\t\t |2.Xuất Danh Sách Sản Phẩm    |");
        System.out.println("\t\t\t\t\t\t\t\t |3.Tìm kiếm sản phẩm          |");
        System.out.println("\t\t\t\t\t\t\t\t |4.Xóa Sản Phẩm               |");
        System.out.println("\t\t\t\t\t\t\t\t |5.Sửa Thông Tin Sản Phẩm (ID)|");
        System.out.println("\t\t\t\t\t\t\t\t +-----------------------------+");
        System.out.print("\t\t\t\t\t\t\t\t - Mời Bạn Nhập Lựa Chọn: ");
    }

    public void extra_showmenustorage() {
        System.out.println("\t\t\t\t\t\t\t\t +---------QUẢN LÝ CHI TIẾT SẢN PHẨM--------------+");
        System.out.println("\t\t\t\t\t\t\t\t |0.Quay Lại Menu Chính                           |");
        System.out.println("\t\t\t\t\t\t\t\t +------------------------------------------------+");
        System.out.println("\t\t\t\t\t\t\t\t |1.Nhập Chi Tiết Sản Phẩm                        |");
        System.out.println("\t\t\t\t\t\t\t\t |2.Xuất Danh Sách Chi Tiết Sản Phẩm              |");
        System.out.println("\t\t\t\t\t\t\t\t |3.Tìm kiếm thông tin chi tiết sản phẩm (ID)     |");
        System.out.println("\t\t\t\t\t\t\t\t |4.Sửa thông tin Chi Tiết Sản Phẩm (ID)          |");
        System.out.println("\t\t\t\t\t\t\t\t +------------------------------------------------+");
        System.out.print("\t\t\t\t\t\t\t\t - Mời Bạn Nhập Lựa Chọn: ");
    }

    public void menuPhieuNhap() {
        System.out.println("\t\t\t\t\t\t\t\t +--------QUẢN LÝ PHIẾU NHẬP---------+");
        System.out.println("\t\t\t\t\t\t\t\t |0.Quay Lại Menu Chính              |");
        System.out.println("\t\t\t\t\t\t\t\t +-----------------------------------+");
        System.out.println("\t\t\t\t\t\t\t\t |1.Thêm Phiếu Nhập                  |");
        System.out.println("\t\t\t\t\t\t\t\t |2.Xuất Danh Sách Phiếu Nhập        |");
        System.out.println("\t\t\t\t\t\t\t\t |3.Tìm Thông Tin Phiếu Nhập         |");
        System.out.println("\t\t\t\t\t\t\t\t |4.Xóa Phiếu Nhập                   |");
        System.out.println("\t\t\t\t\t\t\t\t |5.Sửa Thông Tin Phiếu Nhập (ID)    |");
        System.out.println("\t\t\t\t\t\t\t\t +-----------------------------------+");
        System.out.print("\t\t\t\t\t\t\t\t - Mời Bạn Nhập Lựa Chọn: ");
    }

    public void menuNCC() {
        System.out.println("\t\t\t\t\t\t\t\t +--------QUẢN LÝ NHÀ CUNG CẤP---------+");
        System.out.println("\t\t\t\t\t\t\t\t |0.Quay Lại Menu Chính                |");
        System.out.println("\t\t\t\t\t\t\t\t +-----------------------------------+");
        System.out.println("\t\t\t\t\t\t\t\t |1.Thêm Nhà cung cấp                  |");
        System.out.println("\t\t\t\t\t\t\t\t |2.Xuất Danh Sách Nhà cung cấp        |");
        System.out.println("\t\t\t\t\t\t\t\t |3.Tìm Thông Tin Nhà cung cấp         |");
        System.out.println("\t\t\t\t\t\t\t\t |4.Xóa Nhà Cung Cấp                   |");
        System.out.println("\t\t\t\t\t\t\t\t |5.Sửa Thông Tin Nhà cung cấp (ID)    |");
        System.out.println("\t\t\t\t\t\t\t\t +-----------------------------------+");
        System.out.print("\t\t\t\t\t\t\t\t - Mời Bạn Nhập Lựa Chọn: ");
    }

    public void menuBaoHanh() {
        System.out.println("\t\t\t\t\t\t\t\t +--------QUẢN LÝ BẢO HÀNH---------+");
        System.out.println("\t\t\t\t\t\t\t\t |0.Quay Lại Menu Chính                |");
        System.out.println("\t\t\t\t\t\t\t\t +-------------------------------------+");
        System.out.println("\t\t\t\t\t\t\t\t |1.Thêm thông tin bảo hành            |");
        System.out.println("\t\t\t\t\t\t\t\t |2.Xuất Danh Sách Bảo Hành            |");
        System.out.println("\t\t\t\t\t\t\t\t |3.Tìm thông tin Bảo Hành             |");
        System.out.println("\t\t\t\t\t\t\t\t +-------------------------------------+");
        System.out.print("\t\t\t\t\t\t\t\t - Mời Bạn Nhập Lựa Chọn: ");
    }

    public void menutt() {
        System.out.println("\t\t\t\t\t\t\t\t +-------------------------+");
        System.out.println("\t\t\t\t\t\t\t\t | Bạn có muốn chọn thêm ? |");
        System.out.println("\t\t\t\t\t\t\t\t |                         |");
        System.out.println("\t\t\t\t\t\t\t\t |  1.Có          2.Không  |");
        System.out.println("\t\t\t\t\t\t\t\t +-------------------------+");
        System.out.print("\t\t\t\t\t\t\t\t - Mời Bạn Nhập Lựa Chọn: ");
    }

    public void menuchild() {
        System.out.println("\t\t\t\t\t\t\t\t +-----------------+");
        System.out.println("\t\t\t\t\t\t\t\t |1.Lưu            |");
        System.out.println("\t\t\t\t\t\t\t\t |2.Bỏ             |");
        System.out.println("\t\t\t\t\t\t\t\t |3.Nhập Lại       |");
        System.out.println("\t\t\t\t\t\t\t\t +-----------------+");
        System.out.print("\t\t\t\t\t\t\t\t - Mời Bạn Nhập Lựa Chọn: ");
    }

    //        do {
//            System.out.println("\n\t\t\t\t\t\t\t\t>> Bạn Đã Chọn Quản Lý Bán Hàng <<\n");
//            showmenusell1();
//            int x;
//            x = public void menusell() {
    //input.nextInt();
//            switch (x) {
//                case 0 ->
//                    System.out.println("\n\t\\t\t\t\t\t\t>> Quay Về Quản Lý Cửa Hàng <<\n");
//                        exit(0);
//                case 1 -> {
//                    System.out.println("\n\t\t\t\t\t\t\t\t\t-----HÓA ĐƠN---");
//                    hd.Add();
//                    sp.Output();
//                    System.out.println("Chọn sản phẩm :");
//                    int choice = input.nextInt();
//
//        }
//    }
        public void menu () {
            do {
                showmenuPrimary();
                choice = input.nextInt();
                switch (choice) {
                    // KHÁCH HÀNG //
                    case 1:
                        do {
                            System.out.println("\n\t\t\t\t\t\t\t\t>> Bạn Đã Chọn Quản Lý Khách Hàng <<\n");
                            showmenucustomer();
                            int x;
                            x = input.nextInt();
                            switch (x) {
                                case 0 -> {
                                    System.out.println("\n\t\t\t\t\t\t\t\t>> Quay Về Quản Lý Cửa Hàng <<\n");
                                    menu();
                                }
                                case 1 -> {
                                    System.out.println("\n\t\t\t\t\t\t\t-----Nhập Thông Tin Khách Hàng-----");
                                    kh.Add();
                                }
                                case 2 -> {
                                    System.out.println("\n\t\t\t\t\t\t\t\t-----Danh Sách Khách Hàng-----");
                                    kh.Output();
                                }
                                case 3 -> {
                                    System.out.println("\n\t\t\t\t\t\t\t\t-----Tìm Kiếm Khách Hàng-----");
                                    kh.Search_byCategory();
                                }
                                case 4 -> {
                                    System.out.println("\n\t\t\t\t\t\t\t\t-----Xóa Khách Hàng-(ID)------");
                                    kh.Delete();
                                }
                                case 5 -> {
                                    System.out.println("\n\t\t\t\t\t\t\t\t-----Sửa Thông Tin Khách Hàng-(ID)-----");
                                    kh.Update();
                                }
                            }
                        } while (flag != 0);
                        break;
                    case 2:
                        //NHÂN VIÊN
                        do {
                            System.out.println("\n\t\t\t\t\t\t\t\t>> Bạn Đã Chọn Quản Lý Nhân Viên <<\n");
                            showmenustaff();
                            int x;
                            x = input.nextInt();
                            switch (x) {
                                case 0 -> {
                                    System.out.println("\n\t\t\t\t\t\t\t\t>> Quay Về Quản Lý Cửa Hàng <<\n");
                                    menu();
                                }
                                case 1 -> {
                                    System.out.println("\n\t\t\t\t\t\t\t\t\t-----Nhập Thông Tin Nhân Viên-----");
                                    nv.Add();
                                }
                                case 2 -> {
                                    System.out.println("\n\t\t\t\t\t\t\t\t\t-----Danh Sách Nhân Viên-----");
                                    nv.Output();
                                }
                                case 3 -> {
                                    System.out.println("\n\t\t\t\t\t\t\t\t\t-----Tìm Kiếm Nhân Viên-----");
                                    nv.Search_byCategory();
                                }
                                case 4 -> {
                                    System.out.println("\n\t\t\t\t\t\t\t\t\t-----Xóa Nhân Viên-(ID)-----");
                                    nv.Delete();
                                }
                                case 5 -> {
                                    System.out.println("\n\t\t\t\t\t\t\t\t\t-----Sửa Thông Tin Nhân Viên-(ID)-----");
                                    nv.Update();
                                }
                            }
                        } while (flag != 0);
                        break;
                    case 3:
                        //BÁN HÀNG
                        do {
                            System.out.println("\n\t\t\t\t\t\t\t\t>> Bạn Đã Chọn Quản Lý Bán Hàng <<\n");
                            showmenusell();
                            int x;
                            x = input.nextInt();
                            switch (x) {
                                case 0 -> {
                                    System.out.println("\n\t\t\t\t\t\t\t\t>> Quay Về Quản Lý Cửa Hàng <<\n");
                                    menu();
                                }
                                case 1 -> {
                                    System.out.println("\n\t\t\t\t\t\t\t\t\t-----Nhập Hóa Đơn---");
                                    hd.Add();
                                    hd.AddSP();
                                }
                                case 2 -> {
                                    System.out.println("\n\t\t\t\t\t\t\t\t\t-----Xóa Hóa Đơn---");
                                    hd.Output();
                                }
                                case 3 -> {
                                    System.out.println("\n\t\t\t\t\t\t\t\t\t-----Sửa Hóa Đơn---");
                                    hd.Search_byCategory();
                                }
                                case 4 -> {
                                    System.out.println("\n\t\t\t\t\t\t\t\t\t-----Tìm Kiếm Hóa Đơn---");
                                    hd.Delete();
                                }
                                case 5 -> {
                                    System.out.println("\n\t\t\t\t\t\t\t\t\t-----Xuất Hóa Đơn-----\n");
                                    hd.Update();
                                }
                            }
                        } while (flag != 0);
                        break;
                    case 4:
                        // SẢN PHẨM
                        do {
                            System.out.println("\n\t\t\t\t\t\t\t\t>> Bạn Đã Chọn Quản Lý Sản Phẩm <<\n");
                            showmenustorage();
                            int x;
                            x = input.nextInt();
                            switch (x) {
                                case 0 -> {
                                    System.out.println("\n\t\t\t\t\t\t\t\t>> Quay Về Quản Lý Cửa Hàng <<\n");
                                    menu();
                                }
                                case 1 -> {
                                    System.out.println("\n\t\t\t\t\t\t\t\t\t-----Nhập sản phẩm mới---\n");
                                    sp.Add();
                                }
                                case 2 -> {
                                    System.out.println("\n\t\t\t\t\t\t\t\t\t-----Xuất sản phẩm-----\n");
                                    sp.Output();
                                }
                                case 3 -> {
                                    System.out.println("\n\t\t\t\t\t\t\t\t\t-----Tìm kiếm sản phẩm-----\n");
                                    sp.Search_byCategory();
                                }
                                case 4 -> {
                                    System.out.println("\n\t\t\t\t\t\t\t\t\t-----Xóa Sản Phẩm-(ID)-----\n");
                                    sp.Delete();
                                }
                                case 5 -> {
                                    System.out.println("\n\t\t\t\t\t\t\t\t\t-----Sửa Thông Tin Sản Phẩm-(ID)-----\n");
                                    sp.Update();
                                }
                            }
                        } while (flag != 0);
                        break;
                    case 5:
                        // CHI TIET SAN PHAM
                        do {
                            System.out.println("\n\t\t\t\t\t\t\t\t>> Bạn Đã Chọn Quản Lý Chi Tiết Sản Phẩm <<\n");
                            extra_showmenustorage();
                            int x;
                            x = input.nextInt();
                            switch (x) {
                                case 0 -> {
                                    System.out.println("\n\t\t\t\t\t\t\t\t>> Quay Về Quản Lý Cửa Hàng <<\n");
                                    menu();
                                }
                                case 1 -> {
                                    System.out.println("\n\t\t\t\t\t\t\t\t\t-----Nhập chi tiết sản phẩm mới---\n");
                                    cfg.Add();
                                }
                                case 2 -> {
                                    System.out.println("\n\t\t\t\t\t\t\t\t\t-----Xuất chi tiết sản phẩm-----\n");
                                    
                                    sp.Output();
                                    cfg.Output();
                                }
                                case 3 -> {
                                    System.out.println("\n\t\t\t\t\t\t\t\t\t-----Tìm kiếm chi tiết sản phẩm-----\n");
                                    sp.Search_byCategory();
                                }
                                case 4 -> {
                                    System.out.println("\n\t\t\t\t\t\t\t\t\t-----Xóa Sản Phẩm-(ID)-----\n");
                                    sp.Delete();
                                    cfg.Delete();
                                }
                                case 5 -> {
                                    System.out.println("\n\t\t\t\t\t\t\t\t\t-----Sửa Thông Tin Chi Tiết Sản Phẩm-(ID)-----\n");
                                    cfg.Update();
                                }
                            }
                        } while (flag != 0);
                        break;
                    case 6:
                        // PHIEU NHAP
                        do {
                            System.out.println("\n\t\t\t\t\t\t\t\t>> Bạn Đã Chọn Quản Lý Phiếu Nhập <<\n");
                            menuPhieuNhap();
                            int x;
                            x = input.nextInt();
                            switch (x) {
                                case 0 -> {
                                    System.out.println("\n\t\t\t\t\t\t\t\t>> Quay Về Quản Lý Cửa Hàng <<\n");
                                    menu();
                                }
                                case 1 -> {
                                    System.out.println("\n\t\t\t\t\t\t\t\t\t-----Nhập chi tiết phiếu nhập---\n");
                                    ctpn.Add();
                                }
                                case 2 -> {
                                    System.out.println("\n\t\t\t\t\t\t\t\t\t-----Xuất danh sách phiếu nhập-----\n");
                                    ctpn.Output();
                                }
                                case 3 -> {
                                    System.out.println("\n\t\t\t\t\t\t\t\t\t-----Tìm kiếm phiếu nhập-(ID)-----\n");
                                    ctpn.Search_byCategory();
                                }
                                case 4 -> {
                                    System.out.println("\n\t\t\t\t\t\t\t\t\t-----Xóa phiếu nhập-(ID)-----\n");
                                    ctpn.Delete();
                                }
                                case 5 -> {
                                    System.out.println("\n\t\t\t\t\t\t\t\t\t-----Sửa thông tin phiếu nhập-(ID)-----\n");
                                    ctpn.Update();
                                }
                            }
                        } while (flag != 0);
                        break;
                    case 7:
                        // NHÀ CUNG CẤP
                        do {
                            System.out.println("\n\t\t\t\t\t\t\t\t>> Bạn Đã Chọn Quản Lý Nhà Cung Cấp <<\n");
                            menuNCC();
                            int x;
                            x = input.nextInt();
                            switch (x) {
                                case 0 -> {
                                    System.out.println("\n\t\t\t\t\t\t\t\t>> Quay Về Quản Lý Cửa Hàng <<\n");
                                    menu();
                                }
                                case 1 -> {
                                    System.out.println("\n\t\t\t\t\t\t\t\t\t-----Nhập thông tin nhà cung cấp---\n");
                                    ncc.Add();
                                }
                                case 2 -> {
                                    System.out.println("\n\t\t\t\t\t\t\t\t\t-----Xuất danh sách nhà cung cấp-----\n");
                                    ncc.Output();
                                }
                                case 3 -> {
                                    System.out.println("\n\t\t\t\t\t\t\t\t\t-----Tìm kiếm nhà cung cấp-(ID)-----\n");
                                    ncc.Search_byCategory();
                                }
                                case 4 -> {
                                    System.out.println("\n\t\t\t\t\t\t\t\t\t-----Xóa thông tin nhà cung cấp-(ID)-----\n");
                                    ncc.Delete();
                                }
                                case 5 -> {
                                    System.out.println("\n\t\t\t\t\t\t\t\t\t-----Sửa thông tin nhà cung cấp-(ID)-----\n");
                                    ncc.Update();
                                }
                            }
                        } while (flag != 0);
                        break;
                    case 8:
                        // QUẢN LÝ BẢO HÀNH
                        do {
                            System.out.println("\n\t\t\t\t\t\t\t\t>> Bạn Đã Chọn Quản Lý Bảo Hành <<\n");
                            menuBaoHanh();
                            int x;
                            x = input.nextInt();
                            switch (x) {
                                case 0 -> {
                                    System.out.println("\n\t\t\t\t\t\t\t\t>> Quay Về Quản Lý Cửa Hàng <<\n");
                                    menu();
                                }
                                case 1 -> {
                                    System.out.println("\n\t\t\t\t\t\t\t\t\t-----Nhập thông tin bảo hành---\n");
                                    bh.Add();
                                }
                                case 2 -> {
                                    System.out.println("\n\t\t\t\t\t\t\t\t\t-----Xuất danh sách bảo hành-----\n");
                                    bh.Output();
                                }
                                case 3 -> {
                                    System.out.println("\n\t\t\t\t\t\t\t\t\t-----Tìm kiếm thông tin bảo hành-----\n");
                                    bh.Search_byCategory();
                                }
                            }
                        } while (flag != 0);
                        break;
                    default:
                        flag = 0;
                        break;
                }
            } while (flag != 0);
        }
}