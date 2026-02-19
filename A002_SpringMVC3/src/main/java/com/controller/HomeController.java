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
import com.model.Student3;

@Controller
public class HomeController {
	
	@Autowired
	StudentDao dao;
	
	@RequestMapping("/")
	public String index(Model model) {
		Student3 st = new Student3();
		model.addAttribute("st", st);
		model.addAttribute("students", dao.viewStudent());
		return "index";
	}
	
	@PostMapping("/addStudent")
	public String addStudent(@ModelAttribute("st") Student3 st) {
		dao.addOrUpdate(st);
		return "redirect:/";
	}
	
	@GetMapping("/update")
	public String updateStudent(@RequestParam("id") int id, Model model) {
		Student3 st = dao.studentById(id);
		model.addAttribute("st", st);
		model.addAttribute("students", dao.viewStudent());
		return "index";
	}
	
	@GetMapping("/delete")
	public String deleteStudent(@RequestParam("id") int id) {
		Student3 st = dao.studentById(id);
		dao.deleteStudent(id);
		return "redirect:/";
	}
}
