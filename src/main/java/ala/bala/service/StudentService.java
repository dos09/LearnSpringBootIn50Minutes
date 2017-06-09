package ala.bala.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ala.bala.dao.StudentDao;
import ala.bala.entity.Student;

@Service
public class StudentService {

	@Autowired
	// when more than one implementations of StudentDao interface exist, must
	// tell which one to use, the used qualifier must be present in the
	// implementation class we are going to use
	@Qualifier("fakeData")
	private StudentDao studentDao;

	public Collection<Student> getAllStudents() {
		return studentDao.getAllStudents();
	}

	public Student getStudentById(int id) {
		return studentDao.getStudentById(id);
	}

	public void removeStudentById(int id) {
		studentDao.removeStudentById(id);
	}

	public void updateStudent(Student student) {
		studentDao.updateStudent(student);
	}

	public void insertStudent(Student student) {
		studentDao.insertStudent(student);
	}
}
