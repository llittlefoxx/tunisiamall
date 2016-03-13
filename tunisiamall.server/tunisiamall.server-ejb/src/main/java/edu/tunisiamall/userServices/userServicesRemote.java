package edu.tunisiamall.userServices;

import java.util.List;

import javax.ejb.Remote;

import edu.tunisiamall.entities.Customer;
import edu.tunisiamall.entities.User;

@Remote
public interface userServicesRemote {

	public void create(User user);

	public User authentificate(String login, String password);

	public void delete(int id);

	public List<User> findAll();

	public List<Customer> findAllCustomer();

	public User find(int id);

	public User findByLogin(String login);

}
