package web.service.main;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import edu.tunisiamall.entities.Category;
import edu.tunisiamall.entities.Mvtstock;
import edu.tunisiamall.entities.Product;
import edu.tunisiamall.entities.Store;
import edu.tunisiamall.storeServices.StoreServicesLocal;

@Path("stores")
public class StoresServicesWeb {
	
	static List<Store> stores = new ArrayList<Store>();
	
	static List<Mvtstock> stocks = new ArrayList<>();
	@Inject
	StoreServicesLocal storeLocal;
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("category/{lib}")
	public List<Store> findStoreByCategory(@PathParam(value="lib")String libelle)
	{
		return storeLocal.findAllSStoreByCategory(libelle);
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("allstore")
	public List<Store> findAllStore()
	{
		return storeLocal.findAllSStore();
	}

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("storesShopOwner/{sh}")
	public List<Store> findStoreByShopOwner(@PathParam(value="sh")int idShopOwner)
	{
		return storeLocal.findStoreByShopOwner(idShopOwner);
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Store getStore(@PathParam(value="id")int id)
	{
		return storeLocal.findStoreById(id);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	
	public Response updateStoreShopowner (int id){
		Store s= storeLocal.updateStore(id);
		return Response
				.created(
						UriBuilder
							.fromResource(StoresServicesWeb.class)
							.path(String.valueOf(s.getIdStroe()))
							.build()
						)
							
				.build();
		
	}
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("update")
	public Store updateStoreShopowner2 (int idStore){
		return storeLocal.updateStore(idStore);

		
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addStore (Store s){
		s= storeLocal.addStore(s);
		return Response
				.created(
						UriBuilder
							.fromResource(StoresServicesWeb.class)
							.path(String.valueOf(s.getIdStroe()))
							.build()
						)
							
				.build();
		
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{idS}")
	public Response deleteStore (@PathParam(value="idS") int idStore){
		Store s = storeLocal.findStoreById(idStore);
		storeLocal.deleteStore(idStore);
		
		return Response
				.created(
						UriBuilder
							.fromResource(StoresServicesWeb.class)
							.path("storesShopOwner")
							.path(String.valueOf(s.getShopowner().getIdUser()))
							.build()
						)
							
				.build();
		
	}

	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("stock/{id}")
	public List<Product> findStockProductByStore(@PathParam(value="id")int idStore)
	{
		return storeLocal.findStockProdByIdStore(idStore);
	}
	
	
	@POST
	@Path("addmvtstock")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addMvtStock (Mvtstock st){
		st= storeLocal.addMvtStock(st);
		return Response
				.created(
						UriBuilder
							.fromResource(StoresServicesWeb.class)
							.path("mvtstock")
							.path(String.valueOf(st.getIdMvt()))
							.build()
						)
							
				.build();
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("allmvtstock")
	public List<Mvtstock> findAllMvtStock()
	{
		return storeLocal.getAllMvtStock();
	}

	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("mvtstock/{id}")
	public Mvtstock getMvtStock(@PathParam(value="id")int id)
	{
		return storeLocal.findMvtstockById(id);
	}
}
