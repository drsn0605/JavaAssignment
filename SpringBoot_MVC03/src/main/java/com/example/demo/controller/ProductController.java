package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Product3;
import com.example.demo.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/")
	public String index(Model model ) {
		model.addAttribute("product", new Product3());
		model.addAttribute("products", productService.viewProducts());
		return "index";
	}
	
	@PostMapping("/addProduct")
	public String addProduct(@ModelAttribute("products") Product3 prod) {
		productService.addOrUpdate(prod);
		return "redirect:/";
	}
	
	@GetMapping("/delete")
	public String deleteProd(@RequestParam("id") int id) {
		productService.deleteProduct(id);
		return "redirect:/";
	}
	
	@GetMapping("/update")
	public String updateProd(@RequestParam("id") int id, Model model) {
		model.addAttribute("product", productService.getProductById(id));
		model.addAttribute("products", productService.viewProducts());
		return "index";
		
	}
}
