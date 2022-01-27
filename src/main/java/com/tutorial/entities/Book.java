package com.tutorial.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.SequenceGenerator;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Book {
	
	@Id
	@SequenceGenerator(
			name = "book_id_sequence",
			sequenceName = "book_id_sequence"
	)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_id_sequence")
	private Long id;
	private String title;
	private double price;
	private String author;

}
