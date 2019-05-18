
package lab7.generated;

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

    private final static QName _IllegalRequestException_QNAME = new QName("http://jaxws.ws.ifmo.wishmaster.com/", "IllegalRequestException");
    private final static QName _InternalException_QNAME = new QName("http://jaxws.ws.ifmo.wishmaster.com/", "InternalException");
    private final static QName _Create_QNAME = new QName("http://jaxws.ws.ifmo.wishmaster.com/", "create");
    private final static QName _CreateResponse_QNAME = new QName("http://jaxws.ws.ifmo.wishmaster.com/", "createResponse");
    private final static QName _Delete_QNAME = new QName("http://jaxws.ws.ifmo.wishmaster.com/", "delete");
    private final static QName _DeleteResponse_QNAME = new QName("http://jaxws.ws.ifmo.wishmaster.com/", "deleteResponse");
    private final static QName _Search_QNAME = new QName("http://jaxws.ws.ifmo.wishmaster.com/", "search");
    private final static QName _SearchResponse_QNAME = new QName("http://jaxws.ws.ifmo.wishmaster.com/", "searchResponse");
    private final static QName _Update_QNAME = new QName("http://jaxws.ws.ifmo.wishmaster.com/", "update");
    private final static QName _UpdateResponse_QNAME = new QName("http://jaxws.ws.ifmo.wishmaster.com/", "updateResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.wishmaster.ifmo.ws.jaxws.client.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link StudentServiceClientFault }
     * 
     */
    public StudentServiceClientFault createStudentServiceClientFault() {
        return new StudentServiceClientFault();
    }

    /**
     * Create an instance of {@link StudentServiceInternalFault }
     * 
     */
    public StudentServiceInternalFault createStudentServiceInternalFault() {
        return new StudentServiceInternalFault();
    }

    /**
     * Create an instance of {@link Create }
     * 
     */
    public Create createCreate() {
        return new Create();
    }

    /**
     * Create an instance of {@link CreateResponse }
     * 
     */
    public CreateResponse createCreateResponse() {
        return new CreateResponse();
    }

    /**
     * Create an instance of {@link Delete }
     * 
     */
    public Delete createDelete() {
        return new Delete();
    }

    /**
     * Create an instance of {@link DeleteResponse }
     * 
     */
    public DeleteResponse createDeleteResponse() {
        return new DeleteResponse();
    }

    /**
     * Create an instance of {@link Search }
     * 
     */
    public Search createSearch() {
        return new Search();
    }

    /**
     * Create an instance of {@link SearchResponse }
     * 
     */
    public SearchResponse createSearchResponse() {
        return new SearchResponse();
    }

    /**
     * Create an instance of {@link Update }
     * 
     */
    public Update createUpdate() {
        return new Update();
    }

    /**
     * Create an instance of {@link UpdateResponse }
     * 
     */
    public UpdateResponse createUpdateResponse() {
        return new UpdateResponse();
    }

    /**
     * Create an instance of {@link Student }
     * 
     */
    public Student createStudent() {
        return new Student();
    }

    /**
     * Create an instance of {@link StudentsFilter }
     * 
     */
    public StudentsFilter createStudentsFilter() {
        return new StudentsFilter();
    }

    /**
     * Create an instance of {@link IntBounds }
     * 
     */
    public IntBounds createIntBounds() {
        return new IntBounds();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StudentServiceClientFault }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StudentServiceClientFault }{@code >}
     */
    @XmlElementDecl(namespace = "http://jaxws.ws.ifmo.wishmaster.com/", name = "IllegalRequestException")
    public JAXBElement<StudentServiceClientFault> createIllegalRequestException(StudentServiceClientFault value) {
        return new JAXBElement<StudentServiceClientFault>(_IllegalRequestException_QNAME, StudentServiceClientFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StudentServiceInternalFault }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StudentServiceInternalFault }{@code >}
     */
    @XmlElementDecl(namespace = "http://jaxws.ws.ifmo.wishmaster.com/", name = "InternalException")
    public JAXBElement<StudentServiceInternalFault> createInternalException(StudentServiceInternalFault value) {
        return new JAXBElement<StudentServiceInternalFault>(_InternalException_QNAME, StudentServiceInternalFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Create }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Create }{@code >}
     */
    @XmlElementDecl(namespace = "http://jaxws.ws.ifmo.wishmaster.com/", name = "create")
    public JAXBElement<Create> createCreate(Create value) {
        return new JAXBElement<Create>(_Create_QNAME, Create.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CreateResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://jaxws.ws.ifmo.wishmaster.com/", name = "createResponse")
    public JAXBElement<CreateResponse> createCreateResponse(CreateResponse value) {
        return new JAXBElement<CreateResponse>(_CreateResponse_QNAME, CreateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Delete }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Delete }{@code >}
     */
    @XmlElementDecl(namespace = "http://jaxws.ws.ifmo.wishmaster.com/", name = "delete")
    public JAXBElement<Delete> createDelete(Delete value) {
        return new JAXBElement<Delete>(_Delete_QNAME, Delete.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DeleteResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://jaxws.ws.ifmo.wishmaster.com/", name = "deleteResponse")
    public JAXBElement<DeleteResponse> createDeleteResponse(DeleteResponse value) {
        return new JAXBElement<DeleteResponse>(_DeleteResponse_QNAME, DeleteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Search }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Search }{@code >}
     */
    @XmlElementDecl(namespace = "http://jaxws.ws.ifmo.wishmaster.com/", name = "search")
    public JAXBElement<Search> createSearch(Search value) {
        return new JAXBElement<Search>(_Search_QNAME, Search.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SearchResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SearchResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://jaxws.ws.ifmo.wishmaster.com/", name = "searchResponse")
    public JAXBElement<SearchResponse> createSearchResponse(SearchResponse value) {
        return new JAXBElement<SearchResponse>(_SearchResponse_QNAME, SearchResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Update }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Update }{@code >}
     */
    @XmlElementDecl(namespace = "http://jaxws.ws.ifmo.wishmaster.com/", name = "update")
    public JAXBElement<Update> createUpdate(Update value) {
        return new JAXBElement<Update>(_Update_QNAME, Update.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdateResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://jaxws.ws.ifmo.wishmaster.com/", name = "updateResponse")
    public JAXBElement<UpdateResponse> createUpdateResponse(UpdateResponse value) {
        return new JAXBElement<UpdateResponse>(_UpdateResponse_QNAME, UpdateResponse.class, null, value);
    }

}
