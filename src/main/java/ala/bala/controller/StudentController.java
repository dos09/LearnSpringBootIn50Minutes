package ala.bala.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ala.bala.entity.Student;
import ala.bala.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired // for dependency injection
	private StudentService studentService;

	@RequestMapping(method = RequestMethod.GET) //when a GET request is made to /students
	public Collection<Student> getAllStudents() {
		return studentService.getAllStudents(); //this is returned as array of json objects in the browser
	}

	/*-
		'@PathVariable("id") int id' - this 'int id' parameter is taken from the url's variable 'id', 
		which is specified in 'value = "/{id}"'
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Student getStudentById(@PathVariable("id") int id) {
		return studentService.getStudentById(id);
	}

	// @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@RequestMapping(value = "/delete{id}")
	public void removeStudentById(@PathVariable("id") int id) {
		System.out.println("Delete the one with id = " + id);
		studentService.removeStudentById(id);
	}

	/*- 
	   To test that, for Chrome download 'Postman', for Firefox download 'HttpRequester'
	   then change method to PUT and for request body data put valid json:
	   {"id":1,"name":"Ivanushka Glupaka","course":"Computer Science"}
	   
	   '@RequestBody Student student' - to parse the request's body
	 */
	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateStudent(@RequestBody Student student) {
		System.out.println("Update student: " + student);
		studentService.updateStudent(student);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertStudent(@RequestBody Student student) {
		System.out.println("Add student: " + student);
		studentService.insertStudent(student);
	}
	
}
