public class Main {
    public static void main(String[] args) {

        // tạo mảng 200 khách để chứa dữ liệu đọc từ file
        KHACHHANG[] ds = new KHACHHANG[200];

        // 1. Đọc file
        int n = DocGhiKH.docKhachHang("text/KhachHang.txt", ds);

        // 2. In ra số lượng và danh sách
        System.out.println("Đã đọc " + n + " khách hàng từ file:");
        for (int i = 0; i < n; i++) {
            ds[i].xuat();
            System.out.println("------------------");
        }

        // 3. (Tùy chọn) Ghi lại file để kiểm tra hàm ghi
        DocGhiKH.ghiKhachHang("text/KhachHang_backup.txt", ds, n);

        System.out.println("Đã ghi lại file thành công!");
    }
}
