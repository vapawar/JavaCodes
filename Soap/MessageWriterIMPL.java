package org.vpz.webs.soaps;

import java.io.FileWriter;
import javax.jws.WebService;

import org.vpz.webs.soaps.MessageWriter;

@WebService(endpointInterface = "com.vpz.webs.MessageWriter")
public class MessageWriterIMPL implements MessageWriter
{
    @Override
    public String setMessage(String str)
    {
	System.out.println("Input values are : " + str);
	return "MH";
    }

    @Override
    public void setData(String str)
    {
	try
	{
	    FileWriter f = new FileWriter("D:\\abc.txt", true);
	    f.write(str);
	    f.close();
	} catch (Exception e)
	{
	    e.printStackTrace();
	}
    }
}
