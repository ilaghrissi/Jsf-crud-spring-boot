package com.tutorial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tutorial.entities.Book;
import com.tutorial.repositories.impl.BookRepositoryCustom;

public interface BookRepository extends JpaRepository<Book, Long>, BookRepositoryCustom{
	
}
