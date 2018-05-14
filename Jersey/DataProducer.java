package jersey;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class DataProducer 
{
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String data()
	{
		return "hello";
	}
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public String getCustomerXML(@QueryParam("NAME") String str1, @QueryParam("MARKS") String str2) 
	{
		return "<?xml version=\"1.0\"?>" + "<Name>" + str1 + "</Name>" + "<Code>" + str2 + "</Code>";
	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getCustomerDetailsHTML(@QueryParam("NAME") String str1, @QueryParam("MARKS") String str2)
	{
		return "<html><title> User Data</title><body> Name: " + str1 +" <br/> Code: " + str2 +"</body> </html> ";
	}

	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	public String getCustomerDetails2(String str)
	{
		String []s=str.split(",");
		String str1 = s[0];
		String str2 = s[1];
		return str + ".............................." + str2;
	}

	@POST
	@Consumes(MediaType.TEXT_XML)
	public String getCustomerXML2(String str) 
	{
		String []s=str.split(",");
		String str1 = s[0];
		String str2 = s[1];
		return "<?xml version=\"1.0\"?>" + "<Name>" + str1 + "</Name>" + "<Code>" + str2 + "</Code>";
	}
}
