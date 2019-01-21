package com.vpz.hbm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService
{

	@Autowired
	PlayerRepository dao;

	public void createPlayer(Player player)
	{
		dao.create(player);
	}

	public void getPlayers()
	{
		List data = dao.getAll();
		data.forEach(x->System.out.println(x.toString()));
	}

	public void deleteOne(long id)
	{
		dao.deleteById(id);
	}

}
