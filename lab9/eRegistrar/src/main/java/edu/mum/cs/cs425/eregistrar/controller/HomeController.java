package edu.mum.cs.cs425.eregistrar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.cs.cs425.eregistrar.model.Student;
import edu.mum.cs.cs425.eregistrar.repository.StudentRepository;

@Controller
@RequestMapping("/eregistrar")

public class HomeController {
	@Autowired
	private StudentRepository stdRep;

	@GetMapping("/home")
	public String displayHomePage() {
		return "home/index";
	}

	//----------- read ----------------------------
	@GetMapping("/students")
	public String listStudents(Model model) {
		List<Student> students = stdRep.findAll();
		model.addAttribute("students", students);
		return "student/studentlist";
	}

	//------------ create new ------------------
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("student", new Student());
		return "student/studentnew";
	}

	@PostMapping("/register")
	public String registerStudent(@ModelAttribute("student") Student student) {
		stdRep.save(student);
		return "redirect:/eregistrar/students";
	}
	
	//-------------- delete------------------
	//@DeleteMapping("/students/{id}")
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable Long id) {
		stdRep.deleteById(id); // Implement this method in your service
        return "redirect:/eregistrar/students"; // Redirect to the list of students after deletion
    }
	
	//--------------edit--------------------
	@GetMapping("/edit/{id}")
	public String editStudent(@PathVariable Long id, Model model) {
		Student student =  stdRep.findById(id).get(); // Implement this method in your service
		model.addAttribute("student", student);
		return "student/studentedit"; // Redirect to the list of students after deletion
    }
	
	@PostMapping("/edit/{id}")
	public String saveStudent(@PathVariable Long id, @ModelAttribute("student") Student newStudent) {
		Student student =  stdRep.findById(id).get();
		student.setFirstName(newStudent.getFirstName());
		student.setMiddleName(newStudent.getMiddleName());
		student.setLastName(newStudent.getLastName());
		student.setCgpa(newStudent.getCgpa());
		student.setDateOfEnrollment(newStudent.getDateOfEnrollment());
		student.setIsInternational(newStudent.getIsInternational());
		stdRep.save(student);
		return "redirect:/eregistrar/students"; // Redirect to the list of students after deletion
    }
}
