package com.tutorial.repositories.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tutorial.entities.Book;
import com.tutorial.repositories.BaseEntity;

@Repository
public class BookRepositoryImpl extends BaseEntity implements BookRepositoryCustom{

	@Override
	public List<Book> getBooksBytitle(String title) {
		System.out.println("Hello getBooksBytitle : "+ title);
		return null;
	}

}
