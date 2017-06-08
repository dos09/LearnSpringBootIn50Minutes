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
}
