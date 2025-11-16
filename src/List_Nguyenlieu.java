import java.util.Scanner;
import java.util.Arrays;

public class List_Nguyenlieu {
	private Nguyenlieu[] ds;
	private int n;
	private Scanner sc = new Scanner(System.in);

	public List_Nguyenlieu() {
		n = 0;
		ds = new Nguyenlieu[0];
	}

	public List_Nguyenlieu(int n) {
		this.n = n;
		ds = new Nguyenlieu[n];
	}

	public void nhap() {
		System.out.println("Nhap so luong nguyen lieu: ");
		n = sc.nextInt();
		sc.nextLine();
		ds = new Nguyenlieu[n];
		for (int i = 0; i < ds.length; i++) {
			System.out.println("\nNhap nguyen lieu so " + (i + 1) + " :");
			ds[i] = new Nguyenlieu();
			ds[i].nhap();
		}
	}

	public void xuat() {
		if (ds.length == 0) {
			System.out.println("Danh sach rong");
			return;
		}
		System.out.println("So luong nguyen lieu: " + ds.length);
		System.out.println(
				"----------------------------------------------------------------------------------------------");
		for (int i = 0; i < ds.length; i++) {
			if (ds[i] != null) {
				System.out.println((i + 1) + ". " + ds[i].toString());
			}
		}
	}

	public boolean TonTai(String maNL) {
		if (maNL == null)
			return false;
		for (int i = 0; i < ds.length; i++) {
			if (ds[i] != null && ds[i].getmaNL() != null &&
					ds[i].getmaNL().equalsIgnoreCase(maNL)) {
				return true;
			}
		}
		return false;
	}

	public void them() {
		ds = Arrays.copyOf(ds, ds.length + 1);
		System.out.println("Nhap thong tin nguyen lieu can them: ");
		Nguyenlieu nl = new Nguyenlieu();
		nl.nhap();
		ds[ds.length - 1] = nl;
		System.out.println("Da them thanh cong");
	}

	public void sua() {
		if (ds.length == 0) {
			System.out.println("Khong co trong danh sach! ");
			return;
		}
		System.out.print("Nhap ma nguyen lieu can sua: ");
		String maNL = sc.nextLine();

		int v = -1;
		for (int i = 0; i < ds.length; i++) {
			if (ds[i] != null && ds[i].getmaNL() != null && ds[i].getmaNL().equalsIgnoreCase(maNL)) {
				v = i;
				break;
			}
		}

		if (v == -1) {
			System.out.println("Khong tim thay nguyen lieu co ma:" + maNL);
			return;
		}

		System.out.println("Thong tin hien tai: ");
		System.out.println(ds[v].toString());

		System.out.println("Nhap thong tin moi cho nguyen lieu: ");
		Nguyenlieu nl = new Nguyenlieu();
		nl.nhap();
		ds[v] = nl;
		System.out.println("Da sua thanh cong");
		System.out.println("Thong tin da sua: " + ds[v].toString());
	}

	public void xoaTheoMa(String maNL) {
		boolean found = false;
		for (int i = 0; i < ds.length; i++) {
			if (ds[i] != null && ds[i].getmaNL() != null &&
					ds[i].getmaNL().equalsIgnoreCase(maNL)) {
				System.out.println("Nguyen lieu can xoa: ");
				System.out.println(ds[i].toString());

				for (int j = i; j < ds.length - 1; j++) {
					ds[j] = ds[j + 1];
				}

				ds = Arrays.copyOf(ds, ds.length - 1);
				System.out.println("Da xoa thanh cong ");
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("Khong tim thay nguyen lieu co ma:" + maNL);
		}
	}

	public void xoaTheoTen(String tenNL) {
		boolean found = false;
		for (int i = 0; i < ds.length; i++) {
			if (ds[i] != null && ds[i].gettenNL() != null &&
					ds[i].gettenNL().equalsIgnoreCase(tenNL)) {
				System.out.println("Nguyen lieu can xoa: ");
				System.out.println(ds[i].toString());

				for (int j = i; j < ds.length - 1; j++) {
					ds[j] = ds[j + 1];
				}

				ds = Arrays.copyOf(ds, ds.length - 1);
				System.out.println("Da xoa thanh cong ");
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("Khong tim thay ten nguyen lieu " + tenNL);
		}
	}

	public void timKiemMa(String maNL) {
		boolean found = false;
		for (int i = 0; i < ds.length; i++) {
			if (ds[i] != null && ds[i].getmaNL() != null &&
					ds[i].getmaNL().equalsIgnoreCase(maNL)) {
				System.out.println("Da tim thay nguyen lieu: ");
				System.out.println(ds[i].toString());
				System.out.println();
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("Khong tim thay nguyen lieu co ma: " + maNL);
		}
	}

	public void timKiemTen(String tenNL) {
		boolean found = false;
		for (int i = 0; i < ds.length; i++) {
			if (ds[i] != null && ds[i].gettenNL() != null &&
					ds[i].gettenNL().equalsIgnoreCase(tenNL)) {
				System.out.println("Da tim thay nguyen lieu: ");
				System.out.println(ds[i].toString());
				System.out.println();
				found = true;
				break;
			}
		}
		if (!found) {
			System.out.println("Khong tim thay nguyen lieu: " + tenNL);
		}
	}

	public void thongKe() {
		if (ds.length == 0) {
			System.out.println("Danh sach rong");
			return;
		}

		int tongSo = ds.length;
		double tongGiaTri = 0;
		double giaMax = 0;
		double giaMin = Double.MAX_VALUE;
		String tenGiaMax = "";
		String tenGiaMin = "";

		for (int i = 0; i < ds.length; i++) {
			if (ds[i] != null) {
				double gia = ds[i].getdongia();
				tongGiaTri += gia;

				if (gia > giaMax) {
					giaMax = gia;
					tenGiaMax = ds[i].gettenNL();
				}
				if (gia < giaMin) {
					giaMin = gia;
					tenGiaMin = ds[i].gettenNL();
				}
			}
		}

		System.out.println("\n========== THONG KE NGUYEN LIEU ==========");
		System.out.println("Tong so nguyen lieu: " + tongSo);
		System.out.printf("Tong gia tri: %.2f VND\n", tongGiaTri);
		System.out.printf("Gia tri trung binh: %.2f VND\n", (tongSo > 0 ? tongGiaTri / tongSo : 0));
		System.out.printf("Gia cao nhat: %.2f VND (%s)\n", giaMax, tenGiaMax);
		System.out.printf("Gia thap nhat: %.2f VND (%s)\n", giaMin, tenGiaMin);
		System.out.println("-----------------------------------------------------");
	}

	// Getter va Setter
	public Nguyenlieu[] getDs() {
		return ds;
	}

	public void setDs(Nguyenlieu[] ds) {
		this.ds = ds;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}
}
