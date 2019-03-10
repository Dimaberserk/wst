
package com.wishmaster.ifmo.ws.jaxws.client.generated;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.1-SNAPSHOT
 * Generated source version: 2.2
 * 
 */
@WebService(name = "StudentWebService", targetNamespace = "http://jaxws.ws.ifmo.wishmaster.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface StudentWebService {


    /**
     * 
     * @param entity
     * @return
     *     returns com.wishmaster.ifmo.ws.jaxws.client.generated.Student
     * @throws InternalException
     * @throws IllegalRequestException
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "update", targetNamespace = "http://jaxws.ws.ifmo.wishmaster.com/", className = "com.wishmaster.ifmo.ws.jaxws.client.generated.Update")
    @ResponseWrapper(localName = "updateResponse", targetNamespace = "http://jaxws.ws.ifmo.wishmaster.com/", className = "com.wishmaster.ifmo.ws.jaxws.client.generated.UpdateResponse")
    @Action(input = "http://jaxws.ws.ifmo.wishmaster.com/StudentWebService/updateRequest", output = "http://jaxws.ws.ifmo.wishmaster.com/StudentWebService/updateResponse", fault = {
        @FaultAction(className = IllegalRequestException.class, value = "http://jaxws.ws.ifmo.wishmaster.com/StudentWebService/update/Fault/IllegalRequestException"),
        @FaultAction(className = InternalException.class, value = "http://jaxws.ws.ifmo.wishmaster.com/StudentWebService/update/Fault/InternalException")
    })
    public Student update(
        @WebParam(name = "entity", targetNamespace = "")
        Student entity)
        throws IllegalRequestException, InternalException
    ;

    /**
     * 
     * @param id
     * @throws InternalException
     */
    @WebMethod
    @RequestWrapper(localName = "delete", targetNamespace = "http://jaxws.ws.ifmo.wishmaster.com/", className = "com.wishmaster.ifmo.ws.jaxws.client.generated.Delete")
    @ResponseWrapper(localName = "deleteResponse", targetNamespace = "http://jaxws.ws.ifmo.wishmaster.com/", className = "com.wishmaster.ifmo.ws.jaxws.client.generated.DeleteResponse")
    @Action(input = "http://jaxws.ws.ifmo.wishmaster.com/StudentWebService/deleteRequest", output = "http://jaxws.ws.ifmo.wishmaster.com/StudentWebService/deleteResponse", fault = {
        @FaultAction(className = InternalException.class, value = "http://jaxws.ws.ifmo.wishmaster.com/StudentWebService/delete/Fault/InternalException")
    })
    public void delete(
        @WebParam(name = "id", targetNamespace = "")
        int id)
        throws InternalException
    ;

    /**
     * 
     * @param entity
     * @return
     *     returns java.lang.Integer
     * @throws InternalException
     * @throws IllegalRequestException
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "create", targetNamespace = "http://jaxws.ws.ifmo.wishmaster.com/", className = "com.wishmaster.ifmo.ws.jaxws.client.generated.Create")
    @ResponseWrapper(localName = "createResponse", targetNamespace = "http://jaxws.ws.ifmo.wishmaster.com/", className = "com.wishmaster.ifmo.ws.jaxws.client.generated.CreateResponse")
    @Action(input = "http://jaxws.ws.ifmo.wishmaster.com/StudentWebService/createRequest", output = "http://jaxws.ws.ifmo.wishmaster.com/StudentWebService/createResponse", fault = {
        @FaultAction(className = IllegalRequestException.class, value = "http://jaxws.ws.ifmo.wishmaster.com/StudentWebService/create/Fault/IllegalRequestException"),
        @FaultAction(className = InternalException.class, value = "http://jaxws.ws.ifmo.wishmaster.com/StudentWebService/create/Fault/InternalException")
    })
    public Integer create(
        @WebParam(name = "entity", targetNamespace = "")
        Student entity)
        throws IllegalRequestException, InternalException
    ;

    /**
     * 
     * @param filter
     * @return
     *     returns java.util.List<com.wishmaster.ifmo.ws.jaxws.client.generated.Student>
     * @throws InternalException
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "search", targetNamespace = "http://jaxws.ws.ifmo.wishmaster.com/", className = "com.wishmaster.ifmo.ws.jaxws.client.generated.Search")
    @ResponseWrapper(localName = "searchResponse", targetNamespace = "http://jaxws.ws.ifmo.wishmaster.com/", className = "com.wishmaster.ifmo.ws.jaxws.client.generated.SearchResponse")
    @Action(input = "http://jaxws.ws.ifmo.wishmaster.com/StudentWebService/searchRequest", output = "http://jaxws.ws.ifmo.wishmaster.com/StudentWebService/searchResponse", fault = {
        @FaultAction(className = InternalException.class, value = "http://jaxws.ws.ifmo.wishmaster.com/StudentWebService/search/Fault/InternalException")
    })
    public List<Student> search(
        @WebParam(name = "filter", targetNamespace = "")
        StudentsFilter filter)
        throws InternalException
    ;

}