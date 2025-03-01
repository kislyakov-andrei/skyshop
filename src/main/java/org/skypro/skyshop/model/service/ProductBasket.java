package org.skypro.skyshop.model.service;

import java.util.*;

import org.skypro.skyshop.model.product.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductBasket {

    Map<String, List<Product>> basket = new HashMap<>();

    // Добавление товара
    public void addProduct(Product product) {
        String productName = product.getName();
        List productList = basket.computeIfAbsent(productName, k -> new ArrayList<>());
        productList.add(product);
        basket.put(productName, productList);
    }

    // удаление товара по имени
    public void deletProductToName(String name) {

        System.out.println("Удаление продукта по имени:" + name);
        if (basket.containsKey(name)) {
            basket.remove(name);
            System.out.println("Продукт " + name + " удален.");
        } else {
            System.out.println("Продукт " + name + " не найден");
        }
    }

    // подсчет специальных товаров
    public long isSpecialProduct() {
        long countSpeсial = 0;
        countSpeсial = basket.values().stream()
                .flatMap(Collection::stream)
                .filter(o -> o.isSpecial())
                .count();
        return countSpeсial;
    }

    // получение стоимости корзины
    public double getBasketCost() {
        double total = 0;
        total = basket.values().stream().flatMap(Collection::stream)
                .mapToDouble(x -> x.getCost())
                .sum();
        return total;
    }

    // печать корзины
    public void printBasket() {
        if (!basket.isEmpty()) {
            basket.values().stream().forEach(System.out::println);
        } else {
            System.out.println("Корзина пустая.");
        }
    }

    //поиск товара
    public boolean searchProduct(String productNick) {
        boolean exist = false;
        exist = basket.containsKey(productNick);
        return exist;
    }

    // очистка корзины
    public void cleanBasket() {
        basket.clear();
        System.out.println("корзина очищена");
    }

    public static void printSeparator() {
        System.out.println("-------------------------------------------------------------");
    }

}