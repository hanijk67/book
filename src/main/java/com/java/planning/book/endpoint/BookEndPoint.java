package com.java.planning.book.endpoint;

import com.java.planning.book.entity.Book;
import com.java.planning.book.entity.entityHelper.vi.BookEdit;
import com.java.planning.book.entity.entityHelper.vi.BookSave;
import com.java.planning.book.entity.entityHelper.vi.BookSearch;
import com.java.planning.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/book")
public class BookEndPoint {


    private final BookService bookService;

    @Autowired
    public BookEndPoint(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("")
    public ResponseEntity<List<Book>> findBooks(
            @RequestParam(name = "from") Integer from,
            @RequestParam(name = "to") Integer to,
                                                @RequestParam(name= "title", required = false) String title,
                                                @RequestParam(name= "year", required = false) Integer year
    ) {
        return ResponseEntity.ok(bookService.findByParam(new BookSearch(from, to, title, year)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable(name = "id") Long id) {
        return  ResponseEntity.ok(bookService.findById(id));
    }

    @PutMapping()
    public ResponseEntity<Book> updateBook(@RequestBody BookEdit book) {
        return ResponseEntity.ok(bookService.edit(book));
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteBook(@RequestParam("id") Long id) {
        bookService.delete(id);
        return ResponseEntity.ok("Book deleted");
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody BookSave book) {
        return ResponseEntity.ok(bookService.save(book));
    }
}
