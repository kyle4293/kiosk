package org.example;

import java.time.LocalDateTime;
import java.util.*;

public class MenuController {
    public static LocalDateTime completeTime;

    public static void displayManagementMenu(List<Menu> menuList, List<Order> completeList, List<Order> waitList, Scanner sc) {
        System.out.println("__________________________________\n");
        System.out.println("[ SHAKESHACK 관리프로그램 ]");

        int i = 0;

        System.out.println("[ ORDER MENU ]");
        System.out.println(String.format("%-2d. %-15s | %s", (++i), "Wait", "대기주문 목록"));
        System.out.println(String.format("%-2d. %-15s | %s", (++i), "Complete", "완료주문 목록"));
        System.out.println(String.format("%-2d. %-15s | %s", (++i), "Create", "상품 생성"));
        System.out.println(String.format("%-2d. %-15s | %s", (++i), "Delete", "상품 삭제"));

        int choice = sc.nextInt();
        if (choice == 1) {
            displayWaitList(completeList, waitList, sc);
        } else if (choice == 2) {
            displayCompleteList(completeList);
        } else if (choice == 3) {
            System.out.println("--------------------------------------------------");
            System.out.println("1. 상품 생성        2. 메뉴 생성");
            int num = sc.nextInt();
            if(num==1){
                System.out.println("--------------------------------------------------");
                System.out.println(" 상품을 추가할 메뉴를 선택해 주세요.");
                displayMenu1(menuList);

                int num1=sc.nextInt();
                Menu m = menuList.get(num1-1);
                System.out.println(m.getName());
                displayCreateProduct(m);
            }
            else if(num==2) {
                displayCreateMenu(menuList, sc);
            }

        } else if (choice==4) {
            System.out.println("--------------------------------------------------\n");
            System.out.println("1. 상품 제거        2. 메뉴 제거");
            int num = sc.nextInt();
            if(num==1){
                System.out.println("--------------------------------------------------\n");
                System.out.println(" 삭제할 상품이 있는 메뉴를 선택해 주세요.");
                displayMenu1(menuList);

                int num1=sc.nextInt();
                Menu m = menuList.get(num1-1);
                displayDeleteProduct(m,sc);
            }
            else if(num==2) {
                displayDeleteMenu(menuList, sc);
            }


        }

    }
    public static void displayDeleteMenu(List<Menu> menuList, Scanner sc) {
        System.out.println("삭제할 메뉴을 선택해 주세요. ");
        displayMenu1(menuList);
        int choice;
        choice = sc.nextInt()-1;

        Menu m = menuList.get(choice);
        System.out.println("--------------------------------------------------\n");
        System.out.println(String.format("%-2d. %-15s | %s", (choice+1), m.getName(),m.getDescription()));
        System.out.println("위와 같은 메뉴를 삭제하시겠습니까?");
        System.out.println("1. 확인 2. 취소 ");
        int checkNum = sc.nextInt();

        if (checkNum == 1) {
            menuList.remove(choice);
            System.out.println("메뉴가 삭제 되었습니다. ");
        } else if (checkNum == 2) {
            System.out.println("메뉴삭제를 취소 하셨습니다. \n");
        } else {
            System.out.println("번호를 잘못 입력 하셨습니다.\n");
        }
    }
    public static void displayDeleteProduct( Menu m, Scanner sc) {
        List<Product> products = m.getProducts();

        int i;
        for (i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            System.out.println(String.format("%-2d. %-20s | W %5.0f | %s", (i + 1), p.getName(), p.getPrice(), p.getDescription()));
        }
        System.out.println("삭제할 상품의 번호를 입력해주세요.");
        int choice = sc.nextInt() - 1;
        Product p = products.get(choice);
        System.out.println("--------------------------------------------------\n");
        System.out.println(String.format("%-15s | W %5.0f | %s", p.getName(), p.getPrice(), p.getDescription()));
        System.out.println("위 상품를 삭제 하시겠습니까?");
        System.out.println("1. 확인       2. 취소");
        int num =sc.nextInt();
        if(num==1){
            products.remove(choice);
            System.out.print("상픔 삭제가 완료 되었습니다. ");
        } else if (num==2) {
            System.out.print("상픔 삭제가 취소 되었습니다. ");
        }

    }

    public static void displayCreateProduct( Menu m) {
        Scanner sc = new Scanner(System.in);
        List<Product> products = m.getProducts();
        System.out.println("--------------------------------------------------\n");
        System.out.print("상품이름을 입력하세요 : ");
        String Name = sc.nextLine();


        System.out.print("상품가격을 입력하세요 : ");
        double Price = sc.nextDouble();
        sc.nextLine();

        System.out.print("설명을 입력하세요 : ");
        String Description = sc.nextLine();
        m.addProduct(new Product(Name, Price, Description));

        System.out.print("상픔 생성이 완료 되었습니다. ");
    }
    public static void displayMenu1(List<Menu> menuList) {

        int i;
        for (i = 0; i < menuList.size(); i++) {
            Menu m = menuList.get(i);
            System.out.println(String.format("%-2d. %-15s | %s", (i + 1), m.getName(), m.getDescription()));
        }
    }

    public static void displayCreateMenu(List<Menu> menuList, Scanner sc) {
        System.out.println("--------------------------------------------------\n");
        System.out.print("메뉴 이름을 입력 하세요 : ");
        String name = sc.nextLine();
        name = sc.nextLine();

        System.out.print("메뉴 설명을 입력 하세요 : ");
        String description = sc.nextLine();

        System.out.println("--------------------------------------------------\n");
        System.out.println("\n이름 : " + name + " 설명 : " + description);
        System.out.println("위와 같은 메뉴를 추가하시겠습니까?");
        System.out.println("1. 확인 2. 취소 ");
        int checkNum = sc.nextInt();

        if (checkNum == 1) {
            Menu menu = new Menu(name, description);
            menu.setProducts(new ArrayList<>());
            menuList.add(menu);
        } else if (checkNum == 2) {
            System.out.println("메뉴추가를 취소 하셨습니다. \n");
        } else {
            System.out.println("번호를 잘못 입력 하셨습니다.\n");
        }
    }

