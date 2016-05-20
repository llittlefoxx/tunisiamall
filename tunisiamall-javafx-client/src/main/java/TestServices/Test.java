package TestServices;

import java.util.List;


import Delegates.CategoriesDelegate;
import Delegates.GuestBookEntryDelegate;
import Delegates.UserDelagate;
import edu.tunisiamall.entities.Administrator;
import edu.tunisiamall.entities.Category;
import edu.tunisiamall.entities.Customer;
import edu.tunisiamall.entities.Guestbookentry;
import edu.tunisiamall.entities.Shopowner;
import edu.tunisiamall.entities.User;

public class Test {

	public static void main(String[] args) {
		/*List<Guestbookentry> l = GuestBookEntryDelegate.ListOfEntries();
		System.out.println(l.size());*/
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
		UserDelagate.create(admin);
		UserDelagate.create(c1);
		UserDelagate.create(c2);
		UserDelagate.create(s1);
		UserDelagate.create(s2);
	}

	
}
