
package rw.chris.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rw.chris.dao.IStudentRepository;
import rw.chris.model.Student;

/**
 * @Author: chabiman
 * @FileName: StudentService.java
 * @Date: Jun 22, 2019
 * @Package: rw.chris.service
 * @ProjectName: android_api_crud
 *
 */
@Service
public class StudentService implements IStudentService {

	@Autowired
	private IStudentRepository studentRepository;

	/*
	 *
	 * @see rw.chris.service.IStudentService#createStudent(rw.chris.model.Student)
	 */
	@Override
	public Student createStudent(Student student) {
		try {
			return studentRepository.save(student);
		} catch (Exception e) {
			throw e;
		}
	}

	/*
	 *
	 * @see rw.chris.service.IStudentService#findAllStudent()
	 */
	@Override
	public List<Student> findAllStudent() {
		try {
			if (studentRepository.findAll().isEmpty()) {
				Student student = new Student();
				student.setFirstName("Ingabire");
				student.setLastName("Emma");
				student.setGender("F");
				student.setRegNumber("PS/20282");
				List<Student> studentList = new ArrayList<>();
				studentList.add(student);
				return studentList;
			}
			return studentRepository.findAll();
		} catch (Exception ex) {
			throw ex;
		}
	}
}
