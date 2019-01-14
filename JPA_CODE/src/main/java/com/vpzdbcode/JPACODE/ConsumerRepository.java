package com.vpzdbcode.JPACODE;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumerRepository extends CrudRepository<Consumer, Integer>
{

	@Query("select cs from consumer cs")
	List<Consumer> getData();
}