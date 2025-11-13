package chuong2;
import java.util.Scanner;

public class HOCVIEN {
    private int maSv;
    private String ho;
    private String ten;
    private int lop;
    private float diem1, diem2, diem3;

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nNhap ma sv: ");
        maSv = sc.nextInt();
        sc.nextLine();
        System.out.print("\nNhap ho: ");
        ho = sc.nextLine();
        System.out.print("\nNhap ten: ");
        ten = sc.nextLine();
        System.out.print("\nNhap lop: ");
        lop = sc.nextInt();
        System.out.print("\nNhap diem1: ");
        diem1 = sc.nextFloat();
        System.out.print("\nNhap diem2: ");
        diem2 = sc.nextFloat();
        System.out.print("\nNhap diem3: ");
        diem3 = sc.nextFloat();
    }

    public void xuat() {
        System.out.println("Ma SV: " + maSv);
        System.out.println("Ho: " + ho);
        System.out.println("Ten: " + ten);
        System.out.println("Lop: " + lop);
        System.out.println("Diem 1: " + diem1);
        System.out.println("Diem 2: " + diem2);
        System.out.println("Diem 3: " + diem3);
    }
    public float diemTB() {
        return (diem1 + diem2 + diem3) / 3;
    }   
    public static void main(String[] args) {
        HOCVIEN hv = new HOCVIEN();
        hv.nhap();
        hv.xuat();
        System.out.println("Diem trung binh:\n"+hv.diemTB());
        
}
}