package org.skypro.skyshop.model.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class StorageService {
private final Map<UUID, Product> productMap= new HashMap<>();
private final Map<UUID, Article> articleMap = new HashMap<>();
}
