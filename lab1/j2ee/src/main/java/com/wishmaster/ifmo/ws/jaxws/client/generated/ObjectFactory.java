
package com.wishmaster.ifmo.ws.jaxws.client.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.wishmaster.ifmo.ws.jaxws.client.generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetAllPersons_QNAME = new QName("http://jaxws.ws.ifmo.wishmaster.com/", "getAllPersons");
    private final static QName _GetAllPersonsResponse_QNAME = new QName("http://jaxws.ws.ifmo.wishmaster.com/", "getAllPersonsResponse");
    private final static QName _SearchPerson_QNAME = new QName("http://jaxws.ws.ifmo.wishmaster.com/", "searchPerson");
    private final static QName _SearchPersonResponse_QNAME = new QName("http://jaxws.ws.ifmo.wishmaster.com/", "searchPersonResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.wishmaster.ifmo.ws.jaxws.client.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAllPersons }
     * 
     */
    public GetAllPersons createGetAllPersons() {
        return new GetAllPersons();
    }

    /**
     * Create an instance of {@link GetAllPersonsResponse }
     * 
     */
    public GetAllPersonsResponse createGetAllPersonsResponse() {
        return new GetAllPersonsResponse();
    }

    /**
     * Create an instance of {@link SearchPerson }
     * 
     */
    public SearchPerson createSearchPerson() {
        return new SearchPerson();
    }

    /**
     * Create an instance of {@link SearchPersonResponse }
     * 
     */
    public SearchPersonResponse createSearchPersonResponse() {
        return new SearchPersonResponse();
    }

    /**
     * Create an instance of {@link Person }
     * 
     */
    public Person createPerson() {
        return new Person();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllPersons }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllPersons }{@code >}
     */
    @XmlElementDecl(namespace = "http://jaxws.ws.ifmo.wishmaster.com/", name = "getAllPersons")
    public JAXBElement<GetAllPersons> createGetAllPersons(GetAllPersons value) {
        return new JAXBElement<GetAllPersons>(_GetAllPersons_QNAME, GetAllPersons.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAllPersonsResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link GetAllPersonsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://jaxws.ws.ifmo.wishmaster.com/", name = "getAllPersonsResponse")
    public JAXBElement<GetAllPersonsResponse> createGetAllPersonsResponse(GetAllPersonsResponse value) {
        return new JAXBElement<GetAllPersonsResponse>(_GetAllPersonsResponse_QNAME, GetAllPersonsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchPerson }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SearchPerson }{@code >}
     */
    @XmlElementDecl(namespace = "http://jaxws.ws.ifmo.wishmaster.com/", name = "searchPerson")
    public JAXBElement<SearchPerson> createSearchPerson(SearchPerson value) {
        return new JAXBElement<SearchPerson>(_SearchPerson_QNAME, SearchPerson.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchPersonResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SearchPersonResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://jaxws.ws.ifmo.wishmaster.com/", name = "searchPersonResponse")
    public JAXBElement<SearchPersonResponse> createSearchPersonResponse(SearchPersonResponse value) {
        return new JAXBElement<SearchPersonResponse>(_SearchPersonResponse_QNAME, SearchPersonResponse.class, null, value);
    }

}
