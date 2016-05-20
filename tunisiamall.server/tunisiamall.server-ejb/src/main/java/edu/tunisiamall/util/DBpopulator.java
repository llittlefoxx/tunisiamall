package edu.tunisiamall.util;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import edu.tunisiamall.biservices.IndicatorsServiceRemote;
import edu.tunisiamall.categorieServices.CategoryServicesRemote;
import edu.tunisiamall.entities.Administrator;
import edu.tunisiamall.entities.Category;
import edu.tunisiamall.entities.Customer;
import edu.tunisiamall.entities.Product;
import edu.tunisiamall.entities.Promotion;
import edu.tunisiamall.entities.Shopowner;
import edu.tunisiamall.entities.Store;
import edu.tunisiamall.entities.Subcategory;
import edu.tunisiamall.entities.User;
import edu.tunisiamall.storeServices.StoreServicesLocal;
import edu.tunisiamall.userServices.userServicesLocal;
import edu.tunisiamall.userServices.userServicesRemote;

/*@Singleton
@Startup*/
public class DBpopulator {

	@EJB
	IndicatorsServiceRemote indicatorsServiceRemote;
	@EJB
	CategoryServicesRemote categoryServicesRemote;
	@EJB
	userServicesRemote userServicesRemote;

	@EJB
	StoreServicesLocal storeServicesLocal;

	public DBpopulator() {

	}

	@PostConstruct
	public void createData() {
		Date date = new Date();
		// ########################### Users ###########################

		Administrator admin = new Administrator();
		admin.setLogin("admin");
		admin.setPassword("esprit");
		admin.setFirstName("Administrator");
		admin.setMail("admin@mail.com");
		Customer c1 = new Customer();
		c1.setLogin("customer1");
		c1.setPassword("esprit");
		c1.setFirstName("Customer");
		c1.setLastName("1");
		c1.setMail("customer1@mail.com");
		Customer c2 = new Customer();
		c2.setLogin("customer2");
		c2.setPassword("esprit");
		c2.setFirstName("Customer");
		c2.setLastName("2");
		c2.setMail("customer2@mail.com");
		Shopowner s1 = new Shopowner();
		s1.setLogin("shopowner1");
		s1.setPassword("esprit");
		s1.setFirstName("Shopowner");
		s1.setLastName("1");
		s1.setMail("shopowner1@mail.com");
		Shopowner s2 = new Shopowner();
		s2.setLogin("shopowner2");
		s2.setPassword("esprit");
		s2.setFirstName("Shopowner");
		s2.setLastName("2");
		s2.setMail("shopowner2@mail.com");

		admin = userServicesRemote.findAdmin(userServicesRemote.create(admin));
		c1 = userServicesRemote.findCustomer(userServicesRemote.create(c1));
		c2 = userServicesRemote.findCustomer(userServicesRemote.create(c2));
		s1 = userServicesRemote.findShopowner(userServicesRemote.create(s1));
		s2 = userServicesRemote.findShopowner(userServicesRemote.create(s2));

		// ########################### Categories ###########################

		Category category = new Category("Cette categorie contient des vettement hiver", "Winter Clothes");
		Category category1 = new Category("Cette categorie contient des produis alimentaire", "Food");
		Category category2 = new Category("Cette categorie contient du matériel informatique", "Computers");

		category = categoryServicesRemote.addCategory(category);
		category1 = categoryServicesRemote.addCategory(category1);
		category2 = categoryServicesRemote.addCategory(category2);

		// ########################### Store ###########################

		Store store = new Store("Store for fashion", category, "BERSHKA", date, "OPEN", "33333333", s1);
		Store store1 = new Store("Food store", category, "CARREFOUR", date, "OPEN", "33333332", s1);
		Store store2 = new Store("Technology store", category, "MEDIA-TEK", date, "OPEN", "33333331", s2);

		store = storeServicesLocal.addStore(store);
		store = storeServicesLocal.addStore(store1);
		store = storeServicesLocal.addStore(store2);

		// ########################### SubCategories ###########################

		Subcategory subCategory = new Subcategory("this sub-category contains Shoes", "Shoes", category);
		Subcategory subCategory1 = new Subcategory("this sub-category contains food", "Cake", category1);
		Subcategory subCategory2 = new Subcategory("this sub-category contains Laptops", "Laptops", category2);

		subCategory = categoryServicesRemote.addSubCategory(subCategory);
		subCategory1 = categoryServicesRemote.addSubCategory(subCategory1);
		subCategory2 = categoryServicesRemote.addSubCategory(subCategory2);

		// ########################### Promotions ###########################

		Promotion promotion = new Promotion("Promo ETE", 20.0, true, date, date);
		Promotion promotion1 = new Promotion("Promo HIVER", 15.0, true, date, date);

		promotion = indicatorsServiceRemote.createPromotion(promotion);
		promotion1 = indicatorsServiceRemote.createPromotion(promotion1);

		// ########################### Products ###########################
		Product product = new Product(15.0, date, "Nike shoes", 250, 15, 79.900, "Available", "shoes", 18, promotion,
				null, store, subCategory);
		Product product1 = new Product(19.0, date, "Laptop Acer", 250, 15, 982.600, "Available", "Computer", 18,
				promotion1, null, store2, subCategory);
		Product product2 = new Product(25.0, date, "Biscuit Major", 250, 15, 800, "Available", "Food", 18, null, null,
				store1, subCategory);
		Product product3 = new Product(25.0, date, "Biscuit Major", 250, 15, 800, "Available", "Food", 18, null, null,
				store, subCategory);

		categoryServicesRemote.addProduct(product);
		categoryServicesRemote.addProduct(product1);
		categoryServicesRemote.addProduct(product2);
		categoryServicesRemote.addProduct(product3);

	}

}
