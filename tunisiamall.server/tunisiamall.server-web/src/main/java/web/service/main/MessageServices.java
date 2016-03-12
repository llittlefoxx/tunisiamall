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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import edu.tunisiamall.communication.MessageServiceLocal;
import edu.tunisiamall.entities.Message;
import edu.tunisiamall.entities.User;
import edu.tunisiamall.userServices.userServicesLocal;
import virtual.entities.SendMessage;

@Path("messages")
public class MessageServices {
	@Inject
	MessageServiceLocal ejb;
	@Inject
	userServicesLocal userEJB;

	@GET
	@Path("fromTo/{idSrc}/{idDest}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessagesFromTo(@PathParam("idSrc") int idSrc, @PathParam("idDest") int idDest) {
		User src = userEJB.find(idSrc);
		User dest = userEJB.find(idDest);
		return ejb.getMessagesFromTo(src, dest);
	}

	@GET
	@Path("list/{idUser}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessagesFor(@PathParam("idUser") int idUser) {
		User u = userEJB.find(idUser);
		return ejb.getMessagesFor(u);
	}

	@POST
	@Path("send")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message sendMessage(SendMessage m) {
		User src = userEJB.find(m.idSrc);
		User dest = userEJB.find(m.idDest);
		return ejb.sendMessage(src, dest, m.text);
	}

	@DELETE
	@Path("delete")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public boolean deleteMessage(Message m) {
		return ejb.deleteMessage(m);
	}
}
