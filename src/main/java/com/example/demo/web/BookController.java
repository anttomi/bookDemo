package com.example.demo.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.Book;
import com.example.demo.domain.BookRepository;
import com.example.demo.domain.CategoryRepository;

@Controller
public class BookController {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CategoryRepository cateRepository;

    @GetMapping(value = "/booklist")
    public String bookForm(Model model) {
	model.addAttribute("books", bookRepository.findAll());
	return "booklist";
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> bookListRest() {
	return (List<Book>) bookRepository.findAll();
    }

    @GetMapping(value = "/login")
    public String login() {
	return "login";
    }

    @RequestMapping(value = "/add")
    public String addBook(Model model) {
	model.addAttribute("book", new Book());
	model.addAttribute("categories", cateRepository.findAll());
	return "bookadd";
    }

    @RequestMapping(value = "/edit/{id}")
    public String editBook(@PathVariable("id") Long bookId, Model model) {
	model.addAttribute("book", bookRepository.findById(bookId));
	model.addAttribute("categories", cateRepository.findAll());
	return "editbook";
    }

    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {
	return bookRepository.findById(bookId);
    }

    @GetMapping(value = "/delete/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
	bookRepository.deleteById(bookId);
	return "redirect:../booklist";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String bookSave(Book book) {
	bookRepository.save(book);
	return "redirect:booklist";
    }

}
