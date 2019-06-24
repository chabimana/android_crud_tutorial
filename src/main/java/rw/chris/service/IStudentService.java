/*
 * Copyright (c)  2018. Irembo
 *
 * All rights reserved.
 */

package rw.chris.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import rw.chris.model.Student;

/**
 * @Author: chabiman
 * @FileName: IStudentService.java
 * @Date: Jun 22, 2019
 * @Package: rw.chris.service
 * @ProjectName: android_api_crud
 *
 */
public interface IStudentService {

	/**
	 * @param student
	 * @return
	 */
	public Student createStudent(@NotNull Student student);

	/**
	 * @return
	 */
	public List<Student> findAllStudent();

}
