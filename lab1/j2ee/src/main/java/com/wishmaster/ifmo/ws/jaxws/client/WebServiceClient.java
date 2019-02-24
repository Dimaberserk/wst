package com.wishmaster.ifmo.ws.jaxws.client;

import com.wishmaster.ifmo.ws.jaxws.client.generated.Person;
import com.wishmaster.ifmo.ws.jaxws.client.generated.PersonService;

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
        Map<String, PersonColumn> columnsByNumber = new TreeMap<>();
        IntStream.range(0, PersonColumn.values().length)
            .forEach(i -> columnsByNumber.put(String.valueOf(i), PersonColumn.values()[i]));

        String availableColumns = "Available columns:\n\t" +
            columnsByNumber.entrySet().stream().map(e -> e.getKey() + ". " + e.getValue().getOutput()).collect(Collectors.joining("\n\t"));

        URL url = new URL("http://localhost:8080/jaxws/PersonService?wsdl");
        PersonService personService = new PersonService(url);


        Scanner scanner = new Scanner(System.in);

        PersonsFilter filter = new PersonsFilter();

        try {
            while (true) {
                System.out.println("Enter the column number to choose or ^D to finish. " + availableColumns);
                PersonColumn column = null;
                while (column == null) {
                    String line = scanner.next();
                    column = columnsByNumber.get(line.trim());
                    if (column == null) {
                        System.out.println("Unknown column, type valid column number. " + availableColumns);
                    } else {
                        if (column.getType() == FilterType.LIKE) {
                            System.out.println("Type search string:");
                            line = scanner.next();
                            column.setter.accept(filter, line);
                        } else if (column.getType() == FilterType.BOUNDS) {
                            column.setter.accept(filter, new IntBounds(
                                readBound("minimum " + column.getOutput(), scanner),
                                readBound("maximum " + column.getOutput(), scanner)
                            ));
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("End of input. Filter: " + filter);
            List<Person> persons = personService.getPersonWebServicePort().searchPerson(
                filter.getPersonName(),
                filter.getPersonSurname(),
                filter.getPersonAgeBounds().getFrom(), filter.getPersonAgeBounds().getTo(),
                filter.getPersonHouseStreet(),
                filter.getPersonHouseNumberBounds().getFrom(), filter.getPersonHouseNumberBounds().getTo()
            );
            for (Person person : persons) {
                System.out.println("name: " + person.getName() +
                    ", surname: " + person.getSurname() + ", age: " + person.getAge());
            }
            System.out.println("Total persons: " + persons.size());
        }
    }

    private static Integer readBound(String message, Scanner scanner) {
        Integer bound = null;
        try {
            while (bound == null) {
                System.out.println("Enter the " + message + ". Or type '-' if you do not want to set a limit");
                String line = scanner.next().trim();
                if (line.equals("-")) {
                    break;
                }
                try {
                    bound = Integer.valueOf(line);
                } catch (Exception e) {
                    System.out.println("Unable to parse number. Try again:");
                }
            }
        } catch (Exception e) {}
        return bound;
    }

    private static class PersonsFilter {
        private String personName;
        private String personSurname;
        private IntBounds personAgeBounds = IntBounds.EMPTY;
        private String personHouseStreet;
        private IntBounds personHouseNumberBounds = IntBounds.EMPTY;

        public String getPersonName() {
            return personName;
        }

        public String getPersonSurname() {
            return personSurname;
        }

        public IntBounds getPersonAgeBounds() {
            return personAgeBounds;
        }

        public String getPersonHouseStreet() {
            return personHouseStreet;
        }

        public IntBounds getPersonHouseNumberBounds() {
            return personHouseNumberBounds;
        }

        public void setPersonName(String personName) {
            this.personName = personName;
        }

        public void setPersonSurname(String personSurname) {
            this.personSurname = personSurname;
        }

        public void setPersonAgeBounds(IntBounds personAgeBounds) {
            this.personAgeBounds = personAgeBounds;
        }

        public void setPersonHouseStreet(String personHouseStreet) {
            this.personHouseStreet = personHouseStreet;
        }

        public void setPersonHouseNumberBounds(IntBounds personHouseNumberBounds) {
            this.personHouseNumberBounds = personHouseNumberBounds;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", PersonsFilter.class.getSimpleName() + "[", "]")
                .add("Person name = '" + personName + "'")
                .add("Person surname = '" + personSurname + "'")
                .add("Person age bounds = " + personAgeBounds)
                .add("Person house street = '" + personHouseStreet + "'")
                .add("Person house number bounds = " + personHouseNumberBounds)
                .toString();
        }
    }

    private static class IntBounds {
        private static final IntBounds EMPTY = new IntBounds(null, null);

        private final Integer from;
        private final Integer to;

        public IntBounds(Integer from, Integer to) {
            this.from = from;
            this.to = to;
        }

        public Integer getFrom() {
            return from;
        }

        public Integer getTo() {
            return to;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", "[", "]")
                .add("from = " + from)
                .add("to = " + to)
                .toString();
        }
    }

    private enum PersonColumn {
        NAME("person name", FilterType.LIKE, (p, o) -> p.setPersonName((String) o)),
        SURNAME("person surname", FilterType.LIKE, (p, o) -> p.setPersonSurname((String) o)),
        AGE("person age", FilterType.BOUNDS, (p, o) -> p.setPersonAgeBounds((IntBounds) o)),
        STREET("person house street", FilterType.LIKE, (p, o) -> p.setPersonHouseStreet((String) o)),
        HOUSE("person house number", FilterType.BOUNDS, (p, o) -> p.setPersonHouseNumberBounds((IntBounds) o));

        final String output;
        final FilterType type;
        final BiConsumer<PersonsFilter, Object> setter;

        PersonColumn(String output, FilterType type, BiConsumer<PersonsFilter, Object> setter) {
            this.output = output;
            this.type = type;
            this.setter = setter;
        }

        public String getOutput() {
            return output;
        }

        public FilterType getType() {
            return type;
        }
    }

    private enum FilterType {
        LIKE,
        BOUNDS
    }
}