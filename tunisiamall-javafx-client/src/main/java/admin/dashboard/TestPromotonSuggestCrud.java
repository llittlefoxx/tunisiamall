package admin.dashboard;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import edu.tunisiamall.biservices.IndicatorsServiceRemote;
import edu.tunisiamall.entities.Product;
import edu.tunisiamall.entities.PromotionSuggest;

public class TestPromotonSuggestCrud {
	public static void main(String[] args) {
		IndicatorsServiceRemote indicatorsServiceRemote;
		try {
			Context ctx = new InitialContext();
			indicatorsServiceRemote = (IndicatorsServiceRemote) ctx
					.lookup("tunisiamall-server/IndicatorsService!edu.tunisiamall.biservices.IndicatorsServiceRemote");

			PromotionSuggest promotionSuggest=new PromotionSuggest();
			
			Date d=new Date(2044,01,25);
			promotionSuggest.setSuggestionDate(d);
			promotionSuggest.setEndDate(d);
			promotionSuggest.setStartDate(d);
			//promotionSuggest.setProducts(indicatorsServiceRemote.getAllProducts());
		//	indicatorsServiceRemote.createPromotionSuggest(promotionSuggest);
		//indicatorsServiceRemote.createPromotionSuggest(promotionSuggest);
		//	indicatorsServiceRemote.affectPromotionSuggestToProduct(1, 1);
			//indicatorsServiceRemote.affectPromotionSuggestToProduct(1, 1);
			//indicatorsServiceRemote.affectPromotionSuggestToProduct(3, 2);
			//indicatorsServiceRemote.deletePromotionSuggest(2);
			System.out.println("aaaaaaaa");
			//System.out.println("ssssssssssssssss"+indicatorsServiceRemote.findPromotionSuggestById(1));
		//	for (Product p: indicatorsServiceRemote.findPromotionSuggestById(1).getProducts()) {
			//	System.out.println(p.getLibelle());
		//	}
		//	indicatorsServiceRemote.getHotProducts();
			//indicatorsServiceRemote.removePromotionSuggestFromProduct(1);
			
			System.out.println(indicatorsServiceRemote.getProductsByPromotionSugg(1).size());
			List<Product> lisp=new ArrayList<Product>();
			lisp=indicatorsServiceRemote.getAllPromotionProducts();
			System.out.println(lisp.size());
			for (Product product : lisp) {
				System.out.println(product.getLibelle());
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
