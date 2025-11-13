package chuong3;

import java.util.Scanner;

public class bai1 {
    static class Diem {
        protected float x, y;

        public Diem() {
            x = 0;
            y = 0;
        }

        public Diem(float x, float y) {
            this.x = x;
            this.y = y;
        }

        public void nhap(Scanner sc) {
            System.out.print("Nhap hoanh do x: ");
            x = sc.nextFloat();
            System.out.print("Nhap tung do y: ");
            y = sc.nextFloat();
            sc.nextLine(); // loại bỏ dòng thừa
        }

        public void xuat() {
            System.out.println("Toa do diem: (" + x + ", " + y + ")");
        }
    }

    static class DiemMau extends Diem {
        private String mau;

        public DiemMau() {
            super();
            mau = "Trang";
        }

        public DiemMau(float x, float y, String mau) {
            super(x, y);
            this.mau = mau;
        }

        @Override
        public void nhap(Scanner sc) {
            super.nhap(sc);
            System.out.print("Nhap mau sac: ");
            mau = sc.nextLine().trim();
        }

        @Override
        public void xuat() {
            super.xuat();
            System.out.println("Mau sac: " + mau);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Diem d = new Diem();
        System.out.println("Nhap thong tin diem:");
        d.nhap(sc);
        d.xuat();

        System.out.println("\nNhap thong tin diem mau:");
        DiemMau dm = new DiemMau();
        dm.nhap(sc);
        dm.xuat();

        sc.close();
    }
}