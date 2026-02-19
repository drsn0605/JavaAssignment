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
import com.model.Student4;

@Controller
public class HomeController {
	
	@Autowired
	StudentDao dao;
	
	@RequestMapping("/")
	public String index(Model model) {
		Student4 st = new Student4();
		model.addAttribute("st", st);
		model.addAttribute("students", dao.viewStudent());
		return "index";
	}
	
	@PostMapping("/addStudent")
	public String addStudent(@ModelAttribute("st") Student4 st) {
		dao.addOrUpdate(st);
		return "redirect:/";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		dao.deleteStudent(id);
		return "redirect:/";
	}
	
	@GetMapping("/update")
	public String update(@RequestParam("id") int id, Model model) {
		Student4 st = dao.getStudentById(id);
		model.addAttribute("st", st);
		model.addAttribute("students", dao.viewStudent());
		return "index";
		
	}
}
