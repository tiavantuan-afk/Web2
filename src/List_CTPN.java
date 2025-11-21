import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class List_CTPN {
    Scanner sc = new Scanner(System.in);
    private int n;
    public Chitietphieunhap[] ds;

    public List_CTPN() {
        n = 0;
        ds = new Chitietphieunhap[0];
    }

    public List_CTPN(int n) {
        this.n = n;
        ds = new Chitietphieunhap[n];
    }

    public List_CTPN(List_CTPN List) {
        this.n = List.getN();
        ds = Arrays.copyOf(ds, ds.length);
    }

    public int getN() {
        return ds.length;
    }

    public Chitietphieunhap[] getDS() {
        return ds;
    }

    public boolean TonTai(String mact) {
        if (mact == null)
            return false;
        for (int i = 0; i < ds.length; i++) {
            if (ds[i] != null && ds[i].getmaPNH() != null &&
                    ds[i].getmaPNH().equalsIgnoreCase(mact)) {
                return true;
            }
        }
        return false;
    }

    // Nhập danh sách
    public void nhap(String maPNH, String maNV, double dongia) {
        System.out.print("So luong chi tiet phieu nhap: ");
        n = sc.nextInt();
        sc.nextLine();
        ds = new Chitietphieunhap[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Chi tiet phieu nhap " + (i + 1) + ":");
            ds[i] = new Chitietphieunhap();
            ds[i].nhap(maPNH, maNV, dongia);
        }
    }

    // Xuất danh sách
    public void xuat() {
        System.out.println("DANH SACH CHI TIET PHIEU NHAP");
        for (int i = 0; i < n; i++) {
            ds[i].xuat();
        }
    }

    // Đọc file
    public void docFile(String name) {
        try (BufferedReader br = new BufferedReader(new FileReader("src/data/List_CTPN.txt"))) {
            String line;
            ds = new Chitietphieunhap[0]; // reset mảng
            n = 0;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] t = line.split("-");
                if (t.length >= 5) {
                    Chitietphieunhap x = new Chitietphieunhap();
                    x.setmaPNH(t[0]);
                    x.setmaSP(t[1]);
                    x.setsoluong(Integer.parseInt(t[2]));
                    x.setdongia(Double.parseDouble(t[3]));
                    x.setThanhtien(Double.parseDouble(t[4]));

                    ds = Arrays.copyOf(ds, ds.length + 1);
                    ds[ds.length - 1] = x;
                    n = ds.length;

                }
            }
            System.out.println("Doc file thanh cong, so chi tiet da doc: " + ds.length);
        } catch (IOException e) {
            System.out.println("Loi doc file: " + e.getMessage());
        }
    }

    // Ghi file
    public void ghiFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("src/data/List_CTPN.txt"))) {
            for (int i = 0; i < n; i++) {
                if (ds[i] != null) {
                    writer.println(ds[i].toString());
                }
            }
            System.out.println("Ghi file thanh cong: " + n + " chi tiet");
        } catch (IOException e) {
            System.out.println("Loi ghi file: " + e.getMessage());
        }
    }

    // Thêm theo mã co tham so

    public void timKiemTheoMaPNH(String maPNH) {
        boolean found = false;
        for (int i = 0; i < ds.length; i++) {
            if (ds[i] != null && ds[i].maPNH != null && ds[i].maPNH.equalsIgnoreCase(maPNH)) {
                System.out.println("Da tim thay san pham can tim: ");
                ds[i].xuat();
                System.out.println();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay ma ");
        }
    }

    public void them(Chitietphieunhap ctpn) {
        ds = Arrays.copyOf(ds, ds.length + 1);
        ds[ds.length - 1] = ctpn;
    }

    public void them(String maPNH, String maSP, double dongia) {
        ds = Arrays.copyOf(ds, ds.length + 1);
        Chitietphieunhap x = new Chitietphieunhap();
        x.nhap(maPNH, maSP, dongia);
        ds[ds.length - 1] = x;
        ghiFile();

    }

    public int Soluongmon(String maPNH, String maSP) {
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getmaPNH().equalsIgnoreCase(maPNH) && ds[i].getmaSP().equalsIgnoreCase(maSP)) {
                return ds[i].getsoluong();
            }
        }
        return 0;
    }

    public void xoaALL(String maPNH) {
        int count = 0;
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getmaPNH().equalsIgnoreCase(maPNH)) {
                count++;
                for (int j = i; j < ds.length - 1; j++) {
                    ds[i] = ds[i + 1];
                }
            }
            ds = Arrays.copyOf(ds, ds.length - count);
            System.out.println("Da xoa chi tiet co ma sach " + maPNH);
        }
    }

    public double Tinhtongtien(String maPNH) {
        double tongtien = 0;
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getmaPNH().equalsIgnoreCase(maPNH)) {
                tongtien += ds[i].thanhtien;
            }
        }
        return tongtien;
    }

    public List_CTPN LietKeChiTiet(String maPNH) {
        List_CTPN temp = new List_CTPN();
        for (int i = 0; i < ds.length; i++) {
            if (ds[i].getmaPNH().equalsIgnoreCase(maPNH)) {
                temp.them(ds[i]);
            }
        }
        return temp;
    }

    // Timkiem khong tham so
    public Chitietphieunhap[] timKiemTheoMaSP() {
        System.out.println("\n===== TIM KIEM CHI TIET PHIEU NHAP =====");
        System.out.print("Nhap Ma Phieu Nhap Hang can tim: ");
        String maTim = sc.nextLine().trim();

        int d = 0; // Biến đếm
        boolean timthay = false;

        for (int i = 0; i < ds.length; i++) {
            // Tranh bi crash
            if (ds[i] != null && ds[i].getmaPNH() != null &&
                    ds[i].getmaPNH().equalsIgnoreCase(maTim)) {
                d++;
                timthay = true;
            }
        }
        Chitietphieunhap[] kq = new Chitietphieunhap[d];
        if (timthay) {
            int d1 = 0;
            for (int i = 0; i < ds.length; i++) {
                if (ds[i] != null && ds[i].getmaPNH() != null &&
                        ds[i].getmaPNH().equalsIgnoreCase(maTim)) {
                    kq[d1] = ds[i];
                    d1++;
                }
            }
            System.out.println(" Da tim thay " + d + " chi tiet thuoc ma PNH: " + maTim);
        } else {
            System.out.println(" Khong tim thay Phieu Nhap Hang co ma: " + maTim);
        }

        return kq;
    }

    // Xoá theo mã
    public void xoatheoma(String maPNH, String maNV) {
        for (int i = 0; i < ds.length; i++) {
            if (ds[i] != null && ds[i].getmaPNH() != null && ds[i].getmaPNH().equalsIgnoreCase(maPNH)) {
                System.out.println("Da tim thay ma can xoa: ");
                for (int j = i; j < ds.length - 1; j++) {
                    ds[j] = ds[j + 1];
                }
                ds = Arrays.copyOf(ds, ds.length - 1);
                System.out.println("Da xoa khoi danh sach" + maNV);
                break;

            }
        }

    }

    public void sua() {
        if (ds.length == 0) {
            System.out.println("Danh sach chi tiet phieu nhap rong!");
            return;
        }

        System.out.print("Nhap Ma Phieu Nhap Hang (PNH) can sua: ");
        String macansua = sc.nextLine().trim();

        int v = -1; // Tim vi tri
        for (int i = 0; i < ds.length; i++) {

            if (ds[i] != null && ds[i].getmaPNH() != null &&
                    ds[i].getmaPNH().equalsIgnoreCase(macansua)) {
                v = i;
                break;
            }
        }
        if (v == -1) {
            System.out.println(" Khong tim thay chi tiet phieu nhap co ma: " + macansua);
            return;
        }

        System.out.println("--- TIM THAY CHI TIET THU " + (v + 1) + " TRONG PHIEU ---");
        ds[v].xuat();

        int choice;
        do {
            System.out.println("\n=== CHON THUOC TINH CAN SUA ===");
            System.out.println("1. Sua Ma San Pham (MaSP)");
            System.out.println("2. Sua So Luong");
            System.out.println("3. Sua Don Gia Nhap");
            System.out.println("7. Sua tat ca (Nhap lai)");
            System.out.println("0. Hoan thanh sua & Luu File");
            System.out.print("Lua chon: ");

            if (sc.hasNextInt()) {
                choice = sc.nextInt();
                sc.nextLine();
            } else {
                choice = -1;
                sc.nextLine();
            }

            switch (choice) {
                case 1:
                    System.out.print("Nhap Ma SP moi: ");
                    String maSPMoi = sc.nextLine().trim();
                    ds[v].setmaSP(maSPMoi);
                    System.out.println(" Da cap nhat Ma SP.");
                    break;

                case 2:
                    System.out.print("Nhap So Luong moi: ");
                    int slMoi = sc.nextInt();
                    sc.nextLine();
                    ds[v].setsoluong(slMoi);
                    System.out.println(" Da cap nhat So Luong.");
                    break;

                case 3:
                    System.out.print("Nhap Don Gia moi: ");
                    double dgMoi = sc.nextDouble();
                    sc.nextLine();
                    ds[v].setdongia(dgMoi);
                    System.out.println(" Da cap nhat Don Gia.");
                    break;

                case 4:
                    System.out.println("--- NHAP LAI TOAN BO THONG TIN ---");
                    String maPNHGoc = ds[v].getmaPNH();
                    ds[v].nhap(maPNHGoc, "<->", 0.0);
                    System.out.println(" Da cap nhat tat ca thong tin.");
                    break;

                case 0:
                    System.out.println("Hoan tat sua Chi Tiet Phieu Nhap.");
                    break;

                default:
                    System.out.println("Lua chon khong hop le.");
            }

            if (choice >= 1 && choice <= 7) {
                System.out.println("\n--- THONG TIN SAU KHI SUA ---");
                ds[v].xuat();
            }

        } while (choice != 0);

        ghiFile();
        System.out.println("Đã lưu thay đổi vào file.");
    }

    public void thongkeThanhTien() {
        double tongThanhTien = 0;
        for (int i = 0; i < n; i++) {
            if (ds[i] != null) {
                tongThanhTien += ds[i].thanhtien; // thanhtien là thành tiền của chi tiết
            }
        }
        System.out.printf("\nTỔNG THÀNH TIỀN TẤT CẢ PHIẾU NHẬP: %.2f\n", tongThanhTien);
    }
}
