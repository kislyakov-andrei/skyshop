package org.skypro.skyshop.model.article;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;
@Component
public class Article implements Searchable {
    private final String titleArticle;
    private final String contentArticle;
    private static final String TYPEARTICLE = "ARTICLE";
    private final UUID id;

    public Article(UUID id,String titleArticle, String contentArticle) {
        this.id = id;
        this.titleArticle = titleArticle;
        this.contentArticle = contentArticle;
    }

    public String getTitleArticle() {
        return titleArticle;
    }

    public String getContentArticle() {
        return contentArticle;
    }

    @Override
    public String toString() {
        return "\n" + titleArticle + ":\n" + contentArticle;
    }
@JsonIgnore
    @Override
    public String getSearchTerm() {
        return titleArticle + "-" + contentArticle;
    }

    @Override
    public String getType() {
        return TYPEARTICLE;
    }

    @Override
    public String getName() {
        return titleArticle;
    }

    @Override
    public int compareToIgnoreCase(Searchable o2) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(titleArticle, article.titleArticle);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(titleArticle);
    }

    @Override
    public UUID getId() {
        return this.id;
    }
}