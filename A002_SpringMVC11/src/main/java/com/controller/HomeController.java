package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dao.StudentDao;
import com.model.Student11;

@Controller
public class HomeController {
	
	@Autowired
	StudentDao dao;
	
	@RequestMapping("/")
	public String index(Model model) {
		Student11 st = new Student11();
		model.addAttribute("st1", st);
		model.addAttribute("students", dao.viewStudents());
		return "index";
	}
	
	@PostMapping("/addStudent")
	public String addStudent(@ModelAttribute("st1") Student11 st) {
		dao.addOrUpdate(st);
		return "redirect:/";
	}
	
	@GetMapping("/delete")
	public String deleteStudent(@RequestParam("id") int id) {
		dao.deleteStudent(id);
		return "redirect:/";
	}
	
	@GetMapping("/update")
	public String updateStudent(@RequestParam("id") int id, Model model) {
		Student11 st = dao.getById(id);
		model.addAttribute("st1", st);
		model.addAttribute("students", dao.viewStudents());
		return "index";
	}
}
