package edu.tunisiamall.userServices;

import java.util.List;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import edu.tunisiamall.entities.User;

/**
 * Session Bean implementation class userServices
 */
@Stateless
public class userServices implements userServicesRemote, userServicesLocal {

    /**
     * Default constructor. 
     */
	
	@PersistenceContext
	private EntityManager em;
	
    public userServices() {
        // TODO Auto-generated constructor stub
    }

    @Override
	public void create(User user) {
		em.persist(user);
	}

	@Override
	public User authentificate(String login, String password) {
		
		Query query = em.createQuery("select u from User u where u.login=:param1 and u.password=:param2");

		query.setParameter("param1", login).setParameter("param2", password);
		User user = null;
		try {
			user = (User) query.getSingleResult();

		} catch (Exception e) {

			System.out.println("error " + e.getMessage());
		}
		return user;
	}



	@Override
	public void delete(int id) {
		em.remove(em.find(User.class, id));
		
	}

	@Override
	public List<User> findAll() {
		
			return em.createQuery("select u from User u", User.class).getResultList();
	}

	@Override
	public User find(int id) {
		return em.find(User.class, id);
	}

	@Override
	public User findByLogin(String login) {
		Query q= em.createQuery("select u from User u where u.login=:x");
		q.setParameter("x", login);
	    return (User) q.getResultList().get(0);
	}

}
