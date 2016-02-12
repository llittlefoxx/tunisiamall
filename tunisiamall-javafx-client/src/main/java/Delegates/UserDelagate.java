package Delegates;

import java.util.List;


import edu.tunisiamall.entities.User;
import edu.tunisiamall.userServices.*;

public class UserDelagate {
	
	private static userServicesRemote remote;
	private final static String jndiName="tunisiamall-server/userServices!edu.tunisiamall.userServices.userServicesRemote"; 
	
	private static userServicesRemote getProxy() {
		return (userServicesRemote) Locator.ServiceLocator.getInstance().getProxy(
				jndiName);

	}

	
	public void create(User user){
		getProxy().create(user);
	}
	public User authentificate(String login, String password){
		return getProxy().authentificate(login, password);
		
	}
	public void delete(int id){
		getProxy().delete(id);
		
	}
	public List<User> findAll(){
		return getProxy().findAll();
	}
	public User find(Integer id){
		return getProxy().find(id);
	}
	public User findByLogin(String login){
		return getProxy().findByLogin(login);
	}
	

}
