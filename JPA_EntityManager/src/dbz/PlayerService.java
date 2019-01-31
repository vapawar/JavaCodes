package dbz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

	@Autowired
	private PlayerDao dao;

	public void savePlayerDetails(Player player) {
		dao.save(player);
	}

	public Player getPlayerDetails(long id) {
		return dao.get(id);
	}

	public List<Player> getAllPlayerDetails() {
		return dao.getAll();
	}

	public void deletePlayerDetails(long id) {
		dao.delete(id);
	}
}
