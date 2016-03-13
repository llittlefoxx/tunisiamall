package web.service.main;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.tunisiamall.entities.Subcategory;
import edu.tunisiamall.subCategoriesServices.SubCategoriesServicesLocal;

@Path("subcategories")
public class SubCategoryServices {
	@Inject
	SubCategoriesServicesLocal ejb;
	
	@POST
	@Path("add")
	@Consumes(MediaType.APPLICATION_JSON)
	public void addSubCategory(Subcategory subcategory){
		ejb.addSubCategory(subcategory);
	}

	@DELETE
	@Path("delete/{id}")
	public void deleteSubCategories(@PathParam("id") int idSubCategory){
		ejb.deleteSubCategories(idSubCategory);
	}

	@GET
	@Path("find/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Subcategory findSubCategoryById(@PathParam("id") int idSubCategory){
		return ejb.findSubCategoryById(idSubCategory);
	}

	@GET
	@Path("findAll")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Subcategory> findAll(){
		return ejb.findAll();
	}

	@GET
	@Path("findBy/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Subcategory> findSubCategoryByIdCategory(@PathParam("id") int idCategory){
		return ejb.findSubCategoryByIdCategory(idCategory);
	}
}
