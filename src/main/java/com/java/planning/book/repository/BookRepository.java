package com.java.planning.book.repository;

import com.java.planning.book.entity.Book;
import com.java.planning.book.entity.entityHelper.vi.BookSearch;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("select b from Book b where b.title like :#{#bookVi.title()} and b.year > :#{#bookVi.year()}")
    List<Book> findByParams(@Param("bookVi") BookSearch bookSearch, Pageable pageable);
}
