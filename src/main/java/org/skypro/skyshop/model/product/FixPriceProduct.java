package org.skypro.skyshop.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Component;

import java.util.UUID;

public class FixPriceProduct extends Product {
    private double FIX_PRICE = 50.0;
    private double cost;

    public FixPriceProduct(UUID id,String name) {
        super (id,name);

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
    @JsonIgnore
    @Override
    public boolean isSpecial(){
        return true;
    }

    @Override
    public int compareToIgnoreCase(Searchable o2) {
        return 0;
    }


}