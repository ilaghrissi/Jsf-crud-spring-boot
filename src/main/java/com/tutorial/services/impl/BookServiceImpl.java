package com.tutorial.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tutorial.entities.Book;
import com.tutorial.mappers.BookMapper;
import com.tutorial.repositories.BookRepository;
import com.tutorial.services.BookService;
import com.tutorial.vo.BookVo;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private BookMapper bookMapper;

	@Override
	public void saveOrUpdateBook(BookVo book) {
		Book b = new Book();
		bookRepository.save(b);

	}

	@Override
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}

	@Override
	public List<BookVo> getAllBooks() {
		return bookMapper.mapBookListToBookVoList(bookRepository.findAll());
	}

}
