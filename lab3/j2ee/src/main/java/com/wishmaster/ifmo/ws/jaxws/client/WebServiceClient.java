package com.wishmaster.ifmo.ws.jaxws.client;

import com.wishmaster.ifmo.ws.jaxws.client.generated.IllegalRequestException;
import com.wishmaster.ifmo.ws.jaxws.client.generated.IntBounds;
import com.wishmaster.ifmo.ws.jaxws.client.generated.InternalException;
import com.wishmaster.ifmo.ws.jaxws.client.generated.Student;
import com.wishmaster.ifmo.ws.jaxws.client.generated.StudentService;
import com.wishmaster.ifmo.ws.jaxws.client.generated.StudentsFilter;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WebServiceClient {
    public static void main(String[] args) throws MalformedURLException {
        Map<String, Action> actionsByNumber = new TreeMap<>();
        IntStream.range(0, Action.values().length)
            .forEach(i -> actionsByNumber.put(String.valueOf(i), Action.values()[i]));

        Map<String, StudentColumn> columnsByNumber = new TreeMap<>();
        IntStream.range(0, StudentColumn.values().length)
            .forEach(i -> columnsByNumber.put(String.valueOf(i), StudentColumn.values()[i]));

        URL url = new URL("http://localhost:8080/jaxws/StudentService?wsdl");
        StudentService studentService = new StudentService(url);


        Scanner scanner = new Scanner(System.in);

        while (true) {
            Action action = readAction(scanner, "action", false, actionsByNumber);
            try {
                switch (action) {
                    case CREATE: {
                        Student student = readStudent(scanner);

                        System.out.println("Student: " + toString(student));
                        studentService.getStudentWebServicePort().create(student);
                        break;
                    }
                    case SEARCH: {
                        StudentsFilter filter = new StudentsFilter();
                        filter.setSemesterBounds(new IntBounds());
                        filter.setDebtsBounds(new IntBounds());

                        StudentColumn column = readAction(scanner, "column", true, columnsByNumber);
                        if (column != null) {
                            if (column.getType() == Type.STRING) {
                                System.out.println("Type search string:");
                                String line = scanner.nextLine();
                                column.getFilterSetter().accept(filter, line);
                            } else if (column.getType() == Type.INTEGER) {
                                IntBounds bounds = new IntBounds();
                                bounds.setFrom(readBound("minimum" + column.toString(), scanner));
                                bounds.setTo(readBound("maximum" + column.toString(), scanner));
                                column.getFilterSetter().accept(filter, bounds);
                            }
                        }

                        System.out.println("Filter: " + toString(filter));
                        List<Student> students = studentService.getStudentWebServicePort().search(filter);
                        for (Student student : students) {
                            System.out.println(toString(student));
                        }
                        System.out.println("Total persons: " + students.size());
                        break;
                    }
                    case UPDATE: {
                        Student student = readStudent(scanner);
                        student.setId(readInt("id", scanner, false));

                        System.out.println("Student: " + toString(student));
                        System.out.println("Result: " + toString(studentService.getStudentWebServicePort().update(student)));
                        break;
                    }
                    case DELETE: {
                        studentService.getStudentWebServicePort().delete(readInt("id", scanner, false));
                        System.out.println("Deleted");
                        break;
                    }
                }
            } catch (IllegalRequestException e) {
                System.out.println("Unable to " + action.toString() + ": " + e.getMessage() + "\n" + e.getFaultInfo().getMessage());
            } catch (InternalException e) {
                System.out.println("Internal service error: " + e.getMessage());
            }
            System.out.println();
        }
    }

    private static <T> T readAction(Scanner scanner, String title, boolean finishPhrase, Map<String, T> map) {
        String availableActions = "Available " + title + "s:\n\t" +
            map.entrySet().stream().map(e -> e.getKey() + ". " + e.getValue().toString()).collect(Collectors.joining("\n\t"));

        System.out.println("Enter the " + title + " number to choose or " + (finishPhrase ? "f" : "^d") + " to finish. " + availableActions);

        T action = null;
        while (action == null) {
            String line = scanner.nextLine().trim();
            if (finishPhrase && line.equals("f")) {
                break;
            }
            action = map.get(line);
            if (action == null) {
                System.out.println("Unknown " + title + ", type valid " + title + " number. " + availableActions);
            }
        }
        return action;
    }

    private static Student readStudent(Scanner scanner) {
        Student result = new Student();
        for (StudentColumn column : StudentColumn.values()) {
            if (column.getType() == Type.STRING) {
                System.out.println("Type " + column.toString() + ":");
                String line = scanner.nextLine();
                column.getObjectSetter().accept(result, line);
            } else if (column.getType() == Type.INTEGER) {
                Integer i = readInt(column.toString(), scanner, true);
                column.getObjectSetter().accept(result, i);
            }
        }
        return result;
    }

    private static Integer readBound(String message, Scanner scanner) {
        Integer bound = null;
        while (bound == null) {
            System.out.println("Enter the " + message + ". Or type '-' if you do not want to set a limit");
            String line = scanner.nextLine().trim();
            if (line.equals("-")) {
                break;
            }
            bound = parseInt(line);
        }
        return bound;
    }

    private static Integer readInt(String message, Scanner scanner, boolean emptyAsNull) {
        Integer i = null;
        while (i == null) {
            System.out.println("Enter the " + message + ":");
            String line = scanner.nextLine().trim();
            if (emptyAsNull && line.isEmpty()) {
                return null;
            }
            i = parseInt(line);
        }
        return i;
    }

    private static Integer parseInt(String i) {
        try {
            return Integer.valueOf(i);
        } catch (Exception e) {
            System.out.println("Unable to parse number.");
            return null;
        }
    }

    private static final String toString(Student student) {
        StringJoiner joiner  = new StringJoiner(", ", "{", "}");
        if (student.getId() != null) {
            joiner.add("id = " + student.getId() + "");
        }
        return joiner
            .add("name = '" + student.getName() + "'")
            .add("studyType = '" + student.getStudyType() + "'")
            .add("speciality = '" + student.getSpeciality() + "'")
            .add("semester = " + student.getSemester())
            .add("debts = " + student.getDebts())
            .toString();
    }

    private static final String toString(StudentsFilter filter) {
        return new StringJoiner(", ", "{", "}")
            .add("name = '" + filter.getName() + "'")
            .add("studyType = '" + filter.getStudyType() + "'")
            .add("speciality = '" + filter.getSpeciality() + "'")
            .add("semester = " + toString(filter.getSemesterBounds()))
            .add("debts = " + toString(filter.getDebtsBounds()))
            .toString();
    }

    private static final String toString(IntBounds bounds) {
        return new StringJoiner(" ", "[", "]")
            .add("from " + bounds.getFrom())
            .add(" to" + bounds.getTo())
            .toString();
    }

    private enum Action {
        CREATE("Create student entity"),
        SEARCH("Search students"),
        UPDATE("Update student entity"),
        DELETE("Delete student entity");

        private final String title;

        Action(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return title;
        }
    }

    private enum StudentColumn {
        NAME("student name", Type.STRING, (p, o) -> p.setName((String) o), (s, o) -> s.setName((String) o)),
        STUDY_TYPE("student study type", Type.STRING, (p, o) -> p.setStudyType((String) o), (s, o) -> s.setStudyType((String) o)),
        SPECIALITY("student speciality", Type.STRING, (p, o) -> p.setSpeciality((String) o), (s, o) -> s.setSpeciality((String) o)),
        SEMESTER("semester number", Type.INTEGER, (p, o) -> p.setSemesterBounds((IntBounds) o), (s, o) -> s.setSemester((Integer) o)),
        DEBTS("number of debts", Type.INTEGER, (p, o) -> p.setDebtsBounds((IntBounds) o), (s, o) -> s.setDebts((Integer) o));

        final String output;
        final Type type;
        final BiConsumer<StudentsFilter, Object> filterSetter;
        final BiConsumer<Student, Object> objectSetter;

        StudentColumn(String output, Type type, BiConsumer<StudentsFilter, Object> filterSetter, BiConsumer<Student, Object> objectSetter) {
            this.output = output;
            this.type = type;
            this.filterSetter = filterSetter;
            this.objectSetter = objectSetter;
        }

        @Override
        public String toString() {
            return output;
        }

        public Type getType() {
            return type;
        }

        public BiConsumer<StudentsFilter, Object> getFilterSetter() {
            return filterSetter;
        }

        public BiConsumer<Student, Object> getObjectSetter() {
            return objectSetter;
        }
    }

    private enum Type {
        STRING,
        INTEGER
    }
}