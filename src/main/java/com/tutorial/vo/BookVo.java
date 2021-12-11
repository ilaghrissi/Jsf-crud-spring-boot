package com.tutorial.vo;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
public class BookVo {
	
	private Long id;
	private String title;
	private double price;
	private String author;

}
