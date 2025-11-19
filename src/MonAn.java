
import java.util.Scanner;

public abstract class MonAn {
    // Thuộc tính
    public String maSP;
    public String tenSP;
    public double donGia;
    public int soLuong;

    java.util.Scanner sc = new Scanner(System.in);

    public abstract String getLoai();

    public MonAn() {
        maSP = "";
        tenSP = "";
        donGia = 0;
        soLuong = 0;
    }

    // Có tham số
    public MonAn(String maSP, String tenSP, double donGia, int soLuong) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.soLuong = soLuong;
    }

    public MonAn(MonAn t) {
        this.maSP = t.maSP;
        this.tenSP = t.tenSP;
        this.donGia = t.donGia;
        this.soLuong = t.soLuong;
    }

    // Nhập xuất
    public void nhap() {
        System.out.print("Nhap ma SP: ");
        maSP = sc.nextLine();
        System.out.print("Nhap ten SP: ");
        tenSP = sc.nextLine();
        System.out.print("Nhap gia ban SP: ");
        donGia = sc.nextDouble();
        sc.nextLine();
        System.out.print("Nhập so luong: ");
        soLuong = sc.nextInt();
        sc.nextLine();
    }

    public void xuat() {
        System.out.printf(
                "%-10s | %-20s | %-10.0f | %-10d ",
                maSP, tenSP, donGia, soLuong);

    }

    // Get & Set
    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public double getdonGia() {
        return donGia;
    }

    public void setdonGia(double donGia) {
        this.donGia = donGia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    // Đa hình
    // public abstract void hienThiThongTin();

    // public abstract double tinhGiaSauKhuyenMai();

    // public abstract String getLoaiSanPham();

}
