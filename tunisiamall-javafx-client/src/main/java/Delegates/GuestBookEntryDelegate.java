package Delegates;

import java.util.List;

import edu.tunisiamall.GuestBookServices.GuestBookEntryServicesRemote;
import edu.tunisiamall.entities.Guestbookentry;

public class GuestBookEntryDelegate {
	
	public static GuestBookEntryServicesRemote remote;
	private static String jndiName = "/tunisiamall-server/GuestBookEntryServices!edu.tunisiamall.GuestBookServices.GuestBookEntryServicesRemote";
	private static GuestBookEntryServicesRemote getProxy(){
		return (GuestBookEntryServicesRemote) Locator.ServiceLocator.getInstance().getProxy(
				jndiName);
	}
	public static void deleteEntry(Guestbookentry g){
		getProxy().deleteEntries(g.getIdEntries());
	}
	public static List<Guestbookentry> ListOfEntries(){
		 return getProxy().findAll();
	}
}
