import java.util.Scanner;
public class KHACHHANG {
    private String ho;
    private String ten;
    private int Makh;
    private int SDT;
    public KHACHHANG(){
        ho = "";
        ten = "";
        Makh = 0;
        SDT = 0;
    }
    public KHACHHANG(String ho, String ten, int Makh, int SDT){
        this.ho = ho;
        this.ten = ten;
        this.Makh = Makh;
        this.SDT = SDT;
    }
    public KHACHHANG(KHACHHANG t){
        if (t != null){
        this.ho = t.ho;
        this.ten = t.ten;
        this.Makh = t.Makh;
        this.SDT = t.SDT;
        }
    }
    public void nhap (){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap ho: ");
        ho = sc.nextLine();
        System.out.print("Nhap ten: ");
        ten = sc.nextLine();
        System.out.print("Nhap ma khach hang: ");
        Makh = sc.nextInt();
        System.out.print("Nhap so dien thoai: ");
        SDT = sc.nextInt();
    }
    public void xuat(){
        System.out.println("Thong tin khach hang: ");
        System.out.println("Ho: "+ho);
        System.out.println("Ten: "+ten);
        System.out.println("Ma khach hang: "+Makh);
        System.out.println("So dien thoai: "+SDT);
    }
    public String getHo(){
        return ho;
    }
    public String getTen(){
        return ten;
    }
    public int getMaKH(){
        return Makh;
    }
    public int getSDT(){
        return SDT;
    }
    public void setHo(String ho){
        this.ho = ho;
    }
    public void setTen(String ten){
        this.ten = ten;
    }
    public void setMakh(int Makh){
        this.Makh = Makh;
    }
    public void setSDT(int SDT){
        this.SDT = SDT;
    }
}
                