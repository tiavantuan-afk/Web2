package chuong2;

import java.util.Scanner;

public class MangHOCVIEN {
    private HOCVIEN[] ds;
    private int n;

    public MangHOCVIEN(int size) {
        n = size;
        ds = new HOCVIEN[n];
        for (int i = 0; i < n; i++) {
            ds[i] = new HOCVIEN();
        }
    }

    public void nhapDS() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong hoc vien: ");
        n = sc.nextInt();
        sc.nextLine(); // bỏ dòng thừa
        ds = new HOCVIEN[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap thong tin hoc vien thu " + (i + 1) + ":");
            ds[i] = new HOCVIEN();
            ds[i].nhap();
        }
    }

    public void xuatDS() {
        System.out.println("Danh sach hoc vien:");
        for (int i = 0; i < n; i++) {
            System.out.println("Hoc vien thu " + (i + 1) + ":");
            ds[i].xuat();
            System.out.println("Diem trung binh: " + ds[i].diemTB());
            System.out.println("-------------------");
        }
    }

    public void xuatHocVienGioi() {
        System.out.println("Danh sach hoc vien co diem trung binh >= 8:");
        for (int i = 0; i < n; i++) {
            if (ds[i].diemTB() >= 8) {
                ds[i].xuat();
                System.out.println("-------------------");
            }
        }
    }

    public static void main(String[] args) {
        MangHOCVIEN mang = new MangHOCVIEN(0);
        mang.nhapDS();
        mang.xuatDS();
        mang.xuatHocVienGioi();
    }
}