package org.skypro.skyshop.model.search;

import java.util.UUID;

import static java.sql.DatabaseMetaData.typeSearchable;

public interface Searchable {
    String getSearchTerm();

    String getType();

    String getName();

    default String getStringRepresentation() {

        return "имя объекта - " + getName() + " - тип объекта " + getType();

    }
      UUID getId();

    int compareToIgnoreCase(Searchable o2);
}