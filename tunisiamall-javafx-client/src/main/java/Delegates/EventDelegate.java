package Delegates;


import java.util.List;

import Locator.ServiceLocator;
import edu.tunisiamall.entities.Event;
import edu.tunisiamall.eventServices.GestionEventRemote;

public class EventDelegate {
	private final static String jndiName="tunisiamall-server/GestionEvent!edu.tunisiamall.eventServices.GestionEventRemote";
	
	private static GestionEventRemote getProxy(){
		return (GestionEventRemote) ServiceLocator.getInstance().getProxy(jndiName);	
	}
	
	public static Boolean addEvent (Event event){
		return getProxy().addEvent(event); 
	}
	public static List<Event> SearchEvent(String E){
		return getProxy().SearchEvent(E);
	}
	public static Boolean updateEvent(Event event){
		return getProxy().updateEvent(event); 
	}
	public static Boolean deleteEvent(Event event){
		return getProxy().deleteEvent(event); 
	}
	public static Event findEventById(Integer idEvent){
		return getProxy().findEventById(idEvent); 
	}
	public static List<Event> findAllEvents(){
		return getProxy().findAllEvents(); 
	}
}
