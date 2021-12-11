package com.tutorial.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.tutorial.entities.Book;
import com.tutorial.vo.BookVo;

@Mapper(componentModel = "spring")
public interface BookMapper {
	
	public BookVo mapBookToBookVo(Book book);
	
	public Book mapBookVoToBook(BookVo bookVo);
	
	public List<BookVo> mapBookListToBookVoList(List<Book> books);

}
