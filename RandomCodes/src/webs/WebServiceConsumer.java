package webs;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

public class WebServiceConsumer {

    public static void main(String[] args) throws MalformedURLException {

        URL url = new URL("http://localhost:8086/webs/test2?wsdl");
        QName name = new QName("http://webs.vpz.com/", "DataOperationsIMPLService");
        Service service = Service.create(url, name);

        DataOperations t1 = service.getPort(DataOperations.class);
        // System.out.println(t1.sayHello("vinod"));

        String str = t1.sayHello("vinod");
        String studentDetails[] = str.split(",");
        String key = null;
        String value = null;

        for (String string : studentDetails) {
            if (string.contains("Details"))
                continue;
            key = string.split(":")[0];
            value = string.split(":")[1];
            System.out.println("Key:-" + key);
            System.out.println("Value:-" + value);
        }
    }
}
