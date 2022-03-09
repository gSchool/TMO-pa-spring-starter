package com.galvanize.tmo.paspringstarter.controller;

import com.galvanize.tmo.paspringstarter.data.dto.BookDto;
import com.galvanize.tmo.paspringstarter.data.dto.IncomingBookDto;
import com.galvanize.tmo.paspringstarter.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = {"/api"}, produces = APPLICATION_JSON_VALUE)
public class LibraryController {

    private final LibraryService libraryService;

    @Autowired
    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/health")
    public void health() {

    }

    @PostMapping("/books")
    public ResponseEntity<BookDto> addBookToLibrary(@Valid @RequestBody IncomingBookDto incomingBookDto) {
        final BookDto bookDto = libraryService.addBookToLibrary(incomingBookDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookDto);
    }

    @GetMapping("/books")
    public ResponseEntity<BookDto> getBooks() {
        BookDto bookDto = libraryService.getAllBooks();
        return ResponseEntity.status(HttpStatus.OK).body(bookDto);
    }

    @DeleteMapping("/books")
    public ResponseEntity<Void> deleteAllBooks() {
        libraryService.deleteBooks();
        return ResponseEntity.noContent().header("Content-Length", "0").build();
    }
}
