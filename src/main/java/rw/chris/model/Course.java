package rw.chris.model;

/**
 * @Author: chabiman
 * @FileName: Course.java
 * @Date: Jun 26, 2019
 * @Package: rw.chris.model
 * @ProjectName: android_api_crud
 *
 */
public class Course {

	private Long id;

	private String courseName;

	private String courseCode;

	private Double marks;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * @return the courseCode
	 */
	public String getCourseCode() {
		return courseCode;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * @param courseCode the courseCode to set
	 */
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	/**
	 * @return the marks
	 */
	public Double getMarks() {
		return marks;
	}

	/**
	 * @param marks the marks to set
	 */
	public void setMarks(Double marks) {
		this.marks = marks;
	}

}
