import java.util.Scanner;
import java.util.Arrays;

public class List_NhanVien {
    private NhanVien[] ds;
    private int n;
    private Scanner sc = new Scanner(System.in);

    public List_NhanVien() {
        n = 0;
        ds = new NhanVien[0];
    }

    public List_NhanVien(int n) {
        this.n = n;
        ds = new NhanVien[n];
    }

    public void nhapds() {
        System.out.print("Nhap so luong nhan vien: ");
        n = sc.nextInt();
        sc.nextLine();
        ds = new NhanVien[n];

        for (int i = 0; i < ds.length; i++) {
            System.out.println("\n--- Nhap thong tin nhan vien" + (i + 1) + "---");
            ds[i] = new NhanVien();
            ds[i].nhap();
        }
        System.out.println("Da nhap xong " + n + " nhan vien");
    }

    public void xuatds() {
        if (ds.length == 0) {
            System.out.println("Danh sach empty ");
            return;
        }
        System.out.println("\n=== DANH SACH NHAN VIEN ===");
        System.out.println("So luong nhan vien: " + ds.length);
        System.out.printf("%-8s %-15s %-10s %-15s\n", "Ma NV", "Ho NV", "Ten NV", "Luong Co Ban");
        System.out.println("----------------------------------------------------");
        for (int i = 0; i < ds.length; i++) {
            if (ds[i] != null) {
                ds[i].xuat();
            }
        }
    }

    public boolean OneIDNV(String maNV) {
        if (maNV == null)
            return true;
        for (int i = 0; i < ds.length; i++) {
            if (ds[i] != null && ds[i].getMaNV() != null &&
                    ds[i].getMaNV().equalsIgnoreCase(maNV)) {
                return false;
            }
        }
        return true;
    }

    public void them() {
        System.out.println(" \n---- THEM NHAN VIEN MOI ----");
        NhanVien nvMoi = new NhanVien();
        nvMoi.nhap();

        // Check trùng mã
        if (!OneIDNV(nvMoi.getMaNV())) {
            System.out.println("Ma nhan vien da ton tai ");
            return;
        }

        // Add vào mảng
        ds = Arrays.copyOf(ds, ds.length + 1);
        ds[ds.length - 1] = nvMoi;
        System.out.println("Da them nhan vien moi ");
    }

    public NhanVien[] getArray() {
        return ds;
    }

    public static void main(String[] args) {
        List_NhanVien dsNV = new List_NhanVien();
        dsNV.nhapds();
        dsNV.xuatds();
    }
}