import java.util.Scanner;

public class Chitietphieunhap {
    public Scanner sc = new Scanner(System.in);
    public String maPNH;
    public String maSP;

    public int soluong;
    public double dongia;
    public double thanhtien;

    public Chitietphieunhap() {
        maPNH = "";
        maSP = "";
        soluong = 0;
        dongia = 0;
        thanhtien = 0.0;
    }

    public Chitietphieunhap(String maPNH, String maSP, String ngay, int soluong, double dongia, double thanhtien) {
        this.maPNH = maPNH;
        this.maSP = maSP;
        this.soluong = soluong;
        this.dongia = dongia;
        this.thanhtien = thanhtien;
    }

    public Chitietphieunhap(Chitietphieunhap ct) {
        this.maPNH = ct.maPNH;
        this.maSP = ct.maSP;
        this.soluong = ct.soluong;
        this.dongia = ct.dongia;
        this.thanhtien = ct.thanhtien;
    }

    public void nhap(String maPNH, String maSP, double dongia) {
        this.maPNH = maPNH;
        this.maSP = maSP;
        System.out.print("Số lượng: ");
        soluong = Integer.parseInt(sc.nextLine());
        this.dongia = dongia;
        thanhtien = soluong * dongia;
    }

    public void xuat() {
        System.out.println("\n╔══════════════════════════════════════════════╗");
        System.out.println("║               THONG TIN PHIEU NHAP           ║");
        System.out.println("╠══════════════════════════════════════════════╣");
        System.out.printf("║ %-17s: %-25s ║%n", "Ma phieu nhap hang", maPNH);
        System.out.printf("║ %-17s: %-25s ║%n", "Ma nhan vien", maSP);
        System.out.printf("║ %-17s: %-25s ║%n", "So luong", soluong);
        System.out.printf("║ %-17s: %-25.0f ║%n", "Ma nha cung cap", dongia);
        System.out.printf("║ %-17s: %-25s ║%n", "Tong tien", thanhtien);
        System.out.println("╚══════════════════════════════════════════════╝");
    }

    public String toString() {
        return maPNH + "-" + maSP + "-" + soluong + "-" + dongia + "-" + thanhtien;
    }

    // Các getter và setter
    public String getmaPNH() {
        return maPNH;
    }

    public String getmaSP() {
        return maSP;
    }

    public int getsoluong() {
        return soluong;
    }

    public double getdongia() {
        return dongia;
    }

    public void setThanhtien(double x) {
        this.thanhtien = x;
    }

    public void setmaPNH(String maPNH) {
        this.maPNH = maPNH;
    }

    public void setmaSP(String maSP) {
        this.maSP = maSP;
    }

    public void setsoluong(int soluong) {
        this.soluong = soluong;
    }

    public void setdongia(double dongia) {
        this.dongia = dongia;
    }

    // Tính thành tiền
    public double thanhTien() {
        return soluong * dongia;
    }

}
