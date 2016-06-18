package com.saltech;

public enum Category {
    UNCATEGORISED("UnCategorised"),
    SCIFI("Science Fiction"),
    HORROR("Horror"), FANTASY("Fantasy"), THRILLER("Thriller"), ALL("All");

    private final String name;

    Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
