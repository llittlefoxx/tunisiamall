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

import edu.tunisiamall.GuestBookServices.GuestBookEntryServicesLocal;
import edu.tunisiamall.entities.Gestbookentry;
import virtual.entities.AddGuestbook;

@Path("guestbook")
public class GuestbookServices {
	@Inject
	GuestBookEntryServicesLocal ejb;

	@DELETE
	@Path("delete/{id}")
	public void deleteEntries(@PathParam("id") int id) {
		ejb.deleteEntries(id);
	}

	@GET
	@Path("find/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Gestbookentry findEntryById(@PathParam("id") int idEtries) {
		return ejb.findEntryById(idEtries);
	}

	@GET
	@Path("findAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Gestbookentry> findAll() {
		return ejb.findAll();
	}
	
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public boolean addGuestbookEntry(AddGuestbook g){
		return ejb.addGuestbookEntry(g.idUser, g.text);
	}
}
