package com.wishmaster.ifmo.ws.jaxws;

import com.wishmaster.ifmo.ws.jaxws.datasource.Student;
import com.wishmaster.ifmo.ws.jaxws.datasource.StudentsDAO;
import com.wishmaster.ifmo.ws.jaxws.datasource.StudentsFilter;
import com.wishmaster.ifmo.ws.jaxws.errors.IllegalRequestException;
import com.wishmaster.ifmo.ws.jaxws.errors.InternalException;
import org.glassfish.jersey.process.internal.RequestScoped;

import javax.annotation.Resource;
import javax.sql.DataSource;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.wishmaster.ifmo.ws.jaxws.Util.firstNonNull;

@RequestScoped
@Path("/students")
public class StudentResource {
    @Resource(lookup = "jdbc/ifmo-jaxws")
    private DataSource dataSource;

    private static final Logger LOGGER = Logger.getLogger(StudentResource.class.getName());

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Integer create(Student entity) throws IllegalRequestException, InternalException {
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
            throw new InternalException("Unable to create student entity: " + e.getMessage(), e);
        }
    }

    @Path("search")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Student> searchStudents(StudentsFilter filter) throws InternalException {
        try {
            StudentsDAO dao = new StudentsDAO(dataSource.getConnection());
            return dao.search(filter);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "unable to search", e);
            throw new InternalException("Unable to search: " + e.getMessage(), e);
        }
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Student update(Student entity) throws IllegalRequestException, InternalException {
        checkField(entity.getId(), "id");
        try {
            StudentsDAO dao = new StudentsDAO(dataSource.getConnection());
            Supplier<IllegalRequestException> exceptionSupplier = () -> IllegalRequestException.unknownId(entity.getId());

            Student oldEntity = dao.get(entity.getId()).orElseThrow(exceptionSupplier);

            Student newEntity = new Student(
                entity.getId(),
                firstNotEmpty(entity.getName(), oldEntity.getName()),
                firstNotEmpty(entity.getStudyType(), oldEntity.getStudyType()),
                firstNotEmpty(entity.getSpeciality(), oldEntity.getSpeciality()),
                firstNonNull(entity.getSemester(), oldEntity.getSemester()),
                firstNonNull(entity.getDebts(), oldEntity.getDebts())
            );

            return dao.update(newEntity).orElseThrow(exceptionSupplier);
        } catch (Exception e) {
            throw new InternalException("Unable to update student entity: " + e.getMessage(), e);
        }
    }

    @DELETE
    public void delete(@QueryParam("id") Integer id) throws IllegalRequestException, InternalException {
        try {
            StudentsDAO dao = new StudentsDAO(dataSource.getConnection());
            if (!dao.delete(id)) {
                throw IllegalRequestException.unknownId(id);
            }
        } catch (Exception e) {
            throw new InternalException("Unable to delete student entity: " + e.getMessage(), e);
        }
    }

    private static void checkField(Object field, String fieldName) throws IllegalRequestException {
        if (field == null
            || (field instanceof String && ((String) field).trim().isEmpty())) {
            throw IllegalRequestException.emptyField(fieldName);
        }
    }

    private static String firstNotEmpty(String s1, String s2) {
        return firstNonNull(s1.trim().isEmpty() ? null : s1, s2);
    }
}