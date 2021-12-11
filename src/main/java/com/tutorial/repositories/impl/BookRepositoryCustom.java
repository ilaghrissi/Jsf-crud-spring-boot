package com.tutorial.repositories.impl;

import java.util.List;

import com.tutorial.entities.Book;

public interface BookRepositoryCustom {

	List<Book> getBooksBytitle(String title);
}
