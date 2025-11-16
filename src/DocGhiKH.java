

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Mỗi khách hàng chiếm 4 dòng liên tiếp:
 *  - họ
 *  - tên
 *  - Makh (số nguyên)
 *  - SDT (số nguyên)
 */
class DocGhiKH {
	public static int docKhachHang(String tenFile, KHACHHANG[] ds) {
		int n = 0;
		Scanner sc = null;
		try {
			sc = new Scanner(new File("KhachHang.txt"));
			while (true) {
				// đọc họ
				String ho = null;
				while (sc.hasNextLine()) {
					ho = sc.nextLine().trim();
					if (!ho.isEmpty()) break; // bỏ qua dòng rỗng
					ho = null;
				}
				if (ho == null) break; // hết file

				// đọc tên (nếu không có thì rỗng)
				String ten = "";
				if (sc.hasNextLine()) ten = sc.nextLine().trim();

				// đọc Makh
				int Makh = 0;
				if (sc.hasNextLine()) {
					String s = sc.nextLine().trim();
					try { Makh = Integer.parseInt(s); } catch (Exception ex) { Makh = 0; }
				}

				// đọc SDT
				int SDT = 0;
				if (sc.hasNextLine()) {
					String s = sc.nextLine().trim();
					try { SDT = Integer.parseInt(s); } catch (Exception ex) { SDT = 0; }
				}

			ds[n++] = new KHACHHANG(ho, ten, Makh, SDT);
		}
		} catch (Exception e) {
			System.out.println("Lỗi đọc file khách hàng: " + e.toString());
		}
		return n;
	}	

    public static void ghiKhachHang(String tenFile, KHACHHANG[] ds, int n) {
		FileWriter fw = null;
		try {
			fw = new FileWriter("KhachHang.txt");
			if (ds != null) {
				for (int i = 0; i < n; i++) {
					KHACHHANG k = ds[i];
					if (k == null) continue;
					String ho = k.getHo() == null ? "" : k.getHo();
					String ten = k.getTen() == null ? "" : k.getTen();
					fw.write(ho + System.lineSeparator());
					fw.write(ten + System.lineSeparator());
					fw.write(Integer.toString(k.getMaKH()) + System.lineSeparator());
					fw.write(Integer.toString(k.getSDT()) + System.lineSeparator());
					// thêm một dòng trống giữa bản ghi để dễ đọc tay
					fw.write(System.lineSeparator());
				}
			}
		} catch (Exception e) {
			System.out.println("Lỗi ghi file khách hàng: " + e.toString());
		}
	}
}


