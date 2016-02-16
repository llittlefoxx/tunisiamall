package edu.tunisiamall.GuestBookServices;

import java.util.List;

import javax.ejb.Remote;

import edu.tunisiamall.entities.Category;
import edu.tunisiamall.entities.Gestbookentry;;

@Remote
public interface GuestBookEntryServicesRemote {
	public void deleteEntries(Gestbookentry g);
	public Gestbookentry findEntryById(int idEtries);
	public List<Gestbookentry> findAll();

}
