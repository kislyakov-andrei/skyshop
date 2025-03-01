package org.skypro.skyshop.model.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.exceptions.BestResultNotFound;
import org.skypro.skyshop.model.exceptions.DiscountException;
import org.skypro.skyshop.model.exceptions.NameException;
import org.skypro.skyshop.model.exceptions.PriceException;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.skypro.skyshop.model.service.ProductBasket.printSeparator;

@Service
public class StorageService {
        private final Map<UUID, Product> productStorage;
        private final Map<UUID, Article> articleStorage;

        public StorageService() { // конструктор
                this.productStorage = new HashMap<>();
                this.articleStorage = new HashMap<>();
        }
        // добавление продуктов
        public void addProduct(Product product) {
                productStorage.put(product.getId(), product);
        }
        // добавление статей
        public void addArticle(Article article){
                articleStorage.put(article.getId(), article);
        }


        public Collection<Product> getAllProducts() {
                return productStorage.values();
        }

        public Collection<Article> getAllArticles() {
                return articleStorage.values();
        }
}


