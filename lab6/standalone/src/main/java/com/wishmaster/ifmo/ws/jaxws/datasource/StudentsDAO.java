package com.wishmaster.ifmo.ws.jaxws.datasource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class StudentsDAO {

    private static final String INSERT_STUDENT = "INSERT INTO students (name, study_type, speciality, semester, debts) VALUES (?, ?, ?, ?, ?) RETURNING id";
    private static final String SELECT_STUDENT = "SELECT id, name, study_type, speciality, semester, debts FROM students WHERE id = ?";
    private static final String UPDATE_STUDENT = "UPDATE students SET name = ?, study_type = ?, speciality = ?, semester = ?, debts = ? WHERE id = ? RETURNING id, name, study_type, speciality, semester, debts";
    private static final String SELECT_STUDENTS = "SELECT id, name, study_type, speciality, semester, debts FROM students";
    private static final String DELETE_STUDENTS = "DELETE FROM students WHERE id = ? RETURNING id";

    private final Connection connection;

    public StudentsDAO(Connection connection) {
        this.connection = connection;
    }

    public Integer add(Student entity) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(INSERT_STUDENT);
        int i = 0;
        stmt.setString(++ i, entity.getName());
        stmt.setString(++ i, entity.getStudyType());
        stmt.setString(++ i, entity.getSpeciality());
        stmt.setInt(++ i, entity.getSemester());
        stmt.setInt(++ i, entity.getDebts());

        return retrieveId(stmt.executeQuery()).getAsInt();
    }

    public Optional<Student> get(int id) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(SELECT_STUDENT);
        stmt.setInt(1, id);

        return retrieveStudent(stmt.executeQuery());
    }


    public Optional<Student> update(Student entity) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(UPDATE_STUDENT);
        int i = 0;
        stmt.setString(++ i, entity.getName());
        stmt.setString(++ i, entity.getStudyType());
        stmt.setString(++ i, entity.getSpeciality());
        stmt.setInt(++ i, entity.getSemester());
        stmt.setInt(++ i, entity.getDebts());
        stmt.setInt(++ i, entity.getId());

        return retrieveStudent(stmt.executeQuery());
    }

    public List<Student> all() throws SQLException {
        Statement stmt = connection.createStatement();
        return retrieveStudents(stmt.executeQuery(SELECT_STUDENTS));
    }

    public List<Student> search(StudentsFilter filter) throws SQLException {
        StudentsWhereClause whereClause = new StudentsWhereClause(filter);
        if (whereClause.isEmpty()) {
            return all();
        } else {
            PreparedStatement stmt = connection.prepareStatement(SELECT_STUDENTS + whereClause.get());
            whereClause.setPreparedStatementParameters(stmt);
            return retrieveStudents(stmt.executeQuery());
        }
    }

    public boolean delete(int id) throws SQLException {
        PreparedStatement stmt = connection.prepareStatement(DELETE_STUDENTS);
        stmt.setInt(1, id);
        return retrieveId(stmt.executeQuery()).isPresent();
    }

    public List<Student> retrieveStudents(ResultSet rs) throws SQLException {
        List<Student> result = new ArrayList<>();
        while (rs.next()) {
            result.add(retrieveStudentEntity(rs));
        }
        return result;
    }

    public Optional<Student> retrieveStudent(ResultSet rs) throws SQLException {
        if (rs.next()) {
            return Optional.of(retrieveStudentEntity(rs));
        } else {
            return Optional.empty();
        }
    }

    public Student retrieveStudentEntity(ResultSet rs) throws SQLException {
        int i = 0;
        return new Student(
            rs.getInt(++ i),
            rs.getString(++ i),
            rs.getString(++ i),
            rs.getString(++ i),
            rs.getInt(++ i),
            rs.getInt(++ i)
        );
    }

    public OptionalInt retrieveId(ResultSet rs) throws SQLException  {
        if (rs.next()) {
            return OptionalInt.of(rs.getInt(1));
        } else {
            return OptionalInt.empty();
        }
    }
}