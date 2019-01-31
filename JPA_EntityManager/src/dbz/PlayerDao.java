package dbz;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlayerDao {

	@PersistenceContext
	@Autowired
	EntityManager em;

	@Transactional
	public void save(Player player) {
		em.persist(player);
	}

	@Transactional
	public Player get(long id) {
		return em.find(Player.class, id);
	}

	@Transactional
	public void delete(long id) {
		Player p = em.find(Player.class, id);
		em.remove(p);
	}

	@Transactional
	public List<Player> getAll() {

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Player> cq = cb.createQuery(Player.class);
		cq.from(Player.class);

		// Root<Player> root = cq.from(Player.class);
		// Predicate p1 = cb.isNotNull(root.get("name"));
		// Predicate p2 = cb.notEqual(root.get("name"), "test");s
		// cq.where(p1);
		// cq.where(p2);
		// cq.select(root);

		return em.createQuery(cq).getResultList();

		// Query query = em.createNativeQuery("select * from Player", Player.class);
		// return query.getResultList();
	}
}
