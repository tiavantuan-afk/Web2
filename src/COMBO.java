import java.util.Scanner;

//lớp COMBO kế thừa từ lớp MonAn
public class COMBO extends MonAn {
	private double giaNiemYet;

    //hàm thiết lập
	public COMBO() {
		super();
		giaNiemYet = 0.0;
	}

    //hàm thiết lập có tham số
	public COMBO(String maSP, String tenSP, double giaBan, String soLuong, double giaNiemYet) {
		super(maSP, tenSP, giaBan, soLuong);
		this.giaNiemYet = giaNiemYet;
	}

    //hàm sao chép
	public COMBO(COMBO t) {
		super(t);
		if (t != null) {
			this.giaNiemYet = t.giaNiemYet;
		}
	}

    // Nhập xuất 
	@Override
	public void nhap() {
		Scanner sc = new Scanner(System.in);

		System.out.print("Nhap ma combo: ");
		maSP = sc.nextLine();

		System.out.print("Nhap ten combo: ");
		tenSP = sc.nextLine();

		System.out.print("Nhap gia ban: ");
		giaBan = sc.nextDouble();
		sc.nextLine();

		System.out.print("Nhap so luong: ");
		soLuong = sc.nextLine();

		System.out.print("Nhap gia niem yet: ");
		giaNiemYet = sc.nextDouble();
	}

	@Override
	public void xuat() {
		System.out.println("Ma combo: " + maSP);
		System.out.println("Ten combo: " + tenSP);
		System.out.println("Gia ban: " + giaBan);
		System.out.println("So luong: " + soLuong);
		System.out.println("Gia niem yet: " + giaNiemYet);
	}

	public double getGiaNiemYet() {
		return giaNiemYet;
	}

	public void setGiaNiemYet(double giaNiemYet) {
		this.giaNiemYet = giaNiemYet;
	}
}
