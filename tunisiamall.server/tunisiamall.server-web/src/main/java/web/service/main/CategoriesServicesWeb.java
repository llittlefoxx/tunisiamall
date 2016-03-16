package web.service.main;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import edu.tunisiamall.entities.*;

import edu.tunisiamall.categorieServices.CategoryServicesLocal;

@Path("categories")
public class CategoriesServicesWeb {
 static List<Category> categories = new ArrayList<Category>();
	
	@Inject
	CategoryServicesLocal catLocal;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Category> getAll()
	{
		
		return catLocal.findAll();
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addCategory(Category cat)
	{
		 catLocal.addCategory(cat);
	}
	
	

}
