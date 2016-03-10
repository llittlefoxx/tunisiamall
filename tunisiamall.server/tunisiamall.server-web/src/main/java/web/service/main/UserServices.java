package web.service.main;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import edu.tunisiamall.entities.User;
import edu.tunisiamall.userServices.userServicesLocal;

@Path("users")
public class UserServices {
	@Inject
	userServicesLocal ejb;

	public User authentificate(String login, String password) {
		return ejb.authentificate(login, password);
	}

	public void delete(int id) {
		ejb.delete(id);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> findAll() {
		return ejb.findAll();
	}

	public User find(int id) {
		return ejb.find(id);
	}

	public User findByLogin(String login) {
		return ejb.findByLogin(login);
	}
}
