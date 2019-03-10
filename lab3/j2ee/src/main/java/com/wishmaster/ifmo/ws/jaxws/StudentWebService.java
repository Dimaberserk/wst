package com.wishmaster.ifmo.ws.jaxws;

import com.wishmaster.ifmo.ws.jaxws.datasource.Student;
import com.wishmaster.ifmo.ws.jaxws.datasource.StudentsDAO;
import com.wishmaster.ifmo.ws.jaxws.datasource.StudentsFilter;
import com.wishmaster.ifmo.ws.jaxws.errors.IllegalRequestException;
import com.wishmaster.ifmo.ws.jaxws.errors.InternalException;
import com.wishmaster.ifmo.ws.jaxws.errors.StudentServiceEmptyFieldFault;
import com.wishmaster.ifmo.ws.jaxws.errors.StudentServiceInternalFault;
import com.wishmaster.ifmo.ws.jaxws.errors.StudentServiceUnknownIdFault;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.sql.DataSource;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.wishmaster.ifmo.ws.jaxws.Util.firstNonNull;

@WebService(serviceName = "StudentService")
public class StudentWebService {
    @Resource(lookup = "jdbc/ifmo-jaxws")
    private DataSource dataSource;
    private static final Logger LOGGER = Logger.getLogger(StudentWebService.class.getName());

    @WebMethod(operationName = "create")
    public Integer create(@WebParam(name = "entity") Student entity) throws IllegalRequestException, InternalException {
        checkField(entity.getName(), "name");
        checkField(entity.getStudyType(), "studyType");
        checkField(entity.getSpeciality(), "speciality");
        checkField(entity.getDebts(), "debts");
        checkField(entity.getSemester(), "semester");
        try {
            StudentsDAO dao = new StudentsDAO(dataSource.getConnection());
            return dao.add(entity);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "unable to create student entity", e);
            throw new InternalException("Unable to create student entity", e);
        }
    }

    @WebMethod(operationName = "search")
    public List<Student> search(@WebParam(name = "filter") StudentsFilter filter) throws InternalException {
        try {
            StudentsDAO dao = new StudentsDAO(dataSource.getConnection());
            return dao.search(filter);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "unable to search", e);
            throw new InternalException("Unable to search", e);
        }
    }

    @WebMethod(operationName = "update")
    public Student update(@WebParam(name = "entity") Student entity) throws IllegalRequestException, InternalException {
        checkField(entity.getId(), "id");
        try {
            StudentsDAO dao = new StudentsDAO(dataSource.getConnection());
            Student oldEntity = dao.get(entity.getId()).orElseThrow(() -> new IllegalRequestException("entity not found", new StudentServiceUnknownIdFault(entity.getId())));

            Student newEntity = new Student(
                entity.getId(),
                firstNotEmpty(entity.getName(), oldEntity.getName()),
                firstNotEmpty(entity.getStudyType(), oldEntity.getStudyType()),
                firstNotEmpty(entity.getSpeciality(), oldEntity.getSpeciality()),
                firstNonNull(entity.getSemester(), oldEntity.getSemester()),
                firstNonNull(entity.getDebts(), oldEntity.getDebts())
            );

            return dao.update(newEntity).orElseThrow(() -> new InternalException("entity has been deleted", new StudentServiceInternalFault()));
        } catch (Exception e) {
            throw new InternalException("Unable to update student entity", e);
        }
    }

    @WebMethod(operationName = "delete")
    public void delete(@WebParam(name = "id") int id) throws InternalException {
        try {
            StudentsDAO dao = new StudentsDAO(dataSource.getConnection());
            if (!dao.delete(id)) {
                throw new IllegalRequestException("entity not found", new StudentServiceUnknownIdFault(id));
            }
        } catch (Exception e) {
            throw new InternalException("Unable to create student entity", e);
        }
    }

    private static void checkField(Object field, String fieldName) throws IllegalRequestException {
        if (field == null
            || (field instanceof String && ((String) field).trim().isEmpty())) {
            throw new IllegalRequestException(fieldName + " is not specified", new StudentServiceEmptyFieldFault(fieldName));
        }
    }

    private static String  firstNotEmpty(String s1, String s2) {
        return firstNonNull(s1.trim().isEmpty() ? null : s1, s2);
    }
}