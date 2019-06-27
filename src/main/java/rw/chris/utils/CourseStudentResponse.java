package rw.chris.utils;

import java.util.List;

import rw.chris.model.Course;
import rw.chris.model.Student;

/**
 * @Author: chabiman
 * @FileName: CourseStudentResponse.java
 * @Date: Jun 26, 2019
 * @Package: rw.chris.utils
 * @ProjectName: android_api_crud
 *
 */
public class CourseStudentResponse {

	private boolean error;

	private String message;

	private Long id;

	private Student student;

	private Double average;

	private List<Course> courses;

	/**
	 * @return the error
	 */
	public boolean isError() {
		return error;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * @return the courses
	 */
	public List<Course> getCourses() {
		return courses;
	}

	/**
	 * @param error the error to set
	 */
	public void setError(boolean error) {
		this.error = error;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param student the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
	}

	/**
	 * @param courses the courses to set
	 */
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	/**
	 * @return the average
	 */
	public Double getAverage() {

		Double av = 0.0;
		Double sum = 0.0;
		int courseSize = this.getCourses().size();

		List<Course> c = this.getCourses();
		for (Course course : c) {
			sum += course.getMarks();
		}
		return sum / courseSize;
	}

	/**
	 * @param average the average to set
	 */
	public void setAverage(Double average) {
		this.average = average;
	}
}
