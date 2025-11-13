package doan.DocGhiFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class docghiKH {

    public static int docKhachHang(String tenFile, KhachHang[] ds){
        int n = 0;
        try{
            Scanner sc = new Scanner(new File(tenFile));
            while(sc.hasNextLine()){
                String[] t = sc.nextLine().split(";");
                ds[n] = new KhachHang(t[0], t[1], t[2]);
                n++;
            }
            sc.close();
        } catch(IOException e){
            System.out.println(" Lỗi đọc file khách hàng");
        }
        return n;
    }

    public static void ghiKhachHang(String tenFile, KhachHang[] ds, int n){
        try{
            FileWriter fw = new FileWriter(tenFile);
            for(int i = 0; i < n; i++){
                fw.write(ds[i].getMaKH() + ";" + ds[i].getTenKH() + ";" + ds[i].getSdt() + "\n");
            }
            fw.close();
            System.out.println(" Đã ghi khách hàng");
        } catch(IOException e){
            System.out.println(" Lỗi ghi file khách hàng");
        }
    }
}
