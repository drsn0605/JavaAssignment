package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index() {    //here method name[index()] can be anything.
		return "index";   //here "index" is the name of jsp file.(index.jsp)
	}
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}
}
