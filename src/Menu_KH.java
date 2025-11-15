import java.util.Scanner;
public class Menu_KH {
    private List_KHACHHANG quanly;
    private Scanner sc;
    public Menu_KH(){
        quanly = new List_KHACHHANG();
        Scanner sc = new Scanner(System.in);
    }
    public void menu(){
        int chon = -1;
        do{
            System.out.println("MENU QUAN LY KHACH HANG");
            System.out.println("1. Nhap danh sach khach hang: ");
            System.out.println("2. Xuat danh sach khach hang: ");
            System.out.println("3. Them khach hang: ");
            System.out.println("4. Sua thong tin khach hang: ");
            System.out.println("5. Xoa mot khach hang (theo ma): ");
            // System.out.println("6. Xoa mot khach hang (theo ho): ");
            // System.out.println("7. Xoa mot khach hang (theo ten): ");
            System.out.println("6. Tim mot khach hang (theo ma): ");
            System.out.println("7. Tim mot khach hang (theo ho): ");
            System.out.println("8. Tim mot khach hang (theo ten): ");
            System.out.println("9. Tim mot khach hang (theo so dien thoai): ");
            System.out.println("10. Thong ke khach hang: ");
            System.out.println("0. Thoat.");
            System.out.println("Vui long chon: ");
            chon = sc.nextInt();
            switch (chon) {
                case 1:
                    quanly.nhap();
                    break;
                case 2:
                    quanly.xuat();
                    break;
                case 3:
                    quanly.themkhachhang();
                    break;
                case 4: 
                    quanly.suakhachhang();
                    break;
                case 5:
                    quanly.xoakhachhang();
                    break;
                case 6:
                    quanly.timkiemtheoma();
                    break;
                case 7:
                    quanly.timkiemtheoten();
                    break;
                case 8:
                    quanly.timkiemtheoho();
                    break;
                case 9:
                    quanly.timkiemtheosdt();
                    break;
                case 10:
                    quanly.thongkekhachhang();
                    break;
                case 0:
                    System.out.println("Hip hop never die");
                    break;
                default:
                    System.out.println("Lua chon khong hop le");
                    break;
            }
        } while (chon != 0);
    }
    public static void main (String[] args){
        Menu_KH menu = new Menu_KH();
        menu.menu();
    }
}
