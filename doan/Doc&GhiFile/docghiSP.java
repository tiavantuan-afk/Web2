package doan.DocGhiFile;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// Tiện ích đọc/ghi theo dòng cho file sản phẩm (đơn giản).
// Bộ đọc hai bước sử dụng mảng (không dùng ArrayList) để dễ gõ tay.
public class docghiSP {

    // Đọc tất cả các dòng không rỗng từ file và trả về mảng String[]
    // Cài đặt: bước 1 đếm số dòng không rỗng, bước 2 ghi nội dung vào mảng.
    public static String[] docFile(String tenFile) {
    int n = 0;
        // bước 1: đếm dòng (không dùng thư viện nâng cao)
        Scanner doc = null;
        try {
            doc = new Scanner(new File(tenFile));
            while (doc.hasNextLine()) {
                String dong = doc.nextLine();
                if (dong!= null) {
                    dong = dong.trim();  // loại bỏ khoảng trắng đầu cuối
                    if (!dong.isEmpty()) 
                    n++;
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi đọc file: " + e.getMessage());
            if (doc != null) doc.close();
            return new String[0];
        } finally {
            if (doc != null) doc.close();
        }

    String[] lines = new String[n];
    int i = 0;
        // bước 2: điền mảng
        doc = null;
        try {
            doc = new Scanner(new File(tenFile));
            while (doc.hasNextLine()) {
                String line = doc.nextLine();
                if (line != null) {
                    line = line.trim();
                    if (!line.isEmpty()) {
                        lines[i] = line;
                        i = i + 1;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi đọc file (fill): " + e.getMessage());
            if (doc != null) doc.close();
            return new String[0];
        } finally {
            if (doc != null) doc.close();
        }
        return lines;
    }

    // Ghi mảng dòng ra file (ghi đè). Mỗi phần tử thành một dòng.
    public static void ghiFile(String tenFile, String[] lines) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(tenFile);
            if (lines != null) {
                for (int i = 0; i < lines.length; i++) {
                    String l = lines[i];
                    if (l == null) l = "";
                    fw.write(l);
                    fw.write("\n");
                }
            }
            System.out.println("Ghi file thành công: " + tenFile);
        } catch (Exception e) {
            System.out.println("Lỗi ghi file: " + e.getMessage());
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException ex) {
                    // bỏ qua
                }
            }
        }
    }

    // Tương tự docghiKH: đọc trực tiếp vào mảng String[] do caller cấp phát
    // Trả về số lượng phần tử đã đọc
    public static int docSanPham(String tenFile, String[] ds) {
        int n = 0;
        Scanner doc = null;
        try {
            doc = new Scanner(new File(tenFile));
            while (doc.hasNextLine()) {
                String dong = doc.nextLine();
                if (dong != null) {
                    dong = dong.trim();
                    if (!dong.isEmpty()) {
                        ds[n] = dong;
                        n = n + 1;
                    }
                }
            }
            if (doc != null) doc.close();
        } catch (Exception e) {
            System.out.println("Lỗi đọc file san pham: " + e.getMessage());
            if (doc != null) doc.close();
        }
        return n;
    }

    // Ghi mảng String[] (số phần tử n) ra file (ghi đè)
    public static void ghiSanPham(String tenFile, String[] ds, int n) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(tenFile);
            if (ds != null) {
                for (int i = 0; i < n; i++) {
                    String l = ds[i];
                    if (l == null) l = "";
                    fw.write(l);
                    fw.write("\n");
                }
            }
            System.out.println("Ghi file san pham thành công: " + tenFile);
        } catch (Exception e) {
            System.out.println("Lỗi ghi file san pham: " + e.getMessage());
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException ex) {
                    // bỏ qua
                }
            }
        }
    }

}
