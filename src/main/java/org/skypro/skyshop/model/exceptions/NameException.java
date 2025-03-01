package org.skypro.skyshop.model.exceptions;

import org.springframework.stereotype.Component;

@Component
public class NameException extends IllegalArgumentException{
    public NameException() {
    }
}