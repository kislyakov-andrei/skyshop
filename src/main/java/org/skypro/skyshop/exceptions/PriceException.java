package org.skypro.skyshop.exceptions;

public class PriceException extends IllegalArgumentException {
    private String name;

    public PriceException(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "(" + name + ") - введена некорректная стоимость";
    }

}