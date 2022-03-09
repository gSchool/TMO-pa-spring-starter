package com.galvanize.tmo.paspringstarter.data.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.galvanize.tmo.paspringstarter.data.model.Book;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookDto implements Comparator<BookDto> {
    private Integer id;
    private String author;
    private String title;
    private Integer yearPublished;

    private List<BookDto> books;

    public List<BookDto> getBooks() {
        return books;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public void createAndAddBook(Book book) {
        if (books == null)
            books = new ArrayList<>();
        BookDto bookDto = new BookDto();
        bookDto.setId(book.getId());
        bookDto.setAuthor(book.getAuthor());
        bookDto.setTitle(book.getTitle());
        bookDto.setYearPublished(book.getYearPublished());
        this.books.add(bookDto);
        this.books.sort(this);
    }

    @Override
    public int compare(BookDto o1, BookDto o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}
