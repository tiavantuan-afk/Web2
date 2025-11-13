package doan;.Classchinh;

import java.util.Scanner;

public class NuocUong extends MonAn {
    private boolean coGas;
    private boolean loaiChai;
    private boolean coDa;

    public NuocUong() {
        super();
    }

    public NuocUong(String maSP, String tenSP, double giaBan, String soLuong, boolean coGas, boolean loaiChai,
            boolean coDa) {
        super(maSP, tenSP, giaBan, soLuong);
        this.coGas = coGas;
        this.loaiChai = loaiChai;
        this.coDa = coDa;
    }

    // GetSet
    public boolean isCoGas() {
        return coGas;
    }

    public void setCoGas(boolean coGas) {
        this.coGas = coGas;
    }

    public boolean isLoaiChai() {
        return loaiChai;
    }

    public void setLoaiChai(boolean loaiChai) {
        this.loaiChai = loaiChai;
    }

    public boolean isCoDa() {
        return coDa;
    }

    public void setCoDa(boolean coDa) {
        this.coDa = coDa;
    }

    @Override
    public void hienThiThongTin() {
        System.out.println("== Drinks ==");
        System.out.println("Ma SP" + getMaSP());
        System.out.println("Ten SP" + getTenSP());
        System.out.println("Gia Ban" + getGiaBan());
        System.out.println("So Luong" + getSoLuong());
        System.out.println("Co Gas" + (coGas ? "Co" : "Khong"));
        System.out.println("Co Da" + (coDa ? "Co" : "Khong"));
        System.out.println("Loai Chai" + (loaiChai ? "Co" : "Khong"));
        System.out.println("Tinh gia sau khuyen mai: " + tinhGiaSauKhuyenMai());
    }

    @Override
    public double tinhGiaSauKhuyenMai() {
        double gia = getGiaBan();
        if (coDa)
            gia += 2000;
        if (coGas)
            gia += 5000;
        return gia;
    }

    @Override
    public String getLoaiSanPham() {
        return "Nuoc Uong";
    }
}
