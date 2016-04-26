package web.service.main;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.tunisiamall.entities.Customer;
import edu.tunisiamall.entities.User;
import edu.tunisiamall.userServices.userServicesLocal;
import virtual.entities.Authentificate;

@Path("users")
public class UserServices {
	@Inject
	userServicesLocal ejb;

	@POST
	@Path("authentificate")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User authentificate(Authentificate a) {
		return ejb.authentificate(a.username, a.password);
	}

	@DELETE
	@Path("delete/{id}")
	public void delete(@PathParam("id") int id) {
		ejb.delete(id);
	}

	@GET
	@Path("findAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> findAll() {
		return ejb.findAll();
	}

	@GET
	@Path("find/{id}")
	public User find(@PathParam("id") int id) {
		return ejb.find(id);
	}

	public User findByLogin(String login) {
		return ejb.findByLogin(login);
	}
	
	@GET
	@Path("customers")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Customer> findAllCustomer(){
		return null;
	}
}
