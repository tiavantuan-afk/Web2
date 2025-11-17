import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class List_PN {
    Scanner sc = new Scanner(System.in);
    private int n;
    private Phieunhaphang[] ds = new Phieunhaphang[100];

    public void nhap() {
        System.out.print("So luong phieu nhap hang: ");
        n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Phieu nhap hang thu " + (i + 1) + ":");
            ds[i] = new Phieunhaphang();
            ds[i].nhap();
        }
    }

    public void xuat() {
        System.out.println("DANH SACH PHIEU NHAP HANG");
        for (int i = 0; i < n; i++) {
            System.out.println(ds[i]);
        }
    }
    
    public void docFile(String tenFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(tenFile))) {
            String line;
            n = 0;
            while ((line = br.readLine()) != null && n < 100) {
                String[] parts = line.split(",");
                if (parts.length >= 5) {
                    ds[n] = new Phieunhaphang();
                    ds[n].setmaPNH(parts[0].trim());
                    ds[n].setmaNV(parts[1].trim());
                    ds[n].setngay(parts[2].trim());
                    ds[n].setncc(parts[3].trim());
                    n++;
                }
            }
            System.out.println("Đọc file thành công, tổng số phieu nhap hang: " + n);
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
    }

    public void WriteOne(String tenFile, int index) {
        if (index < 0 || index >= n) {
            System.out.println("Vị trí không hợp lệ!");
            return;
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(tenFile))) {
            String line =
                ds[index].getmaPNH() + "," +
                ds[index].getmaNV() + "," +
                ds[index].getngay() + "," +
                ds[index].getmancc();
            bw.write(line);
            bw.newLine();
            System.out.println("Đã ghi 1 chi tiết vào file!");
       }catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }
    public void WriteAll(String tenFile) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(tenFile))) {
            for (int i = 0; i < n; i++) {
                String line =
                    ds[i].getmaPNH() + "," +
                    ds[i].getmaNV() + "," +
                    ds[i].getngay() + "," +
                    ds[i].getmancc();
                bw.write(line);
                bw.newLine();
            }
            System.out.println("Đã ghi tất cả vào file!");
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    public void themtheoma(){
        System.out.println("Mã cần thêm: ");
        String macanthem = sc.nextLine();
        boolean themma = false;
        for(int i = 0;i < n; i++){
            if(ds[i].getmaPNH().equalsIgnoreCase(macanthem)){
                themma = true;
                return;
                }
            }
            if(themma){
                System.out.print("Mã " + macanthem + "đã tồn tại trong danh sách");
            }
            if(n >= 100){
                System.out.print("Danh sách đã đầy");
                return;
            }
            System.out.println("Nhập thông tin phiêu nhap hang mới có mã " + macanthem);
            ds[n] = new Phieunhaphang();
            ds[n].nhap();
            ds[n].setmaPNH(macanthem);
            n++;
    }

    public void timTheoMa() {
        System.out.print("Nhap ma can tim: ");
        String ma = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getmaPNH().equalsIgnoreCase(ma)) {
                System.out.println("Tim thay: " + ds[i]);
                return;
            }
        }
        System.out.println("Khong tim thay!");
    }
    
    public void xoatheoma(){
        System.out.print("Mã cần xoá: ");
        String macanxoa = sc.nextLine();
        boolean daxoa = false;
        for(int i = 0;i < n; i++){
            if(ds[i].getmaPNH().equalsIgnoreCase(macanxoa)){
                for(int j = i;j < n-1;j++){
                    ds[j] = ds[j+1];
                }
                ds[n-1] = null;
                n--;
                daxoa = true;
                System.out.println("Đã xoá phieu nhap hang có mã " + macanxoa);
                return;
            }
        }
        if(!daxoa){
            System.out.println("Không tìm thấy phieu nhap hang có mã" + macanxoa);
        }
    }

    public void suatheoma(){
        System.out.println("Mã cần sửa: ");
        String macansua = sc.nextLine();
        boolean dasua = false;
        for(int i = 0; i < n; i++){
            if(ds[i].getmaPNH().equalsIgnoreCase(macansua)){
                System.out.println("Tìm thấy phieu nhap hang: ");
                ds[i].toString();
                System.out.println("Thông tin cần sửa cho phieu nhap hang: ");
                ds[i] = new Phieunhaphang();
                ds[i].toString();
                System.out.println("Đã sửa thông tin cho phieu nhap hang có mã "+ macansua);
                dasua = true;
                return;
            }
        }
        if(!dasua){
            System.out.println("Không tìm thấy phieu nhap hang có mã "+ macansua);
        }
    }
    public void thongketheongay() {
        String[] ngaydadem = new String[100];
        int[] soLuong = new int[100];
        int dem = 0;
        for (int i = 0; i < n; i++) {
            String ho = ds[i].getngay();
            int index = -1;
            for (int j = 0; j < dem; j++) {
                if (ngaydadem[j].equalsIgnoreCase(ho)) {
                    index = j;
                    break;
                }
            }
            if (index == -1) { 
                ngaydadem[dem] = ho;
                soLuong[dem] = 1;
                dem++;
            } else {
                soLuong[index]++;
            }
        }
        System.out.println("\nThong ke theo ho");
        System.out.printf("%-15s %-10s\n", "Họ", "Số lượng");
        for (int i = 0; i < dem; i++) {
            System.out.printf("%-15s %-10d\n", ngaydadem[i], soLuong[i]);
        }
    }
}

