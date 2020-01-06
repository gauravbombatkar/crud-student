package com.crudstudent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.crudstudent.model.Student;
import com.crudstudent.service.StudentService;
import com.crudstudent.validation.StudentValidator;

/**
 * @author Gaurav Bombatkar
 */

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@Autowired
	private StudentValidator studentValidator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.addValidators(studentValidator);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String displayLogin(Model model, @ModelAttribute Student student) {
		model.addAttribute("register", new Student());
		return "register";
	}

	@PostMapping("/college/student")
	public String createStudent(Model model, @ModelAttribute("student") @Validated Student student,
			BindingResult result) {

		if (result.hasErrors()) {
			return "register";
		}
		studentService.createStudent(student, null);

		return "redirect:/";
	}

	@GetMapping("/college/student/edit/")
	public String editPage(Model model, @RequestParam(value = "id", required = false) Long id) {

		Student student = new Student();

		if (id != null) {
			student = studentService.getStudentById(id);
		}
		model.addAttribute("student", student);

		return "register";
	}

	@GetMapping("/college/student/")
	public String deleteUser(@RequestParam("id") Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/";
	}

	@GetMapping("/college/student/getAll")
	public List<Student> getAll() {
		return studentService.getAll();
	}

	@ModelAttribute("studentlist")
	public List<Student> studentDisplay(Model model) {
		List<Student> list = studentService.getAll();
		return list;
	}

}
