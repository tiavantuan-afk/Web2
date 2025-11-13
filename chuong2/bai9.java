package chuong2;

import java.util.Scanner;

public class bai9 {
   private String maSV;
    private String ho;
    private String ten;
    private String lop;
    private String ngaySinh;
    private String thangSinh;
    private String namSinh;
    private String maKhoa;


    // Hàm thiết lập không tham số
    public bai9() {
        maSV = "";
        ho = "";
        ten = "";
        lop = "";
        ngaySinh = "";
        thangSinh = "";
        namSinh = "";
        maKhoa = "";

    }
    // Hàm thiết lập có tham số
    public bai9(String maSV, String ho, String ten, String lop, String ngaySinh, String thangSinh, String namSinh, String maKhoa) {
        this.maSV = maSV;
        this.ho = ho;
        this.ten = ten;
        this.lop = lop;
        this.ngaySinh = ngaySinh;
        this.thangSinh = thangSinh;
        this.namSinh = namSinh;
        this.maKhoa = maKhoa;
    }

    public void nhap(){
        Scanner sc= new Scanner(System.in);
        System.out.print("Nhap ma sinh vien: ");
        maSV = sc.nextLine();
        System.out.print("Nhap ho sinh vien: ");
        ho = sc.nextLine();
        System.out.print("Nhap ten sinh vien: ");
        ten = sc.nextLine();
        System.out.print("Nhap lop sinh vien: ");
        lop= sc.nextLine();
        System.out.print("Nhap ngay sinh sinh vien: ");
        ngaySinh = sc.nextLine();
        System.out.print("Nhap thang sinh sinh vien: ");
        thangSinh = sc.nextLine();
        System.out.print("Nhap nam sinh sinh vien: ");
        namSinh = sc.nextLine();
        System.out.print("Nhap ma khoa sinh vien: ");
        maKhoa = sc.nextLine();
    }
    public void xuat() {
        System.out.println("Ma sinh vien: " + maSV);
        System.out.println("Ho sinh vien: " + ho);
        System.out.println("Ten sinh vien: " + ten);
        System.out.println("Lop sinh vien: " + lop);
        System.out.println("Ngay sinh sinh vien: " + ngaySinh);
        System.out.println("Thang sinh sinh vien: " + thangSinh);   
        System.out.println("Nam sinh sinh vien: " + namSinh);
        System.out.println("Ma khoa sinh vien: " + maKhoa);
    }

    public String getmaSV() {
        return maSV;
    }
    public void setMaSV(String maHV) {
        this.maSV = maSV;
    }
    public String getHo() {
        return ho;
    }
    public void setHo(String ho) {
        this.ho = ho;
    }
    public String getTen() {
        return ten;
    }
    public void setTen(String ten) {
        this.ten = ten;
    }
    public String getLop() {
        return lop;
    }
    public void setLop(String lop) {
        this.lop = lop;
    }
    public String getNgaySinh() {
        return ngaySinh;
    }
    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    public String getThangSinh() {
        return thangSinh;
    }
    public void setThangSinh(String thangSinh) {
        this.thangSinh = thangSinh;
    }
    public String getNamSinh() {
        return namSinh;
    }
    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
    }
    public String getMaKhoa() {
        return maKhoa;
    }
    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

}
