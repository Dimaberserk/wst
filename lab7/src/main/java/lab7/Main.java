package lab7;

import lab7.generated.Student;
import lab7.generated.StudentService;
import lab7.generated.StudentWebService;
import lab7.generated.StudentsFilter;
import org.apache.juddi.api_v3.AccessPointType;
import org.apache.juddi.v3.client.UDDIConstants;
import org.apache.juddi.v3.client.config.UDDIClerk;
import org.apache.juddi.v3.client.config.UDDIClient;
import org.apache.juddi.v3.client.mapping.ServiceLocator;
import org.apache.juddi.v3.client.transport.Transport;
import org.uddi.api_v3.AccessPoint;
import org.uddi.api_v3.BindingTemplate;
import org.uddi.api_v3.BindingTemplates;
import org.uddi.api_v3.BusinessEntity;
import org.uddi.api_v3.BusinessInfo;
import org.uddi.api_v3.BusinessList;
import org.uddi.api_v3.BusinessService;
import org.uddi.api_v3.FindBusiness;
import org.uddi.api_v3.FindQualifiers;
import org.uddi.api_v3.GetAuthToken;
import org.uddi.api_v3.Name;
import org.uddi.api_v3.ServiceInfo;
import org.uddi.v3_service.UDDIInquiryPortType;
import org.uddi.v3_service.UDDISecurityPortType;

import javax.xml.ws.BindingProvider;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.StringJoiner;

public class Main {
    private UDDIClerk clerk = null;
    private UDDIInquiryPortType inquiry = null;
    private UDDISecurityPortType security = null;

    private static final String BUSINESS_SERVICE_NAME = "Jddi Business";
    private static final String SERVICE_NAME = "Jddi Service";


    public Main() {
        try {
            UDDIClient client = new UDDIClient("META-INF/uddi_config.xml");
            clerk = client.getClerk("default");
            Transport transport = client.getTransport("default");
            inquiry = transport.getUDDIInquiryService();
            security = transport.getUDDISecurityService();

            if (clerk == null) {
                throw new Exception("the uddi clerk wasn't found, please check the config file");
            }
            if (inquiry == null) {
                throw new Exception("the uddi inquiry wasn't found, please check the config file");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void publish() {
        try {
            BusinessEntity businessEntity = new BusinessEntity();
            Name name = new Name(BUSINESS_SERVICE_NAME, null);
            businessEntity.getName().add(name);
            // Adding the business entity to the "save" structure, using our publisher's authentication info and saving away.
            BusinessEntity register = clerk.register(businessEntity);
            if (register == null) {
                throw new RuntimeException("Unable to save business");
            }
            String businessKey = register.getBusinessKey();
            System.out.println("Jddi Business key:  " + businessKey);

            BusinessService businessService = new BusinessService();
            businessService.setBusinessKey(businessKey);

            Name serviceName = new Name(SERVICE_NAME, null);
            businessService.getName().add(serviceName);

            BindingTemplate bindingTemplate = new BindingTemplate();
            AccessPoint accessPoint = new AccessPoint();
            accessPoint.setUseType(AccessPointType.WSDL_DEPLOYMENT.toString());
            accessPoint.setValue("http://localhost:8081/jaxws/PersonService?wsdl");

            bindingTemplate.setAccessPoint(accessPoint);
            BindingTemplates bindingTemplates = new BindingTemplates();

            bindingTemplate = UDDIClient.addSOAPtModels(bindingTemplate);
            bindingTemplates.getBindingTemplate().add(bindingTemplate);
            businessService.setBindingTemplates(bindingTemplates);

            BusinessService svc = clerk.register(businessService);
            if (svc == null){
                throw new RuntimeException("Unable to save business service");
            }

            String serviceKey = svc.getServiceKey();
            System.out.println("Saved service key:  " + serviceKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private BusinessList getBusinessList(String token, String name) throws Exception {
        FindBusiness fb = new FindBusiness();
        fb.setAuthInfo(token);
        FindQualifiers fq = new FindQualifiers();
        fq.getFindQualifier().add(UDDIConstants.CASE_SENSITIVE_MATCH);

        fb.setFindQualifiers(fq);
        Name searchname = new Name(name, null);
        fb.getName().add(searchname);
        BusinessList findBusiness = inquiry.findBusiness(fb);
        return findBusiness;
    }

    private String getServiceKey() throws Exception {
        GetAuthToken getAuthTokenRoot = new GetAuthToken();
        getAuthTokenRoot.setUserID("jddi");
        getAuthTokenRoot.setCred("jddi");
        String token = security.getAuthToken(getAuthTokenRoot).getAuthInfo();

        List<BusinessInfo> businessInfos = getBusinessList(token, BUSINESS_SERVICE_NAME).getBusinessInfos().getBusinessInfo();
        if (businessInfos.isEmpty()) {
            throw new RuntimeException("Business service not found");
        }
        List<ServiceInfo> serviceInfos = businessInfos.get(0).getServiceInfos().getServiceInfo();
        if (serviceInfos.isEmpty()) {
            throw new RuntimeException("Business service not found");
        }
        return serviceInfos.get(0).getServiceKey();
    }

    private void call(String serviceKey) throws Exception {
        ServiceLocator serviceLocator = new ServiceLocator(clerk);
        String endpoint = serviceLocator.lookupEndpoint(serviceKey);
        StudentService instrumentService = new StudentService();
        StudentWebService port = instrumentService.getStudentWebServicePort();
        Map<String, Object> requestContext = ((BindingProvider) port).getRequestContext();
        requestContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint);
        List<Student> students = port.search(new StudentsFilter());
        System.out.println("Service reply");
        students.forEach(student -> System.out.println(toString(student)));
        serviceLocator.shutdown();
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


    public static void main(String args[]) {
        Main main = new Main();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select operation: \n1. register service\n 2. find service");
            Integer operation = null;
            while (operation == null) {
                String line = scanner.next();
                try {
                    operation = Integer.parseInt(line.trim());
                } catch (Exception e) {
                    throw new RuntimeException("Unable to parse operation number");
                }
            }
            try {
                switch (operation) {
                    case 1: {
                        main.publish();
                        break;
                    }
                    case 2: {
                        String serviceKey = main.getServiceKey();
                        main.call(serviceKey);
                        break;
                    }
                    default: {
                        throw new RuntimeException();
                    }
                }
            } catch (Exception e) {
                System.out.println("Unable to handle operation: " + e.getMessage());
            }
        }
    }
}
