package ala.bala.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ala.bala.entity.Student;

@Repository
@Qualifier("MySQLData")
public class MySQLStudentDao implements StudentDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public Collection<Student> getAllStudents() {
		return jdbcTemplate.query("select id, name, course from students", new StudentRowMapper());
	}

	@Override
	public Student getStudentById(int id) {
		return jdbcTemplate.queryForObject("select id, name, course from students where id = ?", new StudentRowMapper(),
				id);
	}

	@Override
	public void removeStudentById(int id) {
		jdbcTemplate.update("delete from students where id = ?", id);
	}

	@Override
	public void updateStudent(Student student) {
		jdbcTemplate.update("update students set name = ?, course = ? where id = ?",
				new Object[] { student.getName(), student.getCourse(), student.getId() });
	}

	@Override
	public void insertStudent(Student student) {
		jdbcTemplate.update("insert into students (name, course) values(?, ?)",
				new Object[] { student.getName(), student.getCourse() });
	}

	private static class StudentRowMapper implements RowMapper<Student> {
		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Student(rs.getInt("id"), rs.getString("name"), rs.getString("course"));
		}
	}

}
