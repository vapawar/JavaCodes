package org.vpz.dbz;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

@SpringBootApplication
public class DatabaseApplication implements CommandLineRunner
{
	public static void main(String[] args)		
	{
		SpringApplication.run(DatabaseApplication.class, args);
	}

	@Autowired
	JdbcTemplate jdbcTemplate;
	private static final Logger logger = LoggerFactory.getLogger(DatabaseApplication.class);

	@Override
	public void run(String... args) throws Exception
	{
		logger.info("calling getDetails");
		getDetails();

		List<Customer> data = new ArrayList<>();
		Customer c1 = new Customer();
		c1.setId(12);
		c1.setFname("vinod");
		c1.setLname("pawar");
		Customer c2 = new Customer();
		c2.setId(15);
		c2.setFname("Gajanan");
		c2.setLname("pawar");
		data.add(c1);
		data.add(c2);
		logger.info("calling setData");
		setData(data);
	}

	public void getDetails()
	{
		ResultSetExtractor<Customer> rs = null;
		jdbcTemplate.query("select * from customers", new ResultSetExtractor<List<Customer>>()
		{
			@Override
			public List<Customer> extractData(ResultSet rs) throws SQLException, DataAccessException
			{
				List<Customer> data = new ArrayList<>();
				while (rs.next())
				{
					Customer cs = new Customer();
					cs.setId(rs.getInt(1));
					cs.setFname(rs.getString(2));
					cs.setLname(rs.getString(2));
					data.add(cs);
				}
				return data;
			}
		}).forEach(c -> logger.info(c.toString()));
	}

	public void setData(List<Customer> data)
	{
		data.forEach(c -> {
			jdbcTemplate.execute(
					"insert into customers values(" + c.getId() + ",'" + c.getFname() + "','" + c.getLname() + "')");
		});
		logger.info("data added");
	}
}
