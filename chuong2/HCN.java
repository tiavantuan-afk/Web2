package chuong2;
import java.util.Scanner;

public class HCN {

    private float dai;
    private float rong;

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nNhap dai: ");
        dai = sc.nextFloat();
        System.out.print("\nNhap rong: ");
        rong = sc.nextFloat();
    }

    public void xuat() {
        System.out.println("\nHinh chu nhat dai: " + dai + " rong: " + rong +
                " chu vi: " + chuvi() + " dien tich: " + dientich());
    }

    public float chuvi() {
        return (dai + rong) * 2;
    }

    public float dientich() {
        return dai * rong;
    }

    public static void main(String[] args) {
        HCN hcn = new HCN();
        hcn.nhap();
        hcn.xuat();
    }
}

