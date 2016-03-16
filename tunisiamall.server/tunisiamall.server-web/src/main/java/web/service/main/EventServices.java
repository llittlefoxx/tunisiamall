package web.service.main;

import java.util.List;


import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.tunisiamall.entities.Event;
import edu.tunisiamall.eventServices.GestionEventLocal;

@Path("events")
public class EventServices {
	@Inject
	GestionEventLocal ejb;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Boolean addEvent (Event event){
		return ejb.addEvent(event);
	}
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Boolean updateEvent(Event event){
		return ejb.updateEvent(event);
	}
	/*@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	public Boolean deleteEvent(Event event){
		return ejb.deleteEvent(event);
	}*/
	@GET
	@Path("{id}/event")
	@Produces(MediaType.APPLICATION_JSON)
	public Event findEventById(@PathParam("id")Integer idEvent){
		return ejb.findEventById(idEvent);
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Event> findAllEvents(){
		return ejb.findAllEvents();
	}

}
