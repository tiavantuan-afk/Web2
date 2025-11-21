public class Menu_CTPN extends Menu_Main {
    String name;

    @Override
    public void menu() {
        int chon = -1;
        do {
            System.out.println("\n--- MENU CHI TIET PHIEU NHAP (CTPN) ---");
            System.out.println("1. Xuat danh sach");
            System.out.println("2. Them mot chi tiet ");
            System.out.println("3. Tim kiem (Theo Ma PNH, tra ve danh sach)");
            System.out.println("4. Sua theo Ma PNH");
            System.out.println("5. Xoa theo Ma PNH");
            System.out.println("6. Thong ke theo ngay");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");

            chon = sc.nextInt();
            sc.nextLine();

            switch (chon) {
                case 1:
                    DSCTPN.xuat();
                    break;
                case 2:
                    String maPNH;
                    do {
                        System.out.print("Nhap ma  phieu nhap: ");
                        maPNH = sc.nextLine();
                        if (!DSNL.TonTai(maPNH)) {
                            System.out.println("Ma phieunhap khong ton tai! Vui long nhap lai.");
                        }
                    } while (!DSNL.TonTai(maPNH));
                    String maSP;
                    boolean temp = true;
                    do {
                        System.out.print("Nhap ma mon an: ");
                        maSP = sc.nextLine();
                        temp = true;
                        if (!DSNL.TonTai(maSP) && maSP.contains("NL")) {
                            System.out.println("Ma mon an khong ton tai! Vui long nhap lai.");
                            temp = false;
                        } else if (!DSMA.TonTai(maSP) && maSP.contains("NU")) {
                            System.out.println("Ma mon an khong ton tai! Vui long nhap lai.");
                            temp = false;
                        }
                    } while (!temp);
                    if (maSP.contains("NL")) {
                        DSCTPN.them(maPNH, maSP, DSNL.getdonGia(maSP));
                        DSNL.CapNhatSoLuong(maSP, DSCTPN.Soluongmon(maPNH, maSP));
                        DSNL.ghiFile();
                    } else if (maSP.contains("NU")) {
                        DSCTPN.them(maPNH, maSP, DSMA.getdonGia(maSP));
                        DSMA.CapNhatSoLuong(maSP, DSCTPN.Soluongmon(maPNH, maSP));
                        DSMA.ghiFile("src/data/List_MonAn.txt");
                    }
                    DSCTPN.ghiFile();
                    DSPN.capnhattongtien(maPNH, DSCTPN.Tinhtongtien(maPNH));
                    DSPN.ghiFile();
                    break;
                case 3:
                    timkiemVaHienThiKetQua();
                    break;
                case 4:
                    DSCTPN.sua();
                    break;
                case 5:
                    System.out.print("Nhap ma phieu nhap can xoa: ");
                    String maXoa = sc.nextLine();
                    DSCTPN.xoaALL(maXoa);
                    DSCTPN.ghiFile();
                    break;
                case 6:
                    DSCTPN.thongkeThanhTien();
                    ;
                    break;

                case 0:
                    System.out.println("Thoat chuong trinh.");
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long chon lai (0-8).");
            }

        } while (chon != 0);
    }

    // Xuất của case 4
    private void timkiemVaHienThiKetQua() {
        Chitietphieunhap[] ketQua = DSCTPN.timKiemTheoMaSP();
        if (ketQua.length > 0) {
            System.out.println("\n=== KET QUA TIM KIEM ===");
            for (Chitietphieunhap ct : ketQua) {
                ct.xuat();
            }
        }
    }

}
