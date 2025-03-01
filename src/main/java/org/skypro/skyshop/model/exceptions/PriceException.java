package org.skypro.skyshop.model.exceptions;

import org.springframework.stereotype.Component;

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