public class Menu_ncc extends Menu_Main {

    @Override
    public void menu() {
        int chon = -1;
        do {
            System.out.println("\n1. Nhập danh sách nhà cung cấp");
            System.out.println("2. Xuất danh sách nhà cung cấp");
            System.out.println("3. Tìm kiếm nhà cung cấp theo mã");
            System.out.println("4. Thêm nhà cung cấp theo mã");
            System.out.println("5. Xóa nhà cung cấp theo mã");
            System.out.println("6. Sửa nhà cung cấp theo mã");
            System.out.println("7. Thống kê nhà cung cấp theo họ");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");
            chon = sc.nextInt();
            sc.nextLine();
            switch (chon) {
                case 1:
                    DSNCC.nhap();
                    DSNCC.ghiFile();
                    break;
                case 2:
                    DSNCC.xuat();
                    break;
                case 3:
                    System.out.print("Nhập mã cần tìm: ");
                    String maTim = sc.nextLine();
                    DSNCC.timtheoma(maTim);
                    break;
                case 4:
                    DSNCC.themtheoma();
                    DSNCC.ghiFile();
                    break;
                case 5:
                    System.out.print("Nhập mã cần xóa: ");
                    String maXoa = sc.nextLine();
                    DSNCC.xoatheoma(maXoa);
                    DSNCC.ghiFile();
                    break;
                case 6:
                    System.out.print("Nhập mã cần sửa: ");
                    String maSua = sc.nextLine();
                    DSNCC.suatheoma(maSua);
                    DSNCC.ghiFile();
                    break;
                case 7:
                    DSNCC.thongketheohoncc();
                    break;
                case 0:
                    System.out.println("Thoát");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại");
                    break;
            }
        } while (chon != 0);
    }

    public static void main(String[] args) {
        Menu_ncc menu = new Menu_ncc();
        menu.menu();
    }
}
