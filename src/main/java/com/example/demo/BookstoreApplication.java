package com.example.demo;

import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.domain.BookRepository;
import com.example.demo.domain.Book;

import com.example.demo.domain.Category;
import com.example.demo.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(CategoryRepository cRep, BookRepository bRep) {
	    return (args) -> {
		
		Category category1 = new Category("Sci-fi");
		Category category2 = new Category("Fantasy");
		Category category3 = new Category("Children");
		
		
		Book book1 = new Book("Hyvä kirja", "Janne", "35353-2", 2004, category1);
		Book book2 = new Book("Huono kirja", "Kalle", "45645-2", 1550, category2);
		Book book3 = new Book("Iha jees kirja", "Maarit", "62623-2", 1890, category3);
		
		
		cRep.save(category1);
		cRep.save(category2);
		cRep.save(category3);
		
		bRep.save(book1);
		bRep.save(book2);
		bRep.save(book3);
		

	    };
	}

}
