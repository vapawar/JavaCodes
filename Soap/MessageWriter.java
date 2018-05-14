package soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface MessageWriter
{

    @WebMethod
    public String setMessage(String str);

    @WebMethod
    public void setData(String str);
}
