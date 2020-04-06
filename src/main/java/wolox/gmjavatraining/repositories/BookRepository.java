package wolox.gmjavatraining.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import wolox.gmjavatraining.models.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findBookByAuthor(String author);
}
