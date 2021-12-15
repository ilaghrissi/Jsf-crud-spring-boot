package com.tutorial.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

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
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private BookService bookService;

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
	
	public void update() {
		System.out.println("update element"+this.selected);
		bookRepository.getBooksBytitle("test ele");
		addMessage("Confirmed", "You have accepted");
	}
	
	public void delete() {
		System.out.println("delete element"+this.selected);
		bookService.deleteBook(this.selected.getId());
		this.books = bookService.getAllBooks();
	}
	
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
