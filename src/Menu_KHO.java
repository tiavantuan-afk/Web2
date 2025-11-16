import java.util.Scanner;

public class Menu_KHO {
	private List_KHO quanLy;
	private Scanner sc;

	public Menu_KHO() {
		quanLy = new List_KHO();
		sc = new Scanner(System.in);
	}

	public void menu() {
		int luaChon = -1;
		do {
			System.out.println("\n--- MENU QUAN LY KHO HANG ---");
			System.out.println("1. Nhap danh sach hang hoa: ");
			System.out.println("2. Xuat danh sach hang hoa: ");
			System.out.println("3. Them mot hang hoa: ");
			System.out.println("4. Sua thong tin hang hoa:");
			System.out.println("5. Xoa mot hang hoa (Theo ma)");
			System.out.println("6. Xoa mot hang hoa (Theo ten)");
			System.out.println("7. Tim mot hang hoa (Theo ma)");
			System.out.println("8. Tim mot hang hoa (Theo ten)");
			System.out.println("9. Tim mot hang hoa (Theo gia)");
			System.out.println("10. Tim mot hang hoa (Theo so luong)");
			System.out.println("11. Thong ke hang hoa");
			System.out.println("0. Thoat");
			System.out.print("Vui long chon: ");
			luaChon = sc.nextInt();
			sc.nextLine();
			switch (luaChon) {
				case 1:
					quanLy.nhap();
					break;
				case 2:
					quanLy.xuat();
					break;
				case 3:
					System.out.println("Nhap thong tin hang hoa moi:");
					KHO khoMoi = new KHO();
					khoMoi.nhap();
					quanLy.getDskho()[quanLy.getN()] = khoMoi;
					quanLy.setN(quanLy.getN() + 1);
					System.out.println("Da them hang hoa.");
					break;
				case 4:
					System.out.print("Nhap ma hang can sua: ");
					int maSua = sc.nextInt();
					sc.nextLine();
					System.out.println("Nhap thong tin moi:");
					KHO khoSua = new KHO();
					khoSua.nhap();
					quanLy.suahang(maSua, khoSua);
					break;
				case 5:
					System.out.print("Nhap ma hang can xoa: ");
					int maXoa = sc.nextInt();
					sc.nextLine();
					quanLy.xoahang(maXoa);
					break;
				case 6:
					System.out.print("Nhap ten hang can xoa: ");
					String tenCanXoa = sc.nextLine();
					boolean timThay = false;
					for (int i = 0; i < quanLy.getN(); i++) {
						if (quanLy.getDskho()[i].getTenHang().toLowerCase().equalsIgnoreCase(tenCanXoa.toLowerCase())) {
							quanLy.xoahang(quanLy.getDskho()[i].getMaHang());
							timThay = true;
							break;
						}
					}
					if (!timThay) {
						System.out.println("Khong tim thay hang hoa co ten: " + tenCanXoa);
					}
					break;
				case 7:
					System.out.print("Nhap ma hang can tim: ");
					int maCanTim = sc.nextInt();
					sc.nextLine();
					quanLy.timkiemtheomaHang(maCanTim);
					break;
				case 8:
					System.out.print("Nhap ten hang can tim: ");
					String tenCanTim = sc.nextLine();
					quanLy.timkiemtheotenHang(tenCanTim);
					break;
				case 9:
					System.out.print("Nhap gia can tim: ");
					double giaCanTim = sc.nextDouble();
					sc.nextLine();
					quanLy.timkiemtheodonGia(giaCanTim);
					break;
				case 10:
					System.out.print("Nhap so luong can tim: ");
					int luongCanTim = sc.nextInt();
					sc.nextLine();
					quanLy.timkiemtheosoLuong(luongCanTim);
					break;
				case 11:
					System.out.print("Nhap ma hang can thong ke: ");
					int maThongKe = sc.nextInt();
					sc.nextLine();
					quanLy.thongkehang(maThongKe);
					break;
				case 0:
					System.out.println("Thoat chuong trinh.");
					break;
				default:
					System.out.println("Lua chon khong hop le, vui long chon lai.");
					break;
			}
		} while (luaChon != 0);
		sc.close();
	}

	public static void main(String[] args) {
		Menu_KHO menu = new Menu_KHO();
		menu.menu();
	}
}