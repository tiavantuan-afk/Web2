package doan.Classchinh;

public abstract class MonAn {
    private String maSP;
    private String tenSP;
    private double giaBan;
    private String soLuong;

    // Không tham số
    public MonAn() {
        super();
    }

    // Có tham số
    public MonAn(String maSP, String tenSP, double giaBan, String soLuong) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.giaBan = giaBan;
        this.soLuong = soLuong;
    }

    // Sao chép
    public MonAn( MonAn x ) {
        this.maSP = x.maSP;
        this.tenSP = x.tenSP;
        this.giaBan = x.giaBan;
        this.soLuong = x.soLuong;
    }

    // Get & Set (đã sửa lỗi)
    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public String getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(String soLuong) {
        this.soLuong = soLuong;
    }

    // Đa hình
    public abstract void hienThiThongTin();

    public abstract double tinhGiaSauKhuyenMai();

    public abstract String getLoaiSanPham();
}
