package com.galvanize.tmo.paspringstarter.service;

import com.galvanize.tmo.paspringstarter.data.dto.BookDto;
import com.galvanize.tmo.paspringstarter.data.dto.IncomingBookDto;
import com.galvanize.tmo.paspringstarter.data.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LibraryService {
    // For simplicity I will add a list here to hold a list of books. In a real world
    // scenario this class would utilize a repository service for doing any type of
    // crud operations against a DB
    List<Book> libraryBooks = new ArrayList<>();

    public BookDto addBookToLibrary(IncomingBookDto incomingBookDto) {
        Book book = new Book(
                incomingBookDto.getAuthor(),
                incomingBookDto.getTitle(),
                incomingBookDto.getYearPublished());

        BookDto dto = new BookDto();
        dto.setId(book.getId());
        dto.setAuthor(book.getAuthor());
        dto.setTitle(book.getTitle());
        dto.setYearPublished(book.getYearPublished());

        libraryBooks.add(book);

        return dto;
    }

    public BookDto getAllBooks() {
        BookDto bookDto = new BookDto();
        for (Book book : libraryBooks) {
            bookDto.createAndAddBook(book);
        }
        return bookDto;
    }

    public void deleteBooks() {
        libraryBooks.clear();
    }
}
