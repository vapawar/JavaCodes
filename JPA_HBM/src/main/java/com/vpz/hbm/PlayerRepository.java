package com.vpz.hbm;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Transactional
@Repository
public class PlayerRepository
{

	@Autowired
	SessionFactory factory;

	public void create(Player player)
	{
		Session session = factory.getCurrentSession();
		session.save(player);
	}

	public List getAll()
	{
		Session session = factory.getCurrentSession();
		return session.createCriteria(Player.class).list();
	}

	public void deleteById(long id)
	{
		Session session = factory.getCurrentSession();
		Player player = session.load(Player.class, id);
		session.delete(player);
	}
}
