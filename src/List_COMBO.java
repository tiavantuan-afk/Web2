import java.util.Scanner;

class List_COMBO {
    Scanner sc = new Scanner(System.in);
    private int n;
    private COMBO[] ds = new COMBO[100];

    public void nhap() {
        System.out.print("Nhap n combo: ");
        n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap combo thu: " + (i + 1));
            ds[i] = new COMBO();
            ds[i].nhap();
        }
    }

    public void xuat() {
        System.out.println("Danh sach combo: ");
        for (int i = 0; i < n; i++) {
            if (ds[i] != null) ds[i].xuat();
        }
    }

    public void timkiemtheoma(String macantim) {
        System.out.print("Nhap ma combo can tim: ");
        macantim = sc.nextLine();
        boolean timkiem = false;
        for (int i = 0; i < n; i++) {
            if (ds[i] != null && ds[i].maSP != null && ds[i].maSP.equalsIgnoreCase(macantim)) {
                timkiem = true;
                ds[i].xuat();
            }
        }
        if (!timkiem) System.out.println("Khong co trong danh sach.");
    }

    // tìm kiếm theo tên
    public void timkiemtheoten(String tencantim) {
        System.out.print("Nhap ten combo can tim: ");
        tencantim = sc.nextLine();
        boolean timkiem = false;
        for (int i = 0; i < n; i++) {
            if (ds[i] != null && ds[i].tenSP != null && ds[i].tenSP.equalsIgnoreCase(tencantim)) {
                timkiem = true;
                ds[i].xuat();
            }
        }
        if (!timkiem) System.out.println("Khong co trong danh sach.");
    }

    // tìm kiếm theo giá
    public void timkiemtheogia(double giacantim) {
        System.out.print("Nhap gia can tim: ");
        giacantim = Double.parseDouble(sc.nextLine());
        boolean timkiem = false;
        for (int i = 0; i < n; i++) {
            if (ds[i] != null && ds[i].getGiaBan() == giacantim) {
                timkiem = true;
                ds[i].xuat();
            }
        }
        if (!timkiem) System.out.println("Khong co trong danh sach.");
    }

    //sửa combo theo mã
    public void suacombo(String MA, COMBO c) {
        boolean timkiem = false;
        for (int i = 0; i < n; i++) {
            if (ds[i] != null && ds[i].maSP != null && ds[i].maSP.equalsIgnoreCase(MA)) {
                ds[i] = c;
                System.out.println("Da cap nhat thong tin combo: " + MA);
                timkiem = true;
                break;
            }
        }
        if (!timkiem) System.out.println("Khong tim thay combo de sua: " + MA);
    }

    //xóa combo theo mã
    public void xoacombo(String MAC) {
        boolean timkiem = false;
        for (int i = 0; i < n; i++) {
            if (ds[i] != null && ds[i].maSP != null && ds[i].maSP.equalsIgnoreCase(MAC)) {
                for (int j = i; j < n - 1; j++) ds[j] = ds[j + 1];
                ds[n - 1] = null;
                n--;
                System.out.println("Da xoa combo co ma: " + MAC);
                timkiem = true;
                break;
            }
        }
        if (!timkiem) System.out.println("Khong tim thay combo co ma: " + MAC);
    }
    
    //thêm một combo
    public void them() {
        if (n >= ds.length) {
            ds = java.util.Arrays.copyOf(ds, ds.length + 10);
        }
        COMBO combo = new COMBO();
        combo.nhap();
        ds[n] = combo;
        n++;
        System.out.println("Da them combo thanh cong.");
    }
    
    //thống kê combo theo mã
    public void thongkecombo(String macantke) {
        System.out.print("Nhap ma combo can thong ke: ");
        macantke = sc.nextLine();
        int d = 0;
        for (int i = 0; i < n; i++) {
            if (ds[i] != null && ds[i].maSP != null && ds[i].maSP.equalsIgnoreCase(macantke)) d++;
        }
        if (d >= 1) System.out.println("Combo ton tai");
        else System.out.println("Combo khong ton tai");
    }

    // getters/setters
    public COMBO[] getDs() { 
        return ds; 
    }
    public void setDs(COMBO[] ds) { 
        this.ds = ds; 
    }
    public int getN() { 
        return n; 
    }
    public void setN(int n) { 
        this.n = n; 
    }
}
