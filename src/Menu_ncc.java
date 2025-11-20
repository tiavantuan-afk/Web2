public class Menu_ncc extends Menu_Main {
    @Override
    public void menu() {
        int chon = -1;
        do {
            System.out.println("\n1.Nhap danh sach nha cung cap");
            System.out.println("2.Xuat danh sach nha cung cap");
            System.out.println("3.Tim kiem nha cung cap theo ma");
            System.out.println("4.Them nha cung cap theo ma");
            System.out.println("5.Xoa nha cung cap theo ma");
            System.out.println("6.Sua nha cung cap theo ma");
            System.out.println("7.Thong ke nha cung cap theo ho");
            System.out.println("8.Quay lai Menu chinh");
            System.out.println("0.Thoat");
            System.out.print("Chon chuc nang: ");
            chon = sc.nextInt();
            sc.nextLine();
            switch (chon) {
                case 1:
                    DSNCC.nhap();
                    break;
                case 2:
                    DSNCC.xuat();
                    break;
                case 3:
                    list.timtheoma(fileName);
                    break;
                case 4:
                    DSNCC.themtheoma();
                    break;
                case 5:

                    DSNCC.themtheodiachi();
                    break;
                case 6:
                    DSNCC.xoatheoma();
                    break;
                    list.thongketheohoncc();
                    break;
                case 8:
                    System.out.print("Quay ve menu chinh");
                    Menu_Main menuMain = new Menu_Main();
                    menuMain.menuChinh();

                case 0:
                    System.out.println("Thoát");
                    return;
                default:
                    System.out.println("Lua chon khong hop le, vui long chon lai");
            }
        } while (chon != 0);
        sc.close();
    }

}
