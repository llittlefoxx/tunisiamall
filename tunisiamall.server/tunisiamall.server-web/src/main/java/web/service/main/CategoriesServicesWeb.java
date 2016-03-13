package web.service.main;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.tunisiamall.entities.*;

import edu.tunisiamall.categorieServices.CategoryServicesLocal;

@Path("categories")
public class CategoriesServicesWeb {

	
	@Inject
	CategoryServicesLocal catLocal;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Category> getAll()
	{
		
		return catLocal.findAll();
	}
}