    public static void displayCompleteList(List<Order> completeList) {
        System.out.println("__________________________________\n");
        System.out.println("[ 완료주문 목록 ]");

        int i = 1;

        for (Order order : completeList) {
            System.out.println("_______________");
            System.out.println(String.format("Order. %-2d", (i++)));
            System.out.println("완료일시. " + getCompleteTime());
            System.out.println("요청사항. " + order.getMessage());
            List<Product> cart = order.getCart();
            double total = 0;
            for (int j = 0; j < cart.size(); j++) {
                Product p = cart.get(j);
                System.out.println(String.format("%-15s | W %5.0f | %s", p.getName(), p.getPrice(), p.getDescription()));
                total += p.getPrice();
            }
            System.out.println(String.format("[ Total : W %5.0f ]", total));
        }
    }

    public static void displayWaitList(List<Order> completeList, List<Order> waitList, Scanner sc) {
        System.out.println("__________________________________\n");
        System.out.println("[ 대기주문 목록 ]");
        System.out.println("목록을 보시고 완료처리할 주문의 번호를 입력해주세요.");


        int i = 1;

        for (Order order : waitList) {
            System.out.println("_______________");
            System.out.println(String.format("Order. %-2d", (i++)));
            System.out.println("주문일시. " + order.getOrderTime());
            System.out.println("요청사항. " + order.getMessage());
            List<Product> cart = order.getCart();
            double total = 0;
            for (int j = 0; j < cart.size(); j++) {
                Product p = cart.get(j);
                System.out.println(String.format("%-15s | W %5.0f | %s", p.getName(), p.getPrice(), p.getDescription()));
                total += p.getPrice();
            }
            System.out.println(String.format("[ Total : W %5.0f ]", total));
        }

        int choice = sc.nextInt() - 1;
        Order o = waitList.get(choice);
        System.out.println("__________________________________\n");
        System.out.println(String.format("Order. %-2d", (choice + 1)));
        System.out.println("주문일시. " + o.getOrderTime());
        System.out.println("요청사항. " + o.getMessage());
        List<Product> c = o.getCart();
        double total = 0;
        for (int j = 0; j < c.size(); j++) {
            Product p = c.get(j);
            System.out.println(String.format("%-15s | W %5.0f | %s", p.getName(), p.getPrice(), p.getDescription()));
            total += p.getPrice();
        }
        System.out.println(String.format("[ Total : W %5.0f ]", total));
        System.out.println("위 주문을 완료처리 하시겠습니까?");
        System.out.println("1. 확인       2. 취소");
        choice = sc.nextInt();
        if (choice == 1) {
            completeList.add(o);
            waitList.remove(o);
            completeTime = LocalDateTime.now();
            System.out.println("주문이 완료처리 되었습니다. \n");
        } else {
            System.out.println("주문이 완료처리 되지 않았습니다. \n");
        }
    }

    public static void displayMenu(List<Menu> menuList) {
        System.out.println("__________________________________\n");
        System.out.println("SHAKESHACK BURGER 에 오신걸 환영합니다.");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
        System.out.println(String.format("%-2d. %-15s | %s", (0), "Management", "상점 관리 프로그램."));

        System.out.println("[ SHAKESHACK MENU ]");

        int i;
        for (i = 0; i < menuList.size(); i++) {
            Menu m = menuList.get(i);
            System.out.println(String.format("%-2d. %-15s | %s", (i + 1), m.getName(), m.getDescription()));
        }

        System.out.println("[ ORDER MENU ]");
        System.out.println(String.format("%-2d. %-15s | %s", (++i), "Order", "장바구니를 확인 후 주문합니다."));
        System.out.println(String.format("%-2d. %-15s | %s", (++i), "Cancel", "진행중인 주문을 취소합니다."));
        System.out.println(String.format("%-2d. %-15s | %s", (++i), "List", "최근 완료된 주문과 대기중인 주문 목록을 출력합니다."));
        System.out.println(String.format("%-2d. %-15s | %s", (++i), "Quit", "프로그램 종료."));

    }

    public static void displayProduct(Order order, Menu m, Scanner sc) {
        List<Product> products = m.getProducts();
        System.out.println("__________________________________\n");
        System.out.println("SHAKESHACK BURGER 에 오신걸 환영합니다.");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");

        System.out.println(String.format("[ %s ]", m.getName()));

        int i;
        for (i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            System.out.println(String.format("%-2d. %-20s | W %5.0f | %s", (i + 1), p.getName(), p.getPrice(), p.getDescription()));
        }

        int choice = sc.nextInt() - 1;
        Product p = products.get(choice);
        System.out.println("__________________________________\n");
        System.out.println(String.format("%-15s | W %5.0f | %s", p.getName(), p.getPrice(), p.getDescription()));
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인       2. 취소");

        choice = sc.nextInt();
        if (choice == 1) {
            order.addCart(p);
            System.out.println(String.format("%s 가 장바구니에 추가되었습니다. \n", p.getName()));
        } else {
            System.out.println(String.format("%s 가 장바구니에 추가되지 않았습니다. \n", p.getName()));
        }
    }

    public static LocalDateTime getCompleteTime() {
        return completeTime;
    }
}
