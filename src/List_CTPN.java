import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class List_CTPN {
    Scanner sc = new Scanner(System.in);
    private int n;
    private Chitietphieunhap[] ds = new Chitietphieunhap[100];

    public void nhap() {
        System.out.print("So luong chi tiet phieu nhap: ");
        n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Chi tiet phieu nhap " + (i + 1) + ":");
            ds[i] = new Chitietphieunhap();
            ds[i].nhap();
        }
    }

    public void xuat() {
        System.out.println("DANH SACH CHI TIET PHIEU NHAP");
        for (int i = 0; i < n; i++) {
            System.out.println(ds[i]);
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
    public void docFile(String tenFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(tenFile))) {
            String line;
            n = 0;
            while ((line = br.readLine()) != null && n < 100) {
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    ds[n] = new Chitietphieunhap();
                    ds[n].setmaNH(parts[0].trim());
                    ds[n].setmaSP(parts[1].trim());
                    ds[n].setsoluong(Integer.parseInt(parts[2].trim()));
                    ds[n].setdongia(Double.parseDouble(parts[3].trim()));
                    n++;
                }
            }
            System.out.println("Đọc file thành công, tổng số chi tiet phieu nhap: " + n);
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
                ds[index].getmaNH() + "," +
                ds[index].getmaSP() + "," +
                ds[index].getsoluong() + "," +
                ds[index].getdongia();
            bw.write(line);
            bw.newLine();
            System.out.println("Đã ghi 1 chi tiet vào file!");
       }catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }
    public void WriteAll(String tenFile) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(tenFile))) {
            for (int i = 0; i < n; i++) {
                String line =
                    ds[i].getmaNH() + "," +
                    ds[i].getmaSP() + "," +
                    ds[i].getsoluong() + "," +
                    ds[i].getdongia();
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
            if(ds[i].getmaNH().equalsIgnoreCase(macanthem)){
                themma = true;
                return;
                }
            }
            if(themma){
                System.out.print("Mã chi tiết phiếu nhập " + macanthem + "đã tồn tại trong danh sách");
            }
            if(n >= 100){
                System.out.print("Danh sách chi tiết phiếu nhập đã đầy");
                return;
            }
            System.out.println("Nhập thông tin chi tiết phiếu nhập mới có mã " + macanthem);
            ds[n] = new Chitietphieunhap();
            ds[n].nhap();
            ds[n].setmaNH(macanthem);
            n++;
    }

    public void timTheoMa() {
        System.out.print("Nhap ma can tim: ");
        String ma = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (ds[i].getmaNH().equalsIgnoreCase(ma)) {
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
            if(ds[i].getmaNH().equalsIgnoreCase(macanxoa)){
                for(int j = i;j < n-1;j++){
                    ds[j] = ds[j+1];
                }
                ds[n-1] = null;
                n--;
                daxoa = true;
                System.out.println("Đã xoá chi tiết phiếu nhập có mã " + macanxoa);
                break;
            }
        }
        if(!daxoa){
            System.out.println("Không tìm thấy chi tiết phiếu nhập có mã" + macanxoa);
        }
    }

    public void suatheoma(){
        System.out.println("Mã cần sửa: ");
        String macansua = sc.nextLine();
        boolean dasua = false;
        for(int i = 0; i < n; i++){
            if(ds[i].getmaNH().equalsIgnoreCase(macansua)){
                System.out.println("Tìm thấy chi tiết phiếu nhập: ");
                ds[i].toString();
                System.out.println("Thông tin cần sửa cho chi tiết phiếu nhập: ");
                ds[i] = new Chitietphieunhap();
                ds[i].toString();
                System.out.println("Đã sửa thông tin cho chi tiết phiếu nhập có mã "+ macansua);
                dasua = true;
                break;
            }
        }
        if(!dasua){
            System.out.println("Không tìm thấy chi tiết phiếu nhập có mã "+ macansua);
        }
    }
}
