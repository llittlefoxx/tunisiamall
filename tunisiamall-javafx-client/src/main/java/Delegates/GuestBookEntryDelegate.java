package Delegates;

import java.util.List;

import edu.tunisiamall.GuestBookServices.GuestBookEntryServicesRemote;
import edu.tunisiamall.entities.Gestbookentry;

public class GuestBookEntryDelegate {
	
	public static GuestBookEntryServicesRemote remote;
	private static String jndiName = "/tunisiamall-server/GuestBookEntryServices!edu.tunisiamall.GuestBookServices.GuestBookEntryServicesRemote";
	private static GuestBookEntryServicesRemote getProxy(){
		return (GuestBookEntryServicesRemote) Locator.ServiceLocator.getInstance().getProxy(
				jndiName);
	}
	public static void deleteEntry(Gestbookentry g){
		getProxy().deleteEntries(g);
	}
	public static List<Gestbookentry> ListOfEntries(){
		 return getProxy().findAll();
	}
}
