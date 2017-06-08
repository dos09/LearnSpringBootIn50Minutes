package ala.bala.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ala.bala.dao.StudentDao;
import ala.bala.entity.Student;

@Service
public class StudentService {

	@Autowired
	private StudentDao studentDao;

	public Collection<Student> getAllStudents() {
		return studentDao.getAllStudents();
	}
}
