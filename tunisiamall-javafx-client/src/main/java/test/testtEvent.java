package test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import edu.tunisiamall.entities.Event;
import edu.tunisiamall.eventServices.GestionEventRemote;

public class testtEvent {
	static GestionEventRemote remote;
	public static void doAddEvent(GestionEventRemote remote){
		Event event=new Event();
		event.setDescription("description events");
		if (remote.addEvent(event)){
			System.out.println("mchet");
		}
		else 
			System.out.println("mamchetich");
	}
	static void main(String[] args) {
		try {
			Context context=new InitialContext();
			remote=(GestionEventRemote) context.lookup("tunisiamall-server/GestionEvent!edu.tunisiamall.eventServices.GestionEventRemote");
		    doAddEvent(remote);
		} catch (NamingException e) {
			e.printStackTrace();
			
		}
		
		

	}

}
