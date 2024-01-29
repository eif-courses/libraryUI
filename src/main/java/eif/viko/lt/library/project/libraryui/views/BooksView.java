package eif.viko.lt.library.project.libraryui.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.router.Route;
import eif.viko.lt.library.project.libraryui.components.DialogBasic;
import eif.viko.lt.library.project.libraryui.model.Book;
import eif.viko.lt.library.project.libraryui.service.BookService;

@Route(value = "/books", layout = AppLayoutNavbar.class)
public class BooksView extends Div {
    private final BookService bookService;
    private final Grid<Book> grid;

    public BooksView(BookService bookService) {
        this.bookService = bookService;
        this.grid = new Grid<>(Book.class);
        setupGrid();

        Button addBookButton = new Button("Add New Book", e -> openAddBookDialog());
        add(new H1("Books"), addBookButton, grid);
    }

    private void setupGrid() {
        grid.removeAllColumns();
        grid.setItems(bookService.getAllBooks());
        grid.addColumn(Book::getId).setHeader("ID");
        grid.addColumn(Book::getTitle).setHeader("Title");
        grid.addColumn(Book::getAuthor).setHeader("Author");
        grid.addColumn(Book::getIsAvailable).setHeader("Is Available");

    }

    private void openAddBookDialog() {
        Dialog dialog = new Dialog();
        dialog.setHeaderTitle("Add New Book");

        DialogBasic dialogBasic = new DialogBasic();
        Component dialogContent = dialogBasic.createDialogLayout(book -> {
            bookService.createBook(book);
            grid.setItems(bookService.getAllBooks()); // Refresh the grid
            dialog.close();
        }, dialog);

        dialog.add(dialogContent);
        dialog.open();
    }
}