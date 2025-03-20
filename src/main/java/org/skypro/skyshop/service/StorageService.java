package org.skypro.skyshop.service;

import org.skypro.skyshop.model.article.Article;
//import org.skypro.skyshop.model.exceptions.BestResultNotFound;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class StorageService {

    private final Map<UUID, Product> productStorage = new HashMap<>();
    private final Map<UUID, Article> articleStorage=new HashMap<>();

    public StorageService() {
        UUID id1=UUID.randomUUID();
        productStorage.put(id1, new SimpleProduct(id1,"Хлеб", 120.0));
        UUID id2=UUID.randomUUID();
        productStorage.put(id2, new DiscountedProduct(id2,"сахар", 100.0, 10));
        UUID id3=UUID.randomUUID();
        productStorage.put(id3, new FixPriceProduct(id3,"вода минеральная"));
        UUID id4=UUID.randomUUID();
        productStorage.put(id4, new DiscountedProduct(id4,"масло", 320.0, 20));
        UUID id5=UUID.randomUUID();
        articleStorage.put(id5, new Article(id5,"хлеб", "История создания продукта"));
        UUID id6= UUID.randomUUID();
        articleStorage.put(id6, new Article(id6,"соль", "Может ли человек прожить без соли"));

    }

    public Collection<Product> getAllProducts() {
        return productStorage.values();
    }

    public Collection<Article> getAllArticles() {

        return articleStorage.values();
    }

    public Collection<Searchable> getAll (){
        ArrayList<Searchable> list = new ArrayList<>();
        list.addAll(getAllProducts());
        list.addAll(getAllArticles());
        return list;
    }

}


