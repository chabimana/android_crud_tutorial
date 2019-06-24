
package rw.chris.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rw.chris.model.Student;
import rw.chris.service.IStudentService;
import rw.chris.utils.StudentListResponse;

/**
 * @Author: chabiman
 * @FileName: MainController.java
 * @Date: Jun 22, 2019
 * @Package: rw.chris.controller
 * @ProjectName: android_api_crud
 *
 */
@RestController
@RequestMapping("/api")
public class MainController {

	@Autowired
	private IStudentService studentService;

	// Using @RequestParam for now. Still searching for the way to use @RequestBody for seek of simplicity
	@PostMapping("/create_student")
	public ResponseEntity<StudentListResponse> createStudent(@RequestParam String firstName,
			@RequestParam String lastName, @RequestParam String regNumber, @RequestParam String gender) {

		System.out.println("Reaching at this point at least");

		// Getting the student data from the client request and create a new student object to be saved
		Student student = new Student();
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setRegNumber(regNumber);
		student.setGender(gender);

		StudentListResponse response = new StudentListResponse();
		if (studentService.createStudent(student) != null) {
			response.setError(false);
			response.setMessage("Student Saved Successfully");
			response.setStudents(studentService.findAllStudent());
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		}
		response.setError(true);
		response.setMessage("Student Not Saved");
		response.setStudents(studentService.findAllStudent());
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	@GetMapping("/get_all")
	public ResponseEntity<StudentListResponse> getAllStudents() {
		StudentListResponse response = new StudentListResponse();
		response.setMessage("Request successfully completed");
		response.setError(false);
		response.setStudents(studentService.findAllStudent());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
