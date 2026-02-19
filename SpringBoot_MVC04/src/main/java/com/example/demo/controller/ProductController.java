package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Product4;
import com.example.demo.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("pro", new Product4());
		model.addAttribute("products", productService.viewProduct());
		return "index";
	}
	
	@PostMapping("/addProduct")
	public String addProduct(@ModelAttribute("products") Product4 product) {
		productService.addOrUpdate(product);
		return "redirect:/";
	}
	
	@GetMapping("/delete")
	public String deleteProduct(@RequestParam("id") int id) {
		productService.deleteProduct(id);
		return "redirect:/";
	}
	
	@GetMapping("/update")
	public String updateProduct(@RequestParam("id") int id, Model model) {
		model.addAttribute("pro", productService.getById(id));
		model.addAttribute("products", productService.viewProduct());
		return "index";
	}
}
