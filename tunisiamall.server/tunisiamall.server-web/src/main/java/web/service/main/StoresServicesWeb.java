package web.service.main;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.tunisiamall.entities.Category;
import edu.tunisiamall.entities.Store;
import edu.tunisiamall.storeServices.StoreServicesLocal;

@Path("stores")
public class StoresServicesWeb {
	
	@Inject
	StoreServicesLocal storeLocal;
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Store> findStoreByCategory(Category cat)
	{
		return storeLocal.findAllSStoreByCategory(cat);
	}

}
