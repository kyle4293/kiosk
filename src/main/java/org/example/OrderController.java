package org.example;

import java.util.*;

import static org.example.MenuController.*;
import static org.example.OrderService.cancelOrder;
import static org.example.OrderService.displayOrder;
import static org.example.OrderService.displayOrderList;

public class OrderController {

    private static MenuController menuController;
    private static MenuRepository menuRepository;
    private static OrderService orderService;

    public OrderController() {
        menuRepository = new MenuRepository();
        orderService = new OrderService();
        menuController = new MenuController();
        List<Menu> menuList = menuRepository.getMenuList();
        List<Order> waitList = new ArrayList<>();
        List<Order> completeList = new ArrayList<>();

        Order order = new Order();
        Scanner sc = new Scanner(System.in);

        while (true){
            displayMenu(menuList);

            int choice = sc.nextInt()-1;

            if (choice==menuList.size()) {
                displayOrder(waitList, order, sc);
            }
            else if (choice==menuList.size()+1) {
                cancelOrder(order, sc);
            }
            else if (choice==menuList.size()+2) {
                displayOrderList(completeList, waitList);
            }
            else if (choice==menuList.size()+3) {
                System.out.println("관리 프로그램");
                displayManagementMenu(completeList, waitList, sc);
            }
            else if (choice==menuList.size()+4) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            else {
                Menu m = menuList.get(choice);
                displayProduct(order, m, sc);
            }
        }
    }

}
