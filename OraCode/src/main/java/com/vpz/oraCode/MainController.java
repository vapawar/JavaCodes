package com.vpz.oraCode;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController
{
	@Autowired
	StudentsRepository repo;

	@RequestMapping("/home/getDetails")
	public String getDetails()
	{
		List<Student> data;
		try
		{
			data = (List<Student>) repo.findAll();
		} catch (Exception e)
		{
		}
		return null;
	}

	public String saveStudent(Student student)
	{
		return null;
	}

	public String saveStudents(List<Student> students)
	{
		return null;
	}
}
