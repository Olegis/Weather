package com.olegis.weather;

/**
 * Created by Olegis on 12.03.2018.
 */

public class City {

    private String name;
    private String description;

    private City(String name, String description) {
        this.name = name;
        this.description = description;
    }

    String getName() {
        return name;
    }

    String getDescription() {
        return description;
    }

    static final City[] cityes = {
            new City("Москва", "Отличная погода: + 5"),
            new City("Санкт-Питербург", "Холодно и слякотно: - 7"),
            new City("Омск", "Очень холодно: - 24"),
            new City("Тверь", "Как обычно: - 3")
    };
}
