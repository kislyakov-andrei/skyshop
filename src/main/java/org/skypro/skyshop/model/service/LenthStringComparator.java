package org.skypro.skyshop.model.service;

import java.util.Comparator;

import org.skypro.skyshop.model.search.Searchable;

import java.util.Comparator;

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