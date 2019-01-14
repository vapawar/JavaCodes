package com.vpzdbcode.JPACODE;

import java.util.List;

import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService
{
	@Autowired
	DataSource dataSource;
	@Autowired
	ConsumerRepository repository;

	@Transactional
	public boolean addConsumer(Consumer entity)
	{
		return repository.save(entity) != null;
	}

	@Transactional
	public List<Consumer> getConsumers(List k)
	{
		return (List<Consumer>) repository.findAllById(k);
	}

	@Transactional
	public List<Consumer> getAllConsumers()
	{
		return (List<Consumer>) repository.findAll();
	}

	@Transactional
	public void deleteConsumer(Consumer entity)
	{
		repository.delete(entity);
	}

	@Transactional
	public List<Consumer> getDetails()
	{
		return repository.getData();
	}
}
