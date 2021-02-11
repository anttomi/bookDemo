package com.example.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.example.demo.domain.BookRepository;

@Controller
public class BookController {
    
    @Autowired
    private BookRepository repository;
    
    @GetMapping(value="/booklist")
    public String bookForm(Model model) {
	model.addAttribute("books", repository.findAll());

	

        return "booklist";
    }
/*
    @RequestMapping(value="/index", method=RequestMethod.POST)
    public String bookSubmit(Model model) {

        return "index";
    }
    */
}

//third commit