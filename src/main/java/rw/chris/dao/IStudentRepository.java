
package rw.chris.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rw.chris.model.Student;

/**
 * @Author: chabiman
 * @FileName: IStudentRepository.java
 * @Date: Jun 22, 2019
 * @Package: rw.chris.dao
 * @ProjectName: android_api_crud
 *
 */
public interface IStudentRepository extends JpaRepository<Student, Long> {

	/**
	 * @param studentId
	 * @return
	 */
	Student findByStudentId(Long studentId);

	/*
	 *
	 * @see org.springframework.data.jpa.repository.JpaRepository#findAll()
	 */
	@Override
	List<Student> findAll();

}
