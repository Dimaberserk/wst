package com.wishmaster.ifmo.ws.jaxws;

import com.wishmaster.ifmo.ws.jaxws.datasource.Person;
import com.wishmaster.ifmo.ws.jaxws.datasource.PersonsFilter;
import com.wishmaster.ifmo.ws.jaxws.datasource.PostgreSQLDAO;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebService(serviceName = "PersonService")
public class PersonWebService {
    @Resource(lookup = "jdbc/ifmo-jaxws")
    private DataSource dataSource;

    @WebMethod(operationName = "getAllPersons")
    public List<Person> getAllPersons() {
        PostgreSQLDAO dao = new PostgreSQLDAO(getConnection());
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
        PostgreSQLDAO dao = new PostgreSQLDAO(getConnection());
        return dao.getPersons(new PersonsFilter(name, subname, ageFrom, ageTo, street, housetNumberFrom, houseNumberTo));
    }

    private Connection getConnection() {
        Connection result = null;
        try {
            result = dataSource.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(PersonWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}