package org.skypro.skyshop.model.exceptions;

import org.springframework.stereotype.Component;

@Component
public class DiscountException extends IllegalArgumentException{
    String name;

    public DiscountException( String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "(" + name + ") - введен некорректный размер скидки";
    }
}