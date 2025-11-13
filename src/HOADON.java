import java.util.Scanner;
public class HOADON {
    private int Mahd;
    private int Manv;
    private int Makh;
    private String Ngay;
    private double Tongtien;  
    public HOADON(){
        Mahd = 0;
        Manv = 0;
        Makh = 0;
        Ngay = "";
        Tongtien = 0.0;
    }
    public HOADON(int Mahd, int Manv, int Makh, String Ngay, double Tongtien){
        this.Mahd = Mahd;
        this.Manv = Manv;
        this.Makh = Makh;
        this.Ngay = Ngay;
        this.Tongtien = Tongtien;
    }
    public HOADON(HOADON t){
        if (t != null){
        this.Mahd = t.Mahd;
        this.Manv = t.Manv;
        this.Makh = t.Makh;
        this.Ngay = t.Ngay;
        this.Tongtien = t.Tongtien;
        }
    }
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ma hoa don: ");
        Mahd = sc.nextInt();
        System.out.print("Nhap ma nhan vien: ");
        Manv = sc.nextInt();
        System.out.print("Nhap ma khach hang: ");
        Makh = sc.nextInt();
        System.out.print("Nhap ngay xuat hoa don: ");
        Ngay = sc.nextLine();
        System.out.print("Nhap tong tien: ");
        Tongtien = sc.nextDouble();
        sc.close();
    }
    public void xuat(){
        System.out.println("Hoa don: ");
        System.out.println("Ma hoa don: "+Mahd);
        System.out.println("Ma nhan vien: "+Manv);
        System.out.println("Ma khach hang: "+Makh);
        System.out.println("Ngay xuat: "+Ngay);
        System.out.println("Tong tien: "+Tongtien);
    }
    public int getMahd(){
        return Mahd;
    }
    public int getManv(){
        return Manv;
    }
    public int getMakh(){
        return Makh;
    }
    public String getNgay(){
        return Ngay;
    }    
    public double getTongtien(){
        return Tongtien;
    }
    public void setMahd(int Mahd){
        this.Mahd = Mahd;
    }
    public void setManv(int Manv){
        this.Manv = Manv;
    }
    public void setMakh(int Makh){
        this.Makh = Makh;
    }
    public void setNgay(String Ngay){
        this.Ngay = Ngay;
    }
    public void setTongTien(double Tongtien){
        this.Tongtien = Tongtien;
    }
}
