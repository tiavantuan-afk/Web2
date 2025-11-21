import java.util.*;

public class Menu_Cook extends Menu_Main {
    private Scanner sc = new Scanner(System.in);

    @Override
    public void menu() {
        int chon;
        int n;
        do {
            System.out.println("\n=== QUAN LY NAU AN ===");
            System.out.println("1. Cook");
            System.out.println("2. xuat");
            System.out.println("3. Them");
            System.out.println("4. Xoa");
            System.out.println("5. Sua");
            System.out.println("6. Tim");
            System.out.println("0. Thoat");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    String id;
                    do {
                        System.out.print("Nhap ma cong thuc: ");
                        id = sc.nextLine();
                        if (!DSCOOK.TonTai(id)) {
                            System.out.println("Ma cong thuc khong ton tai! Vui long nhap lai.");
                        }
                    } while (!DSCOOK.TonTai(id));
                    DSMA.CapNhatSoLuong(DSCOOK.getIDSP(id), 1);
                    DSMA.ghiFile("src/data/List_MonAn.txt");
                    String[] idnl = DSCOOK.getCNL(id);
                    for (int i = 0; i < idnl.length; i++) {
                        DSNL.GiamSoLuong(idnl[i], 1);
                    }
                    DSNL.ghiFile();
                    break;
                case 2:
                    DSCOOK.xuat();
                    break;
                case 3:
                    do {
                        System.out.print("Nhap ma cong thuc: ");
                        id = sc.nextLine();
                        if (!DSCOOK.OneID(id)) {
                            System.out.println("Ma cong thuc da ton tai! Vui long nhap lai.");
                        }
                    } while (!DSCOOK.OneID(id));
                    String idsp;
                    do {
                        System.out.print("Nhap ma san pham: ");
                        idsp = sc.nextLine();
                        if (!DSMA.TonTai(id)) {
                            System.out.println("Ma san pham khong ton tai! Vui long nhap lai.");
                        }
                    } while (!DSMA.TonTai(id));
                    System.out.println("nhap so luong nguyen: ");
                    n = sc.nextInt();
                    sc.nextLine();
                    String[] idnlt = new String[n];
                    for (int i = 0; i < n; i++) {
                        do {
                            System.out.println("nhap nguyen lieu thu " + (i + 1) + ":");
                            idnlt[i] = sc.nextLine();
                            if (!DSNL.TonTai(idnlt[i])) {
                                System.out.println("ma nguyen lieu nay khong ton tai");
                            }
                        } while (!DSNL.TonTai(idnlt[i]));
                    }
                    DSCOOK.them(id, idsp, idnlt);
                    DSCOOK.fileWriterALL();
                    break;
                case 4:
                    System.out.print("Nhập mã công thức cần xóa: ");
                    String idXoa = sc.nextLine();
                    DSCOOK.xoaALL(idXoa);
                    DSCOOK.fileWriterALL();
                    System.out.println("Đã xóa công thức " + idXoa);
                    break;
                case 5:
                    System.out.print("Nhập mã công thức cần sửa: ");
                    String idSua = sc.nextLine();
                    DSCOOK.sua(idSua);
                    DSCOOK.fileWriterALL();
                    break;
                case 6:
                    System.out.print("Nhập mã công thức cần tìm: ");
                    String idct = sc.nextLine();
                    DSCOOK.timkiemTheoCongThuc(idct).xuat();
                    break;
                case 0:
                    System.out.println("Thoat chuong trinh quan ly phieu nhap.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }
        } while (chon != 0);
    }
}