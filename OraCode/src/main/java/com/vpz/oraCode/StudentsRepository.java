package com.vpz.oraCode;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public class StudentsRepository implements CrudRepository<Student, Integer>
{
	@Override
	public <S extends Student> S save(S entity)
	{
		return save(entity);
	}

	@Override
	public <S extends Student> Iterable<S> saveAll(Iterable<S> entities)
	{
		return saveAll(entities);
	}

	@Override
	public Optional<Student> findById(Integer id)
	{
		return findById(id);
	}

	@Override
	public boolean existsById(Integer id)
	{
		return existsById(id);
	}

	@Override
	public Iterable<Student> findAll()
	{
		return findAll();
	}

	@Override
	public Iterable<Student> findAllById(Iterable<Integer> ids)
	{
		return findAllById(ids);
	}

	@Override
	public long count()
	{
		return count();
	}

	@Override
	public void deleteById(Integer id)
	{
		deleteById(id);
	}

	@Override
	public void delete(Student entity)
	{
		delete(entity);
	}

	@Override
	public void deleteAll(Iterable<? extends Student> entities)
	{
		deleteAll(entities);
	}

	@Override
	public void deleteAll()
	{
		deleteAll();
	}
}
