package org.skypro.skyshop.model.product;

import java.util.Objects;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.exceptions.NameException;
import org.skypro.skyshop.model.search.Searchable;

import java.util.UUID;

public abstract class Product implements Searchable {
    protected String name;
    protected final UUID id;
    private static final String TYPEPRODUCT = "PRODUCT";

    public Product(UUID id, String name) throws NameException {

        if (name == null || name.isBlank()) {
            throw new NameException();
        }
        this.name = name;
        this.id = id;
    }

    public String getName() {

        return name;
    }

    public abstract boolean isSpecial();

    public abstract double getCost();

    @Override
    public String toString() {

        return name + " : " + getCost();
    }

    @JsonIgnore
    @Override
    public String getType() {
        return TYPEPRODUCT;
    }

    @JsonIgnore
    @Override
    public String getSearchTerm() {
        return getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public UUID getId() {
        return id;
    }
}