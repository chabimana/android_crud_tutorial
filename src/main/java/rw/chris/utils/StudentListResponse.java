
package rw.chris.utils;

import java.util.List;

import rw.chris.model.Student;

/**
 * @Author: chabiman
 * @FileName: StudentListResponse.java
 * @Date: Jun 22, 2019
 * @Package: rw.chris.utils
 * @ProjectName: android_api_crud
 *
 */
public class StudentListResponse {

	private boolean error;

	private String message;

	private List<Student> students;

	/**
	 * @return the error
	 */
	public boolean isError() {
		return error;
	}

	/**
	 * @param error the error to set
	 */
	public void setError(boolean error) {
		this.error = error;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @return the students
	 */
	public List<Student> getStudents() {
		return students;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @param students the students to set
	 */
	public void setStudents(List<Student> students) {
		this.students = students;
	}

}
