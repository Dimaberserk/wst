package com.wishmaster.ifmo.ws.jaxws.datasource;

public class StudentsFilter {
    public final String name;
    public final String studyType;
    public final String speciality;
    public final IntBounds semesterBounds;
    public final IntBounds debtsBounds;

    public StudentsFilter(String name, String studyType, String speciality, Integer semesterFrom, Integer semesterTo, Integer debtsFrom, Integer debtsTo) {
        this.name = name;
        this.studyType = studyType;
        this.speciality = speciality;
        this.semesterBounds = new IntBounds(semesterFrom, semesterTo);
        this.debtsBounds = new IntBounds(debtsFrom, debtsTo);
    }

    public StudentsFilter() {
        this(null, null, null, null, null, null, null);
    }

    public String getName() {
        return name;
    }

    public String getStudyType() {
        return studyType;
    }

    public String getSpeciality() {
        return speciality;
    }

    public IntBounds getSemesterBounds() {
        return semesterBounds;
    }

    public IntBounds getDebtsBounds() {
        return debtsBounds;
    }
}
