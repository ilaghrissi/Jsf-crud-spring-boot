package com.tutorial.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.springframework.stereotype.Component;

import com.tutorial.vo.Book;

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

	private List<Book> books = new ArrayList<Book>();
	private Book selected;

	@PostConstruct
	public void init() {
		Book b1 = new Book();
		b1.setTitle("java ocp");
		b1.setAuthor("author test");
		b1.setPrice(20);
		Book b2 = new Book();
		b2.setTitle("java ocp 2");
		b2.setAuthor("author test 2");
		b2.setPrice(30);
		this.books = Arrays.asList(b1, b2);
	}
	
	public void update() {
		System.out.println("update element"+this.selected);
		addMessage("Confirmed", "You have accepted");
	}
	
	public void delete() {
		System.out.println("delete element"+this.selected);
	}
	
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
