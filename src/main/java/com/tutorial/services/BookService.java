package com.tutorial.services;

import java.util.List;

import com.tutorial.vo.BookVo;

public interface BookService {

	void saveOrUpdateBook(BookVo book);

	void deleteBook(Long id);

	List<BookVo> getAllBooks();

}
