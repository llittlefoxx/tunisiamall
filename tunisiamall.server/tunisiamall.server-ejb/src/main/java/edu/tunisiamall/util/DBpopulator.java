package edu.tunisiamall.util;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import edu.tunisiamall.GuestBookServices.GuestBookEntryServicesLocal;
import edu.tunisiamall.biservices.IndicatorsServiceRemote;
import edu.tunisiamall.categorieServices.CategoryServicesRemote;
import edu.tunisiamall.entities.Administrator;
import edu.tunisiamall.entities.Category;
import edu.tunisiamall.entities.Customer;
import edu.tunisiamall.entities.Event;
import edu.tunisiamall.entities.Guestbookentry;
import edu.tunisiamall.entities.Product;
import edu.tunisiamall.entities.Promotion;
import edu.tunisiamall.entities.Shopowner;
import edu.tunisiamall.entities.Store;
import edu.tunisiamall.entities.Subcategory;
import edu.tunisiamall.entities.User;
import edu.tunisiamall.eventServices.GestionEventLocal;
import edu.tunisiamall.eventServices.GestionEventRemote;
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
	@EJB
	GestionEventLocal gestionEventLocal;
	@EJB
	GuestBookEntryServicesLocal guestBookEntryServicesLocal;

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

		// ########################### Events ###########################
		Event e1 = new Event();
		e1.setTitleEvent("zara Events");
		e1.setDescription("Here you will find the latest pictures from new collections, Lookbook, ZaraPictures, Brothers and Sisters and other general news."); 
		e1.setPeriodEvent(3);
		e1.setDateEvent(new Date());
		e1.setTypeEvent("Opening Zara in Tunisia Mall");
		Event e2 = new Event();
		e2.setTitleEvent("Bershka Events");
		e2.setDescription("This is a place where you can meet other fashionable people and fans of the Bershka brand to have an engaging and fun experience. ");
		e2.setPeriodEvent(5);
		e2.setDateEvent(new Date());
		e2.setTypeEvent("Bershka's birthday");
		Event e3 = new Event();
		e3.setTitleEvent("Pull & Bear");
		e3.setDescription("Pull&Bear was founded in 1991 with a clear international vocation and the intention to sell clothes to young people committed to their environment who live in the community and interact together.");
		e3.setPeriodEvent(4);
		e3.setDateEvent(new Date());
		e3.setTypeEvent("new Arrivals");
		Event e4 = new Event();
		e4.setTitleEvent("Ralphe lauren");
		e4.setDescription("raplphe lauren was founded in 1991 with a clear international vocation and the intention to sell clothes to young people committed to their environment who live in the community and interact together.");
		e4.setPeriodEvent(6);
		e4.setDateEvent(new Date());
		e4.setTypeEvent("opening Store");
		Event e5 = new Event();
		e5.setTitleEvent("Starce");
		e5.setDescription("Strace was founded in 1991 with a clear international vocation and the intention to sell clothes to young people committed to their environment who live in the community and interact together.");
		e5.setPeriodEvent(4);
		e5.setDateEvent(new Date());
		e5.setTypeEvent("New Collection");
		Event e6 = new Event();
		e6.setTitleEvent("Guess");
		e6.setDescription(" Thanks for visiting us on Facebook — we’re happy you’re here! This page was designed for you to share your comments with us.");
		e6.setPeriodEvent(6);
		e6.setDateEvent(new Date());
		e6.setTypeEvent("2 end boutique in tunisia");
		Event e7 = new Event();
		e7.setTitleEvent("Celio");
		e7.setDescription(" Celio brand and to live a full experience To make sure you have a good time on our page , we have established some rules .");
		e7.setPeriodEvent(3);
		e7.setDateEvent(new Date());
		e7.setTypeEvent("2 end boutique in tunisia");
		Event e8 = new Event();
		e8.setTitleEvent("Tommy");
		e8.setDescription("Tommy established some rules . All we ask is that you stick to the topic and to respect the opinions of other users Thank you");
		e8.setPeriodEvent(2);
		e8.setDateEvent(new Date());
		e8.setTypeEvent("New Collection in Tommy");
		gestionEventLocal.addEvent(e1);
		gestionEventLocal.addEvent(e2);
		gestionEventLocal.addEvent(e3);
		gestionEventLocal.addEvent(e4);
		gestionEventLocal.addEvent(e5);
		gestionEventLocal.addEvent(e6);
		gestionEventLocal.addEvent(e7);
		gestionEventLocal.addEvent(e8);
		
		// ########################### Guestbook ###########################

		guestBookEntryServicesLocal.addGuestbookEntry(c1.getIdUser(), "Great website");
		guestBookEntryServicesLocal.addGuestbookEntry(c2.getIdUser(), "Not bad, a good site");
	}

}
