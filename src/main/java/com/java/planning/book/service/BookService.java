package com.java.planning.book.service;

import com.java.planning.book.entity.Book;
import com.java.planning.book.entity.entityHelper.vi.BookEdit;
import com.java.planning.book.entity.entityHelper.vi.BookSave;
import com.java.planning.book.entity.entityHelper.vi.BookSearch;
import com.java.planning.book.repository.BookRepository;
import com.java.planning.book.service.exception.BookException;
import com.java.planning.book.service.exception.GeneralException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    public Book save(BookSave bookSave) {
        try {
            Book book = new Book();
            book.setTitle(bookSave.title());
            book.setAuthor(bookSave.author());
            book.setYear(bookSave.year());
            book.setGenre(bookSave.genre());
            book.setPages(bookSave.pages());
            book.setDescription(bookSave.description());
            book.setPublisher(bookSave.publisher());
            book.setIsbn(bookSave.isbn());
            book.setUrl(bookSave.url());
            book.setThumbnail(bookSave.thumbnail());
            book.setDeleted(false);
            return bookRepository.save(book);
        } catch (Exception e) {
            throw new GeneralException.UnHandledException(e.getMessage());
        }
    }

    @Transactional
    public Book edit(BookEdit book) {
        Book bookToEdit = findById(book.id());
        try {
            bookToEdit.setTitle(book.title() != null ? book.title() : bookToEdit.getTitle());
            bookToEdit.setYear(book.year() != null ? book.year() : bookToEdit.getYear());
            bookToEdit.setLastModifyDate(new Date());
            return bookRepository.save(bookToEdit);
        } catch (Exception e) {
            throw new GeneralException.UnHandledException(e.getMessage());
        }
    }

    public Book findById(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            throw new BookException.BookNotFoundException("Book not found");
        }
    }

    public List<Book> findByParam(BookSearch vi) {
        return bookRepository.findByParams(vi, PageRequest.of(vi.from(), vi.to()));
    }

    public void delete(Long id) {
        Book book = findById(id);
        try {
            book.setDeleted(true);
            bookRepository.save(book);
        } catch (Exception e) {
            throw new GeneralException.UnHandledException(e.getMessage());
        }
    }
}
