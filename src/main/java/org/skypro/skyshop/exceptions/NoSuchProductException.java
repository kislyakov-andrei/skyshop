package org.skypro.skyshop.exceptions;

public class NoSuchProductException extends RuntimeException {
   public NoSuchProductException(String message) {
        super(message);
    }
}

