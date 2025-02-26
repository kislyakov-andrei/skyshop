package org.skypro.skyshop.model.service;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.skypro.skyshop.model.exceptions.BestResultNotFound;
import org.skypro.skyshop.model.search.Searchable;
import org.skypro.skyshop.model.service.LenthStringComparator;
import org.skypro.skyshop.model.product.Product;

import java.util.*;
        import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SearchEngine {

    private Set<Searchable> searchables = new HashSet<>();

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    // поиск товара по имени
    public Set<Searchable> search(String name) {
        System.out.println("Поиск продукта " + name);
        TreeSet<Searchable> searchResult = searchables.stream()
                .filter(s -> s.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new LenthStringComparator())));

        if (searchResult.isEmpty()) {
            System.out.println("Продукт -" + name + "- не найден");
        }
        return searchResult;
    }

    public Searchable foundBestResult(String searchTerm) throws BestResultNotFound {
        Searchable bestResult = null;
        int maxFound = 0;
        int score;
        for (Searchable searchable : searchables) {
            String str = searchable.getSearchTerm().toLowerCase();
            String subStr = searchTerm.toLowerCase();
            score = resultMaxFound(str, subStr);
            if (score > maxFound) {
                maxFound = score;
                bestResult = searchable;
            } else if (bestResult == null) {
                throw new BestResultNotFound(searchTerm);
            }
        }
        return bestResult;
    }

    private int resultMaxFound(String str, String subStr) {
        int score = 0;
        int index = 0;
        int indexSubStr = str.indexOf(subStr, index);
        while (indexSubStr != -1) {
            score++;
            index = indexSubStr + subStr.length();
            indexSubStr = str.indexOf(subStr, index);
        }
        return score;
    }

    // печать корзины
    public void printSearchebles() {
        if (!searchables.isEmpty()) {
            System.out.println(searchables);
        } else {
            System.out.println("Корзина пустая.");
        }
    }
}