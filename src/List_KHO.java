import java.util.Scanner;

public class List_KHO {
	Scanner sc = new Scanner(System.in);
	private int n;
	private KHO[] dskho = new KHO[100];

	public void nhap() {
		System.out.print("Nhap n hang hoa: ");
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.print("Nhap hang hoa thu: " + (i + 1) + "\n");
			dskho[i] = new KHO();
			dskho[i].nhap();
		}
	}

	public void xuat() {
		System.out.println("Danh sach hang hoa: ");
		for (int i = 0; i < n; i++) {
			dskho[i].xuat();
		}
	}

	public void timkiemtheomaHang(int macanTim) {
		boolean timKiem = false;
		for (int i = 0; i < n; i++) {
			if (dskho[i].getMaHang() == macanTim) {
				timKiem = true;
				dskho[i].xuat();
			}
		}
		if (!timKiem) {
			System.out.println("Khong co trong danh sach.");
		}
	}

	public void timkiemtheotenHang(String tenCanTim) {
		boolean timKiem = false;
		for (int i = 0; i < n; i++) {
			if (dskho[i].getTenHang().toLowerCase().equalsIgnoreCase(tenCanTim.toLowerCase())) {
				timKiem = true;
				dskho[i].xuat();
			}
		}
		if (!timKiem) {
			System.out.println("Khong co trong danh sach.");
		}
	}

	public void timkiemtheodonGia(double giaCanTim) {
		boolean timKiem = false;
		for (int i = 0; i < n; i++) {
			if (dskho[i].getDonGia() == giaCanTim) {
				timKiem = true;
				dskho[i].xuat();
			}
		}
		if (!timKiem) {
			System.out.println("Khong co trong danh sach.");
		}
	}

	public void timkiemtheosoLuong(int luongCanTim) {
		boolean timKiem = false;
		for (int i = 0; i < n; i++) {
			if (dskho[i].getSoLuong() == luongCanTim) {
				timKiem = true;
				dskho[i].xuat();
			}
		}
		if (!timKiem) {
			System.out.println("Khong co trong danh sach.");
		}
	}

	public void xoahang(int MAHANG) {
		boolean timKiem = false;
		for (int i = 0; i < n; i++) {
			if (dskho[i].getMaHang() == MAHANG) {
				for (int j = i; j < n - 1; j++) {
					dskho[j] = dskho[j + 1];
				}
				dskho[n - 1] = null;
				n--;
				System.out.println("Da xoa hang hoa co ma: " + MAHANG);
				timKiem = true;
				break;
			}
		}
		if (!timKiem) {
			System.out.println("Khong tim thay hang hoa co ma: " + MAHANG);
		}
	}

	public void suahang(int MA, KHO kho) {
		boolean timKiem = false;
		for (int i = 0; i < n; i++) {
			if (dskho[i].getMaHang() == MA) {
				dskho[i] = kho;
				System.out.println("Da cap nhat thong tin hang hoa: " + MA);
				timKiem = true;
				break;
			}
		}
		if (!timKiem) {
			System.out.println("Khong tim thay hang hoa de sua: ");
		}
	}

	public void thongkehang(int mahang) {
		int d = 0;
		for (int i = 0; i < n; i++) {
			if (dskho[i].getMaHang() == mahang) {
				d++;
			}
		}
		if (d >= 1) {
			System.out.println("Hang hoa ton kho");
		} else {
			System.out.println("Hang hoa khong con");
		}
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public KHO[] getDskho() {
		return dskho;
	}

	public void setDskho(KHO[] dskho) {
		this.dskho = dskho;
	}
}
