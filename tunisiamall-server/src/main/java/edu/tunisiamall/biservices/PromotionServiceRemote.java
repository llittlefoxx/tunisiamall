package edu.tunisiamall.biservices;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import edu.tunisiamall.entities.PromotionSuggest;

@Remote
public interface PromotionServiceRemote {

	public void suggestPromotionOnProduct(List<PromotionSuggest> promotionsSuggest);
    
}
