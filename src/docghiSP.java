import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Đọc/ghi sản phẩm theo định dạng dễ sửa tay:
 * Mỗi sản phẩm chiếm 1 dòng.
 * Dòng rỗng bị bỏ qua khi đọc.
 */
class DocGhiSP {
	public static int docSanPham(String tenFile, String[] ds) {
		int n = 0;
		Scanner sc = null;
		try {
			sc = new Scanner(new File("MonAn.txt"));
			while (sc.hasNextLine()) {
				String dong = sc.nextLine().trim();
				if (!dong.isEmpty()) {
					ds[n++] = dong;
				}
			}
		} catch (Exception e) {
			System.out.println("Lỗi đọc file san pham: " + e.toString());
		}
		return n;
	}

    public static void ghiSanPham(String tenFile, String[] ds, int n) {
        FileWriter fw = null;
        try {
            fw = new FileWriter("MonAn.txt");
            if (ds != null) {
                for (int i = 0; i < n; i++) {
                    String l = ds[i];
                    if (l == null) l = "";
                    fw.write(l);
                    fw.write(System.lineSeparator());
                }
            }
            System.out.println("Ghi file san pham thành công: " + tenFile);
        } catch (Exception e) {
            System.out.println("Lỗi ghi file san pham: " + e.toString());
        }
    }

}
