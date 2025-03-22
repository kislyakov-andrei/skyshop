package org.skypro.skyshop.service;

import org.skypro.skyshop.model.search.SearchResult;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
    private final StorageService storageService;

    public SearchService(StorageService storageService) {
        this.storageService = storageService;
    }
    public List<SearchResult> search (String q) {
        return storageService.getAll().stream()
                .filter(searchable -> searchable.getSearchTerm().toLowerCase().contains(q.toLowerCase()))
                .map (searchable -> SearchResult.fromSearchable(searchable))
                .toList();
    }
}
