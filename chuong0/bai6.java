//Viet chuong trinh nhap so tu nhien N, kiem tra va xuat ket qua N la so nguyen to hay khong.
package chuong0;

import java.util.Scanner;

public class bai6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhap so tu nhien N: ");
        int N = sc.nextInt();

        if (N < 2) {
            System.out.println(N + " khong phai so nguyen to");
        } else {
            boolean laNguyenTo = true;
            for (int i = 2; i <= Math.sqrt(N); i++) {
                if (N % i == 0) {
                    laNguyenTo = false;
                    break;
                }
            }
            

            if (laNguyenTo) {
                System.out.println(N + " la so nguyen to");
            } else {
                System.out.println(N + " khong phai so nguyen to");
            }
        }
        sc.close();
    }

}