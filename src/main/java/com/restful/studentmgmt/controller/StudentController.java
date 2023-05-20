package com.restful.studentmgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.restful.studentmgmt.entity.Student;
import com.restful.studentmgmt.service.StudentService;

@Controller
@RequestMapping("/students")

public class StudentController {
	
//	/StudentManagement/students/showFormForUpdate
//	/StudentManagement/students/save
//	/StudentManagement/students/list
//	/StudentManagement/students/delete
//	/StudentManagement/students/showFormForAdd
	@Autowired
	StudentService service;
	
	@RequestMapping("/list")
	public String viewAllStudents(Model model) {
		List<Student> students = service.getAllStudents();
		model.addAttribute("Students", students);
		return "list-Students";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Student student = new Student();
		model.addAttribute("Student", student);
		return "student-form";
	}
	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(Model model, @RequestParam(name="studentId") int id) {
		Student student = service.getStudentById(id);
		model.addAttribute("Student", student);
		return "student-form";
	}
	
	@RequestMapping("/delete")
	public String delete(@RequestParam(name="studentId") int id) {
		service.deleteByStudentId(id);
		return "redirect:/student/list";
	}
	
	@RequestMapping("/save")
	public String save(@RequestParam(name="id") int id, @RequestParam(name="firstName") String firstName, @RequestParam(name="lastName") String lastName, @RequestParam(name="course") String course, @RequestParam(name="country") String country) {
		Student student;
		if(id==0) {
			student = new Student();
		}
		else {
			student = service.getStudentById(id);
		}
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setCourse(course);
		student.setCountry(country);
		service.addOrUpdate(student);
		return "redirect:/student/list";
	}
	
}
