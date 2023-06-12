package com.example.uliral.model.DAO;

import com.example.uliral.model.entities.Diplom;
import com.example.uliral.model.entities.Internship;
import com.example.uliral.model.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class InternshipDaoImpl implements InternshipDao{
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public InternshipDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean insert(Internship intern) {
        String sql = "INSERT INTO Internship (student_id, companyName, duration) VALUES (?, ?, ?)";
        int rows = jdbcTemplate.update(sql, intern.getStudent().getStudent_id(), intern.getCompanyName(), intern.getDuration());

        return rows > 0;
    }

    @Override
    public Internship findById(int id) {
        String sql = "SELECT * FROM Internship WHERE internship_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new InternshipDaoImpl.InternshipRowMapper());
    }

    @Override
    public List<Internship> findAll(String filter) {
        if (filter.equals("")) {
            String sql = "SELECT * FROM Internship";
            return jdbcTemplate.query(sql, new InternshipDaoImpl.InternshipRowMapper());
        }
        String sql = "SELECT * FROM Internship WHERE companyName LIKE ? OR student_id LIKE ?";
        return jdbcTemplate.query(sql, new Object[]{"%" + filter + "%", "%" + filter + "%"}, new InternshipDaoImpl.InternshipRowMapper());
    }

    @Override
    public boolean deleteById(int id) {
        String sql = "DELETE FROM Internship WHERE internship_id = ?";
        int rows = jdbcTemplate.update(sql, id);

        return rows > 0;
    }

    @Override
    public void update(Internship intern) {
//        String sql = "UPDATE Internship SET st = ?, degreeName = ?, universityName = ?, graduationYear = ? WHERE diploma_id = ?";
//        jdbcTemplate.update(sql, diplom.getStudent().getStudent_id(), diplom.getDegreeName(), diplom.getUniversityName(), diplom.getGraduationYear(), diplom.getId());
    }

    private static final class InternshipRowMapper implements RowMapper<Internship> {
        @Override
        public Internship mapRow(ResultSet rs, int rowNum) throws SQLException {
            Internship internship = new Internship();
            internship.setId(rs.getInt("internship_id"));

            Student student = new Student(rs.getString("student_id"));
            internship.setStudent(student);

            internship.setCompanyName(rs.getString("companyName"));
            internship.setDuration(rs.getInt("duration"));
            return internship;
        }
    }
}
