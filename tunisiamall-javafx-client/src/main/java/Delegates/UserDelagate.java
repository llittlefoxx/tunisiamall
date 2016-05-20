package Delegates;

import java.util.List;

import Locator.ServiceLocator;
import edu.tunisiamall.entities.User;
import edu.tunisiamall.userServices.*;

public class UserDelagate {

	private final static String jndiName = "tunisiamall.server-ear/tunisiamall.server-ejb/userServices!edu.tunisiamall.userServices.userServicesRemote";

	private static userServicesRemote getProxy() {
		return (userServicesRemote) ServiceLocator.getInstance().getProxy(jndiName);
	}

	public static void create(User user) {
		getProxy().create(user);
	}

	public static User authentificate(String login, String password) {
		return getProxy().authentificate(login, password);

	}

	public static void delete(int id) {
		getProxy().delete(id);

	}

	public static List<User> findAll() {
		return getProxy().findAll();
	}

	public static User find(Integer id) {
		return getProxy().find(id);
	}

	public static User findByLogin(String login) {
		return getProxy().findByLogin(login);
	}

}
