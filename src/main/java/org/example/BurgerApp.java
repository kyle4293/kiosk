package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BurgerApp {

    static int cnt;

    public static void main(String[] args) {
        List<Menu> menuList = new ArrayList<>();
        setMenu(menuList);

        Order order = new Order();
        Scanner sc = new Scanner(System.in);

        cnt = 0;

        while (true){
            displayMenu(menuList);

            int choice = sc.nextInt()-1;

            if (choice==menuList.size()) {
                displayOrder(order, sc);
            }
            else if (choice==menuList.size()+1) {
                cancelOrder(order, sc);
            }
            else if (choice==menuList.size()+2) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            else {
                Menu m = menuList.get(choice);
                displayProduct(order, m, sc);
            }
        }

    }


    private static void displayMenu(List<Menu> menuList) {
        System.out.println("__________________________________\n");
        System.out.println("SHAKESHACK BURGER 에 오신걸 환영합니다.");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");

        System.out.println("[ SHAKESHACK MENU ]");

        int i;
        for (i=0; i<menuList.size(); i++) {
            Menu m = menuList.get(i);
            System.out.println(String.format("%-2d. %-15s | %s", (i+1), m.getName(), m.getDescription()));
        }

        System.out.println("[ ORDER MENU ]");
        System.out.println(String.format("%-2d. %-15s | %s", (++i), "Order",  "장바구니를 확인 후 주문합니다."));
        System.out.println(String.format("%-2d. %-15s | %s", (++i), "Cancel",  "진행중인 주문을 취소합니다."));
        System.out.println(String.format("%-2d. %-15s | %s", (++i), "Quit",  "프로그램 종료."));

    }

    private static void displayProduct(Order order, Menu m, Scanner sc) {
        List<Product> products = m.getProducts();
        System.out.println("__________________________________\n");
        System.out.println("SHAKESHACK BURGER 에 오신걸 환영합니다.");
        System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");

        System.out.println(String.format("[ %s ]", m.getName()));

        int i;
        for (i=0; i<products.size(); i++) {
            Product p = products.get(i);
            System.out.println(String.format("%-2d. %-20s | W %5.0f | %s", (i+1), p.getName(), p.getPrice(), p.getDescription()));
        }

        int choice = sc.nextInt() - 1;
        Product p = products.get(choice);
        System.out.println("__________________________________\n");
        System.out.println(String.format("%-15s | W %5.0f | %s", p.getName(), p.getPrice(), p.getDescription()));
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인       2. 취소");

        choice = sc.nextInt();
        if (choice==1) {
            order.addCart(p);
            System.out.println(String.format("%s 가 장바구니에 추가되었습니다. \n", p.getName()));
        }
        else {
            System.out.println(String.format("%s 가 장바구니에 추가되지 않았습니다. \n", p.getName()));
        }
    }

    private static void displayOrder(Order order, Scanner scanner) {
        System.out.println("__________________________________\n");
        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println("[ Orders ]");

        List<Product> cart = order.getCart();
        double total = 0;
        for (int i = 0; i < cart.size(); i++) {
            Product p = cart.get(i);
            System.out.println(String.format("%-15s | W %5.0f | %s", p.getName(), p.getPrice(), p.getDescription()));
            total += p.getPrice();
        }
        System.out.println("[ Total ]");
        System.out.println("W" + total);
        System.out.println("__________________________________\n");

        System.out.println("1. 주문       2. 메뉴판");

        int choice = scanner.nextInt();

        if (choice==1) {
            completeOrder(order);
        }
    }


    private static void completeOrder(Order order) {
        System.out.println("__________________________________\n");

        System.out.println("주문이 완료되었습니다!");
        System.out.println(String.format("대기번호는 [ %s ] 번 입니다.", ++cnt));
        System.out.println("(3초후 메뉴판으로 돌아갑니다.)");
        order.clearCart();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void cancelOrder(Order order, Scanner sc) {
        System.out.println("__________________________________\n");

        System.out.println("주문을 취소할까요? (1. 확인 / 2. 취소)");
        int choice = sc.nextInt();

        if (choice==1) {
            order.clearCart();
            System.out.println("__________________________________\n");
            System.out.println("주문이 취소되었습니다.");
        }
    }


    private static void setMenu(List<Menu> menuList) {
        Menu m1  = new Menu("Burgers","앵거스 비프 통살을 다져만든 버거");
        List<Product> products1 = new ArrayList<>();
        // Burgers
        products1.add(new Product("ShackBurger", 6900 ,"토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        products1.add(new Product("SmokeShack", 8900 ,"베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        products1.add(new Product("Shroom Burger", 9400 ,"몬스터 치즈와 체다 치즈로 속을 채운 베지테리안 버거"));
        products1.add(new Product("Cheeseburger", 6900 ,"포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        products1.add(new Product("Hamburger", 5400 ,"비프패티를 기반으로 야채가 들어간 기본버거"));
        m1.setProducts(products1);

        Menu m2  = new Menu("Forzen Custard","매장에서 신선하게 만드는 아이스크림");
        List<Product> products2 = new ArrayList<>();
        //Forzen Custard
        products2.add(new Product("Shakes", 5900 ,"바닐라, 초콜렛, 솔티드 카라멜, 스트로베리, 커피"));
        products2.add(new Product("Shake of the Week", 6500 ,"특별한 커스터드 플레이버"));
        products2.add(new Product("Floats", 5900 ,"루트 비어, 퍼플 카우, 크림시클"));
        m2.setProducts(products2);

        Menu m3  = new Menu("Drinks","매장에서 직접 만드는 음료");
        List<Product> products3 = new ArrayList<>();
        //Drinks
        products3.add(new Product("Fountain Soda", 3300 ,"코카콜라, 코카콜라 제로, 스프라이트, 환타"));
        products3.add(new Product("Fifty/Fifty", 4400 ,"레몬에이드와 아이스티의 만남"));
        products3.add(new Product("Bottled Water", 1000 ,"지리산 암반대수층으로 만든 프리미엄 생수"));
        m3.setProducts(products3);

        Menu m4  = new Menu("Beer","뉴욕 브루클린 브루어리에서 양조한 맥주");
        List<Product> products4 = new ArrayList<>();
        //Beer
        products4.add(new Product("ShakeMeister Ale", 9800 ,"쉐이크쉑 버거를 위해 뉴욕 브루클린 브루어리에서 특별히 양조한 메일 맥주"));
        m4.setProducts(products4);

        menuList.add(m1);menuList.add(m2);menuList.add(m3);menuList.add(m4);
    }
}
