package com.wishmaster.ifmo.ws.jaxws.datasource;

public class Student {
    private static final Student EMPTY = new Student();
    private Integer id;
    private String name;
    private String studyType;
    private String speciality;
    private Integer semester;
    private Integer debts;

    public Student(Integer id, String name, String studyType, String speciality, Integer semester, Integer debts) {
        this.id = id;
        this.name = name;
        this.studyType = studyType;
        this.speciality = speciality;
        this.semester = semester;
        this.debts = debts;
    }

    public Student(String name, String studyType, String speciality, Integer semester, Integer debts) {
        this(null, name, studyType, speciality, semester, debts);
    }

    public Student() {
        this(null, null, null, null, null, null);
    }

    public Integer getId() {
        return id;
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

    public Integer getSemester() {
        return semester;
    }

    public Integer getDebts() {
        return debts;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStudyType(String studyType) {
        this.studyType = studyType;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public void setDebts(Integer debts) {
        this.debts = debts;
    }
}