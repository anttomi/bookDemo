package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {
    
    @GetMapping(value="/index")
    public String bookForm(Model model) {
	

	model.addAttribute("msg", "Hello");

        return "index";
    }
/*
    @RequestMapping(value="/index", method=RequestMethod.POST)
    public String bookSubmit(Model model) {

        return "index";
    }
    */
}

//third commit