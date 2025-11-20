import java.util.Scanner;

public class CHITIETHOADON {
    public String Mahd;
    public String Masp;
    public int SL;
    public double DG;
    public double Thanhtien;
    Scanner sc = new Scanner(System.in);

    public CHITIETHOADON() {
        Mahd = "";
        Masp = "";
        Makh = "";
        SL = 0;
        DG = 0;
        Thanhtien = 0.0;
    }

    public CHITIETHOADON(String Mahd, String Masp, String Makh, int SL, double DG, double Thanhtien) {
        this.Mahd = Mahd;
        this.Masp = Masp;
        this.Makh = Makh;
        this.SL = SL;
        this.DG = DG;
        this.Thanhtien = Thanhtien;
    }

    public CHITIETHOADON(CHITIETHOADON t) {
        if (t != null) {
            this.Mahd = t.Mahd;
            this.Masp = t.Masp;
            this.Makh = t.Makh;
            this.SL = t.SL;
            this.DG = t.DG;
            this.Thanhtien = t.Thanhtien;
        }
    }

    public void nhap(String Mahd, String Masp, String Makh, double DG) {
        this.Mahd = Mahd;
        this.Masp = Masp;
        this.Makh = Makh;
        System.out.print("Nhap so luong: ");
        SL = sc.nextInt();
        sc.nextLine();
        this.DG = DG;
        Thanhtien = DG * SL;
    }

    public void xuat() {
        System.out.println("Chi tiet hoa don: ");
        System.out.println("Ma hoa don: " + Mahd);
        System.out.println("Ma san pham: " + Masp);
        System.out.println("Ma khach hang: "+Makh);
        System.out.println("So luong: " + SL);
        System.out.println("Don gia: " + DG);
        System.out.println("Thanh tien: " + Thanhtien);
    }

    public String getMahd() {
        return Mahd;
    }

    public String getMasp() {
        return Masp;
    }

    public String getMakh() {
        return Makh;
    }

    public int getSL() {
        return SL;
    }

    public double getDG() {
        return DG;
    }

    public double getThanhtien() {
        return Thanhtien;
    }

    public void setMahd(String Mahd) {
        this.Mahd = Mahd;
    }

    public void setMasp(String Masp) {
        this.Masp = Masp;
    }

    public void setMakh(String Makh) {
        this.Makh = Makh;
    }

    public void setSL(int SL) {
        this.SL = SL;
    }

    public void setDG(double DG) {
        this.DG = DG;
    }

    public void setThanhtien(double Thanhtien) {
        this.Thanhtien = Thanhtien;
    }

    @Override
    public String toString() {
        return Mahd + "-" + Masp + "-" + Makh + "-" + SL + "-" + DG + "-" + Thanhtien;
    }
}
