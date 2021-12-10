package com.examples.books.repository;

import com.examples.books.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

    Page<Book> findAllByCategoryId(Integer id, Pageable pageable);
}
