package com.example.demo;

import com.example.demo.domain.Book;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.domain.BookRepository;
import com.example.demo.domain.Category;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTest {
    
    @Autowired
    private BookRepository repository;
    
    @Test
    public void findByTitleShouldReturnBook() {
	List<Book> books = repository.findByTitle("Hyvä kirja");
	
	assertThat(books).hasSize(1);
	assertThat(books.get(0).getAuthor()).isEqualTo("Janne");
    }
    
    @Test
    public void createNewBook() {
	Book book = new Book("Jea Kirja", "Kalle", "1231232-2", 1929, new Category("Horror"));
	repository.save(book);
	assertThat(book.getId()).isNotNull();
    }

}
