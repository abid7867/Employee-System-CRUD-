package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.service.EmpService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmpController {
	
	@Autowired
	private EmpService service;
	
	@GetMapping("/")
	public String home(Model m) {
		
		List<EmployeeEntity> emp= service.getAllEmp();
		m.addAttribute("emp", emp);
		
		return "index";
	}
	
	@GetMapping("/addEmp")
	public String addEmp() {
		return "addEmp";
	}
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute EmployeeEntity e , HttpSession session) {
				
		service.addEmp(e);
		session.setAttribute("msg", "Employee Data added successfully...");
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String editEmp(@PathVariable int id , Model m)
	{
		EmployeeEntity e= service.getEmpById(id);
		m.addAttribute("emp", e);
		return "edit";
	}
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute EmployeeEntity e , HttpSession session)
	{	
		service.addEmp(e);
		session.setAttribute("msg", "Employee data updated successfully...");
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id ,  HttpSession session) {
		
		service.deleteEmp(id);
		session.setAttribute("msg", "Employee datadeleted  successfully...");
		return "redirect:/";
	}

}
