package org.skypro.skyshop.service;

import java.util.Comparator;

import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.Comparator;
@Service
public class LenthStringComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable o1, Searchable o2) {
        int lengthComparison = Integer.compare(o2.getSearchTerm().length(), o1.getSearchTerm().length());
        // Если длины равны, сравниваем имена
        if (lengthComparison == 0) {
            return o1.getSearchTerm().compareToIgnoreCase(o2.getSearchTerm());
        }
        return lengthComparison;
    }
}