package com.wishmaster.ifmo.ws.jaxws.datasource;

public class StudentsFilter {
    private String name;
    private String studyType;
    private String speciality;
    private IntBounds semesterBounds;
    private IntBounds debtsBounds;

    public StudentsFilter(String name, String studyType, String speciality, Integer semesterFrom, Integer semesterTo, Integer debtsFrom, Integer debtsTo) {
        this.name = name;
        this.studyType = studyType;
        this.speciality = speciality;
        this.semesterBounds = new IntBounds(semesterFrom, semesterTo);
        this.debtsBounds = new IntBounds(debtsFrom, debtsTo);
    }

    public StudentsFilter(String name, String studyType, String speciality, IntBounds semesterBounds, IntBounds debtsBounds) {
        this(name, studyType, speciality, semesterBounds.getFrom(), semesterBounds.getTo(), debtsBounds.getFrom(), debtsBounds.getTo());
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

    public void setName(String name) {
        this.name = name;
    }

    public void setStudyType(String studyType) {
        this.studyType = studyType;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public void setSemesterBounds(IntBounds semesterBounds) {
        this.semesterBounds = semesterBounds;
    }

    public void setDebtsBounds(IntBounds debtsBounds) {
        this.debtsBounds = debtsBounds;
    }
}
