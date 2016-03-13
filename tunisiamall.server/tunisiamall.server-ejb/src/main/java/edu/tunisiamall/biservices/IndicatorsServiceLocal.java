package edu.tunisiamall.biservices;

import java.util.List;

import javax.ejb.Local;

import edu.tunisiamall.entities.Product;

@Local
public interface IndicatorsServiceLocal {
	public List<Product> getAllProducts();
}
