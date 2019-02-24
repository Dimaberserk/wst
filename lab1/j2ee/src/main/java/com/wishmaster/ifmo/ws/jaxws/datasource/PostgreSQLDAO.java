package com.wishmaster.ifmo.ws.jaxws.datasource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PostgreSQLDAO {

    private static final String SELECT_PERSONS = "SELECT name, surname, age, street, house FROM persons";

    private final Connection connection;

    public PostgreSQLDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Person> getAllPersons() {
        List<Person> persons = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            retrievePersons(stmt.executeQuery(SELECT_PERSONS), persons);
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return persons;
    }

    public List<Person> getPersons(PersonsFilter filter) {
        List<Person> persons = new ArrayList<>();
        try {
            if (filter.isEmpty()) {
                return getAllPersons();
            } else {
                PreparedStatement stmt = connection.prepareStatement(SELECT_PERSONS + filter.getWhereClause());
                filter.setPreparedStatementParameters(stmt);
                retrievePersons(stmt.executeQuery(), persons);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return persons;
    }

    public void retrievePersons(ResultSet rs, List<Person> persons) throws SQLException {
        while (rs.next()) {
            int i = 0;
            Person person = new Person(
                rs.getString(++i),
                rs.getString(++i),
                rs.getInt(++i),
                rs.getString(++i),
                rs.getInt(++i)
            );
            persons.add(person);
        }
    }
}