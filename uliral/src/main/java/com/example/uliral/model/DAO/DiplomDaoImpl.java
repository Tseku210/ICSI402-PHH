package com.example.uliral.model.DAO;

import com.example.uliral.model.entities.Diplom;
import com.example.uliral.model.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DiplomDaoImpl implements DiplomDao{
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public DiplomDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean insert(Diplom diplom) {
        String sql = "INSERT INTO Diploma (student_id, degreeName, universityName, graduationYear) VALUES (?, ?, ?, ?)";
        int rows = jdbcTemplate.update(sql, diplom.getStudent().getStudent_id(), diplom.getDegreeName(), diplom.getUniversityName(), diplom.getGraduationYear());

        return rows > 0;
    }

    @Override
    public Diplom findById(int id) {
        String sql = "SELECT * FROM Diploma WHERE diploma_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new DiplomDaoImpl.DiplomRowMapper());
    }

    @Override
    public List<Diplom> findAll(String filter) {
        if (filter.equals("")) {
            String sql = "SELECT * FROM Diploma";
            return jdbcTemplate.query(sql, new DiplomDaoImpl.DiplomRowMapper());
        }
        String sql = "SELECT * FROM Diploma WHERE degreeName LIKE ? OR universityName LIKE ?";
        return jdbcTemplate.query(sql, new Object[]{"%" + filter + "%", "%" + filter + "%"}, new DiplomDaoImpl.DiplomRowMapper());
    }

    @Override
    public boolean deleteById(int id) {
        String sql = "DELETE FROM Diploma WHERE diploma_id = ?";
        int rows = jdbcTemplate.update(sql, id);

        return rows > 0;
    }

    @Override
    public void update(Diplom diplom) {
        String sql = "UPDATE Diploma SET student_id = ?, degreeName = ?, universityName = ?, graduationYear = ? WHERE diploma_id = ?";
        jdbcTemplate.update(sql, diplom.getStudent().getStudent_id(), diplom.getDegreeName(), diplom.getUniversityName(), diplom.getGraduationYear(), diplom.getId());
    }

    private static final class DiplomRowMapper implements RowMapper<Diplom> {
        @Override
        public Diplom mapRow(ResultSet rs, int rowNum) throws SQLException {
            Diplom diplom = new Diplom();
            diplom.setId(rs.getInt("diploma_id"));

            Student student = new Student(rs.getString("student_id"));
            diplom.setStudent(student);

            diplom.setDegreeName(rs.getString("degreeName"));
            diplom.setUniversityName(rs.getString("universityName"));
            diplom.setGraduationYear(rs.getString("graduationYear"));
            return diplom;
        }
    }
}
