import java.util.Scanner;

public class bai1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a= sc.nextInt();
        int b= sc.nextInt();
        
        int tong= a+b;
        int hieu= a-b;
        int tich= a*b;
        double thuong= (b!=0)?(double) a/b: Double.NaN;

        System.out.println("tong="+tong);
        System.out.println("hieu="+hieu);   
        System.out.println("tich="+tich);
        if(b!=0){
            System.out.println("thuong="+thuong);
        }else{
            System.out.println("Khong the chia cho 0!");
        }
        sc.close();
    }
}
