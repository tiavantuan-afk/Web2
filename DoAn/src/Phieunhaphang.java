import java.util.ArrayList;
import java.util.Scanner;

public class Phieunhaphang {
    Scanner sc = new Scanner(System.in);
    private String maNH;
    private String maNV;
    private String ngay;
    private String maNCC;
    private ArrayList<Chitietphieunhap> Danhsachchitiet;
    
    public Phieunhaphang(){
        Danhsachchitiet = new ArrayList<>();
    }
    public String getmaNH(){
        return maNH;
    }
    public void setmaPN(String maNH){
        this.maNH = maNH;
    }
    public String getmaNV(){
        return maNV;
    }
    public void setmaNV(String maNV){
        this.maNV = maNV;
    }
    public String getngay(){
        return ngay;
    }
    public void setngay(String ngay){
        this.ngay = ngay;
    }
    public String getmaNCC(){
        return maNCC;
    }
    public void setncc(String maNCC){
        this.maNCC = maNCC;
    }
    public ArrayList<Chitietphieunhap> getDanhsachchitiet(){
        return Danhsachchitiet;
    }
    public void setDanhsachchitiet(ArrayList<Chitietphieunhap> Danhsachchitiet){
        this.Danhsachchitiet = Danhsachchitiet;
    }
    public void nhap(){
        System.out.println("Mã phiếu nhập hàng: ");
        maNH = sc.nextLine();
        System.out.println("Mã nhân viên: ");
        maNV = sc.nextLine();
        System.out.println("Ngày nhập hàng: ");
        ngay = sc.nextLine();
        System.out.println("Nhà cung cấp: ");
        maNCC = sc.nextLine();
        System.out.println("Số mặt hàng: ");
        int n = Integer.parseInt(sc.nextLine());
        for(int i = 0;i<n;i++){
            System.out.println("Chi tiết hàng "+(i+1));
            Chitietphieunhap ct = new Chitietphieunhap();
            ct.nhap();
            Danhsachchitiet.add(ct);
        }
    }
    public double tien(){
        double s = 0;
        for(Chitietphieunhap ct : Danhsachchitiet) {
            s+=ct.thanhTien();
        }
        return s;
    }
    @Override
    public String toString(){
        String s = " Phiếu nhập hàng";
        s+= "Mã PN: " + maNH +"| Ngày nhập hàng: " + ngay + "\n";
        s+= "Nhà cung cấp: " + maNCC +"\n Danh sách chi tiết \n";

        for(Chitietphieunhap ct : Danhsachchitiet){
            s+= ct.toString() + "\n";
        }
        s+="\nTổng tiền: " + tien() + "VND\n";
        return s;
    }
    public class MenuPhieuNhap {
        Phieunhaphang phieu = new Phieunhaphang();
        int chon = -1;
        do{
            System.out.println("MENU PHIẾU NHẬP");
            System.out.println("1. Nhập phiếu nhập");
            System.out.println("2. Xem phiếu nhập");
            System.out.println("3. Chi tiết phiếu nhập");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            chon = sc.nextInt();
            sc.nextLine();
        switch (chon) {
                case 1:
                    nhap();
                    break;

                case 2:
                    System.out.println(phieu.toString());
                    break;

                case 3:
                    Chitietphieunhap ct = new Chitietphieunhap();
                    ct.menuchitietphieunhap();
                    break;

                case 0:
                    System.out.println("Thoat");
                    break;

                default:
                    System.out.println("Chon sai");
            }

        }while (chon != 0);
    }
}
