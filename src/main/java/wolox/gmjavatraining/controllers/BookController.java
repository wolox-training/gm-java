package wolox.gmjavatraining.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import wolox.gmjavatraining.exceptions.BookIdMismatchException;
import wolox.gmjavatraining.exceptions.BookNotFoundException;
import wolox.gmjavatraining.models.Book;
import wolox.gmjavatraining.repositories.BookRepository;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public Iterable findAll() {
        return bookRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody Book book) {
        try {
            return bookRepository.save(book);
        } catch (DataAccessException ex) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), ex);
        }
    }

    @GetMapping("/author")
    public Book findByAuthor(@RequestParam(name="author") String author) {
        return bookRepository.findByAuthor(author);
    }

    @GetMapping("/{id}")
    public Book findById(@PathVariable long id) throws BookNotFoundException {
        return bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws BookNotFoundException {
        bookRepository.findById(id).orElseThrow(BookNotFoundException::new);
        bookRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable Long id) throws BookNotFoundException, BookIdMismatchException {
        if (book.getId() != id) {
            throw new BookIdMismatchException();
        }
        bookRepository.findById(id)
            .orElseThrow(BookNotFoundException::new);
        try {
            return bookRepository.save(book);
        } catch (DataAccessException ex) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), ex);
        }
    }
}