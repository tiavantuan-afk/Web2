import java.util.Scanner;
public class CHITIETHOADON {
    private int Mahd;
    private int Masp;
    private int Makh;
    private int SL;
    private int DG;
    private double Thanhtien;
    public CHITIETHOADON(){
        Mahd = 0;
        Masp = 0;
        Makh = 0;
        SL = 0;
        DG = 0;
        Thanhtien = 0.0;
    }
    public CHITIETHOADON(int Mahd, int Masp, int Makh, int SL, int DG, double Thanhtien){
        this.Mahd = Mahd;
        this.Masp = Masp;
        this.Makh = Makh;
        this.SL = SL;
        this.DG = DG;
        this.Thanhtien = Thanhtien;
    }
    public CHITIETHOADON(CHITIETHOADON t){
        if (t != null){
        this.Mahd = t.Mahd;
        this.Masp = t.Masp;
        this.Makh = t.Makh;
        this.SL = t.SL;
        this.DG = t.DG;
        this.Thanhtien = t.Thanhtien;
        }
    }
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma hoa don: ");
        Mahd = sc.nextInt();
        System.out.print("Nhap ma san pham:");
        Masp = sc.nextInt();
        System.out.print("Nhap ma khach hang: ");
        Makh = sc.nextInt();
        System.out.print("Nhap so luong: ");
        SL = sc.nextInt();
        System.out.print("Nhap don gia: ");
        DG = sc.nextInt();
        System.out.print("Nhap so thanh tien: ");
        Thanhtien = sc.nextDouble();
        sc.close();
    }
    public void xuat(){
        System.out.println("Chi tiet hoa don: ");
        System.out.println("Ma hoa don: "+Mahd);
        System.out.println("Ma san phan: "+Masp);
        System.out.println("Ma khach hang: "+Makh);
        System.out.println("So luong: "+SL);
        System.out.println("Don gia: "+DG);
        System.out.println("Thanh tien: "+Thanhtien);
    }
    public int getMahd(){
        return Mahd;
    }
    public int getMasp(){
        return Masp;
    }
    public int getMakh(){
        return Makh;
    }
    public int getSL(){
        return SL;
    }
    public int getDG(){
        return DG;
    }
    public double getThanhtien(){
        return Thanhtien;
    }
    public void setMahd(int Mahd){
        this.Mahd = Mahd;
    }
    public void setMasp(int Masp){
        this.Masp = Masp;
    }
    public void setMakh(int Makh){
        this.Makh = Makh;
    }
    public void setSL(int SL){
        this.SL = SL;
    }
    public void setDG(int DG){
        this.DG = DG;
    }
    public void setThanhtien(double Thanhtien){
        this.Thanhtien = Thanhtien;
    }
    
}
