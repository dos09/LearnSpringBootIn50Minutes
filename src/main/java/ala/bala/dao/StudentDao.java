package ala.bala.dao;

import java.util.Collection;

import ala.bala.entity.Student;

public interface StudentDao {

	Collection<Student> getAllStudents();

	Student getStudentById(int id);

	void removeStudentById(int id);

	void updateStudent(Student student);

	void insertStudent(Student student);

}