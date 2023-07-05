package com.employee.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.employee.system.entity.EmpEntity;
import com.employee.system.service.EmpService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;




@Controller
public class EmpController {
	
	@Autowired
	private EmpService empService;

	@GetMapping("/")
	public String home(Model m) {
		
		List<EmpEntity> emp = empService.getAllEmp();
		m.addAttribute("emp",emp);
		
		return "index";
	}
	
	@GetMapping("/addemp")
	public String addEmpForm() {
		return "add_emp";
	}
	
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute EmpEntity e , HttpSession session) {
//	all data of form will be come in e and EmpEntity is a that classname where we define entity 
		System.out.println("all form data is coming here" +e);
		
//		here we create a object of service class and call the method to add the data in mysql database
		empService.addEmp(e);
//		by using HttpSession we can show the pop up msg after successfully  submit the data 
		session.setAttribute("msg", "Employee Added Successfully...");
//		return "index";
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id , Model m) {
		 EmpEntity e = empService.getEmpById(id);
		 m.addAttribute("emp", e);
		 
		 return "edit_Emp_detail";
		 
	}
	
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute EmpEntity e , HttpSession session) {
//		all data of form will be come in e and EmpEntity is a that classname where we define entity 
//			System.out.println("all form data is coming here" +e);
			
//			here we create a object of service class and call the method to add the data in mysql database
			empService.addEmp(e);
//			by using HttpSession we can show the pop up msg after successfully  submit the data 
			session.setAttribute("msg", "Employee data updated Successfully...");
//			return "index";
			return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmp(@PathVariable int id, HttpSession session) {
		empService.deleteEmp(id);
		
//		by using HttpSession we can show the pop up msg after successfully  submit the data 
		session.setAttribute("msg", "Employee data deleted Successfully...");
//		both are same
//		return "index";
		return "redirect:/";
	}
	
}



















