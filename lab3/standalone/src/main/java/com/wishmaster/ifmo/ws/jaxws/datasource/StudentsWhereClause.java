package com.wishmaster.ifmo.ws.jaxws.datasource;

import com.wishmaster.ifmo.ws.jaxws.Util;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentsWhereClause {
    private final String whereClause;
    private final List<Util.ThrowableBiConsumer<PreparedStatement, Integer, SQLException>> setters;

    public StudentsWhereClause(StudentsFilter filter) {
        List<String> whereClauses = new ArrayList<>();
        List<Util.ThrowableBiConsumer<PreparedStatement, Integer, SQLException>> setters = new ArrayList<>();

        if (filter != null) {
            if (filter.getName() != null) {
                whereClauses.add("name ILIKE ?");
                setters.add((stmt, i) -> stmt.setString(i, filter.getName()));
            }
            if (filter.getStudyType() != null) {
                whereClauses.add("study_type ILIKE ?");
                setters.add((stmt, i) -> stmt.setString(i, filter.getStudyType()));
            }
            if (filter.getSpeciality() != null) {
                whereClauses.add("speciality ILIKE ?");
                setters.add((stmt, i) -> stmt.setString(i, filter.getSpeciality()));
            }
            addBoundsFilter(whereClauses, setters, "semester", filter.getSemesterBounds().getFrom(), filter.getSemesterBounds().getTo());
            addBoundsFilter(whereClauses, setters, "debts", filter.getDebtsBounds().getFrom(), filter.getDebtsBounds().getTo());
        }

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

    public String get() {
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
