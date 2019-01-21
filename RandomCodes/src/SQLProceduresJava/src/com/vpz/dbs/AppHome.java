package com.vpz.dbs;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class AppHome 
{
	public static void main(String[] args) throws Exception 
	{
	
		Logger logger=Logger.getLogger(AppHome.class.getName());
		Handler h=new FileHandler("test.log");
		h.setFormatter(new SimpleFormatter());
		logger.addHandler(h);
		Level level=Level.FINE;
		logger.finest("finest");
		logger.finer("finer");
		logger.fine("fine");
		logger.config("config");
		logger.info("info");
		logger.warning("warn");
		logger.severe("severe");
		logger.log(level, "log method call");
		
		
		
		
		Properties props=new Properties();
		OutputStream out=new FileOutputStream("test.properties");
		props.setProperty("name", "vinod");
		props.setProperty("lastname", "pawar");
		props.store(out, null);
		out.close();
		
		Properties props2=new Properties();
		InputStream input=new FileInputStream("test.properties");
		props2.load(input);
		System.out.println(props2.getProperty("name"));
		System.out.println(props2.getProperty("lastname"));
		input.close();
		
		
		
		int stnum=1;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","vp","vp");
		CallableStatement cstatement=connection.prepareCall("{CALL test26(?,?,?,?)}");
		cstatement.setInt(1, stnum);
		cstatement.registerOutParameter(2, Types.INTEGER);
		cstatement.registerOutParameter(3, Types.VARCHAR);
		cstatement.registerOutParameter(4, Types.INTEGER);
		cstatement.executeUpdate();
		System.out.println(cstatement.getInt(2));
		System.out.println(cstatement.getString(3));
		System.out.println(cstatement.getInt(4));
		
	}
}
