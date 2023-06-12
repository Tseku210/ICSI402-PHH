package com.example.uliral.model.DAO;

import com.example.uliral.model.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public StudentDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(Student student) {
        String sql = "INSERT INTO Student (studentId, firstName, lastName, email, phoneNo) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, student.getStudent_id(), student.getFirstName(), student.getLastName(), student.getEmail(), student.getPhoneNo());
    }

    @Override
    public Student findById(String id) {
        String sql = "SELECT * FROM Student WHERE studentId = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new StudentRowMapper());
    }

    @Override
    public List<Student> findAll(String filter) {
        if (filter.equals("")) {
            String sql = "SELECT * FROM Student";
            return jdbcTemplate.query(sql, new StudentRowMapper());
        }
        String sql = "SELECT * FROM Student WHERE firstName LIKE ? OR lastName LIKE ? OR studentId LIKE ?";
        return jdbcTemplate.query(sql, new Object[]{"%" + filter + "%", "%" + filter + "%", "%" + filter + "%"}, new StudentDaoImpl.StudentRowMapper());
    }

    @Override
    public boolean deleteById(String id) {
        String sql = "DELETE FROM Student WHERE studentId = ?";
        int rowsAffected = jdbcTemplate.update(sql, id);

        return rowsAffected > 0;
    }

    @Override
    public void update(Student student) {
        String sql = "UPDATE Student SET firstName = ?, lastName = ?, email = ?, phoneNo = ? WHERE studentId = ?";
        jdbcTemplate.update(sql, student.getFirstName(), student.getLastName(), student.getEmail(), student.getPhoneNo(), student.getStudent_id());
    }

    private static final class StudentRowMapper implements RowMapper<Student> {
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student student = new Student();
            student.setStudent_id(rs.getString("studentId"));
            student.setFirstName(rs.getString("firstName"));
            student.setLastName(rs.getString("lastName"));
            student.setEmail(rs.getString("email"));
            student.setPhoneNo(rs.getString("phoneNo"));
            return student;
        }
    }
}
