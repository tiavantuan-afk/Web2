import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

class List_KHACHHANG {
    Scanner sc = new Scanner(System.in);
    private int n;
    private KHACHHANG[] dskh = new KHACHHANG[100];

    
    public void nhap() {
        System.out.print("Nhap n khach hang: ");
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print("Nhap khach hang thu: " + (i + 1));
            dskh[i] = new KHACHHANG();
            dskh[i].nhap();
        }
    }

    public void xuat() {
        System.out.println("Danh sach khach hang: ");
        for (int i = 0; i < n; i++) {
            dskh[i].xuat();
        }
    }
    public KHACHHANG[] getDskh(){
        return dskh;
    }
    public void setDskh(KHACHHANG[] dskh){
        this.dskh = dskh;
    }
    public int getN(){
        return n;
    }
    public void setN(int n){
        this.n = n;
    }

    public void timkiemtheoma(String macantim) {
        boolean timkiem = false;
        for (int i = 0; i < n; i++) {
            if (dskh[i].getMaKH().equalsIgnoreCase(macantim)) {
                timkiem = true;
                dskh[i].xuat();
            }
        }
        if (!timkiem) {
            System.out.println("Khong co trong danh sach.");
        }
    }

    public void timkiemtheoten(String tencantim) {
        boolean timkiem = false;
        for (int i = 0; i < n; i++) {
            if (dskh[i].getTen().toLowerCase().equalsIgnoreCase(tencantim.toLowerCase())) {
                timkiem = true;
                dskh[i].xuat();
            }
        }
        if (!timkiem) {
            System.out.println("Khong co trong danh sach.");
        }
    }

    public void timkiemtheoho(String hocantim) {
        boolean timkiem = false;
        for (int i = 0; i < n; i++) {
            if (dskh[i].getHo().toLowerCase().equalsIgnoreCase(hocantim.toLowerCase())) {
                timkiem = true;
                dskh[i].xuat();
            }
        }
        if (!timkiem) {
            System.out.println("Khong co trong danh sach.");
        }
    }

    public void timkiemtheosdt( String socantim) {
        boolean timkiem = false;
        for (int i = 0; i < n; i++) {
            if (dskh[i].getSDT() == socantim) {
                timkiem = true;
                dskh[i].xuat();
            }
        }
        if (!timkiem) {
            System.out.println("Khong co trong danh sach.");
        }
    }

    public void xoakhachhang(String MAKH) { 
        boolean timkiem = false;
        for (int i = 0; i < n; i++) {
            if (dskh[i].getMaKH().equalsIgnoreCase(MAKH)) {
                for (int j = i; j < n; j++) {
                    dskh[i] = dskh[j + 1];
                }
                dskh[n - 1] = null;
                n--;
                System.out.println("Da xoa khach hang co ma: " + MAKH);
                timkiem = true;
                break;
            }
        }
        if (!timkiem) {
            System.out.println("Khong tim thay khach hang co ma: " + MAKH);
        }
    }

    public void suakhachhang() {
        boolean timkiem = false;
        System.out.println("Nhap ma khach hang can sua: ");
        String MA = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (dskh[i].getMaKH().equalsIgnoreCase(MA)) {  
                System.out.println("Da cap nhat thong tin khach hang: " + MA);
                timkiem = true;
                break;
            }
        }
        if (!timkiem) {
            System.out.println("Khong tim thay khach hang de sua: ");
        }
    }
    public boolean IDKH(String makh){
        if (makh == null){
            return true;
        }
        for (int i=0; i<n; i++){
            if(dskh[i] != null && dskh[i].getMaKH() != null && dskh[i].getMaKH().equalsIgnoreCase(makh)){
                return false;
            }
        }
        return true;
    }
    public void themkhachhang(){
        System.out.println("Nhap khach hang can them");
        KHACHHANG khmoi = new KHACHHANG();
        khmoi.nhap();
        if (!IDKH(khmoi.getMaKH())){
            System.out.println("Ma khach hang da ton tai");
            return;
        }
        dskh = Arrays.copyOf(dskh, n + 1);
        dskh[n-1] = khmoi;
        System.out.println("Da them khach hang moi");
    }
    public void thongkekhachhang() {
        int d = 0;
        System.out.print("Nhap ma khach hang can thong ke: ");
        String makhachhang = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (dskh[i].getMaKH().equalsIgnoreCase(makhachhang)) {
                d++;
            }
        }
        if (d >= 1) {
            System.out.println("Khach hang cu");
        } else {
            System.out.println("Khach hang moi");
        }
    }
    public void docfile(String filename){
        try (BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;
            KHACHHANG x = null;
            dskh = new KHACHHANG[0];
            while ((line = br.readLine()) != null){
                if (line.trim().isEmpty()){
                    continue;
                }
                String[] t = line.split("-");
                if (t.length >= 5){
                    String type = t[0].toUpperCase();
                    if (type.contains("KH")){ 
                            x = new KHACHHANG(t[1], t[2], t[3], t[4]);
                            // x.setMakh();
                            // x.setHo(); 
                            // x.setTen();
                            // x.setSDT(());
                    } else {
                        System.out.println("Bo qua dong khong hop le: " + line);
                        continue;
                    }
                    if (x != null) {
                        dskh = Arrays.copyOf(dskh, n+1);
                        dskh[n-1] = x;
                    }
                }
            }
            System.out.println("Doc file thanh cong, So khach hang da doc: "+ n);
        }catch (IOException e){
            System.out.println("Loi doc file: "+e.getMessage());
        }// catch (NumberFormatException e){
        //     System.out.println("Loi format so: "+e.getMessage());
        // }
    }
    public void ghiFile(String filename){
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))){
            for (int i=0; i<n; i++){
                if (dskh[i] != null){
                    writer.println(dskh[i].toString());
                }
            }
            System.out.println("Ghi file thanh cong: "+n+ " khach");
        }catch (IOException e){
            System.out.println("Loi ghi file");
        }   
    }
    public static void main (String[] args){
        List_KHACHHANG dskh = new List_KHACHHANG();
        System.out.println("Bat dau doc file.........");
        dskh.docfile("data\\List_KHACHHANG.txt");
        System.out.println("Hien thi ket qua: ");
        dskh.xuat();
    }
}
