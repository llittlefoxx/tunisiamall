package web.service.main;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.jws.WebParam;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import edu.tunisiamall.biservices.IndicatorsServiceLocal;
import edu.tunisiamall.entities.AnonimousRating;
import edu.tunisiamall.entities.Image;
import edu.tunisiamall.entities.Product;
import web.service.model.CustomizedProduct;

@Path(value = "prod")
public class ProductServices {

	@Inject
	IndicatorsServiceLocal indicatorsServiceLocal;

	@GET
	@Produces("application/json")
	public List<CustomizedProduct> getAllProducts() {
		List<Product> origin = new ArrayList<Product>();
		List<CustomizedProduct> Custumised = new ArrayList<CustomizedProduct>();
		origin = indicatorsServiceLocal.getAllProducts();

		for (Product product : origin) {

			CustomizedProduct cp = new CustomizedProduct(product.getIdProduct(), product.getQte(), product.getLibelle(),
					product.getSubcategory().getCategory().getIdCategory(),
					product.getSubcategory().getCategory().getLibelle(), product.getPromotion().getValue(),
					product.getSubcategory().getIdSubCategory(), product.getSubcategory().getLibelle(),
					indicatorsServiceLocal.getImagesByProduct(product.getIdProduct()), product.getSellPrice());
			Custumised.add(cp);
		}
		return Custumised;
	}

	@GET
	@Produces("application/json")
	@Path("/rech/{name}")
	public List<CustomizedProduct> findProductByLibelle(@PathParam(value = "name") String name) {
		List<Product> origin = new ArrayList<Product>();
		List<CustomizedProduct> custumised = new ArrayList<CustomizedProduct>();
		origin = indicatorsServiceLocal.findProductByLib(name);
		for (Product product : origin) {
			CustomizedProduct cp = new CustomizedProduct(product.getIdProduct(), product.getQte(), product.getLibelle(),
					product.getSubcategory().getCategory().getIdCategory(),
					product.getSubcategory().getCategory().getLibelle(), product.getPromotion().getValue(),
					product.getSubcategory().getIdSubCategory(), product.getSubcategory().getLibelle(),
					indicatorsServiceLocal.getImagesByProduct(product.getIdProduct()), product.getSellPrice());
			custumised.add(cp);
		}
		System.out.println("liste recherche " + custumised.size());
		return custumised;
	}

	@POST
	@Consumes("application/json")
	@Path("rate")
	public void rate(AnonimousRating an) {
		indicatorsServiceLocal.rateProduct(an);
	}
}
