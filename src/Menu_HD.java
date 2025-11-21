
public class Menu_HD extends Menu_Main {
    @Override
    public void menu() {
        int chon = -1;
        do {
            System.out.println("\nMENU QUAN LY HOA DON");
            System.out.println("1. Xuat danh sach hoa don: ");
            System.out.println("2. Tim mot hoa don theo ma hoa don: ");
            System.out.println("3. Sua mot hoa don theo ma hoa don: ");
            System.out.println("4. Them mot hoa don theo ma hoa don: ");
            System.out.println("5. Xoa mot hoa don theo ma hoa don: ");
            System.out.println("6. Thong ke doanh thu: ");
            System.out.println("0. Thoat.");
            System.out.print("Vui long chon: ");
            chon = sc.nextInt();
            sc.nextLine();
            switch (chon) {
                case 1:
                    DSHD.xuat();
                    break;
                case 2:
                    System.out.print("Nhap ma hoa don can tim: ");
                    String hoadoncantim = sc.nextLine();
                    DSHD.timkiemtheomahd(hoadoncantim);
                    break;
                case 3:
                    DSHD.suahoadon();
                    break;
                case 4:
                    String maHD;
                    do {
                        System.out.print("Nhap ma hoa don: ");
                        maHD = sc.nextLine();
                        if (!DSHD.ONEID(maHD)) {
                            System.out.println("Ma hoa don da ton tai! Vui long nhap lai.");
                        }
                    } while (!DSHD.ONEID(maHD));
                    DSHD.themhoadon(maHD);
                    System.out.println("Nhap so luong chi tiet hoa don: ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    for (int i = 0; i < n; i++) {
                        String maSP;
                        do {
                            System.out.print("Nhap ma sp: ");
                            maSP = sc.nextLine();
                            if (!DSMA.TonTai(maSP)) {
                                System.out.println("Khong ton tai san pham nay: ");
                            }
                        } while (!DSMA.TonTai(maSP));
                        DSCTHD.them(maHD, maSP, DSMA.getdonGia(maSP));
                        DSCTHD.ghiFile();
                        DSMA.GiamSoLuong(maSP, DSCTHD.Soluongmon(maHD, maSP));
                        DSMA.ghiFile("scr/data/List_MonAn.txt");
                    }
                    DSHD.capnhattongtien(maHD, DSCTHD.Tinhtongtien(maHD));
                    DSHD.ghiFile();
                    break;
                case 5:
                    System.out.print("Nhap ma hoa don can xoa: ");
                    String hdcanxoa = sc.nextLine();
                    DSHD.xoahoadon(hdcanxoa);
                    break;
                case 6:
                    DSHD.thongKeDoanhThu();
                    break;
                case 0:
                    System.out.println("Xong");
                    break;
                default:
                    System.out.println("Lua chon khong hop le");
                    break;
            }
        } while (chon != 0);

    }

}
