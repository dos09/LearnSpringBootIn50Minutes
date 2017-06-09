package ala.bala.dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import ala.bala.entity.Student;

@Repository
@Qualifier("fakeData")
public class FakeStudentDao implements StudentDao {
	private static Map<Integer, Student> students;
	
	static {
		students = new HashMap<>();
		students.put(1, new Student(1, "Ivan", "Computer Science"));
		students.put(2, new Student(2, "Gosho", "Finance"));
		students.put(3, new Student(3, "Misho", "Maths"));
	}

	/* (non-Javadoc)
	 * @see ala.bala.dao.StudentDao#getAllStudents()
	 */
	@Override
	public Collection<Student> getAllStudents() {
		return students.values();
	}
	
	/* (non-Javadoc)
	 * @see ala.bala.dao.StudentDao#getStudentById(int)
	 */
	@Override
	public Student getStudentById(int id) {
		return students.get(id);
	}

	/* (non-Javadoc)
	 * @see ala.bala.dao.StudentDao#removeStudentById(int)
	 */
	@Override
	public void removeStudentById(int id) {
		students.remove(id);
	}
	
	/* (non-Javadoc)
	 * @see ala.bala.dao.StudentDao#updateStudent(ala.bala.entity.Student)
	 */
	@Override
	public void updateStudent(Student student) {
		Student existingStudent = students.get(student.getId());
		existingStudent.setName(student.getName());
		existingStudent.setCourse(student.getCourse());
	}

	/* (non-Javadoc)
	 * @see ala.bala.dao.StudentDao#insertStudent(ala.bala.entity.Student)
	 */
	@Override
	public void insertStudent(Student student) {
		students.put(student.getId(), student);
	}
}
