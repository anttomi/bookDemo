package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.domain.BookRepository;
import com.example.demo.domain.Book;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
	    return (args) -> {
		Book book1 = new Book("Hyvä kirja", "Janne", "35353-2", 2004, 3);
		Book book2 = new Book("Huono kirja", "Kalle", "45645-2", 1550, 10.70);
		Book book3 = new Book("Iha jees kirja", "Maarit", "62623-2", 1890, 200);
		
		repository.save(book1);
		repository.save(book2);
		repository.save(book3);
		

	    };
	}

}
