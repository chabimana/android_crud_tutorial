
package rw.chris.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import rw.chris.model.Course;
import rw.chris.model.Student;
import rw.chris.service.IStudentService;
import rw.chris.utils.CourseStudentResponse;
import rw.chris.utils.StudentListResponse;

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

	@PostMapping("/get_one_student")
	public ResponseEntity<StudentListResponse> getStudentByRegNumber(@RequestParam String regNumber) {
		StudentListResponse response = new StudentListResponse();
		System.out.println("Hitting here");
		Student student = studentService.findStudentByRegNumber(regNumber);

		if (student != null) {
			response.setError(false);
			response.setMessage("Student found from the back end");
			List<Student> students = new ArrayList<>();
			students.add(student);
			response.setStudents(students);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		response.setError(true);
		response.setStudents(null);
		response.setMessage("No Student found with provided reg number: " + regNumber);
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	@PostMapping("/get_student_results")
	public ResponseEntity<CourseStudentResponse> getStudentResults(@RequestParam String regNumber) {
		System.out.println(regNumber + " search box");
		CourseStudentResponse response = new CourseStudentResponse();

		List<Course> courses = new ArrayList<>();
		// Sample Data to be returned
		if (regNumber.equals("PS123")) {
			response.setError(false);
			response.setMessage("Student Results fetched successfully");
			response.setId((long) 12);

			Student student = new Student();
			student.setFirstName("MUNANA");
			student.setLastName("Kelly");
			student.setGender("FEMALE");
			student.setRegNumber("PS123");
			response.setStudent(student);

			Course one = new Course();
			one.setCourseCode("ICT345");
			one.setCourseName("Artificial Intelligence");
			one.setId((long) 1);
			one.setMarks(34.5);

			Course two = new Course();
			two.setCourseCode("ICT350");
			two.setCourseName("Mobile Apps Development");
			two.setId((long) 2);
			two.setMarks(89.5);

			courses.add(one);
			courses.add(two);

			response.setCourses(courses);

			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		response.setError(true);
		response.setMessage("Student not found");
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
}
