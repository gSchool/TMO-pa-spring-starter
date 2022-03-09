package com.galvanize.tmo.paspringstarter.data.model;

import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

@Data
public class Book {
    private static final AtomicInteger idCounter = new AtomicInteger(0);
    private int id;
    private String author;
    private String title;
    private int yearPublished;

    public Book(String author, String title, int yearPublished) {
        this.author = author;
        this.title = title;
        this.yearPublished = yearPublished;
        this.id = idCounter.incrementAndGet();
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYearPublished() {
        return yearPublished;
    }
}
