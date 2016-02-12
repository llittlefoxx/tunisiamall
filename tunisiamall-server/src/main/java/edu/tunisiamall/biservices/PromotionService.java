package edu.tunisiamall.biservices;

import java.util.List;

import javax.ejb.Stateless;

import edu.tunisiamall.entities.PromotionSuggest;

/**
 * Session Bean implementation class PromotionService
 */
@Stateless
public class PromotionService implements PromotionServiceRemote, PromotionServiceLocal {

    /**
     * Default constructor. 
     */
    public PromotionService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void suggestPromotionOnProduct(List<PromotionSuggest> promotionsSuggest) {
		// TODO Auto-generated method stub
		
	}

}
