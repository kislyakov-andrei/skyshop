package org.skypro.skyshop.model.product;

import org.skypro.skyshop.model.exceptions.PriceException;
import org.skypro.skyshop.model.search.Searchable;

import java.util.UUID;

public class SimpleProduct extends Product {
    private double cost;


    public SimpleProduct(String name, double cost) {
        super(name, id);

        if (cost <= 0) {
            throw new PriceException(name);
        }
        this.cost = cost;
    }

    @Override
    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "\n" + name + " : " + cost;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public int compareToIgnoreCase(Searchable o2) {
        return 0;
    }

    @Override
    public UUID getId() {
        return id;
    }
}