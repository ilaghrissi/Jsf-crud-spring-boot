package com.tutorial.beans;

import com.tutorial.mappers.BookMapper;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.stereotype.Component;

import com.tutorial.repositories.BookRepository;
import com.tutorial.services.BookService;
import com.tutorial.vo.BookVo;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Slf4j
@Data
@Getter
@Setter
@NoArgsConstructor
@Component
@ManagedBean
@RequestScoped
public class BookBean {

	private List<BookVo> books;
	private BookVo selected;

	private BookVo newBook = new BookVo();
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private BookService bookService;

	@Autowired
	private BookMapper bookMapper;

	@Autowired
	BuildProperties buildProperties;

	/*
	@Autowired
   private Environment environment;
    environment.getActiveProfiles();
	 */

	/*
		buildProperties.getName();  // Artifact's name from the pom.xml file
		buildProperties.getVersion();  	// Artifact version
		buildProperties.getTime(); // Date and Time of the build
		buildProperties.getArtifact(); 	// Artifact ID from the pom file
		buildProperties.getGroup(); 	// Group ID from the pom file
	 */

	@PostConstruct
	public void init() {
		this.books = bookService.getAllBooks();
	}


	public void add() {
		log.info("update element {}", this.selected);
		bookRepository.save(bookMapper.mapBookVoToBook(newBook));
		this.books = bookMapper.mapBookListToBookVoList(bookRepository.findAll());
		this.newBook = new BookVo();
		addMessage("Confirmed", "Your book is added");
	}

	public void update() {
		log.info("update element {}", this.selected);
		bookRepository.getBooksBytitle("test ele");
		addMessage("Confirmed", "You have accepted");
	}
	
	public void delete() {
		log.info("delete element {}", this.selected);
		bookService.deleteBook(this.selected.getId());
		this.books = bookService.getAllBooks();
	}
	
	public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
	}
}
