package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.model.Product;
import com.service.ProductService;

@Controller
public class HomeController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("product", new Product());
		model.addAttribute("products", productService.allproduct());
		return "index";
	}
	
	@PostMapping("/addProduct")
	public String addProduct(@ModelAttribute("product") Product product) {
		productService.addOrUpdate(product);
		return "redirect:/";
		
	}
}
