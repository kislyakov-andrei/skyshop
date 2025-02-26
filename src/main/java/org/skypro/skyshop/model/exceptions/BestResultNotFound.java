package org.skypro.skyshop.model.exceptions;

import java.io.IOException;

public class BestResultNotFound extends IOException {
    String searchTerm;
    public BestResultNotFound (String searchTerm){
        this.searchTerm=searchTerm;
    }

    @Override
    public String toString() {
        return "Запрос (" + searchTerm + ") не найден";
    }
}