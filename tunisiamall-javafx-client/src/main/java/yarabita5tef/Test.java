package yarabita5tef;



import java.util.List;

import Delegates.CustomerDelegate;
import Delegates.ShopeOwnerDelegate;
import Delegates.UserDelagate;
import edu.tunisiamall.entities.Administrator;
import edu.tunisiamall.entities.Customer;
import edu.tunisiamall.entities.Shopowner;
import edu.tunisiamall.entities.User;


public class Test {
	
	

	public static void main(String[] args) {
	
		
		Administrator admin = new Administrator();
		
		
		admin.setFirstName("soufiene");
		admin.setLogin("soufiene");
		admin.setPassword("soufiene");
		
		//userServiceRemote.create(admin);
		
		//admin.setFirstName("ilyes");
			//	admin.setLogin("ilyes");
			//	admin.setPassword("ilyes");
		//UserDelagate.create(admin);
		//UserDelagate.delete(2);
		List<User> user;
		user=UserDelagate.findAll();
		for (int i = 0; i < user.size(); i++) {
			System.out.println(user.get(i).getLogin());
		}
		//admin=(Administrator) UserDelagate.authentificate("soufiene", "soufiene");
		//System.out.println(admin.getLogin());
		Shopowner salah =new Shopowner();
		salah.setFirstName("salah");
		salah.setLastName("ghabri");
		ShopeOwnerDelegate.create(salah);
		Customer sel3a=new Customer();
		sel3a.setFirstName("User First Name");
		sel3a.setLastName("User Last Name");
		List<Customer> cust;
		CustomerDelegate.create(sel3a);
		cust=CustomerDelegate.findAllCos();
		ShopeOwnerDelegate.create(salah);
		List<Shopowner> so;
		so=ShopeOwnerDelegate.findAllSO();
		long a =ShopeOwnerDelegate.count();
		long b =CustomerDelegate.count();
		System.out.println(b);
		System.out.println(a);
		for (int i = 0; i < so.size(); i++) {
			System.out.println(so.get(i).getFirstName());
		}
		for (int i = 0; i < cust.size(); i++) {
			System.out.println(cust.get(i).getFirstName());
		}
	}

}
