package org.example;

import java.util.ArrayList;
import java.util.List;

public class MenuRepository {
    private List<Menu> menuList;

    public MenuRepository() {
        menuList = new ArrayList<>();
        setMenu(menuList);
    }

    public List<Menu> getMenuList() {
        return menuList;
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
