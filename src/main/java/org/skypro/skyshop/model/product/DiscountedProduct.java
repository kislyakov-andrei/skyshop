package org.skypro.skyshop.model.product;


import org.skypro.skyshop.model.exceptions.DiscountException;
import org.skypro.skyshop.model.exceptions.PriceException;
import org.skypro.skyshop.model.search.Searchable;

import java.util.UUID;

public class DiscountedProduct extends Product {
    private double cost;
    //private final UUID id;
    private int discount;

    public DiscountedProduct(String name, double cost, int discount) {
        super(name,id);


        if (cost <= 0) {
            throw new PriceException(name);
        }
        if (discount < 0 || discount > 100) {
            throw new DiscountException(name);
        }
        this.cost = cost * (1 - discount / 100.0);
        this.discount = discount;

    }

    @Override
    public double getCost() {
        //price= cost*(1-discount/100.0);
        return cost;
    }

    @Override
    public String toString() {
        return name + " : " + cost + " (" + discount + "% )";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public int compareToIgnoreCase(Searchable o2) {
        return 0;
    }


}