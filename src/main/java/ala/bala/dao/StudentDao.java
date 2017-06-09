package ala.bala.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import ala.bala.entity.Student;

@Repository
public class StudentDao {
	private static Map<Integer, Student> students;
	
	static {
		students = new HashMap<>();
		students.put(1, new Student(1, "Ivan", "Computer Science"));
		students.put(2, new Student(2, "Gosho", "Finance"));
		students.put(3, new Student(3, "Misho", "Maths"));
	}

	public Collection<Student> getAllStudents() {
		return students.values();
	}
	
	public Student getStudentById(int id) {
		return students.get(id);
	}

	public void removeStudentById(int id) {
		students.remove(id);
	}
	
	public void updateStudent(Student student) {
		Student existingStudent = students.get(student.getId());
		existingStudent.setName(student.getName());
		existingStudent.setCourse(student.getCourse());
	}

	public void insertStudent(Student student) {
		students.put(student.getId(), student);
	}
}
