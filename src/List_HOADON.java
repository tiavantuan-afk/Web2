import java.util.Scanner;

class List_HOADON {
    Scanner sc = new Scanner(System.in);
    private int n;
    private HOADON[] dshd = new HOADON[100];

    public void nhap() {
        System.out.print("Nhap n hoa don: ");
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Nhap hoa don thu: " + (i + 1));
            dshd[i] = new HOADON();
            dshd[i].nhap();
        }
    }

    public void xuat() {
        System.out.println("Danh sach hoa don: ");
        for (int i = 0; i < n; i++) {
            dshd[i].xuat();
        }
    }

    public void timkiemtheomahd() {
        System.out.print("Nhap ma hoa don can tim: ");
        int hdcantim = sc.nextInt();
        boolean timkiem = false;
        for (int i = 0; i < n; i++) {
            if (dshd[i].getMahd() == hdcantim) {
                timkiem = true;
                dshd[i].xuat();
            }
        }
        if (!timkiem) {
            System.out.println("Khong co trong danh sach.");
        }
    }

    public void timkiemtheomanv() {
        System.out.print("Nhap ma nhan vien can tim: ");
        int nvcantim = sc.nextInt();
        boolean timkiem = false;
        for (int i = 0; i < n; i++) {
            if (dshd[i].getManv() == nvcantim) {
                timkiem = true;
                dshd[i].xuat();
            }
        }
        if (!timkiem) {
            System.out.println("Khong co trong danh sach.");
        }
    }

    public void timkiemtheomakh() {
        System.out.print("Nhap ma khach hang ");
        int khcantim = sc.nextInt();
        boolean timkiem = false;
        for (int i = 0; i < n; i++) {
            if (dshd[i].getMakh() == khcantim) {
                timkiem = true;
                dshd[i].xuat();
            }
        }
        if (!timkiem) {
            System.out.println("Khong co trong danh sach.");
        }
    }

    public void timkiemtheongay() {
        System.out.print("Nhap ngay can tim: ");
        String ngaycantim = sc.nextLine();
        boolean timkiem = false;
        for (int i = 0; i < n; i++) {
            if (dshd[i].getNgay().equals(ngaycantim)) {
                timkiem = true;
                dshd[i].xuat();
            }
        }
        if (!timkiem) {
            System.out.println("Khong co trong danh sach. ");
        }
    }

    public void timkiemtheotongtien() {
        System.out.print("Tong tien can tim: ");
        double tongcantim = sc.nextDouble();
        boolean timkiem = false;
        for (int i = 0; i < n; i++) {
            if (dshd[i].getTongtien() == tongcantim) {
                timkiem = true;
                dshd[i].xuat();
            }
        }
        if (!timkiem) {
            System.out.println("Khong co trong danh sach.");
        }
    }

    public void suahoadon() {
        System.out.println("Nhap ma hoa don can sua: ");
        int MA = sc.nextInt();
        boolean timkiem = false;
        for (int i = 0; i < n; i++) {
            if (dshd[i].getMahd() == MA) {
                System.out.println("Da cap nhat thong tin hoa don.");
                timkiem = true;
                break;
            }
        }
        if (!timkiem) {
            System.out.println("Khong ti thay hoa don de sua. ");
        }
    }

    public void xoahoadon() {
        System.out.println("Nhap ma hoa don can xoa: ");
        int MAHD = sc.nextInt();
        boolean timkiem = false;
        for (int i = 0; i < n; i++) {
            if (dshd[i].getMahd() == MAHD) {
                for (int j = i; j < n; j++) {
                    dshd[i] = dshd[i + 1];
                }
                dshd[n - 1] = null;
                n--;
                System.out.println("Da xoa hoa don co ma: " + MAHD);
                timkiem = true;
                break;
            }
        }
        if (!timkiem) {
            System.out.println("Khong tim thay hoa don co ma: " + MAHD);
        }
    }
    public void thongkenhanvien() {
        int d = 0;
        System.out.print("Nhap ma nhan vien can thong ke: ");
        int manhanvien = sc.nextInt();
        for (int i = 0; i < n; i++) {
            if (dshd[i].getManv() == manhanvien) {
                d++;
            }
        }
        if (d >= 5) {
            System.out.println("Nhan vien uu tu");
        }
    }
}
