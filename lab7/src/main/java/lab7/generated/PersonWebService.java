
package lab7.generated;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import java.util.List;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.1-SNAPSHOT
 * Generated source version: 2.2
 * 
 */
@WebService(name = "PersonWebService", targetNamespace = "http://jaxws.ws.ifmo.wishmaster.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface PersonWebService {


    /**
     * 
     * @return
     *     returns java.util.List<com.wishmaster.ifmo.ws.jaxws.client.generated.Person>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAllPersons", targetNamespace = "http://jaxws.ws.ifmo.wishmaster.com/", className = "com.wishmaster.ifmo.ws.jaxws.client.generated.GetAllPersons")
    @ResponseWrapper(localName = "getAllPersonsResponse", targetNamespace = "http://jaxws.ws.ifmo.wishmaster.com/", className = "com.wishmaster.ifmo.ws.jaxws.client.generated.GetAllPersonsResponse")
    @Action(input = "http://jaxws.ws.ifmo.wishmaster.com/PersonWebService/getAllPersonsRequest", output = "http://jaxws.ws.ifmo.wishmaster.com/PersonWebService/getAllPersonsResponse")
    public List<Person> getAllPersons();

    /**
     * 
     * @param personName
     * @param personAgeFrom
     * @param personAgeTo
     * @param personSubname
     * @param personStreet
     * @param personHouseNumberFrom
     * @param personHouseNumberTo
     * @return
     *     returns java.util.List<com.wishmaster.ifmo.ws.jaxws.client.generated.Person>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "searchPerson", targetNamespace = "http://jaxws.ws.ifmo.wishmaster.com/", className = "com.wishmaster.ifmo.ws.jaxws.client.generated.SearchPerson")
    @ResponseWrapper(localName = "searchPersonResponse", targetNamespace = "http://jaxws.ws.ifmo.wishmaster.com/", className = "com.wishmaster.ifmo.ws.jaxws.client.generated.SearchPersonResponse")
    @Action(input = "http://jaxws.ws.ifmo.wishmaster.com/PersonWebService/searchPersonRequest", output = "http://jaxws.ws.ifmo.wishmaster.com/PersonWebService/searchPersonResponse")
    public List<Person> searchPerson(
        @WebParam(name = "personName", targetNamespace = "")
            String personName,
        @WebParam(name = "personSubname", targetNamespace = "")
            String personSubname,
        @WebParam(name = "personAgeFrom", targetNamespace = "")
            Integer personAgeFrom,
        @WebParam(name = "personAgeTo", targetNamespace = "")
            Integer personAgeTo,
        @WebParam(name = "personStreet", targetNamespace = "")
            String personStreet,
        @WebParam(name = "personHouseNumberFrom", targetNamespace = "")
            Integer personHouseNumberFrom,
        @WebParam(name = "personHouseNumberTo", targetNamespace = "")
            Integer personHouseNumberTo);

}
