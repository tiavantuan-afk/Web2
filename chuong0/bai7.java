package chuong0;

import java.util.Scanner;

public class bai7 {
    //Hàm tìm kiếm số nguyên tố
    public static boolean isPrime(int n){
        if(n<2) return false;
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i==0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);

        System.out.println("Nhap so tu nhien N:");
        int N= sc.nextInt();
        //câu a: Các số tự nhiên <=N và tổng của chúng
        int tonga=0;
        System.out.println("Cac so tu nhien <=N");
        for(int i=0; i<=N; i++){
            tonga+=i;
        }
        System.out.println("Tong cac so tu nhien <=N la: "+tonga);
        

    
        //câu b: Các só tự nhiên chắn <=N và tổng của chúng
        int tongb=0;
        System.out.print("Cac so tu nhien chan <=N");
        for(int i=2; i<=N; i+=2){
            tongb+=i;
        }
        System.out.println("\nTong cac so tu nhien chan "+tongb);
       


        //câu c: Các số tự nhiên lẻ &lt;=N và tổng của chúng
        int tongc=0;
        System.out.print("Cac so tu nhien le <=N");
        for(int i=1; i<=N; i+=2){
            tongc+=i;
        }
        System.out.println("\nTong cac so tu nhien le "+tongc);
        

        //câu d: Các số tự nhiên là số nguyên tố <=N và tổng của chúng
        int tongd=0;
        System.out.print("Cac so tu nhien la so nguyen to <=N: ");
        for(int i=2; i<=N; i++){
            if(isPrime(i)){
                System.out.print(i+" ");
                tongd+=i;
           }
        }
        System.out.print("\nTong cac so "+tongd);
        sc.close();
    }
}
