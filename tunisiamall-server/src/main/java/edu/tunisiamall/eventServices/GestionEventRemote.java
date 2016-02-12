package edu.tunisiamall.eventServices;

import java.util.List;

import javax.ejb.Remote;

import edu.tunisiamall.entities.Event;

@Remote
public interface GestionEventRemote {
	Boolean addEvent (Event event);
	Boolean updateEvent(Event event);
	Boolean deleteEvent(Event event);
	Event findEventById(Integer idEvent);
	List<Event> findAllEvents();
	

}
