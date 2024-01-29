package eif.viko.lt.library.project.libraryui.service;

import eif.viko.lt.library.project.libraryui.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(Long id);
    void createBook(Book book);
    void deleteBook(Long id);
}