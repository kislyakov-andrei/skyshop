package org.skypro.skyshop.model.exceptions;

import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
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