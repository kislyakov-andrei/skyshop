package org.skypro.skyshop.model.product;

import org.skypro.skyshop.model.search.Searchable;

import java.util.UUID;

public class FixPriceProduct extends Product {
    // private final UUID id;
    private double FIX_PRICE = 50.0;
    private double cost;

    public FixPriceProduct(String name) {
        super (name, id);

        this.cost = FIX_PRICE;
    }

    @Override
    public double getCost() {

        return  FIX_PRICE;
    }

    @Override
    public String toString() {
        return name + " : Фиксированная цена " + cost;
    }
    @Override
    public boolean isSpecial(){
        return true;
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