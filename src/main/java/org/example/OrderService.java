package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderService {

    public static void displayOrder(List<Order> waitOrder, Order order, Scanner scanner) {
        System.out.println("__________________________________\n");
        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println("[ Orders ]");

        List<Product> cart  = order.getCart();
        double        total = 0;
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

        if (choice == 1) {
            completeOrder(waitOrder, order);
        }
    }

    public static void completeOrder(List<Order> waitOrder, Order order) {
        System.out.println("요구사항을 입력해주세요(최대 20자)");
        Scanner scanner = new Scanner(System.in);
        String  message = scanner.nextLine();

        if (message.length() > 20) {
            System.out.println("입력한 요구사항이 20자를 초과했습니다. 처음 20자까지만 저장됩니다.");
            message = message.substring(0, 20);
        }

        System.out.println("__________________________________\n");

        System.out.println("주문이 완료되었습니다!");
        Order         o    = new Order();
        List<Product> cart = new ArrayList<>(order.getCart());
        o.setCart(cart, message);
        waitOrder.add(o);
        System.out.println(String.format("대기번호는 [ %s ] 번 입니다.", waitOrder.size()));
        System.out.println("(3초후 메뉴판으로 돌아갑니다.)");
        order.clearCart();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void cancelOrder(Order order, Scanner sc) {
        System.out.println("__________________________________\n");

        System.out.println("주문을 취소할까요? (1. 확인 / 2. 취소)");
        int choice = sc.nextInt();

        if (choice == 1) {
            order.clearCart();
            System.out.println("__________________________________\n");
            System.out.println("주문이 취소되었습니다.");
        }
    }

    public static void displayOrderList(List<Order> completeList, List<Order> waitList) {
        System.out.println("__________________________________\n");
        System.out.println("[ 완료주문 목록 ]");

        int i = 1;

        if(completeList.isEmpty()) {
            System.out.println("최근 완료된 주문이 없습니다.");
        } else { // 완료된 최근주문 최대 3개 출력
            int count = 0;
            for (Order order: completeList) {
                // completeList가 3개가 넘어갈 경우 출력 종료
                count++;
                if (count > 3) {
                    break;
                }
                System.out.println("_______________");
                System.out.println(String.format("Order. %-2d", (i++)));
                List<Product> cart = order.getCart();
                double total = 0;
                for (int j = 0; j < cart.size(); j++) {
                    Product p = cart.get(j);
                    System.out.println(String.format("%-15s | W %5.0f | %s", p.getName(), p.getPrice(), p.getDescription()));
                    total += p.getPrice();
                }
                System.out.println(String.format("[ Total : W %5.0f ]",total));
            }
        }

        System.out.println("__________________________________\n");
        System.out.println("[ 대기주문 목록 ]");

        i = 1;

        for (Order order: waitList) {
            System.out.println("_______________");
            System.out.println(String.format("Order. %-2d", (i++)));
            List<Product> cart = order.getCart();
            double total = 0;
            for (int j = 0; j < cart.size(); j++) {
                Product p = cart.get(j);
                System.out.println(String.format("%-15s | W %5.0f | %s", p.getName(), p.getPrice(), p.getDescription()));
                total += p.getPrice();
            }
            System.out.println(String.format("[ Total : W %5.0f ]",total));
        }
    }

}
