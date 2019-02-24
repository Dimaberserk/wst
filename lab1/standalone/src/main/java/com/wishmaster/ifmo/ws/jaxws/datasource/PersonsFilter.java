package com.wishmaster.ifmo.ws.jaxws.datasource;

import com.wishmaster.ifmo.ws.jaxws.Util;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonsFilter {
    private final String whereClause;
    private final List<Util.ThrowableBiConsumer<PreparedStatement, Integer, SQLException>> setters;

    public PersonsFilter(String name, String surname, Integer ageFrom, Integer ageTo, String street, Integer houseNumberFrom, Integer houseNumberTo) {
        List<String> whereClauses = new ArrayList<>();
        List<Util.ThrowableBiConsumer<PreparedStatement, Integer, SQLException>> setters = new ArrayList<>();

        if (name != null) {
            whereClauses.add("name ILIKE ?");
            setters.add((stmt, i) -> stmt.setString(i, name));
        }
        if (surname != null) {
            whereClauses.add("surname ILIKE ?");
            setters.add((stmt, i) -> stmt.setString(i, surname));
        }
        addBoundsFilter(whereClauses, setters, "age", ageFrom, ageTo);
        if (surname != null) {
            whereClauses.add("street ILIKE ?");
            setters.add((stmt, i) -> stmt.setString(i, street));
        }
        addBoundsFilter(whereClauses, setters, "house", houseNumberFrom, houseNumberTo);

        this.whereClause = whereClauses.isEmpty() ? "" : " WHERE " + String.join(" AND ", whereClauses);
        this.setters = setters;
    }

    private static void addBoundsFilter(List<String> whereClauses, List<Util.ThrowableBiConsumer<PreparedStatement, Integer, SQLException>> setters, String columnName, Integer bottom, Integer top) {
        if (bottom != null) {
            whereClauses.add(columnName + " > ?");
            setters.add((stmt, i) -> stmt.setInt(i, bottom));
        }
        if (top != null) {
            whereClauses.add(columnName + " < ?");
            setters.add((stmt, i) -> stmt.setInt(i, top));
        }
    }

    public String getWhereClause() {
        return whereClause;
    }

    public boolean isEmpty() {
        return whereClause.isEmpty();
    }

    public void setPreparedStatementParameters(PreparedStatement statement) throws SQLException {
        int i = 0;
        for (Util.ThrowableBiConsumer<PreparedStatement, Integer, SQLException> setter : setters) {
            setter.accept(statement, ++i);
        }
    }
}
