package edu.tunisiamall.biservices;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateful;

import edu.tunisiamall.entities.Product;
import edu.tunisiamall.entities.Store;

/**
 * Session Bean implementation class IndicatorsService
 */
@Stateful
public class IndicatorsService implements IndicatorsServiceRemote, IndicatorsServiceLocal {

    /**
     * Default constructor. 
     */
    public IndicatorsService() {
        // TODO Auto-generated constructor stub
    }
    
    

	@Override
	public List<Product> getAllProducts() {
		
		return null;
	}

	@Override
	public List<Product> getAllPromotionProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getHotProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getStockStatus() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Store> getTopSellingStores() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Double> getIncomeByPeriod(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return null;
	}

}
