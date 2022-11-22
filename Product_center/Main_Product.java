package Product_center;

public class Main_Product {
    public static void main(String[] args) {
        Configuation Config = new Configuation();
        Config.Add();
        Config.Update();
        Config.Search_byCategory();
        Config.Output();

        //QuanLySanPham sp = new QuanLySanPham();
        //sp.Add();
        //sp.Output();
    }
}