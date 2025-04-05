package org.skypro.skyshop.model;

import java.util.ArrayList;
import java.util.List;

public final class UserBasket {
    private final List<BasketItem> items;
    private final double total;

    public UserBasket(List<BasketItem> items) {
        this.items = items;
        this.total = calculateTotal(items);

    }

    public List<BasketItem> getItems() {
        return items;
    }

    public double getTotal() {
        return total;
    }

    private double calculateTotal(List<BasketItem> items) {
        return items.stream()
                .mapToDouble(item ->item.getProduct().getCost()*item.getQuantity())
                .sum();
    }
}
