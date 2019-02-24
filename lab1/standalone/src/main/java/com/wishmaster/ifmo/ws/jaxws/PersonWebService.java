package com.wishmaster.ifmo.ws.jaxws;

import com.wishmaster.ifmo.ws.jaxws.datasource.Person;
import com.wishmaster.ifmo.ws.jaxws.datasource.PersonsFilter;
import com.wishmaster.ifmo.ws.jaxws.datasource.PostgreSQLDAO;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(serviceName = "PersonService")
public class PersonWebService {
    @WebMethod(operationName = "getAllPersons")
    public List<Person> getAllPersons() {
        PostgreSQLDAO dao = new PostgreSQLDAO(ConnectionUtil.getConnection());
        return dao.getAllPersons();
    }

    @WebMethod(operationName = "searchPerson")
    public List<Person> searchPersons(
        @WebParam(name = "personName") String name,
        @WebParam(name = "personSubname") String subname,
        @WebParam(name = "personAgeFrom") Integer ageFrom,
        @WebParam(name = "personAgeTo") Integer ageTo,
        @WebParam(name = "personStreet") String street,
        @WebParam(name = "personHouseNumberFrom") Integer housetNumberFrom,
        @WebParam(name = "personHouseNumberTo") Integer houseNumberTo
    ) {
        PostgreSQLDAO dao = new PostgreSQLDAO(ConnectionUtil.getConnection());
        return dao.getPersons(new PersonsFilter(name, subname, ageFrom, ageTo, street, housetNumberFrom, houseNumberTo));
    }
}