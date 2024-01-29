package eif.viko.lt.library.project.libraryui.repository;

import eif.viko.lt.library.project.libraryui.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
